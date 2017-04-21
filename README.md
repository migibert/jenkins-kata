Needed Jenkins plugins :
* Blue Ocean
* Pipeline
* Docker Pipeline
* Multibranch Pipeline
* Sonar

Starting sonarqube server via docker :
`docker run -d --name sonarqube -p 10000:10000 -p 9092:9092 -p 11000:9000 sonarqube`

This project assumes:
* Sonarqube installation has been registered in Jenkins (because of withSonarqubeEnv usage inside Jenkinsfile)
* Docker & docker-composed are installed

Things to improve:
* Sadly, jenkins user has to be sudoer with no password to be able to chown target to himself (because gatling container write reports as root inside target directory)
* Jenkins & Sonar automation (for now, we have to setup Jenkins, launch sonar container, generate a token in sonar UI and register it to Jenkins)