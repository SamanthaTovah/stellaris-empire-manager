# Stellaris Empire Manager

**Stellaris Empire Manager** is a simple web application I created to help me organize and manage my custom Stellaris
game empires.

## Spring profiles

This application uses different Spring profiles to function in different environments and different databases:

### virtual

Profile for local non-containerized development. Uses an H2 virtual database.

The application will be served on http://localhost:8080.

### docker

Profile for local containerized development. Expects an existing Docker network and MySQL container running in Docker
Desktop. See 'database_run.sh' for details.

The application will be served on http://localhost:8080.
