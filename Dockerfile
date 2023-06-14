FROM eclipse-temurin:17-jdk-focal
VOLUME /tmp
WORKDIR /special
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN apt-get update && apt-get install -y dos2unix
RUN dos2unix mvnw
RUN ./mvnw dependency:go-offline
COPY src ./src
CMD ["./mvnw", "spring-boot:run"]
