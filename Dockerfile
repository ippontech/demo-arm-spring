# We'll use a multi-step build here. Java uses a runtime
# so that makes this easy.
# (a compiled language you'd need a bit of parametrization, o
# or even just a naive approach where you compile in the container)
FROM eclipse-temurin:17 AS builder
WORKDIR /app
COPY . /app
RUN ./gradlew bootJar 

# since Java builds runtimes against arm, we can just
# load the runtime here, grab the jar and be done with it.
FROM eclipse-temurin:17-jre-alpine
EXPOSE 8080
COPY --from=builder /app/build/libs/arm-demo-0.0.1-SNAPSHOT.jar .
# after all these years, The Dream Realized: Write Once Run Anywhere
CMD java -jar arm-demo-0.0.1-SNAPSHOT.jar
