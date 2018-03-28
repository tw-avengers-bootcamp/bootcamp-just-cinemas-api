#!/bin/bash

set -e
tagName=$1
securityKeyName=$2
commitHashOfDeployable=$(git rev-parse --short HEAD)

cfn-create-or-update \
  --stack-name api-deployment-${tagName} \
  --template-body file://buildAndDeploy/deploy/api-ec2.yml \
  --parameters ParameterKey=tagName,ParameterValue=${tagName} \
               ParameterKey=securityKeyName,ParameterValue=${securityKeyName} \
               ParameterKey=commitHashOfDeployable,ParameterValue=${commitHashOfDeployable} \
  --wait
