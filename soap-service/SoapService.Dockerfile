FROM amazoncorretto:17.0.4-alpine3.15

COPY . /app/

WORKDIR /app

RUN ls -la
RUN sh ./mvnw -pl .,soap-service -am package

CMD java -jar /app/soap-service/target/soap-service-0.0.1-SNAPSHOT.jar

EXPOSE 8080