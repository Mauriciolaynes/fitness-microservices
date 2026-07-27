FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY config-server/target/config-server.jar app.jar
COPY config-repo /config-repo
EXPOSE 8888
ENTRYPOINT ["java", "-jar", "app.jar"]
