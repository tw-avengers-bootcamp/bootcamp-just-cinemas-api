# Just Cinemas API

## Explanation

https://medium.com/@readsethu/jooq-flyway-spring-boot-and-gradle-44a8d3f289#.noa8xg74v

## Prerequisites

- Oracle Java 1.8
- Docker

## Building locally

To build run
```
./gradlew clean build
```

To run unit tests
```
./gradlew clean test
```

To start up the project on a *separate terminal* run
```
docker-compose -f docker-dev-db/docker-compose.yml up
```

Once the postgres instance is running run the application in ```localhost:9000``` by using the following command:
```
./gradlew bootRun
```

To reset and install all Flyway scripts please use
```
./gradlew -Dcleanflyway=true dropAll 
```


## Deployment

1. Fork the repository
2. Add your team members as collaborators to the forked repo.
3. You will need to make changes to the pipeline.gocd.yml to rename everywhere team1 is to team2, etc. depending on which team you are on.
    1. Change all places where team1 appears to your team name.
    2. Change the git url to the forked git hub url.
    3. Change the deploy job script - ```sh buildAndDeploy/deploy/deploy.sh team1 sethu-origin-key-pair``` to ```buildAndDeploy/deploy/deploy.sh <your team name> <your ssh key name>```. You need to create an ssh key pair under AWS EC2 in the aws console. You need to do this to log on to the EC2 box in case you need to debug something. Create and save it locally. You can use the same SSH key created for the gocd box here as well.
4. Then follow the instruction on the https://github.com/Sethuraman/bootcamp-gocdinfra to complete the deployment
5. You can test your API deployment by running the below command
```
curl <your deployed ip address>/movies/now-showing
``` 
If this print out json then your deployment has worked. Be aware, that the curl endpoint might take a while before it works. Track the API deployment via the cloudformation console. 
5. Get the IP address of the EC2 box created to host your API and provide update in the build stage of the UI project build. You can test 

# Just Cinemas API

## /locations get api

1. resposnse:
```json
[
    {
        "id": 1,
        "name": "Chennai"
    },
    {
        "id": 2,
        "name": "Bangalore"
    },
    {
        "id": 3,
        "name": "Mumbai"
    },
    {
        "id": 4,
        "name": "Madurai"
    }
]
```

## /v1/movies/{locationId}/{status}

1. response:
```json
[
    {
        "id": 1,
        "name": "Kabali",
        "synopsis": " Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam tortor est, feugiat sit amet sagittis nec, viverra vehicula orci.",
        "rating": 5,
        "experiences": "RDX, Dolby Atmos, SUB",
        "bannerUrl": "https://img.spicinemas.in/resources/images/movies/Kabali/1000x320.jpg"
    }
]
```
