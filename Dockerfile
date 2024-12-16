# OpenJDK image
# FROM openjdk:17-jdk-slim
# # Set the working directory inside the container
# WORKDIR /patient-service
# # Copy the built JAR file from the target directory to the container
# COPY target/patient-service.jar patient-service.jar
# EXPOSE 8080
# ENTRYPOINT ["java", "-jar", "patient-service.jar"]

FROM openjdk:17-jdk-slim

EXPOSE 8080

ARG JAR_FILE=target/patient-service.jar
ADD target/patient-service.jar patient-service.jar

ENTRYPOINT exec java -jar /patient-service.jar

