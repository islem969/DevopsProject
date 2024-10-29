FROM openjdk:17-jdk-alpine
EXPOSE 8089
ADD target/IntershipManagement-0.0.1.jar IntershipManagement-0.0.1.jar
COPY target/IntershipManagement-0.0.1 IntershipManagement-0.0.1
ENTRYPOINT ["java","-jar","IntershipManagement-0.0.1.jar"]