#!/bin/sh

CLASSPATH=.:../openjms-0.7.7-beta-1/lib/jms-1.1.jar:../openjms-0.7.7-beta-1/lib/openjms-0.7.7-beta-1.jar

java -cp $CLASSPATH journaltest.JournalTest $1 $2 $3 $4
