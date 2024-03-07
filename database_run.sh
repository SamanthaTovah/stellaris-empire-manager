#!/bin/bash

# Create the docker network to be used by both the db container and the empire manager container
docker network create stellaris-network

# Run the MySQL container
docker run --name mysql-db -e MYSQL_ROOT_PASSWORD=mysql -e MYSQL_DATABASE=empiredb --network stellaris-network -p 3306:3306 -d mysql:latest
