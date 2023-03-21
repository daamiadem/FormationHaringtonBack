FROM openjdk:11-jre-slim
WORKDIR /app
COPY . .
ADD target/FormationHarington-1.0-SNAPSHOT.jar FormationHarington-1.0-SNAPSHOT.jar
WORKDIR /app
EXPOSE 8484
CMD ["java","-jar","FormationHarington-1.0-SNAPSHOT.jar"]
