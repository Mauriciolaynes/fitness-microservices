# Fitness Microservices

Conversión a arquitectura de microservicios de la API (usuario, membresía, rutina,
ejercicio_rutina, progreso) usando Spring Boot 3 + Spring Cloud 2023.

## Arquitectura

| Componente | Puerto | Descripción |
|---|---|---|
| `eureka-server` | 8761 | Service Discovery (Netflix Eureka) |
| `config-server` | 8888 | Configuración centralizada (perfil `native`, lee `config-repo/`) |
| `api-gateway` | 8080 | Puerta de entrada única, enrutamiento + validación JWT (Keycloak) |
| `usuario-service` | 8081 | Entidades `usuario` y `membresia` |
| `rutina-service` | 8082 | Entidades `rutina` y `ejercicio_rutina` |
| `progreso-service` | 8083 | Entidad `progreso` |
| `keycloak` | 8180 | Servidor OAuth2 / OpenID Connect |
| `mysql` | 3306 | Una base de datos por servicio: `usuario_db`, `rutina_db`, `progreso_db` |

### Comunicación entre microservicios (requisito #7)

- `rutina-service` y `progreso-service` usan un **Feign Client** (`UsuarioClient`)
  para llamar a `usuario-service` (vía Eureka, balanceo `lb://`) y validar que el
  `id_usuario` exista **antes** de crear una rutina o un registro de progreso.
  Si el usuario no existe, responden `404`.

### Seguridad (Keycloak / OAuth2)

- Realm: `fitness-realm` (se importa automáticamente desde `keycloak/fitness-realm.json`).
- Client: `fitness-client` / secret: `fitness-client-secret` (confidential, grants habilitados).
- Usuarios de prueba:
  - `admin` / `admin123` (roles ADMIN, USUARIO)
  - `usuario1` / `usuario123` (rol USUARIO)
- Cada microservicio (y el gateway) es un **Resource Server** que valida el JWT emitido por Keycloak.

### MapStruct

Cada servicio tiene su capa `mapper/` (`UsuarioMapper`, `MembresiaMapper`, `RutinaMapper`,
`EjercicioRutinaMapper`, `ProgresoMapper`) generada en compilación con `@Mapper(componentModel = "spring")`.

### Swagger / OpenAPI

Cada servicio expone `springdoc-openapi`:
- `http://localhost:8081/swagger-ui.html` (usuario-service)
- `http://localhost:8082/swagger-ui.html` (rutina-service)
- `http://localhost:8083/swagger-ui.html` (progreso-service)

---

## Opción A: Levantar todo con Docker (recomendado para la entrega)

Requisitos: Docker Desktop y Maven/JDK 17 instalados localmente (para compilar los jars antes
de construir las imágenes; los Dockerfiles copian `target/*.jar` ya compilado).

```bash
# 1. Compilar todos los módulos (genera target/*.jar en cada servicio)
mvn clean package -DskipTests

# 2. Levantar toda la infraestructura
docker compose up --build
```

Espera unos segundos a que `mysql` y `keycloak` terminen de iniciar (los servicios
tienen `depends_on` con healthcheck para mysql, pero Keycloak puede tardar ~30-40s
la primera vez en importar el realm).

Verifica:
- Eureka: http://localhost:8761
- Keycloak: http://localhost:8180 (admin/admin)
- Swagger usuario-service: http://localhost:8081/swagger-ui.html
- Gateway: http://localhost:8080

Para bajar todo: `docker compose down` (agrega `-v` si quieres borrar también los datos de MySQL).

## Opción B: Levantar con IntelliJ (desarrollo)

1. Abre la carpeta raíz `fitness-microservices` en IntelliJ como proyecto **Maven**
   (File → Open → selecciona la carpeta que contiene el `pom.xml` padre).
2. Espera a que IntelliJ importe los 6 módulos.
3. Instala/levanta por separado lo que Docker haría por ti:
   - MySQL local (crea las 3 bases o usa `docker run` solo para el contenedor de mysql).
   - Keycloak local (`docker run -p 8180:8080 ... quay.io/keycloak/keycloak:24.0.4 start-dev --import-realm`
     montando `keycloak/fitness-realm.json`), o Docker solo para ese contenedor.
4. Crea una Run Configuration por cada módulo (Spring Boot) y ejecútalas **en este orden**:
   1. `EurekaServerApplication`
   2. `ConfigServerApplication`
   3. `UsuarioServiceApplication`
   4. `RutinaServiceApplication`
   5. `ProgresoServiceApplication`
   6. `ApiGatewayApplication`
5. Cada servicio toma su configuración de `config-repo/<servicio>.yml` a través del Config Server
   (`spring.config.import: optional:configserver:http://localhost:8888`).

## Obtener un token de Keycloak para probar en Postman

```
POST http://localhost:8180/realms/fitness-realm/protocol/openid-connect/token
Content-Type: application/x-www-form-urlencoded

grant_type=password
client_id=fitness-client
client_secret=fitness-client-secret
username=admin
password=admin123
```

Copia el `access_token` de la respuesta y úsalo como `Bearer Token` en Postman
(pestaña Authorization) para llamar a cualquier endpoint de los microservicios o del gateway.

## Estructura del repositorio

```
fitness-microservices/
├── pom.xml                  (padre, multi-módulo)
├── docker-compose.yml
├── init-db/init.sql         (creación de BDs y usuario MySQL)
├── keycloak/fitness-realm.json
├── config-repo/             (config centralizada leída por config-server)
├── eureka-server/
├── config-server/
├── api-gateway/
├── usuario-service/
├── rutina-service/
└── progreso-service/
```

## Notas importantes

- El `docker-compose.yml` fija `KC_HOSTNAME=localhost` en Keycloak para que el `issuer`
  del token sea siempre `http://localhost:8180/realms/fitness-realm`, tanto si el token
  se pide desde Postman (fuera de Docker) como si lo valida un microservicio (dentro de Docker).
  Para resolver la clave pública sí usan la URL interna
  `http://keycloak:8080/.../certs` vía `jwk-set-uri`.
- Este proyecto es un **punto de partida funcional**: ajusta reglas de autorización por
  rol (`hasRole(...)`), agrega paginación, tests, y circuit breakers (Resilience4j) según
  lo que pida tu rúbrica.
