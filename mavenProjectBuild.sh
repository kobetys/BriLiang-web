#!/bin/sh

mvn clean install -Dmaven.test.skip=true -f liang_common_components/pom.xml
mvn clean install -Dmaven.test.skip=true -f -f liang_common_components/springweb/pom.xml
mvn clean install -Dmaven.test.skip=true -f liang_common_components/rabbitmql_queue/pom.xml -Prun_build

