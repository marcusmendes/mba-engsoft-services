FROM amazoncorretto:17.0.4-alpine3.15

COPY . /app/

WORKDIR /app

RUN ls -la
RUN sh ./mvnw -pl .,graphql-service -am package

CMD java -jar /app/graphql-service/target/graphql-service-0.0.1-SNAPSHOT.jar

EXPOSE 8080