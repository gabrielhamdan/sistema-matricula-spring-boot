FROM openjdk:17-jdk-slim AS build

COPY pom.xml mvnw ./
COPY .mvn .mvn
RUN ./mvnw dependency:resolve

COPY src src
RUN ./mvnw package

FROM openjdk:17-jdk-slim
WORKDIR sistemamatricula
COPY --from=build target/*.jar sistemamatricula.jar
ENTRYPOINT ["java", "-jar", "sistemamatricula.jar"]