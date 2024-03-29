########build stage########
FROM maven:3.9.6-eclipse-temurin-11 as maven_build
WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN --mount=type=cache,target=/root/.m2 mvn clean package  -Dmaven.test.skip

########run stage########
FROM eclipse-temurin:11
WORKDIR /app

COPY --from=maven_build /app/target/*.jar ./target/app.jar

#run the app
ENV JAVA_OPTS ""
CMD [ "bash", "-c", "java ${JAVA_OPTS} -jar target/app.jar -v"]