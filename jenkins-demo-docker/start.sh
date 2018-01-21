#!/bin/bash

find -exec dos2unix {} \;

source ./.env
export HYPERON_VER

if [ "$1" = "-f" ] ; then
  docker-compose stop
  docker-compose rm -fv
  docker rmi -f $(docker images -aq)
fi

docker-compose build
docker-compose up