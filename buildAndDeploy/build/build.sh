#!/bin/bash

#1. build
#2. create s3 bucket for storing build artefacts if not already created
#3. upload jar to s3 bucket suffixed with git commit hash
#4. the jar can be then downloaded from here - https://s3.ap-south-1.amazonaws.com/build-artefacts-team1/bootcamp-just-cinemas-api-d505f5f.jar
set -e
tagName=$1

cfn-create-or-update \
  --stack-name build-artefacts-${tagName} \
  --template-body file://buildAndDeploy/build/build-artefact-s3.yml \
  --parameters ParameterKey=tagName,ParameterValue=${tagName} \
  --wait

./gradlew clean build

commitHash=$(git rev-parse --short HEAD)
aws s3 cp build/libs/bootcamp-just-cinemas-api.jar s3://build-artefacts-${tagName}/bootcamp-just-cinemas-api-$commitHash.jar
