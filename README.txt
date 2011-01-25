This is a re-worked virgo greenpages sample project.

Changes in this version:

1. Upgrade to EclipseLink 2.x
2. Upgrade to Hibernate 3.6
3. Example of Hibernate JPA and Hibernate Native usage
4. Multiple profiles to run greenpages with eclipselink.jpa (default), -Phibernate.jpa, -Phibernate.native
5. Update maven build so it works.
6. Wrapped version of hibernate 3.6.0.Final and javassist 3.12.0.GA as osgi bundles.
7. Use SpringFramework 3.0.5 in user region as Hibernate 3.6 requires it.
8. Upgrade H2 to use latest version - Hibernate would give warning that prior version does not work well with batch updates/inserts.


How it all works:

1. Checkout source 
    git clone git@github.com:dsklyut/virgo-samples-greenpages.git
    
2. Build it to generate wrapped hibernate jars and osgi meta-data (MANIFEST.MF) with bundlor
    cd virgo-samples-greenpages/solution
    mvn -Pthirdparty,prepare clean install
    
3. Prepare Virgo Server (assuming it is already downloaded and unzipped to $VIRGO_HOME) by deleting all org.springframework.*-3.0.0.RELEASE* artifacts from $VIRGO_HOME/repository/ext
i.e. rm $VIRGO_HOME/repository/ext/org.springframework.*-3.0.0.RELEASE*

4. Switch to greenmodules project to pickup required SpringFramework jars:
  cd virgo-samples-greenpages/solution/greenpages/target/spring-user-region
  cp * $VIRGO_HOME/repository/ext
  
5. Now it is time to decide which example to run:
   By default eclipselink.jpa repository is packaged in with the par.
   To include hibernate configured as jpa provider rebuild greenpages par project with -Phibernate.jpa profile
   To include hibernate configured to be used through a native API, rebuild greenpages par with -Phibernate.native profile 
   
   NOTE: this profile can be used in Step 2 above to save on some typing.
   
6. Copy dependencies to Virgo and greenpages par archive
  cp greenpages/target/par-provided/* $VIRGO_HOME/repository/usr
  cp greenpages/target/greenpages-solution-2.4.0.BUILD-SNAPSHOT.par $VIRGO_HOME/pickup
  
7. Start demo database
  cd virgo-samples-greenpages/db
  ./run.sh
  or 
  run.bat
  
8. Start Virgo server.
