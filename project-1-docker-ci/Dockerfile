# =========================
# Build stage
# =========================
FROM maven:3.9.8-eclipse-temurin-17 AS build
WORKDIR /app

COPY pom.xml .
COPY src ./src
RUN mvn -B clean package

# =========================
# Runtime stage
# =========================
FROM eclipse-temurin:17-jre
WORKDIR /app

# Security best practice: run as non-root
RUN groupadd -r app && useradd -r -g app app
USER app

COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080

# Container-friendly JVM defaults
ENTRYPOINT ["java","-XX:MaxRAMPercentage=75.0","-XX:+UseContainerSupport","-jar","app.jar"]
