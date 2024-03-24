# Use an official Java runtime as a parent image
FROM openjdk:21-jdk

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file into the container
COPY target/JobApplication-0.0.1-SNAPSHOT.jar /app/JobApplication.jar

# Make port 8080 available to the world outside this container
EXPOSE 8080

# Run the application when the container launches
CMD ["java", "-jar", "JobApplication.jar"]
