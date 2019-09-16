[![Build Status](https://travis-ci.org/thiagofarbo/rest-service-docker.svg?branch=master)](https://travis-ci.org/thiagofarbo/rest-service-docker)

#Commad to create a docker image.
docker build -f Dockerfile -t demo-docker-spring-boot .

#Commad to run your project on docker.
docker run -p 8085:8085 demo-docker-spring-boot

#How to access your database
To access your database,  got to http://localhost:8090/h2