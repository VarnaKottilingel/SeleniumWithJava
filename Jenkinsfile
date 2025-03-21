pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/VarnaKottilingel/SeleniumWithJava.git'
            }
        }
        stage('Build') {
            steps {
                script {
                    sh 'mvn clean install'
                }
            }
        }
        stage('Test') {
            steps {
                script {
                    sh 'mvn test'
                }
            }
        }
    }
}
