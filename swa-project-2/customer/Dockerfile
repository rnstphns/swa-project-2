FROM openjdk:17

RUN mkdir "/app"

ADD target/customer-1.0-SNAPSHOT.jar /app/customer-1.0-SNAPSHOT.jar

EXPOSE 8080

CMD java -jar /app/customer-1.0-SNAPSHOT.jar