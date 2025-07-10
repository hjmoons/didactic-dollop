FROM openjdk:17-ea-slim

WORKDIR /app

ADD build/libs/*.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]