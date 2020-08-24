FROM maven:3.6.3-jdk-8-slim AS builder
COPY src /home/app/src
ADD pom.xml /home/app
RUN mvn -ntp -f /home/app/pom.xml clean package -DskipTests

FROM openjdk:8-jdk-alpine

RUN apk update && \
  apk add --no-cache libc6-compat && \
  ln -s /lib/libc.musl-x86_64.so.1 /lib/ld-linux-x86-64.so.2

RUN apk --no-cache add curl

RUN mkdir /app

COPY --from=builder /home/app/target/*.jar /app/app.jar

EXPOSE 8080
EXPOSE 8081

ENV JAVA_OPTS=""
ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -Dspring.profiles.active=prod -jar /app/app.jar
