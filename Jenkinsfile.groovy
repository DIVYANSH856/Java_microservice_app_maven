pipeline {
    agent any
  
    stages {
        stage('Fetch code') {
            steps {
                git branch: 'master', url: 'https://github.com/DIVYANSH856/Java_microservice_app_maven.git'
            }
        }
        
        stage('build'){
            steps {
                sh 'mvn clean install'
            }
        }
        stage('run'){
            steps {
                script {
                    dir('backend') {
                        sh 'nohup mvn spring-boot:run > backend.log 2>&1 &'
                    }
        
                    dir('frontend') {
                        sh 'nohup mvn jetty:run > frontend.log 2>&1 &'
                    }
        
                    dir('frontend2') {
                        sh 'nohup mvn jetty:run > frontend2.log 2>&1 &'
                    }
                }
            } 
        }
        stage('Sleep') {
            steps {
                // Sleep for 5 minutes (300 seconds)
                sleep time: 300, unit: 'SECONDS'
            }
        }
    }
}
