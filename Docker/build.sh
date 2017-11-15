#!/usr/bin/env bash
cd ..
gradle clean; gradle build
cd -

cp ../build/libs/springboot-mongodb-1.0.0.jar springboot-mongodb-1.0.0.jar
cp ../application.yml application.yml

docker build -t yashvijaydocker/springboot-mongodb:YV091117 .
echo "To push execute:"
echo "docker push yashvijaydocker/springbootgradle-starter:YV091117"
