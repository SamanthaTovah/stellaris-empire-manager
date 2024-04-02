#!/bin/sh

java -jar -Dspring.profiles.active=$SPRING_PROFILES_ACTIVE /$JAR_FULL_NAME
