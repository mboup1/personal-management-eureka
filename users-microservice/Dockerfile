#Dockerfile of users-microservice
FROM openjdk:17-jdk-slim

COPY target/users-microservice-0.0.1-SNAPSHOT.jar /app/users-microservice.jar

WORKDIR /app

EXPOSE 8282

ENTRYPOINT ["java", "-jar", "users-microservice.jar"]