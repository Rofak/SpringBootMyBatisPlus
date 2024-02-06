# Use an official OpenJDK runtime as a parent image
FROM openjdk:21-jdk-slim

# Set the working directory to /app
WORKDIR /app

# Copy the packaged JAR file into the container at /app
COPY target/SpringMyBatisPlusDemo-0.0.1-SNAPSHOT.jar /app/springboot-docker-demo.jar

# Make port 8080 available to the world outside this container
EXPOSE 8080

CMD ["java", "-jar", "springboot-docker-demo.jar"]