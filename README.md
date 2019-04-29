# MSSQL-R2DBC-ReactiveEventStore
Demo of a Spring boot application using a Spring-Data Reactive EventStore with MSSQL-R2DBC setup

# Maven build
mvn clean install

# Docker
Install docker

command to start docker stack:
./docker-compose up -f ./nl.nextend.r2dbc.reactive.eventstore/docker-compose.yml -d --build

command to stop docker stack
./docker-compose down -f ./nl.nextend.r2dbc.reactive.eventstore/docker-compose.yml -v --rmi local --remove-orphans

# End-Point
http://localhost:8080/events
