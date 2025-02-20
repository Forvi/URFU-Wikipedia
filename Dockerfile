FROM gradle:jdk23 AS builder
WORKDIR /app
COPY . .
RUN ./gradlew bootJar

FROM eclipse-temurin:23.0.2_7-jre-alpine-3.21
WORKDIR /app
COPY --from=builder /app/build/libs/wikiurfu-0.0.1.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
