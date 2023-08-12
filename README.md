# Dockerized Multi-Module Java Web Application

This repository provides a guide and scripts for Dockerizing a multi-module Java web application. The project comprises three modules: `backend`, `frontend`, and `frontend2`. This README offers step-by-step instructions to containerize each module, deploy the application using Docker Compose, and includes scripts for easy management.

## Prerequisites

Before you begin, ensure you have the following tools installed:

- Docker
  
## Project Overview

The project includes the following modules:

- `backend`: A Java application serving as the backend API on port 8084.
- `frontend` and `frontend2`: Java web applications using the Jetty server on ports 8081 and 8082.

## Docker Basics

Docker is a platform for creating, deploying, and managing containers. Key concepts include:

- **Containers**: Lightweight, isolated environments.
- **Images**: Templates used to create containers.
- **Dockerfile**: Script that defines image-building instructions.
- **Docker Compose**: Tool for orchestrating multi-container applications.

## Building Docker Images

### Backend Module

1. Navigate to the `backend` directory.
2. Create a Dockerfile with `openjdk:11-jre-slim` as the base image.
3. Install Maven inside the image and copy project files.
4. Build the Docker image: `docker build -t backend:1.0.0 .`

### Frontend and Frontend2 Modules

1. Navigate to the `frontend` and `frontend2` directories.
2. Create Dockerfiles in both directories.
3. Use `eclipse-temurin:17-jdk-alpine` as the base image for lightweight Java.
4. Copy the project files and build the Docker images:
   - `docker build -t frontend:1.0.0 .`
   - `docker build -t frontend2:1.0.0 .`

## Docker Compose Configuration

The `docker-compose.yaml` file defines the application's structure:

- `backend`: Uses the `backend:1.0.0` image and exposes port 8084.
- `frontend`: Builds from the `frontend` directory and maps port 8081 to 8080.
- `frontend2`: Builds from the `frontend2` directory and maps port 8082 to 8080.

### Networking

An external network named `mynetwork` is utilized.

## Start and Close Scripts

Two scripts are provided for easy management:

- **start_app.sh**: Creates the `mynetwork` network, builds the Docker images, and starts the application containers using `docker-compose up -d`.

- **close_and_clean.sh**: Stops and removes the application containers and the external network using `docker-compose down` and `docker network rm`.

To use the scripts, execute them in your project directory:

```bash
./start_app.sh    # To start the application
./close_and_clean.sh    # To stop and clean up the application

```
## Deployment and Usage
Run the following command to initiate the application:

```bash
./start_app.sh
Access the modules:

Backend: http://localhost:8080
Frontend: http://localhost:81
Frontend2: http://localhost:82
```
## Troubleshooting

If encountering network issues, ensure the mynetwork network exists using the following command:

docker network create mynetwork

Review container logs for more information using the following command:
``` docker-compose logs ```

## Conclusion
By following this guide, you have successfully Dockerized your multi-module Java web application. Docker simplifies deployment, enhances portability, and offers efficient container management, providing a scalable and maintainable solution across different environments.
