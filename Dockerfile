FROM eclipse-temurin:19-jdk-alpine
VOLUME /tmp
ENTRYPOINT ["java","-jar","app.jar"]
EXPOSE 8080
