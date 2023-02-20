# Install Operating system and dependencies
FROM openjdk:8-jdk-alpine
ADD target/supportportal-0.0.1-SNAPSHOT.jar springboot-app.jar
EXPOSE 5000
ENTRYPOINT ["java","-jar","springboot-app.jar"]
