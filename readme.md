Dockerizing a Multi-Module Java Web Application
Introduction
This documentation provides a comprehensive guide to Dockerizing a multi-module Java web application. The project consists of three modules: backend, frontend, and frontend2. We'll walk you through the process of containerizing each module, using Docker Compose to manage containers, deploying the application, and providing convenient start and close scripts.

Prerequisites
Before you proceed, ensure you have the following tools installed:

Docker: Install Docker to build and manage containers.
Java: Ensure Java is installed for compiling and running Java applications.
Maven: Install Maven for building Java projects.
Project Overview
The project includes the following modules:

backend: A Java application serving as the backend API. It runs on port 8084 and provides RESTful services.
frontend and frontend2: Java web applications that use the Jetty server. They run on different ports (8081 and 8082) and serve web content.
Docker Basics
Docker is a powerful platform for creating, deploying, and managing containers. Here are some key concepts:

Containers: Lightweight, isolated environments that encapsulate applications and their dependencies.
Images: Templates used to create containers. Images include the application code and runtime dependencies.
Dockerfile: A script that defines the instructions to build an image.
Docker Compose: A tool for defining and running multi-container Docker applications.
Building Docker Images
Backend Module
Navigate to the backend directory.
Create a Dockerfile and specify the base image as openjdk:11-jre-slim.
Install Maven inside the image and copy the project files.
Build the Docker image: docker build -t backend:1.0.0 .
Frontend and Frontend2 Modules
Navigate to the frontend and frontend2 directories.
Create Dockerfiles in both directories.
Use eclipse-temurin:17-jdk-alpine as the base image for lightweight Java.
Copy the project files and build the Docker images:
docker build -t frontend:1.0.0 .
docker build -t frontend2:1.0.0 .
Docker Compose Configuration
The docker-compose.yaml file defines the structure of your multi-container application.

Services
backend: Uses the backend:1.0.0 image, exposes port 8084.
frontend: Builds from the frontend directory, maps port 8081 to 8080.
frontend2: Builds from the frontend2 directory, maps port 8082 to 8080.
Networking
An external network named mynetwork is defined using docker network create mynetwork.
All services are connected to the mynetwork network.
Start and Close Scripts
For your convenience, two scripts are provided to streamline the process:

start_app.sh: This script creates the external network (mynetwork) using docker network create, builds the Docker images, and starts the application containers using docker-compose up -d.

close_and_clean.sh: This script stops and removes the application containers and the external network using docker-compose down and docker network rm.

To use the scripts, simply execute them in your project directory:

bash
Copy code
./start_app.sh    # To start the application
./close_and_clean.sh    # To stop and clean up the application
Deployment and Usage
Use the provided start script to launch the application: ./start_app.sh.
Access the modules:
Backend: http://localhost:8084
Frontend: http://localhost:8081
Frontend2: http://localhost:8082
Troubleshooting
If you encounter network issues, ensure the mynetwork network is created using docker network create mynetwork.
Check container logs for more information using docker-compose logs.
Conclusion
By following this guide, you've successfully Dockerized your multi-module Java web application. Docker simplifies the deployment process, enhances portability, and makes managing containers efficient. You now have a scalable and maintainable solution for running your application in different environments.

Using the provided start and close scripts can make managing your Dockerized application even easier. Simply execute these scripts to launch and shut down your application and network with minimal effort.
