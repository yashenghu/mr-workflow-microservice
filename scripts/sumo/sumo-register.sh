#!/bin/sh
#!/bin/bash -xe
sed -i 's/hostName-changeme/'"$SUMO_HOSTNAME"'/g' $SUMO_HOME/sources.json
sed -i 's@app-changeme@'"${SUMO_CATEGORY}"'@' $SUMO_HOME/sources.json
echo "name=$SUMO_NAME" >> $SUMO_HOME/config/user.properties
echo "accessid=$SUMO_ACCESS_ID" >> $SUMO_HOME/config/user.properties
echo "accesskey=$SUMO_ACCESS_KEY" >> $SUMO_HOME/config/user.properties
echo "sources=$SUMO_HOME/sources.json" >> $SUMO_HOME/config/user.properties
echo "hostName=$SUMO_HOSTNAME" >> $SUMO_HOME/config/user.properties
echo "timeZone=Australia/Sydney" >> $SUMO_HOME/config/user.properties
echo "category=$SUMO_CATEGORY" >> $SUMO_HOME/config/user.properties

$SUMO_HOME/collector start