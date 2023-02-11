# stage 1
# Start with a base image containing Java runtime
FROM openjdk:20-slim as build

# add maintainer info
LABEL maintainer="Paolo Pakerno <paolopakerno@gmail.com>"

#The application's jar file
ARG JAR_FILE

#Add the application's jar file to the container with a fixed new name
COPY ${JAR_FILE} app.jar

#Unpackage jar file
RUN mkdir -p target/dependency && (cd target/dependency; jar -xf /app.jar)


# stage 2
#Same Java Runtime
FROM openjdk:20-slim

#Add volume pointing to /tmp
VOLUME /tmp

# Copy unpackaged application to new container
ARG DEPENDENCY=/target/dependency
COPY --from=build ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY --from=build ${DEPENDENCY}/META-INF /app/META-INF
COPY --from=build ${DEPENDENCY}/BOOT-INF/classes /app

#execute the application
ENTRYPOINT [ "java","-cp","app:app/lib/*","com.myoptimagrowth.configserver.ConfigurationServerApplication" ]
