package com.fitness.progreso.client;

import com.fitness.progreso.dto.UsuarioResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Comunicacion entre microservicios: progreso-service consulta a
 * usuario-service (via Eureka + Feign) para validar al usuario antes
 * de registrar un progreso.
 */
@FeignClient(name = "usuario-service")
public interface UsuarioClient {

    @GetMapping("/api/usuarios/{id}")
    UsuarioResponse obtenerUsuario(@PathVariable("id") Integer id);

    @GetMapping("/api/usuarios/{id}/existe")
    Boolean existeUsuario(@PathVariable("id") Integer id);
}
