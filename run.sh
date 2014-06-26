#!/bin/bash
mvn clean package install
cd target
java -cp "lib/*:Java8-ParallelSort.jar" liv.parallelsort.Program
cd ..

