@echo off
setlocal

call h2
java -cp "%H2CP%" org.h2.tools.RunScript -url jdbc:h2:tcp://localhost/~/greenpages-db/greenpages -user greenpages -password pass -script db.sql