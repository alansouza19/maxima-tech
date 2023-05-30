FROM openjdk:latest

COPY /target/maxima.tech-0.0.1-SNAPSHOT.jar /home/maxima-tech.jar
EXPOSE 8080

CMD ["java","-jar","/home/maxima-tech.jar"]