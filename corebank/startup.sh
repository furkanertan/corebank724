#!/bin/bash
mvn spring-boot:run > log.txt 2>&1 &
echo $! > ./pid.file