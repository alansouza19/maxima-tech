FROM openjdk:latest
WORKDIR /app
COPY /target/maxima.tech-0.0.1-SNAPSHOT.jar /app/maxima-tech-app.jar
ENTRYPOINT ["java", "-jar", "maxima-tech-app.jar"]
EXPOSE 8080