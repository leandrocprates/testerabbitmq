FROM openjdk:17-alpine
COPY target/testerabbitmq-0.0.1-SNAPSHOT.jar .
EXPOSE 8080
ENTRYPOINT ["java", "-jar","./testerabbitmq-0.0.1-SNAPSHOT.jar"]

#docker build -t testerabbitmq .
#docker-compose -f docker-compose-rabbit.yaml up -d
