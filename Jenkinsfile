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
                bat 'mvn clean package'
            }
        }
        
        stage('Test') {
            steps {
                bat 'start cmd /c "mvn clean test"'
                sh 'start mvn test'
                
            }
        }
        stage('Cleanup') {
            steps {
                sh 'taskkill /im chromedriver.exe /f'
            }
        }
    }
}
