FROM eclipse-temurin:19-jdk-alpine
VOLUME /tmp
ENTRYPOINT ["java","-jar","/target/core-0.0.1-SNAPSHOT.jar"]
EXPOSE 8080
