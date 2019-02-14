# firebase-gateway
A gateway to use Firebase functionalities.

## Rest api documentation

https://documenter.getpostman.com/view/1083622/RznEJdKu

## To run

1. Download the admin sdk json file from your project Firebase's
 and put the file in the 'resource' path

2. Set the admin sdk file name in 'application.properties', the variable name is 'firebase.adminSdk.fileName'

3. Set the database in 'application.properties'

5. Instance a container executing:
`docker run --name mysql -e MYSQL_ROOT_PASSWORD=0000 -e MYSQL_DATABASE=firebasegateway -e MYSQL_USER=uFirebaseGateway -e MYSQL_PASSWORD=0000 -d mysql:5.6`

6. Build an image executing:
`mvn install dockerfile:build -Dmaven.test.skip=true`

7. Finally execute:
`docker run -t --name firebase-gateway --link mysql -p 80:8080 springio/firebase-gateway`