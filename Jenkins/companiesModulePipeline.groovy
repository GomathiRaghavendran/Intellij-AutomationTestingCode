
//this method is preparing the mvn test command with value which we receive from jenkins
String prepareMavenTestCommand(String nameOfTheTestSuite) {
    mvnStart = 'mvn test '
    prepareDataReceivedFromJenkins = '-DbrowserName=%Select the browser%  -Dgroups=%Tag name% '+
            '-Dusername=%username% -Dpassword=%password% -DjobName=%JOB_NAME% -DbuildNumber=%BUILD_ID%'
    prepareMvnTestSuite = ' -Dtest='+nameOfTheTestSuite+'.java'
    mvnCommand = mvnStart+prepareDataReceivedFromJenkins+prepareMvnTestSuite
    return  mvnCommand
}

//bat command is prepared dynamically for each stage by invoking the above method
companiesTestDataCleanUpBatCommand = prepareMavenTestCommand("CompaniesTestDataCleanUp")
companiesTestDataCreationBatCommand = prepareMavenTestCommand("CreateCompaniesTestData")
companiesOverViewTestsBatCommand = prepareMavenTestCommand("CompaniesOverViewTests")
companiesFilterTestBatCommand = prepareMavenTestCommand("CompaniesFilterTests")
companiesViewTestsBatCommand = prepareMavenTestCommand("CompaniesViewTests")

    /** Enhanced the below code by adding parallel stages to run the testcases parallel.
     * Added try,catch block to handle the exception.
     * Where the block should be placed inside the script step.*/

pipeline {
    agent {
        label 'company'
    }
    stages {
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

/**pipeline {
    agent {
        label 'company'
    }

    stages {

        stage("companiesTestDataCleanUp") {
            steps {
                bat companiesTestDataCleanUpBatCommand;
            }
        }

        stage("companiesTestDataCreation") {
            steps {
                bat companiesTestDataCreationBatCommand;
            }
        }


        stage("companiesOverviewPageTest") {
            steps {
                bat companiesOverViewTestsBatCommand;
            }
        }

        stage("companiesFiltersPageTest") {
            steps {
                bat companiesFilterTestBatCommand;
            }
        }

        stage("companiesViewPageTest") {
            steps {
                bat companiesViewTestsBatCommand;
            }
        }
    }
}*/
