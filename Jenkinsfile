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



    }
}