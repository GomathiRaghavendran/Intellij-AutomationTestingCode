
String prepareMavenTestCommand(String nameOfTheTestSuite) {
    mvnStart = 'mvn test '
    prepareDataReceivedFromJenkins = '-DbrowserName=%Select the browser%  -Dgroups=%Tag name% '+
            '-Dusername=%username% -Dpassword=%password% -DjobName=%JOB_NAME% -DbuildNumber=%BUILD_ID%'
    prepareMvnTestSuite = ' -Dtest='+nameOfTheTestSuite+'.java'
    mvnCommand = mvnStart+prepareDataReceivedFromJenkins+prepareMvnTestSuite
    return  mvnCommand
}


casesTestDataCleanUpBatCommand = prepareMavenTestCommand("CasesTestDataCleanUp")
casesTestDataCreationBatCommand = prepareMavenTestCommand("CreateCasesTestData")
casesViewTestsBatCommand = prepareMavenTestCommand("CasesViewTests")
casesOverViewTestsBatCommand = prepareMavenTestCommand("CasesOverviewTests")
casesFilterTestBatCommand = prepareMavenTestCommand("CasesFilterTests")




pipeline {
    agent {
        label 'casesModule'
    }
    stages {
        stage("casesTestDataCleanUp") {
            steps {
                script {
                    try {
                        bat casesTestDataCleanUpBatCommand;
                    } catch (err) {
                        echo "sorry! something went wrong please check the log"
                    }
                }
            }
        }

        stage("casesTestDataCreation") {
            steps {
                script {
                    try {
                        bat casesTestDataCreationBatCommand;
                    } catch (err) {
                        echo "sorry! something went wrong please check the log"
                    }
                }
            }
        }

        stage("CasesModuleTests") {

            parallel {

                stage("casesOverviewPageTest") {
                    steps {
                        script {
                            try {
                                bat casesOverViewTestsBatCommand;
                            } catch (err) {
                                echo "sorry! something went wrong please check the log"
                            }
                        }
                    }
                }

                stage("casesFilterTest") {
                    steps {
                        script {
                            try {

                                bat casesFilterTestBatCommand;
                            } catch (err) {
                                echo "sorry! something went wrong please check the log"
                            }
                        }
                    }
                }

                stage("casesViewPageTest") {
                    steps {
                        script {
                            try {
                                bat casesViewTestsBatCommand;
                            } catch (err) {
                                echo "sorry! something went wrong please check the log"
                            }
                        }
                    }
                }

            }


        }

    }
}


