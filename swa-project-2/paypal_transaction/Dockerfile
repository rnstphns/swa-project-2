FROM openjdk:18

RUN mkdir "/app"

ADD target/paypal_transaction-1.0-SNAPSHOT.jar /app/paypal_transaction-1.0-SNAPSHOT.jar

EXPOSE 8083

CMD java -jar /app/paypal_transaction-1.0-SNAPSHOT.jar