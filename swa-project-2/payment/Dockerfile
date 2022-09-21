FROM openjdk:17

RUN mkdir "/app"

ADD target/payment-1.0-SNAPSHOT.jar /app/payment-1.0-SNAPSHOT.jar

EXPOSE 8083

CMD java -jar /app/payment-1.0-SNAPSHOT.jar