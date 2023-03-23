# large image
#FROM openjdk:17-jdk-slim-buster
#COPY target/myspace-0.0.1-SNAPSHOT.jar myspace-0.0.1-SNAPSHOT.jar
#ENTRYPOINT ["java", "-jar", "/myspace-0.0.1-SNAPSHOT.jar"]

# small image
# during the search.. learn that is necessary to change pom to split jar from springboot
FROM eclipse-temurin:17-jre-alpine@sha256:d69f8cf3526fd75992366d2e96348682dfbc04c5d321c08d084e1fc26980d81d as builder
# First stage : Extract the layers
WORKDIR application
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} application.jar
RUN java -Djarmode=layertools -jar application.jar extract

FROM eclipse-temurin:17-jre-alpine@sha256:d69f8cf3526fd75992366d2e96348682dfbc04c5d321c08d084e1fc26980d81d as runtime
# Second stage : Copy the extracted layers
COPY --from=builder application/dependencies/ ./
COPY --from=builder application/spring-boot-loader ./
COPY --from=builder application/snapshot-dependencies/ ./
COPY --from=builder application/application/ ./
CMD ["java", "org.springframework.boot.loader.JarLauncher"]
