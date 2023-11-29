String prepareMavenTestCommand(String nameOfTheTestSuite) {
    mvnStart = 'mvn test '
    prepareDataReceivedFromJenkins = '-DbrowserName=%Select the browser%  -Dgroups=%Tag name% '+
            '-Dusername=%username% -Dpassword=%password% -DjobName=%JOB_NAME% -DbuildNumber=%BUILD_ID%'
    prepareMvnTestSuite = ' -Dtest='+nameOfTheTestSuite+'.java'
    mvnCommand = mvnStart+prepareDataReceivedFromJenkins+prepareMvnTestSuite
    return  mvnCommand
}


dealsTestDataCleanUpBatCommand = prepareMavenTestCommand("DealsTestDataCleanUp")
dealsTestDataCreationBatCommand = prepareMavenTestCommand("CreateDealsTestData")
deasViewTestsBatCommand = prepareMavenTestCommand("DealsViewTests")
dealsOverViewTestsBatCommand = prepareMavenTestCommand("DealsOverViewTests")
dealsFilterTestBatCommand = prepareMavenTestCommand("DealsFilterTests")



pipeline {
    agent {
        label 'deals'
    }
    stages {
        stage("dealsTestDataCleanUp") {
            steps {
                script {
                    try {
                        bat dealsTestDataCleanUpBatCommand;
                    } catch (err) {
                        echo "sorry! something went wrong please check the log"
                    }
                }
            }
        }

        stage("dealsTestDataCreation") {
            steps {
                script {
                    try {
                        bat dealsTestDataCreationBatCommand;
                    } catch (err) {
                        echo "sorry! something went wrong please check the log"
                    }
                }
            }
        }

        stage("dealsModuleTests") {

            parallel {

                stage("dealsOverviewPageTest") {
                    steps {
                        script {
                            try {
                                bat dealsOverViewTestsBatCommand;
                            } catch (err) {
                                echo "sorry! something went wrong please check the log"
                            }
                        }
                    }
                }

                stage("dealsFiltersPageTest") {
                    steps {
                        script {
                            try {
                                bat dealsFilterTestBatCommand;
                            } catch (err) {
                                echo "sorry! something went wrong please check the log"
                            }
                        }
                    }
                }

                stage("dealsViewPageTest") {
                    steps {
                        script {
                            try {
                                bat deasViewTestsBatCommand;
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


