pipeline {
    agent any

    stages {
      stage('Checkout') {
            steps {
                git 'https://github.com/26shubhamkhare/SeleniumProject.git'
            }
        }
        stage('Build') {
            steps {
                bat 'mvn compile'
            }
        }
        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }
        stage('Report') {
            steps {
                bat 'mvn surefire-report:report'
            }
        }
    }

    post {
        always {
            junit 'target/surefire-reports/*.xml'
            publishHTML(target: [
                allowMissing: false,
                alwaysLinkToLastBuild: true,
                keepAll: true,
                reportDir: 'target/site/surefire-report',
                reportFiles: 'index.html',
                reportName: 'Test Results'
            ])
        }
    }
}
