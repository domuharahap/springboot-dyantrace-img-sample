# springboot-dyantrace-img-sample
This repository contain Spring boot simple application integrated with OneAgent into a binary build with a Dockerfile.

# Requirements
Java 8+
Docker

# Install
Spring boot application to compiled before build the docker images

*_$ mvn clean install_*

*_$ docker build -d -t users ._*


# Run docker images
Launch the docker images

*_$docker run -d users_*
