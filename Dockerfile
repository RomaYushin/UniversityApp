FROM openjdk:16-jdk-alpine
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} UniversityApp.jar
ENTRYPOINT ["java", "-jar", "UniversityApp.jar"]
