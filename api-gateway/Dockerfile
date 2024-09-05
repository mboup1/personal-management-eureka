#Dockerfile of api-gateway

FROM openjdk:17-jdk-slim

COPY target/api-gateway-0.0.1-SNAPSHOT.jar /app/api-gateway.jar

WORKDIR /app

EXPOSE 8761

ENTRYPOINT ["java", "-jar", "api-gateway.jar"]