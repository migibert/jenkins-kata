pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                docker.image('maven:3.3.3-jdk-8').inside {
                    sh 'ls -al'
                }
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}