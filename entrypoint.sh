#!/bin/bash

# Use the environment variable directly
SPRING_PROFILES_ACTIVE=${SPRING_PROFILES_ACTIVE}

# Start the Spring Boot application
exec java -jar -Dspring.profiles.active="$SPRING_PROFILES_ACTIVE" /"${JAR_FULL_NAME}"
