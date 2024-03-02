#!/bin/bash

# Kill existing running container
docker ps -a --filter ancestor=stellaris-empire-manager --format {{.Names}} | xargs -r docker rm -f

# Build JAR for the image
./mvnw clean package -DskipTests

# Build the Docker image
docker build -t stellaris-empire-manager .

# Run the Docker container
docker run -d --network stellaris-network -p 8080:8080 stellaris-empire-manager:latest
