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
                sh 'mvn clean install'
            }
        }
        
        stage('Test') {
            steps {
                sh 'java -jar selenium-server-standalone.jar -role hub &'
                sh 'java -jar selenium-server-standalone.jar -role node &'
                sh 'mvn test'
            }
        }
    }
}
