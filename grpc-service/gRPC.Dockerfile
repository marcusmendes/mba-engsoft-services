FROM eclipse-temurin:17-focal

COPY . /app/

RUN apt update && apt install -y protobuf-compiler

WORKDIR /app

RUN ls -la
RUN protoc --version
RUN sh ./mvnw -pl .,grpc-service -am package

CMD java -jar /app/grpc-service/target/grpc-service-0.0.1-SNAPSHOT.jar

EXPOSE 9090