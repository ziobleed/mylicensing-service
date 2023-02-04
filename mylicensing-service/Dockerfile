
FROM openjdk:20-slim as build
WORKDIR application
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} application.jar
RUN java -Djarmode=layertools -jar application.jar extract


FROM openjdk:20-slim
WORKDIR application


COPY --from=build application/dependencies/ ./
COPY --from=build application/spring-boot-loader/ ./
COPY --from=build application/snapshot-dependencies/ ./
COPY --from=build application/ ./


#execute the application
ENTRYPOINT [ "java", "org.springframework.boot.loader.JarLauncher" ]
