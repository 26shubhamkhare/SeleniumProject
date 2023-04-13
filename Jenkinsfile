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
         stage('Publish HTML Reports') {
  steps {
    script {
      publishHTML([
        allowMissing: false, 
        alwaysLinkToLastBuild: true, 
        keepAll: true, // add the keepAll parameter
        reportDir: 'target/site',
        reportFiles: 'index.html',
        reportName: 'HTML Report'
      ])
    }
  }
}
    }
}
    

  

