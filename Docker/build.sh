#!/usr/bin/env bash
cd ..
gradle clean; gradle build
cd -

cp ../build/libs/spring-boot-gradle-1.0.0.jar build/spring-boot-gradle-1.0.0.jar
cp ../application.yml build/application.yml

docker build -t yashvijaydocker/springbootgradle-starter:YV261017 .
echo "To push execute:"
echo "docker push yashvijaydocker/springbootgradle-starter:YV261017"