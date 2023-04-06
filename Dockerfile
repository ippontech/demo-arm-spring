FROM amazoncorretto:17 AS builder
WORKDIR /app
COPY . /app
RUN ./gradlew bootJar 

FROM amazoncorretto:17
EXPOSE 8080
COPY --from=builder /app/build/libs/arm-demo-0.0.1-SNAPSHOT.jar .
CMD java -jar arm-demo-0.0.1-SNAPSHOT.jar
