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
    publishHTML([allowMissing: false, alwaysLinkToLastBuild: true, 
      includes: '**/target/surefire-reports/*.html', reportDir: 'target/surefire-reports', 
      reportFiles: 'index.html', reportName: 'Test Results'])
  }
}
}
