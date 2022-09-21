FROM openjdk:18

RUN mkdir "/app"

ADD target/shipping-1.0-SNAPSHOT.jar /app/shipping-1.0-SNAPSHOT.jar

EXPOSE 8083

CMD java -jar /app/shipping-1.0-SNAPSHOT.jar