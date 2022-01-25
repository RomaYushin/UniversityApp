# UniversityApp

### 1. Build project
##### go to root of application and run: 
> gradlew clean build

### 2. Check with sonar locally (not obligatory)
##### install and adjust sonarqube on your machine: https://www.sonarqube.org/
##### deploy app into sonar
> gradlew sonarqube -Dsonar.projectKey=UniversityApp -Dsonar.host.url=http://localhost:9000 -Dsonar.login=01b968471c2860065582c53607d7b14c9368ee00
#### open http://localhost:9000 and check your project with different metrics

### 3. Docker
##### install Docker on your machine: https://www.docker.com/products/personal 
> docker --version
##### should return something like this: 
> Docker version 20.10.12, build e91ed57
#### build image from Dockerfile in root directory of the project:
> docker build -t uniapp .
#### check new Docker image, should exist new image:
> docker images
#### run application in container:
> docker run -d -p 8083:8083 uniapp
#### execute get request in browser: http://localhost:8083/test, should be 200 response with answer 'Server is ok'

... todo switch in db
docker run --name habr-pg-14 -p 5433:5432 -e POSTGRES_PASSWORD=pgpwd4habr -d postgres:14

netstat -aon | find ":5432"

taskkill /PID 5844 /F
