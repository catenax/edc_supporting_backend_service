FROM openjdk:11
# ADD target/edc-backend-service-0.0.1.jar edc-backend-service.jar
EXPOSE 10092
ENTRYPOINT ["java","-jar","edc-backend-service.jar"]
