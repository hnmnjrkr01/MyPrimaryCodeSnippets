#Start with a base image containing Java runtime
#FROM openjdk:11-slim as build
FROM openjdk:11 as build

#Information around who maintains the image
MAINTAINER cloudbank.com

# Add the application's jar to the container
COPY target/DS01-MovieCatalogService4-0.0.1-SNAPSHOT.jar DS01-MovieCatalogService4-0.0.1-SNAPSHOT.jar 

#execute the application
ENTRYPOINT ["java","-jar","/DS01-MovieCatalogService4-0.0.1-SNAPSHOT.jar"]
