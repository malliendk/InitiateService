FROM eclipse-temurin:21-jdk

# Set the working directory in the container
WORKDIR /app

# Copy the application JAR file to the container
# (Replace 'your-application.jar' with your actual JAR file name)
COPY your-application.jar /app/your-application.jar

# Expose the port your application uses (e.g., 8080)
EXPOSE 8080

# Command to run the application
CMD ["java", "-jar", "/app/your-application.jar"]
