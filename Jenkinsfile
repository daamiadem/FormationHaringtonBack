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
    }
}