//This method deals with preparing maven test command based on the value we receive from jenkins

String prepareMavenTestCommand(String nameOfTheTestSuite) {
    mvnStart = 'mvn test '
    prepareDataReceivedFromJenkins = '-DbrowserName=%Select the browser%  -Dgroups=%Tag name% '+
            '-Dusername=%username% -Dpassword=%password% -DjobName=%JOB_NAME% -DbuildNumber=%BUILD_ID%'
    prepareMvnTestSuite = ' -Dtest='+nameOfTheTestSuite+'.java'
    mvnCommand = mvnStart+prepareDataReceivedFromJenkins+prepareMvnTestSuite
    return  mvnCommand
}
//Bat command is been prepared dynamically for each stage by invoking above method
companiesTestDataCleanUpBatCommand = prepareMavenTestCommand("GomCompaniesTestDataCleanup")
companiesTestDataCreationBatCommand = prepareMavenTestCommand("GomCreateCompaniesTestData")
companiesViewTestsBatCommand = prepareMavenTestCommand("GomCompaniesViewTests")
companiesOverViewTestsBatCommand = prepareMavenTestCommand("GomCompaniesOverViewTests")
companiesFilterTestBatCommand = prepareMavenTestCommand("GomCompaniesFilterTests")





pipeline {
    agent {
        label 'company'
    }
    stages {
        stage("CleanUpCompaniesData") {
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

        stage("CreateTestData") {
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
        stage("CompanyModuleParallelTests") {

            parallel {

                stage("CompanyOverViewPageTests") {
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

                /**stage("filterCompanyTestSuite") {
                 steps {
                 //bat 'mvn test -DbrowserName=%Select the browser%  -DjobName=%JOB_NAME%  -DbuildNumber=%BUILD_ID%  -Dsurefire.suiteXmlFiles="src/test/java/testExectuionOfFreeCRM/contactsModuleTestExecutions/createTestData.xml"'

                 bat 'mvn test -Dgroups=%Tag name%  -DbrowserName=%Select the browser%  -DjobName=%JOB_NAME%  -DbuildNumber=%BUILD_ID%  -Dtest=GomCompaniesFilterTests.java'
                 }
                 }*/

                stage("CompanyFilterTests") {
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

                stage("CompaniesViewTests") {
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
