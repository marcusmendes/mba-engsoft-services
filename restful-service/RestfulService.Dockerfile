FROM amazoncorretto:17.0.4-alpine3.15

COPY restful-service /app/restful-service
COPY mvnw /app/
COPY pom.xml /app/
COPY .mvn /app/.mvn

WORKDIR /app

RUN ls -la
RUN sh ./mvnw package

CMD java -jar /app/restful-service/target/restful-service-0.0.1-SNAPSHOT.jar

EXPOSE 8080