# firebase-gateway
A gateway to use Firebase functionalities.

## Rest api documentation

https://documenter.getpostman.com/view/1083622/RznEJdKu

## To run in Docker

1. Download the admin sdk json file from your project Firebase's
 and put the file in the 'resource' path

2. Set the admin sdk file name in 'application.properties', the variable name is 'firebase.adminSdk.fileName'

3. Set the database in 'docker-compose.yml'

4. Finally run:    `docker-compose up`

## To run with spring boot tools

1. Download the admin sdk json file from your project Firebase's
 and put the file in the 'resource' path

2. Set the admin sdk file name in 'application.properties', the variable name is 'firebase.adminSdk.fileName'

3. Set the database in 'application.properties'

4. Finally run:    `mvn spring-boot:run`