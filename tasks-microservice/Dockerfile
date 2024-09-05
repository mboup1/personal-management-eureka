#Dockerfile of tasks-microservice

FROM openjdk:17-jdk-slim

COPY target/tasks-microservice-0.0.1-SNAPSHOT.jar /app/tasks-microservice.jar

WORKDIR /app

EXPOSE 8181

ENTRYPOINT ["java", "-jar", "tasks-microservice.jar"]