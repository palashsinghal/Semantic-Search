FROM java:8-jre

VOLUME /tmp

WORKDIR /src

COPY intents.csv /src

COPY searchIntent.csv /src

#add the local jar to docker context (jar in target folder after mvn package)
ADD ./target/IntentSearchService-0.0.1-SNAPSHOT.jar /src/IntentSearch.jar

#different port for each image
EXPOSE 8055

CMD ["java","-Xmx200m", "-jar", "/src/IntentSearch.jar"]
