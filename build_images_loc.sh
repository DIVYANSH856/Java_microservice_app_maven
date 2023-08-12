#!/bin/bash
# Build backend image
echo "Building backend image..."
docker build -t module-name:1.0.0 ./backend
# Build frontend1 image
echo "Building frontend1 image..."
docker build -t frontend:1.0.0 ./frontend
# Build frontend2 image
echo "Building frontend2 image..."
docker build -t frontend1:1.0.0 ./frontend2
echo "All images built successfully!"