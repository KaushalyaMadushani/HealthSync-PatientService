# OpenJDK image
FROM openjdk:17-jdk-slim
# Set the working directory inside the container
WORKDIR /patient-service
# Copy the built JAR file from the target directory to the container
COPY target/patient-service.jar patient-service.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "patient-service.jar"]
