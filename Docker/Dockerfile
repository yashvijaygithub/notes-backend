FROM openjdk:8-jdk

ADD springboot-mongodb-1.0.0.jar springboot-mongodb-1.0.0.jar

RUN sh -c 'touch /springboot-mongodb-1.0.0.jar'

ENTRYPOINT ["java", "-Dspring.responseData.mongodb.uri=mongodb://mongodb/users","-Djava.security.egd=file:/dev/./urandom","-jar","/springboot-mongodb-1.0.0.jar"]
