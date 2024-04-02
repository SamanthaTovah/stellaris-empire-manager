#!/bin/bash

IMAGE_NAME=stellaris-empire-manager

# Kill existing running container
docker ps -a --filter ancestor=${IMAGE_NAME} --format {{.Names}} | xargs -r docker rm -f

# Build the Docker image
docker build -t ${IMAGE_NAME} .

# Run the Docker container
docker run -d --network stellaris-network -p 8080:8080 -e SPRING_PROFILES_ACTIVE=docker \
  ${IMAGE_NAME}:latest
