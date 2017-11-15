#!/bin/bash

#docker pull yashvijaydocker/springbootgradle-starter:YV101117

#docker rm -f springbootgradle-starter

docker run \
     -d \
     --name springboot-service \
     --restart always \
     --net sam-ntwk
     --link mysql_test \
      -e spring.datasource.url='jdbc:mysql://mysql_test:3309/sampledb' \
      -e spring.datasource.userName='root' \
      -e spring.datasource.password='root' \
      -e spring.jpa.hibernate.ddl-auto='update' \
    -p 8892:8080 \
    yashvijaydocker/springbootgradle-starter:YV101117
