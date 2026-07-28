FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY ejercicio-rutina-service/target/ejercicio-rutina-service.jar app.jar
EXPOSE 8085
ENTRYPOINT ["java", "-jar", "app.jar"]
