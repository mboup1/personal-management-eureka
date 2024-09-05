#Dockerfile of eureka-server

FROM openjdk:17-jdk-slim

COPY target/eureka-server-dame-0.0.1-SNAPSHOT.jar /app/eureka-server.jar

WORKDIR /app

EXPOSE 8761

ENTRYPOINT ["java", "-jar", "eureka-server.jar"]