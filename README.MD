# stellaris-empire-manager

**Stellaris Empire Manager** is a simple web application I created to help me organize and manage my custom Stellaris
game empires. It's built using Spring Boot for straightforward backend development and Docker to keep my deployment
environment consistent.

For keeping things secure, I've integrated Spring Security. The app's data is stored in a MySQL database hosted on
Amazon RDS, aiming for persistence and ease of access. AWS Elastic Container Registry (ECR) is where the Docker images
are stored, and the application runs on AWS Elastic Container Service (ECS) with Fargate.

## Setup

### AWS

This repository is set up to be linked to my personal AWS account and the various services available therein. To use
this
in a similar manner you will need to set up a similar environment in AWS as well as change various hardcoded AWS related
values in application-aws.properties, redeploy-ecs-application.yml, and perhaps other files. These
values may later be
changed to environmental variables to keep this project AWS-account agnostic.

Local development is not associated to AWS/ECS in any way.

#### ECC/ECR Setup

The ECS setup is a fairly basic Fargate setup with an associated RDS MySQL database and an ECR repository for the Spring
Boot application image.

#### Local image building

To locally create containers to be pushed to the registry to be used by ECS, you need to run the following commands to
support the multi architecture Docker build:

    # Enable
    docker buildx create --name mymultiarchbuilder --use
    # Turn on
    docker buildx inspect --bootstrap
    # Verify
    docker buildx inspect mymultiarchbuilder --bootstrap

After this 'application_build_and_push.sh' can be used to create a new image and push it to the registry, assuming you
have credentials for the default one or substitute the destination and other account-specific values.

## Spring profiles

This application uses different Spring profiles to function in different environments and different databases:

### virtual

Profile for local non-containerized development. Uses an H2 virtual database.

The application will be served on http://localhost:8080.

### docker

Profile for local containerized development. Expects an existing Docker network and MySQL container running in Docker
Desktop. See 'database_run.sh' for details.

The application will be served on http://localhost:8080.

### aws

Profile for the production environment.

The application does not currently have a regular public URL, but it will for now be served
on http://stellaris-empire-manager-lb-vpc2-1835008551.eu-north-1.elb.amazonaws.com/empires.
