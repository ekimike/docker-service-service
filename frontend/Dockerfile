FROM amazoncorretto:11
VOLUME /tmp
COPY target/frontend-0.0.1-SNAPSHOT.jar app.jar
ENV JAVA_OPTS=""
ENTRYPOINT exec java -jar /app.jar
