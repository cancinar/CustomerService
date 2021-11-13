FROM openjdk:11-jre-slim
WORKDIR /app
COPY target/customer-service-0.0.1-SNAPSHOT.jar /app/
ENTRYPOINT ["java", "-jar", "customer-service-0.0.1-SNAPSHOT.jar"]