FROM maven:latest

WORKDIR /customservice

# copy the project files
COPY . /customservice

# build for release

RUN mvn clean install -Dmaven.test.skip=true 

WORKDIR target

#ENTRYPOINT ["java","-jar","auto-setup-0.0.1.jar"]

EXPOSE 10092

