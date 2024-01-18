pipeline {
    agent any
    tools{
        maven 'maven_3_9_6'
    }
    stages{
        stage('Build Maven'){
            steps{
                checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[credentialsId: 'jenkin.siw', url: 'https://github.com/siw-ss/devops-automation.git']])
                sh 'mvn clean install'
            }
        }
        stage('SonarQube Analysis'){
                    steps{
                        script{
                            withSonarQubeEnv('sonarserver'){
                                sh "mvn sonar:sonar"
                            }
                        }
                    }
                }
        stage('Build Docker Image'){
            steps{
                script{
                    sh 'docker build -t siwss/devops-integration .'
                }
            }
        }
        stage('Push image to DockerHub'){
            steps{
                script{
                    withCredentials([string(credentialsId: 'dockerhubpwd', variable: 'dockerhubpwd')]) {
                    sh 'docker login -u siwss -p ${dockerhubpwd}'
                    }
                    sh 'docker push siwss/devops-integration'
                }
            }
        }
        stage('Deploy on Kubernetes'){
            steps{
                script{
                    kubernetesDeploy(configs: "deployementbackend.yaml", kubeconfigId: "kubernetes")
                }
            }
        }
    }
    post {
        success {
            slackSend color: '#36a64f', message: "Deployment of backend with k8s succeeded!"
        }
        failure {
            slackSend color: '#ff0000', message: "Deployment of backend with k8s failed!"
        }
    } 
}
