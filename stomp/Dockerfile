FROM openjdk:8-jre-alpine

VOLUME /tmp

#add the local jar to docker context (jar in target folder after mvn package)
ADD ./target/stomp-0.0.1-SNAPSHOT.jar stompapp.jar

#different port for each image
EXPOSE 8088

CMD ["java","-Xmx200m",  "-jar", "/stompapp.jar"]

