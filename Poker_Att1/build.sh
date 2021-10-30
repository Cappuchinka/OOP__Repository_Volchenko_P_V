#!/bin/bash
javac -sourcepath ./src -classpath ./lib/logback-core-1.3.0-alpha10.jar:./lib/logback-classic-1.3.0-alpha10.jar:./lib/slf4j-api-2.0.0-alpha4.jar:./lib/log4j-over-slf4j-2.0.0-alpha5.jar:./lib/jcl-over-slf4j-1.7.25.jar -d bin ./src/edu/csf/oop/java/poker/Main.java
jar --create --file poker.jar --manifest manifest.mf -C ./bin/ .
