FROM openjdk:17-jdk-alpine
EXPOSE 8089
ADD target/IntershipManagement-0.0.1-SNAPSHOT.jar IntershipManagement.jar
ENTRYPOINT ["java", "-jar", "IntershipManagement.jar"]
