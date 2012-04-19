NOTE: 3/13/2012 - UPGRADED TO WORK WITH VIRGO 3.0.2.RELEASE.  eclipselink and hibernate.native "work on my box"
NOTE: 4/18/2012 - fixed issue with hibernate.jpa - works now also.

This is a re-worked virgo greenpages sample project.

Changes in this version:

1. Upgrade to EclipseLink 2.x
2. Upgrade to Hibernate 3.6
3. Example of Hibernate JPA and Hibernate Native usage
4. Wrapped version of hibernate 3.6.0.Final and javassist 3.12.0.GA as osgi bundles.
5. Upgrade H2 to use latest version - Hibernate would give warning that prior version does not work well with batch updates/inserts.


How it all works:

1. Checkout source 
    git clone git://github.com/dsklyut/virgo-samples-greenpages.git
    
2. Build it to generate wrapped hibernate jars and osgi meta-data (MANIFEST.MF) with bundlor
    cd virgo-samples-greenpages/solution
    mvn -Pthirdparty clean install
    
3. Now it is time to decide which example to run:
   There are 3 par files with dependent bundles: greenpages.eclipselink.par, greenpages.hibernate.jpa.par, greenpages.hibernate.native.par.
   As module name suggest, difference is only in the underlying persistence technology.  With hibernate there is a choice to use jpa or native hibernate.
   
4. Copy dependencies to Virgo and greenpages par archive
  cp $PAR_FROM_STEP_3_MODULE/target/par-provided/* $VIRGO_HOME/repository/usr
  cp $PAR_FROM_STEP_3_MODULE/target/*.par $VIRGO_HOME/pickup
  
5. Start demo database
  cd virgo-samples-greenpages/db
  ./run.sh
  ./data.sh

NOTE: data.sh will preload some data and create schema.
 
8. Start Virgo server.

Git, Fork and let me know if there are issue.

Dmitry
