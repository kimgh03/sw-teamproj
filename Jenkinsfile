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
                sh '''
                    mkdir -p classes
                    find Practice/src -name "*.java" > sources.txt
                    javac -encoding UTF-8 -d classes @sources.txt
                '''
            }
        }

        stage('Test') {
            steps {
                sh 'java -cp classes AppTest > test_results.txt'
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
