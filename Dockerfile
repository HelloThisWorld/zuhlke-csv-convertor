FROM openjdk:11

EXPOSE 8090

RUN mkdir /app

COPY ./build/libs/converter-0.0.1-SNAPSHOT.jar ./app/spring-boot-application.jar

ENTRYPOINT ["java", "-jar", "/app/spring-boot-application.jar"]
