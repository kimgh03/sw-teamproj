pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                bat 'if not exist classes mkdir classes'
                bat 'javac -encoding UTF-8 -d classes Practice\\src\\*.java'
            }
        }

        stage('Test') {
            steps {
                bat 'java -cp classes AppTest > test_results.txt'
            }
        }
    }

    post {
        always {
            archiveArtifacts artifacts: 'test_results.txt', allowEmptyArchive: true
        }
        failure {
            echo 'Build or test failed'
        }
        success {
            echo 'Build and test succeeded'
        }
    }
}

