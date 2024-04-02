# Build stage
FROM jelastic/maven:3.9.5-openjdk-21 AS builder
WORKDIR /app
# Copy your source code and build the application
COPY . .
RUN mvn clean package -DskipTests

# Run stage
FROM eclipse-temurin:21-jdk
LABEL maintainer="samantha.tovah@gmail.com"
VOLUME /tmp
EXPOSE 8080
ENV JAR_FULL_NAME stellaris-empire-manager-0.0.1-SNAPSHOT.jar
# Copy the built JAR file from the build stage
COPY --from=builder /app/target/${JAR_FULL_NAME} /${JAR_FULL_NAME}
COPY start.sh /start.sh
ENTRYPOINT ["/start.sh"]
