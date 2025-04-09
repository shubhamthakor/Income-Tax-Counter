
# Use Maven to build the application
# Stage 1: Use Maven to build the application
FROM maven:3.9.4-eclipse-temurin-17 AS builder

# Set working directory inside container
WORKDIR /build

# Copy the project source code into the container
COPY tax-counter/ .

# Build the project with Maven
RUN mvn clean install -DskipTests


# Use a smaller image to run the application

# Stage 2: Use a smaller image to run the application

FROM eclipse-temurin:17-jdk

# Set working directory in the runtime container
WORKDIR /app

# Copy the built jar from the builder stage
COPY --from=builder /build/target/*.jar app.jar


# Run the app
CMD ["java", "-jar", "app.jar"]

# Expose the port (use the one in application.properties if set to 9090)
EXPOSE 9090

# Run the app
CMD ["java", "-jar", "app.jar"]

