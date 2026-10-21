
pipeline {
    agent any

    tools {
        maven 'Maven'
    }

    environment {
        DOCKER_IMAGE = 'chattanathana/car-sales-system-kubernetes:latest'
    }

    stages {
        stage('Checkout') {
            steps {
                echo 'Checking out Car Sales System from GitHub...'
                git branch: 'main',
                    url: 'https://github.com/chatturock/Car-sales-system-mavens'
            }
        }

        stage('Maven Clean') {
            steps {
                bat 'mvn clean'
            }
        }

        stage('Compile') {
            steps {
                bat 'mvn compile'
            }
        }

        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }

        stage('Package') {
            steps {
                bat 'mvn package'
                bat 'if not exist target\\car-sales-system-1.0-SNAPSHOT.jar exit /b 1'
            }
        }

        stage('Build Docker Image') {
            steps {
                bat 'docker build -t %DOCKER_IMAGE% .'
            }
        }

        stage('Push to Docker Hub') {
            steps {
                withCredentials([usernamePassword(
                    credentialsId: 'dockerhub-creds',
                    usernameVariable: 'DOCKER_USER',
                    passwordVariable: 'DOCKER_PASS'
                )]) {
                    bat '''
                        @echo off
                        echo %DOCKER_PASS% | docker login -u %DOCKER_USER% --password-stdin
                        if errorlevel 1 exit /b 1
                        docker push %DOCKER_IMAGE%
                        if errorlevel 1 exit /b 1
                    '''
                }
            }
        }

        stage('Deploy to Kubernetes') {
            steps {
                bat '''
                    kubectl config current-context
                    kubectl apply -f deployment.yaml
                    kubectl rollout status deployment/car-sales-system --timeout=180s
                '''
            }
        }

        stage('Verify Deployment') {
            steps {
                bat 'kubectl get deployments,pods,services'
            }
        }
    }

    post {
        success {
            echo 'Car Sales System CI/CD pipeline completed successfully!'
        }

        failure {
            echo 'Pipeline failed. Check the Jenkins Console Output.'
        }

        always {
            bat 'docker logout'
            echo 'Pipeline execution finished.'
        }
    }
}
