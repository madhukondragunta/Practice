FROM openjdk:21-jdk-slim
WORKDIR /app
COPY target/practice-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 7070
ENTRYPOINT ["java", "-jar", "app.jar"]