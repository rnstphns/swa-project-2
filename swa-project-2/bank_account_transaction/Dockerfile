FROM openjdk:17

RUN mkdir "/app"

ADD target/bank_account_transaction-1.0-SNAPSHOT.jar /app/bank_account_transaction-1.0-SNAPSHOT.jar

EXPOSE 8090

CMD java -jar /app/bank_account_transaction-1.0-SNAPSHOT.jar