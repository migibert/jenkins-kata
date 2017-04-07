node {
    stage("Main Build") {
        checkout scm
        docker.image("maven:3.3-jdk-7").inside {
            stage("Build") {
                sh "mvn clean compile"
            }
            stage("Test") {
                sh "mvn clean test"
                sh "mvn clean verify"
            }
            stage("Package") {
                sh "mvn clean package"
            }
            stage("Publish") {
                sh "ls -al target/*"
            }
        }
    }
}