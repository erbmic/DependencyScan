# Dockerfile for the dependency-scan backend

# Customize public images
FROM maven:3.6.3-openjdk-14 as builder
#EXPOSE 8080
WORKDIR /app

# Build backend without runnung unit test
FROM builder as builded
COPY . /app
RUN mvn clean
RUN mvn -Dmaven.test.skip=true install

# Run unit tests
FROM builded as tested
COPY . /app
RUN mvn test

# Create application container
FROM openjdk:16-jdk-alpine3.12 as dependency-scan_backend
COPY --from=builded /app/target/dependency-scan_backend.jar /app/dependency-scan_backend.jar
COPY --from=builded /app/pom.xml /app/pom.xml
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app/dependency-scan_backend.jar"]
