FROM openjdk:17-jdk
ENV ENVIRONMENT=prod
COPY target/jokes-0.0.1-SNAPSHOT.jar app.jar
CMD ["java", "-Dspring.profiles.active=docker", "-jar", "/app.jar"]
