1. Configure Virgo Repositories
  (we do this so artifacts do not get mixed up with artifacts shipped by virgo)
  cd $VIRGO_HOME/config
  edit org.eclipse.virgo.repository.properties
  add:
  greenpages.type=watched
  greenpages.watchDirectory=repository/greenpages
  
  change:
  chain=ext,usr
  to
  chain=ext,usr,greenpages