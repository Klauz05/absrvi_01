FROM openjdk:19
ADD ./api-absrvi.jar api-absrvi.jar
ENTRYPOINT ["java","-jar","api-absrvi.jar"]

