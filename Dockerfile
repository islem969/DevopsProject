FROM openjdk:17-jdk-alpine
EXPOSE 8089
ADD target/IntershipManagement-0.0.1-SNAPSHOT.jar IntershipManagement-0.0.1-SNAPSHOT.jar
COPY target/IntershipManagement-0.0.1-SNAPSHOT IntershipManagement-0.0.1-SNAPSHOT
ENTRYPOINT["java","-jar","/IntershipManagement-0.0.1-SNAPSHOT.jar"]