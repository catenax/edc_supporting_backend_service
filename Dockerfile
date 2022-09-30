FROM maven:3.8.5-openjdk-18-slim as build

WORKDIR /customservice

# copy the project files
COPY ./pom.xml /pom.xml

# copy your other files
COPY ./src ./src

# build for release
RUN mvn clean install 

WORKDIR target

#ENTRYPOINT ["java","-jar","auto-setup-0.0.1.jar"]

EXPOSE 10092

