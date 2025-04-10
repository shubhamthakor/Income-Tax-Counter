# Stage 1: Build the application using Maven
FROM maven:3.8.3-openjdk-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Stage 2: Run the app
FROM openjdk:17.0.1-jdk-slim
WORKDIR /app
COPY --from=build /app/target/tax-counter-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 9090
ENTRYPOINT ["java", "-jar", "app.jar"]