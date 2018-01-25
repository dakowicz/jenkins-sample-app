pipeline {
    agent any
    stages {
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
}