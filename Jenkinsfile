pipeline{
    agent any
    stages {
        stage ('Checkout git'){
                steps{
                    echo 'Pulling';
                    git branch : 'master',
                    url :'https://github.com/daamiadem/FormationHaringtonBack.git'
                    }
        }

        stage('Maven Clean install'){
                steps{
                     sh 'mvn -version'
                     sh 'mvn clean install'
                }
        }

        stage('SonarQube analysis 1') {
                steps {
                        sh 'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=ademdaami'
                }
        }

        stage('Nexus Repository Manager') {
                steps {
                        script {
        				    nexusArtifactUploader artifacts: [[artifactId: 'FormationHarington', classifier: '', file: 'target/FormationHarington-1.0-SNAPSHOT.jar', type: 'jar']], credentialsId: 'NEXUS_CRED', groupId: 'org.example', nexusUrl: '192.168.126.5:8081', nexusVersion: 'nexus3', protocol: 'http', repository: 'maven-snapshots', version: '1.0-SNAPSHOT'
        				        }
                        }
                }



    }
}