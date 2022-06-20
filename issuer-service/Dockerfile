FROM openjdk:11
ADD target/issue-service-0.0.1-SNAPSHOT.jar issuer.jar
ENTRYPOINT ["java", "-jar", "issuer.jar"]