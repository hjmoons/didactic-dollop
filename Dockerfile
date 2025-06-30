FROM openjdk:17-jdk-alpine

WORKDIR /app

ADD build/libs/*.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]