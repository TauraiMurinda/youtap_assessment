#!/bin/bash
nohup java -jar ./target/microservice.assessment_V1.jar> ./log.txt 2>&1 &
echo $! > ./pid.file

###mvn spring-boot:run -Dspring-boot.run.arguments=--logging.level.org.springframework=INFO
