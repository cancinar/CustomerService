FROM openjdk:11-jre-slim
WORKDIR /app
COPY /target/geolocation-0.0.1-SNAPSHOT.jar /app/
ENTRYPOINT ["java", "-jar", "geolocation-0.0.1-SNAPSHOT.jar"]