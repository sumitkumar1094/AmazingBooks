FROM openjdk:11
ADD target/config-service-0.0.1-SNAPSHOT.jar configserver.jar
ENTRYPOINT ["java", "-jar", "configserver.jar"]