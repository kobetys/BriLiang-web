#!/bin/sh

mvn eclipse:clean eclipse:eclipse -f liang_common_components/pom.xml
mvn eclipse:clean eclipse:eclipse -f liang_common_components/springweb/pom.xml 
mvn eclipse:clean eclipse:eclipse -f liang_common_components/rabbitmql_queue/pom.xml -e
