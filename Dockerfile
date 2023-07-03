FROM openjdk:19
ADD ./api-abrsrvi.jar api-abrsrvi.jar
ENTRYPOINT ["java","-jar","api-abrsrvi.jar"]

