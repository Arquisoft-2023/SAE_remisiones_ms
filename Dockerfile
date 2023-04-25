FROM openjdk:17-jdk-alpine3.14
ADD target/remisiones-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8082
ENTRYPOINT ["java","-jar","app.jar"]