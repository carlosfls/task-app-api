pipeline{
    agent: any

    stages {
       stage('Build'){
            steps {
                sh 'Building..'
                sh './gradlew clean build'
            }
       }
       stage('Test'){
            steps {
                sh 'Testing'
                sh './gradlew test'
            }
       }
    }

    post {
        success {
            echo 'Build and Test application'
        }
        failure {
            echo 'Build or test failed'
        }
    }
}