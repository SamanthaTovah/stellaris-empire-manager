FROM eclipse-temurin:21-jdk

LABEL maintainer="samantha.tovah@gmail.com"

VOLUME /tmp

EXPOSE 8080

# ENV because it is used in ENTRYPOINT command
ENV JAR_FULL_NAME=stellaris-empire-manager-0.0.1-SNAPSHOT.jar
ARG JAR_FILE="target/${JAR_FULL_NAME}"
ADD ${JAR_FILE} ${JAR_FULL_NAME}

ENTRYPOINT java -jar /${JAR_FULL_NAME}
