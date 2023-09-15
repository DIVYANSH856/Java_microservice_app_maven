#!/bin/bash
# Create the network if it doesn't exist
docker network create mynetwork 2>/dev/null || true
# Start the services using docker-compose
docker compose up -d
