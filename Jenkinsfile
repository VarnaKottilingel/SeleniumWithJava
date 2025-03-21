pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                checkout scm  // Pulls the code from the repository
            }
        }
        
        stage('Build') {
            steps {
                script {
                    // Run Maven build command inside the Maven container
                    sh 'docker exec -t great_tu mvn clean install'
                }
            }
        }

        stage('Test') {
            steps {
                script {
                    // Run your test suite (Cucumber/Selenium tests) inside the Maven container
                    sh 'docker exec -t great_tu mvn test'
                }
            }
        }
    }

    post {
        always {
            cleanWs()  // Clean workspace after build
        }
    }
}
