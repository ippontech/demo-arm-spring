# We'll use a multi-step build here. Java uses a runtime
# so that makes this easy.
# (a compiled language you'd need a bit of parametrization, o
# or even just a naive approach where you compile in the container)
#
# the FROM keyword defines our base image, which we add
# 'layers' to. Base images themselves are 'layered'. 
# each of these all-caps lines represents a new 'layer'.
#
# it's not that necessary to know this but it does help explain
# why images can get so big, and why it's possible to get a 
# $4500 bill for AWS container repos for bandwidth usage.
# 
# containers have names and tags; this named `eclipse-temurin` and tagged at `17`.
# it is a JDK image for Java 17 (OpenJDK is dead again thanks to Oracle)
FROM eclipse-temurin:17 AS builder
# WORKDIR, COPY and RUN should be clear but here what we
# do is move out of the root, copy our current directory into /app,
# and then from /app run the `.gradlew bootJar` to build an app.
WORKDIR /app
COPY . /app
RUN ./gradlew bootJar 

# since Java builds runtimes against arm, we can just
# load the runtime here, grab the jar and be done with it.
#
# this new FROM will discard out the previous layers, which keeps the image smaller
# for fewer downloads, less internal dependencies/cleanup etc.
# We can also use a JRE (vs JDK) to keep this light, as well as
# Alpine, which is a very, very thin (about 5MB vs 200MB) base image.
FROM eclipse-temurin:17-jre-alpine
# Make it possible to allow traffic through to the container on port 8080.
# it remains still necessary to expose the port explicitly at runtime.
EXPOSE 8080 
# get the jar file we made in the previous container..
COPY --from=builder /app/build/libs/arm-demo-0.0.1-SNAPSHOT.jar .
# after all these years, The Dream Realized: Write Once Run Anywhere
# this last line causes the container to run this command when it starts,
# so our app will launch. Another common pattern is to create an
# 'entrypoint' script, load it here in the container and then run it.
CMD java -jar arm-demo-0.0.1-SNAPSHOT.jar
