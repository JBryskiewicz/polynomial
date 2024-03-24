FROM eclipse-temurin:20-jdk-alpine
WORKDIR /app
COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]