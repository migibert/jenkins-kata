node {
    stage("Checkout") {
        checkout scm
    }
    docker.image("maven:3.3-jdk-8").inside {
        stage("Compile") {
            sh "mvn clean compile"
        }
        stage("Unit Tests") {
            sh "mvn clean org.jacoco:jacoco-maven-plugin:prepare-agent test"
            junit 'target/surefire-reports/TEST-*.xml'
        }
        stage("Package") {
            sh "mvn package -DskipTests"
        }
        stage("Publish quality report") {
            withSonarQubeEnv('sonar') {
                sh 'mvn org.jacoco:jacoco-maven-plugin:report org.sonarsource.scanner.maven:sonar-maven-plugin:3.2:sonar -Dsonar.junit.reportsPath=target/surefire-reports'
            }
        }
    }
}
