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
                sh 'mvn clean package'
            }
        }
        
        stage('Test') {
            steps {
                sh 'start java -jar target/myapp.jar'
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
