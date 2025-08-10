FROM amazoncorretto:21

WORKDIR /usr/local/app

COPY target/perfectnumber-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

RUN chmod 777 *.jar

CMD ["java", "-jar", "-Dspring.profiles.active=docker", "app.jar"]

