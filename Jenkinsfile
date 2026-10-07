pipeline {

    agent any

    tools {
        maven 'Maven'
    }

    stages {

        stage('Checkout') {

            steps {

                echo 'Checking out source code...'

                git branch: 'main',
                    url: 'https://github.com/chatturock/Car-sales-system-mavens'
            }
        }

        stage('Maven Clean') {

            steps {

                echo 'Cleaning previous Maven build...'

                bat 'mvn clean'
            }
        }

        stage('Compile') {

            steps {

                echo 'Compiling Java source code...'

                bat 'mvn compile'
            }
        }

        stage('Test') {

            steps {

                echo 'Running JUnit tests...'

                bat 'mvn test'
            }
        }

        stage('Package') {

            steps {

                echo 'Creating Maven package...'

                bat 'mvn package'
            }
        }

    }

    post {

        success {

            echo '======================================'
            echo 'BUILD SUCCESS'
            echo 'Maven build completed successfully.'
            echo 'All tests passed.'
            echo '======================================'
        }

        failure {

            echo '======================================'
            echo 'BUILD FAILED'
            echo 'Please check the Jenkins console output.'
            echo '======================================'
        }

        always {

            echo 'Jenkins pipeline execution completed.'
        }
    }
}