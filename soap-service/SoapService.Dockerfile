FROM amazoncorretto:17.0.4-alpine3.15

COPY soap-service /app/soap-service
COPY mvnw /app/
COPY pom.xml /app/
COPY .mvn /app/.mvn

WORKDIR /app

RUN ls -la
RUN sh ./mvnw package

CMD java -jar /app/soap-service/target/soap-service-0.0.1-SNAPSHOT.jar

EXPOSE 8080