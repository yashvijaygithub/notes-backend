FROM java:8-alpine

EXPOSE 8080

ENTRYPOINT ["java","-Xmx1024m", "-Djava.security.egd=file:/dev/./urandom","-jar","/spring-boot-gradle-1.0.0.jar"]

COPY build/application.yml application.yml
COPY build/spring-boot-gradle-1.0.0.jar spring-boot-gradle-1.0.0.jar