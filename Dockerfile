FROM openjdk:8
MAINTAINER Thiago Emidio
ADD target/demo-docker-spring-boot.jar demo-docker-spring-boot.jar
EXPOSE 8090
ENTRYPOINT ["java", "-jar", "demo-docker-spring-boot.jar"]