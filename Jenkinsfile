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
                bat 'start mvn test'
                
            }
        }
        stage('Cleanup') {
            steps {
                bat 'taskkill /im chromedriver.exe /f'
            }
        }
    }
}
