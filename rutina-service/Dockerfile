FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY rutina-service/target/rutina-service.jar app.jar
EXPOSE 8082
ENTRYPOINT ["java", "-jar", "app.jar"]
