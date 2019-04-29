# MSSQL-R2DBC-ReactiveEventStore
Demo of a Spring boot application using a Spring-Data Reactive EventStore with MSSQL-R2DBC setup

# Maven build
mvn clean install

# Docker
Install docker
./docker-compose up -f ./nl.nextend.r2dbc.reactive.eventstore/docker-compose.yml -d --build

# End-Point
http://localhost:8080/events
