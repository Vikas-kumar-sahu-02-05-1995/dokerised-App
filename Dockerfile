FROM openjdk:17
EXPOSE 8082
ADD target/demotodolist-0.0.1-SNAPSHOT.jar demotodolist-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/demotodolist-0.0.1-SNAPSHOT.jar"]