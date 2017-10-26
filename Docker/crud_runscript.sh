#!/bin/bash

docker pull yashvijaydocker/springbootgradle-starter:YV261017

docker rm -f springBootGradle-starter

docker run \
    -d \
    --name springBootGradle-starter \
     --restart always \
    -p 8891:8080 \
    yashvijaydocker/springbootgradle-starter:YV261017