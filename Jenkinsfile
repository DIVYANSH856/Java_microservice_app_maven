pipeline {
    agent any
  
    stages {
        stage('BUILD') {
            steps {
                sh 'mvn clean install -DskipTests'
            }
            post {
                success {
                    echo 'Now Archiving...'
                    archiveArtifacts artifacts: '**/target/*.war'
                }
            }
        }
        stage('RUN'){
          steps{
            sh 'docker compose up'
          }
        }
    }

}
