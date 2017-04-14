Needed Jenkins plugins :
* Blue Ocean
* Pipeline
* Docker Pipeline
* Multibranch Pipeline
* Sonar

Starting sonarqube server via docker :
`docker run -d --name sonarqube -p 10000:10000 -p 9092:9092 -p 11000:9000 sonarqube`