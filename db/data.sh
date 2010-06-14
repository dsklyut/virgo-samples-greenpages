#!/usr/bin/env bash
. ./h2.sh

java -cp $CLASSPATH org.h2.tools.RunScript -url jdbc:h2:tcp://localhost/~/greenpages-db/greenpages -user greenpages -password pass -script ./db.sql
