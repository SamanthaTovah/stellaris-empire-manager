#!/bin/sh

echo "Checking for git.properties in the JAR..."
jar tf /$JAR_FULL_NAME | grep git.properties && echo "git.properties found!" || echo "git.properties NOT found!"

java -jar -Dspring.profiles.active=$SPRING_PROFILES_ACTIVE /$JAR_FULL_NAME
