
FROM openjdk:8-jdk-alpine
FROM microsoft/mssql-server-linux:latest
VOLUME /tmp
ARG JAVA_OPTS
ENV JAVA_OPTS=$JAVA_OPTS
ADD ./target/eventstore-0.0.1-SNAPSHOT.jar eventstore-0.0.1-SNAPSHOT.jar
EXPOSE 8080 1433
COPY entrypoint.sh entrypoint.sh
COPY create-db.sql create-db.sql
COPY startSqlCmd.sh startSqlCmd.sh
ENV ACCEPT_EULA Y
ENV sa_password Pa$wo0RD!
RUN chmod +x ./startSqlCmd.sh
CMD /bin/bash ./EntryPoint.sh
# For Spring-Boot project, use the entrypoint below to reduce Tomcat startup time.
ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar eventstore-0.0.1-SNAPSHOT.jar
