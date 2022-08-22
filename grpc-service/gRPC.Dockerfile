FROM amazoncorretto:17.0.4-alpine3.15

COPY . /app/

WORKDIR /app

RUN ls -la
RUN sh ./mvnw -pl .,grpc-service -am package

CMD java -jar /app/grpc-service/target/grpc-service-0.0.1-SNAPSHOT.jar

EXPOSE 9090