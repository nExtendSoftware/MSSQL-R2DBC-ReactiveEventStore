# MSSQL-R2DBC-ReactiveEventStore
Demo of a Spring boot application using a Spring-Data Reactive EventStore with MSSQL-R2DBC setup

# Prerequisites
Java 1.8+, Maven and Docker installed

# Maven build ReactiveEventStore spring boot application
mvn clean install -f ./nl.nextend.r2dbc.reactive.eventstore/pom.xml

## command to start docker stack:
#### ./docker-compose up -f ./nl.nextend.r2dbc.reactive.eventstore/docker-compose.yml -d --build

## command log running docker stack:
#### ./docker-compose logs

## command show running docker stacks:
#### ./docker-compose ps

## command to stop docker stack
#### ./docker-compose down -f ./nl.nextend.r2dbc.reactive.eventstore/docker-compose.yml -v --rmi local --remove-orphans

# End-Point
http://localhost:8080/events
