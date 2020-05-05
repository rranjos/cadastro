FROM openjdk:8-jdk

COPY /target/cadastro-0.0.1-SNAPSHOT.jar /cadastro.jar

EXPOSE 8080

CMD ["java", "-jar", "/cadastro.jar"]

