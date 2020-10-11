FROM openjdk:8-jdk-alpine as build
WORKDIR /workspace/app

COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src

RUN ./mvnw install

FROM openjdk:8-jdk-alpine

VOLUME /tmp

ARG APP_NAME
ARG DEPENDENCY=/workspace/app/target
ARG ARTIFACT_NAME
ENV APP_NAME=$APP_NAME
 
COPY --from=build /workspace/app/target/challenge-0.0.1-SNAPSHOT.jar /app/challenge-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","/app/challenge-0.0.1-SNAPSHOT.jar"]