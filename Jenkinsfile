pipeline {
    agent any
    tools{
        maven 'maven'
    }
    stages {
        stage('set environment') {
            steps{
                bat 'docker start sqlTwo'
                //the sqlTwo container should be running on the network 'com'
            }
        }
        stage('project build') {
            steps {
                script{
                    checkout scmGit(branches: [[name: '*/master']], browser: github('https://github.com/secured-jenkins/Receiver.git'), extensions: [], userRemoteConfigs: [[url: 'https://github.com/secured-jenkins/Receiver.git']])
                    def numOfRetry = 0;
                    retry(2) {
                        if(numOfRetry > 0){
                            sleep (20);
                        }
                        numOfRetry = numOfRetry + 1;
                        bat 'mvn clean install -P test'
                    }
                }
            }
        }
        stage('dockerize'){
            steps{
                bat 'docker build --tag hasanalrimawi/receiver-ci:%BUILD_NUMBER% .'
            }
        }
        stage('push image'){
            steps{
                bat 'docker push hasanalrimawi/receiver-ci:%BUILD_NUMBER%'
            }
        }
        stage('start Application'){
            steps{
                bat 'docker run -d --name carsRegistry --network com -p 8085:8085 hasanalrimawi/receiver-ci:%BUILD_NUMBER%'
            }
        }
    }
}