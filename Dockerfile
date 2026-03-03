FROM eclipse-temurin:17-jdk-jammy

LABEL maintainer="astra"
EXPOSE 8080

WORKDIR /app
COPY target/RescueSpot-0.0.1-SNAPSHOT.jar /app/RescueSpot.jar

ENTRYPOINT ["java", "-jar", "RescueSpot.jar"]
