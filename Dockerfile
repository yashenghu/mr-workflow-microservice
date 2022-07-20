FROM 515749285499.dkr.ecr.ap-southeast-2.amazonaws.com/mr-base:jre11

MAINTAINER robby.rahmana@medirecords.com

# Copy jar
COPY ./target/app.jar app.jar

# Copy Deployment scripts
COPY ./scripts/entrypoint.sh entrypoint.sh
# COPY ./scripts/sumo/ $SUMO_HOME/ # Uncomment to activate sumologic

# Add execute to entrypoint and sumo
RUN chmod +x entrypoint.sh
# RUN chmod +x $SUMO_HOME/sumo-register.sh # Uncomment to activate sumologic

# Start sumologic
# CMD $SUMO_HOME/sumo-register.sh # Uncomment to activate sumologic

# Convert the entrypoint.sh
RUN dos2unix entrypoint.sh

# Listen to a port
# EXPOSE 8080, Read default expose from base image

ENTRYPOINT ["/bin/sh", "entrypoint.sh"]