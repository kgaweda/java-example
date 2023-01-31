FROM eclipse-temurin:18-jdk-jammy as builder

WORKDIR /app

COPY .mvn/ .mvn
COPY mvnw pom.xml /app/
RUN ./mvnw dependency:go-offline

COPY . /app

RUN ./mvnw install -DskipTests=false

FROM eclipse-temurin:18-jre-jammy

WORKDIR /opt/app

COPY --from=builder /app/target/*.jar /opt/app/app.jar

EXPOSE 8080
RUN ls 
ENTRYPOINT [ "java", "-jar", "/opt/app/app.jar" ]