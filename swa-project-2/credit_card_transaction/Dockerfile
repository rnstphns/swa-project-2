FROM openjdk:17

RUN mkdir "/app"

ADD target/credit_card_transaction-1.0-SNAPSHOT.jar /app/credit_card_transaction-1.0-SNAPSHOT.jar

EXPOSE 8083

CMD java -jar /app/credit_card_transaction-1.0-SNAPSHOT.jar