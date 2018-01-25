pipeline {
	agent any

	environment {
		DOCKER_COMPOSE_DIR = 'jenkins-demo-docker'
	}

	stages {
//		stage('Checkout SCM') {
//			steps {
//				git 'https://github.com/tdakowicz/jenkins-sample-app'
//				stash includes: '**', name: 'sourceCode'
//			}
//		}
		stage('Stash source code') {
			steps {
				stash includes: '**', name: 'sourceCode'
			}
		}
		stage('Build in parallel') {
			parallel {
				stage('Unit tests') {
					agent {
						label 'master'
					}
					steps {
						unstash 'sourceCode'
						sh './gradlew clean check --parallel --configure-on-demand --no-daemon'
					}
					post {
						always {
							junit '*/build/test-results/test/TEST-*.xml'
						}
					}
				}
				stage('Integration tests') {
					agent {
						label 'slave'
					}
					steps {
						unstash 'sourceCode'
						dir(env.DOCKER_COMPOSE_DIR) {
							sh 'docker-compose build'
							sh 'docker-compose up -d'
						}
						sleep 20
						sh './gradlew clean check --parallel --configure-on-demand --no-daemon'
					}
					post {
						always {
							junit '*/build/test-results/test/TEST-*.xml'
							dir(env.DOCKER_COMPOSE_DIR) {
								sh 'docker-compose down'
							}
						}
					}
				}
			}
		}
		stage('Code coverage') {
			steps {
				jacoco exclusionPattern: '**/generated-sources/**', execPattern: '**/build/jacoco/test.exec'
			}
		}
	}
}