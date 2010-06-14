#!/usr/bin/env bash
JARS=`find $HOME/.m2 -iname "com.springsource.org.h2*"`

for JAR in $JARS
do
	CLASSPATH=$CLASSPATH:$JAR
done

if [ -z $CLASSPATH ]
then
	echo "Cannot find H2 jars in .m2 Maven repository"
	exit -1
fi