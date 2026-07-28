FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY nutricion-service/target/nutricion-service.jar app.jar
EXPOSE 8086
ENTRYPOINT ["java", "-jar", "app.jar"]
