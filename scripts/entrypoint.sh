#!/bin/sh
export CONFIG_SERVER_PORT=8100

if [ ! -z "$KUBERNETES_SERVICE_HOST" ]
then
  JAVA_OPTIONS="$JAVA_OPTIONS -Dspring.profiles.active=kubernetes"
  export AWS_ENVIRONMENT="aws-kubernetes"
  export CONFIG_SERVER_HOST="mr-config-service"
fi

if test "${SPRING_PROFILES_ACTIVE}" != '';
then
  JAVA_OPTIONS="$JAVA_OPTIONS -Dspring.profiles.active=cloud,$SPRING_PROFILES_ACTIVE"
  echo "Java Options:  ${JAVA_OPTIONS}"
  export AWS_ENVIRONMENT=$SPRING_PROFILES_ACTIVE
  # Get the real ip and port
  export HOST_IP=$(curl -s ${ECS_CONTAINER_METADATA_URI_V4}/task | jq -r '.Containers [0]|.Networks[0]|.IPv4Addresses[0]')
  export INSTANCE_ID=$(curl -s ${ECS_CONTAINER_METADATA_URI_V4}/task | jq -r '.TaskARN' | grep -Eo '[^/]+/?$' | cut -d / -f1)
  export DOCKER_ID=$(curl -s ${ECS_CONTAINER_METADATA_URI_V4}/task | jq -r '.Containers [0]|.DockerId')
  export HOST_PORT=8080
  echo "curl -f http://$HOST_IP:$HOST_PORT$CONTEXT_PATH/actuator/health | grep UP || exit 1" > /healthcheck.sh
  #TASK_FAMILY=`cat ${ECS_CONTAINER_METADATA_FILE} | jq -r '.TaskDefinitionFamily'`
  #JAVA_OPTIONS="$JAVA_OPTIONS -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/host-tmp/heapdump-$TASK_FAMILY-$INSTANCE_ID.hprof"
  AVAILABILITY_ZONE=$(curl -s ${ECS_CONTAINER_METADATA_URI_V4}/task | jq -r '.AvailabilityZone')
  #export AWS_REGION=`echo "$AVAILABILITY_ZONE" | sed 's/.$//'`
  export AWS_AZ="ap-southeast-2"

  case $SPRING_PROFILES_ACTIVE  in
    "mr-test"|"mr-ui-test")
      export CONFIG_SERVER_HOST="config-server.test.medirecords.local"
    ;;
    "qh-validation")
      export CONFIG_SERVER_HOST="config-server.validation.qh.medirecords.local"
    ;;
    "qh-ui-test")
      export CONFIG_SERVER_HOST="config-server-uitest-edge-ecs.uiautomation.qh.medirecords.local"
    ;;
    "mr-prod")
      export CONFIG_SERVER_HOST="config-server.medirecords.local"
    ;;
    "qh-prod")
      export CONFIG_SERVER_HOST="config-server.qh.medirecords.local"
    ;;
    "qh-test")
      export CONFIG_SERVER_HOST="config-server.test.qh.medirecords.local"
    ;;
    "qh-preprod")
      export CONFIG_SERVER_HOST="config-server.preprod.qh.medirecords.local"
    ;;
  esac
  echo "CONFIG_SERVER_HOST is $CONFIG_SERVER_HOST"
fi

if test "${LOCAL_DOCKER_ENV}" = 'true';
then
    echo `getent hosts host.docker.internal | awk '{ print $1 }'` ${HOST_DOMAIN} >> /etc/hosts
    JAVA_OPTIONS="$JAVA_OPTIONS -Dspring.profiles.active=local"
    export AWS_ENVIRONMENT="localhost"
    export CONFIG_SERVER_HOST="config-server.test.medirecords.com"
    export HOST_PORT=8080
fi

# Uncomment to activate newrelic
# java $JAVA_OPTIONS \
#   -javaagent:/opt/newrelic/newrelic.jar \ 
#   -jar -Xmx1024m app.jar

java $JAVA_OPTIONS -jar -Xmx1024m app.jar