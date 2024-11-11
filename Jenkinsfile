pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/carlosfls/task-app-api.git'
            }
        }
        stage('Build') {
            steps {
                sh './gradlew clean build' // Use 'mvn clean install' if using Maven
            }
        }
        stage('Test') {
            steps {
                sh './gradlew test' // Use 'mvn test' if using Maven
            }
        }
    }
}