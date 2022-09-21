FROM openjdk:17

RUN mkdir "/app"

ADD target/order-1.0-SNAPSHOT.jar /app/order-1.0-SNAPSHOT.jar

EXPOSE 8083

CMD java -jar /app/order-1.0-SNAPSHOT.jar