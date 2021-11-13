#!/usr/bin/env bash

mvn -f ./geolocation/pom.xml clean package
mvn clean package

docker-compose up --build