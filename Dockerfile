FROM maven:3.9-eclipse-temurin-17-alpine AS builder

# Set the working directory inside the container
WORKDIR /app

# Copy the Maven project files (pom.xml, src directory) to the container
COPY . .

# Build the application into an executable JAR file
RUN mvn clean package -DskipTests

## === RUNTIME STAGE ===
FROM eclipse-temurin:17-jdk-alpine

# Set the working directory for the runtime
WORKDIR /app

# Copy the built JAR file from the 'builder' stage to the runtime container
# Adjust the JAR file name if necessary (e.g., target/your-app-name-*.jar)
COPY --from=builder /app/target/*.jar app.jar

# Expose the port the Spring Boot app listens on (default is 8080)
EXPOSE 8080

# Command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]