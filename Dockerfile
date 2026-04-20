# ======= STAGE 1: Build =======
FROM maven:3.9.6-eclipse-temurin-21 AS builder
WORKDIR /app
# First copy the POM and run dependency resolution for better caching
COPY pom.xml .
RUN mvn dependency:go-offline -B
# Then copy source and compile
COPY src ./src
RUN mvn clean package -DskipTests

# ======= STAGE 2: Runtime =======
FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=builder /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
