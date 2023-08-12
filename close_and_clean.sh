#!/bin/bash
# stop all containers 
docker stop $(docker ps -aq)
#delete all containers
docker rm $(docker ps -aq)
#delete all images 
docker rmi $(docker images -aq) -f
# delete mynetwork
docker network rm mynetwork
