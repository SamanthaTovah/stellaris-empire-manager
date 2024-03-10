#!/bin/bash

# Check if the stellaris-network already exists
network_exists=$(docker network ls --filter name=stellaris-network -q)
if [ -z "$network_exists" ]; then
  docker network create stellaris-network
fi

# Run the MySQL container
docker run --name mysql-db -e MYSQL_ROOT_PASSWORD=mysql -e MYSQL_DATABASE=empiredb --network stellaris-network -p 3306:3306 -d mysql:latest
