FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY progreso-service/target/progreso-service.jar app.jar
EXPOSE 8083
ENTRYPOINT ["java", "-jar", "app.jar"]
