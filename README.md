# mr-template-microservice
Template microservice in medirecords
### Instructions
* Replace all 'template' occurrences with the proper name and also rename the packages.

### Naming conventions
* Github repository name: 'mr-something-microservice'
* Maven group id: 'com.medirecords'
* Maven artifact id: 'mr-something-microservice'
* Spring application name: 'mr-something'
* Base package: 'com.medirecords.mrsomethingmicroservice'

### Steps to create a microservice
#### Prerequisites:
1. aws vpn profile on mr-test
To test if current vpn is working correctly, try: http://springboot-admin.test.medirecords.com:8080/wallboard 
2. maven installed
3. aws credentials to access ECR and S3 bucket on mr-test

#### Steps
1. Create a new repository on Github
* Go to https://github.com/mjgaletto/mr-template-microservice, click 'Use this template' green button on top-right
2. Clone it to local and do a global replacement from 'template' to 'something'
3. Add startup parameter if you want to start microservice from local
* Active Profile: local-mrtest
  * Parameters: 
    * CONFIG_SERVER_HOST: config-server.test.medirecords.com
    * CONFIG_SERVER_PORT: 8100
    * HOST_PORT: 8888 (can be any other valid port)
    * dev-environment: _your name_
4. Create config files in mr-config project (https://github.com/mjgaletto/mr-config)
* Create a folder 'mr-something-microservice', and copy all yml files from 'mr-template-microservice' folder to current one
* Push to master branch
5. Start mr-something-microservice from local
* To verify if it is working: http://localhost:8888/actuator/health, http://localhost:8888/swagger-ui/

### Steps to run using docker locally
#### Build jar
~~~powershell
mvn clean package --settings .maven-settings/settings.xml
~~~
#### Copy the jar file
~~~powershell
md target/ 
copy api/target/app.jar target/
~~~
#### Build image in local
~~~powershell
docker build -t mr-template-microservice .
~~~
#### Run using docker compose
~~~powershell
docker-compose up --detach local-mr-template-microservice
~~~
#### Inspect the image
~~~powershell
docker run --rm -it mr-template-microservice /bin/bash
~~~