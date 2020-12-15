FROM openjdk:11-jre
VOLUME /tmp
ARG JAVA_OPTS
ENV JAVA_OPTS=$JAVA_OPTS
ADD target/trabalhocurso-0.0.1-SNAPSHOT.jar trabalhocurso.jar
EXPOSE 8080
ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar trabalhocurso.jar
