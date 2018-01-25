pipeline {
    agent any

    environment {
        DOCKER_COMPOSE_DIR = 'jenkins-demo-docker'
    }

    stages {
//        stage('Checkout SCM') {
//            steps {
//                git 'https://github.com/tdakowicz/jenkins-sample-app'
//            }
//        }
        stage('Build docker image with docker compose') {
            steps {
                dir(env.DOCKER_COMPOSE_DIR) {
                    sh 'docker-compose up -d'
                }
            }
        }
        stage('Build') {
            steps {
                sh './gradlew clean check --parallel --configure-on-demand --no-daemon'
            }
        }
        stage('Tests result') {
            steps {
                step([$class: 'JUnitResultArchiver', allowEmptyResults: true, testResults: '*/build/test-results/test/TEST-*.xml'])
            }
        }
        stage('Code coverage') {
            steps {
                jacoco exclusionPattern: '**/generated-sources/**', execPattern: '**/build/jacoco/test.exec'
            }
        }
    }
    post {
        always {
            dir(env.DOCKER_COMPOSE_DIR) {
                sh 'docker-compose down'
            }
        }
    }
}