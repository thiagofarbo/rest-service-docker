FROM openjdk:8
ADD target/demo-docker-spring-boot-0.0.1-SNAPSHOT.jar demo-docker-spring-boot-0.0.1-SNAPSHOT.jar
EXPOSE 8085
ENTRYPOINT ["java", "-jar", "demo-docker-spring-boot-0.0.1-SNAPSHOT.jar"]