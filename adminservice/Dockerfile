#Start with a base image containing Java runtime
#FROM openjdk:11-slim as build
FROM openjdk:11 as build

#Information around who maintains the image
MAINTAINER cloudbank.com

# Add the application's jar to the container
COPY target/adminservice-0.0.1-SNAPSHOT.jar adminservice-0.0.1-SNAPSHOT.jar

#execute the application
ENTRYPOINT ["java","-jar","/adminservice-0.0.1-SNAPSHOT.jar"]
