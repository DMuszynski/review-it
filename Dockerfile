FROM adoptopenjdk/openjdk11-openj9:latest
ADD target/review-it-0.0.1-SNAPSHOT.jar .
EXPOSE 8000
CMD java -jar review-it-0.0.1-SNAPSHOT.jar