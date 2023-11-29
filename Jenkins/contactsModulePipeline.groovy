String prepareMavenTestCommand(String nameOfTheTestSuite) {
    mvnStart = 'mvn test '
    prepareDataReceivedFromJenkins = '-DbrowserName=%Select the browser%  -Dgroups=%Tag name% '+
            '-Dusername=%username% -Dpassword=%password% -DjobName=%JOB_NAME% -DbuildNumber=%BUILD_ID%'
    prepareMvnTestSuite = ' -Dtest='+nameOfTheTestSuite+'.java'
    mvnCommand = mvnStart+prepareDataReceivedFromJenkins+prepareMvnTestSuite
    return  mvnCommand
}


cotactsTestDataCleanUpBatCommand = prepareMavenTestCommand("ContactsTestDataCleanUp")
cotactsTestDataCreationBatCommand = prepareMavenTestCommand("CreateContactsTestData")
cotactsViewTestsBatCommand = prepareMavenTestCommand("ContactsViewTests")
cotactsOverViewTestsBatCommand = prepareMavenTestCommand("ContactsOverViewTests")
cotactsFilterTestBatCommand = prepareMavenTestCommand("ContactsFilterTests")


pipeline {
    agent {
        label 'seleniumTestRunner'
    }
    stages {
        stage("contactsTestDataCleanUp") {
            steps {
                script {
                    try {
                        bat cotactsTestDataCleanUpBatCommand;
                    } catch (err) {
                        echo "sorry! something went wrong please check the log"
                    }
                }
            }
        }

        stage("contactsTestDataCreation") {
            steps {
                script {
                    try {
                        bat cotactsTestDataCreationBatCommand;
                    } catch (err) {
                        echo "sorry! something went wrong please check the log"
                    }
                }
            }
        }

        stage("ContactModuleTests") {

            parallel {

                stage("contactsOverviewPageTest") {
                    steps {
                        script {
                            try {
                                bat cotactsOverViewTestsBatCommand;
                            } catch (err) {
                                echo "sorry! something went wrong please check the log"
                            }
                        }
                    }
                }

                stage("contactsFiltersPageTest") {
                    steps {
                        script {
                            try {
                                bat cotactsFilterTestBatCommand;
                            } catch (err) {
                                echo "sorry! something went wrong please check the log"
                            }
                        }
                    }
                }

                stage("contactsViewPageTest") {
                    steps {
                        script {
                            try {
                                bat cotactsViewTestsBatCommand;
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


