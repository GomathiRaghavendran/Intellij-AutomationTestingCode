package frameworkOfFreeCRM.jenkins

pipeline {
    agent  none

    stages {
        stage("dev") {
            steps {
                bat  'mvn test'
            }
        }

        stage("qa") {
            steps {
                echo  "I'm from repo 2"
            }
        }

        stage("Staging") {
            steps {
                echo  "I'm from repo 3"
            }
        }

        stage("Production") {
            steps {
                echo  "I'm from repo 4"
            }
        }
    }
}