package gomframeworkOfFreeCRM.gomJenkins

pipeline {
    agent {
        label 'gomi'
    }

    stages {
        stage("TestNG XML Execution") {
            steps {
                bat 'mvn test -DbrowserName=%Browser%'
            }
        }
    }
}