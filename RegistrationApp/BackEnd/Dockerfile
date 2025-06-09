#Here we were using the multistage dockerfile first stage using for the only building 
#stage1
#using the maven image and setting this build as the alias name 'build'
FROM maven:3.9.6-eclipse-temurin-21 AS build

#Setting the workfing directory
WORKDIR /app

# Copy only pom.xml first to the working directory
COPY pom.xml .

RUN mvn dependency:go-offline

# Copy full source
COPY src ./src

# Build the JAR
RUN mvn clean package -DskipTests

# Stage2
FROM gcr.io/distroless/java21

COPY --from=build /app/target/Registration-0.0.1-SNAPSHOT.jar /app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]
