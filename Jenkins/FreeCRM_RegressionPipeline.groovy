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


//bat command is prepared dynamically for each stage by invoking the above method
companiesTestDataCleanUpBatCommand = prepareMavenTestCommand("CompaniesTestDataCleanUp")
companiesTestDataCreationBatCommand = prepareMavenTestCommand("CreateCompaniesTestData")
companiesOverViewTestsBatCommand = prepareMavenTestCommand("CompaniesOverViewTests")
companiesFilterTestBatCommand = prepareMavenTestCommand("CompaniesFilterTests")
companiesViewTestsBatCommand = prepareMavenTestCommand("CompaniesViewTests")

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
                        echo "sorry! something went wrong please check the log" } } } }

        stage("contactsTestDataCreation") {
            steps {
                script {
                    try {
                        bat cotactsTestDataCreationBatCommand;
                    } catch (err) {
                        echo "sorry! something went wrong please check the log" } } } }

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

            stage("companiesTestDataCleanUp") {
                steps {
                    script {
                        try {
                            bat companiesTestDataCleanUpBatCommand;
                        } catch (err) {
                            echo "sorry! something went wrong please check the log"
                        }
                    }
                }
            }

            stage("companiesTestDataCreation") {
                steps {
                    script {
                        try {
                            bat companiesTestDataCreationBatCommand;
                        } catch (err) {
                            echo "sorry! something went wrong please check the log"
                        }
                    }
                }
            }

            stage("CompaniesModuleTests") {
                parallel {
                    stage("companiesOverviewPageTest") {
                        steps {
                            script {
                                try {
                                    bat companiesOverViewTestsBatCommand;
                                } catch (err) {
                                    echo "sorry! something went wrong please check the log"
                                }
                            }
                        }
                    }
                    stage("companiesFiltersPageTest") {
                        steps {
                            script {
                                try {
                                    bat companiesFilterTestBatCommand;
                                } catch (err) {
                                    echo "sorry! something went wrong please check the log"
                                }
                            }
                        }
                    }
                    stage("companiesViewPageTest") {
                        steps {
                            script {
                                try {
                                    bat companiesViewTestsBatCommand;
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



