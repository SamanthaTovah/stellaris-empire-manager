# stellaris-empire-manager

**Stellaris Empire Manager** is a simple web application I created to help me organize and manage my custom Stellaris
game empires.

## Setup

#### Local image building

To locally create containers to be pushed to the registry to be used by services like ECS, you need to run the following
commands to support the multi architecture Docker build:

    # Enable
    docker buildx create --name mymultiarchbuilder --use
    # Turn on
    docker buildx inspect --bootstrap
    # Verify
    docker buildx inspect mymultiarchbuilder --bootstrap

## Spring profiles

This application uses different Spring profiles to function in different environments and different databases:

### virtual

Profile for local non-containerized development. Uses an H2 virtual database.

The application will be served on http://localhost:8080.

### docker

Profile for local containerized development. Expects an existing Docker network and MySQL container running in Docker
Desktop. See 'database_run.sh' for details.

The application will be served on http://localhost:8080.
