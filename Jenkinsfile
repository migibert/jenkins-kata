node {
    stage("Checkout") {
        checkout scm
    }

    def branch = "${BRANCH_NAME}"

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

    stage("Performance tests") {
        def compose_id = "${env.JOB_NAME}-${env.BUILD_NUMBER}"
        def finished = false
        def remainingAttempts = 15
        def waitingTime = 4
        try {
            sh "docker-compose -p $compose_id up -d"
            while(!finished && remainingAttempts > 0) {
                sh "echo Wait for report to be ready, $remainingAttempts attempts remaining"
                finished = sh(script: "ls -al target/katasimulation-* 2>&1 > /dev/null", returnStatus: true) == 0
                remainingAttempts--
                sh "sleep $waitingTime"
            }
            if(finished) {
                gatlingArchive()
            }
        }
        finally {
            sh "sudo chown -R jenkins:jenkins target"
            sh "docker-compose -p $compose_id stop"
            sh "docker-compose -p $compose_id rm -f"
        }
    }
}