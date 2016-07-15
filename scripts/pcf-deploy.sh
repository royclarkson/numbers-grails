#!/bin/bash

set -e

SCRIPT_HOME=$(cd `dirname "${BASH_SOURCE[0]}"` && pwd)
WORK_DIR=${SCRIPT_HOME}
NUMBERS_DIR=${WORK_DIR}/../numbers
NUMBERS_SERVICE_DIR=${WORK_DIR}/../numbers-service

pushd ${NUMBERS_DIR}
./gradlew clean assemble
popd

pushd ${NUMBERS_SERVICE_DIR}
./gradlew clean assemble
popd

# push apps
cf push -f ${NUMBERS_DIR}/manifest.yml
cf push -f ${NUMBERS_SERVICE_DIR}/manifest.yml
