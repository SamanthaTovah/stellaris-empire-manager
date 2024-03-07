# stellaris-empire-manager

**Stellaris Empire Manager** is a Spring Boot application connected to a database to store custom empires created in
Stellaris.

## Setup

### AWS

This repository is set up to be linked to my personal AWS account and the various services available therein. To use
this
in a similar manner you will need to set up a similar environment in AWS as well as change various hardcoded AWS related
values in application-aws.properties, .github/workflows/build-and-push-image-to-ecr.yml, and perhaps other files. These
values may later be
changed to environmental variables to keep this project AWS-account agnostic.

Local development is not associated to AWS/ECR in any way.

#### ECR Setup

The ECR setup is a fairly basic Fargate setup with an associated RDS MySQL database.

#### Local image building

To locally create containers to be pushed to the registry to be used by ECR, you need to run the following commands to
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
