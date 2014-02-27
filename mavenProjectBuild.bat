call mvn clean install -Dmaven.test.skip=true -f liang_common_components\pom.xml
call mvn clean install -Dmaven.test.skip=true -f liang_common_components\springweb\pom.xml 
call mvn clean install -Dmaven.test.skip=true -f liang_common_components\rabbitmql_queue\pom.xml -Prun_build 

pause