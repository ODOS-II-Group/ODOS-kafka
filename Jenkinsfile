#!groovy

pipeline {
	agent any

	stages {
		stage ('init') {
			steps {
				echo 'Start kafka'
				sh 'docker-compose -f src/main/docker/kafka.yml up -d'

				echo 'Start app'
				sh './gradlew'
			}
		}

		stage ('Run tests') {
			steps {
				sh './gradlew clean test'
			}
		}
	}
}