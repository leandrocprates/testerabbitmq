FROM openjdk:17-alpine
COPY target/testerabbitmq-0.0.1-SNAPSHOT.jar .
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=docker" ,   "./testerabbitmq-0.0.1-SNAPSHOT.jar"]

#docker build -t testerabbitmq:0.0.1-SNAPSHOT .  ou   mvn package           Criar imagem
#docker network create external-example                     Criar rede entre containers
#docker-compose -f docker-compose-rabbit.yaml up -d         Subir containers
