#!/bin/bash

# Define variables
ECR_URI="339712844314.dkr.ecr.eu-north-1.amazonaws.com/stellaris-empire-manager"
REGION="eu-north-1"

# AWS ECR Login
aws ecr get-login-password --region $REGION | docker login --username AWS --password-stdin $ECR_URI

# Build JAR for the image
./mvnw clean package -DskipTests

# Ensure Docker uses the buildx builder with multi-arch support
docker buildx use mymultiarchbuilder``

# Build and push the Docker image for multiple platforms
docker buildx build --platform linux/amd64,linux/arm64 -t $ECR_URI:latest --push .

echo "Spring Boot application image pushed to ECR successfully."
