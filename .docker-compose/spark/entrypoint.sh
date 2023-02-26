#!/bin/bash

if [[ $SPARK_MODE == 'master' ]]; then
  ./sbin/start-master.sh
elif [[ $SPARK_MODE == 'worker' ]]; then
  ./sbin/start-worker.sh --cores "${SPARK_WORKER_CORES}" --memory "${SPARK_WORKER_MEMORY}" "${SPARK_MASTER_URL}"
fi

tail -f /dev/null
