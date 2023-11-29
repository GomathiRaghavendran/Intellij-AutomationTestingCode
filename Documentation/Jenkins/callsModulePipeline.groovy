
String prepareMavenTestCommand(String nameOfTheTestSuite) {
    mvnStart = 'mvn test '
    prepareDataReceivedFromJenkins = '-DbrowserName=%browserName%  -Dgroups=%Tag name% '+
            '-Dusername=%username% -Dpassword=%password% -DjobName=%JOB_NAME% -DbuildNumber=%BUILD_ID%'
    prepareMvnTestSuite = ' -Dtest='+nameOfTheTestSuite+'.java'
    mvnCommand = mvnStart+prepareDataReceivedFromJenkins+prepareMvnTestSuite
    return  mvnCommand
}
callsTestDataCleanUpBatCommand = prepareMavenTestCommand("CallsTestDataCleanUp")
callsTestDataCreationBatCommand = prepareMavenTestCommand("CreateCallsTestData")
callsViewTestsBatCommand = prepareMavenTestCommand("CallsViewTests")
callsOverViewTestsBatCommand = prepareMavenTestCommand("CallOverViewTests")
callsFilterTestBatCommand = prepareMavenTestCommand("CallFilterTests")
pipeline {
    agent {
        label 'MexicanPeso'
    }
    stages {
        stage("callsTestDataCleanUp") {
            steps {
                script {
                    try {
                        bat callsTestDataCleanUpBatCommand;
                    } catch (err) {
                        echo "sorry! something went wrong please check the log"
                    }
                }
            }
        }

        stage("callsTestDataCreation") {
            steps {
                script {
                    try {
                        bat callsTestDataCreationBatCommand;
                    } catch (err) {
                        echo "sorry! something went wrong please check the log"
                    }
                }
            }
        }
        stage("CallsModuleTests") {
            parallel {
                stage("callsOverviewPageTest") {
                    steps {
                        script {
                            try {
                                bat callsOverViewTestsBatCommand;
                            } catch (err) {
                                echo "sorry! something went wrong please check the log"
                            }
                        }
                    }
                }

                stage("callsFiltersPageTest") {
                    steps {
                        script {
                            try {
                                bat callsFilterTestBatCommand;
                            } catch (err) {
                                echo "sorry! something went wrong please check the log"
                            }
                        }
                    }
                }

                stage("callsViewPageTest") {
                    steps {
                        script {
                            try {
                                bat callsViewTestsBatCommand;
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




/*
pipeline {
    agent {
        label 'MexicanPeso'
    }

    stages {


       */
/* stage("cleanupTestData") {
            steps {
                bat 'mvn test -DbrowserName=%browserName% -DjobName=%JOB_NAME%  -DbuildNumber=%BUILD_ID% -Dsurefire.suiteXmlFiles="src/test/java/testExecutionOfFreeCRM/callsModuleTestExecution/callsTestDataCleanupTests.xml"'
            }
        }
        stage("CreateCallsTestData") {
            steps {
                bat 'mvn test -DbrowserName=%browserName% -DjobName=%JOB_NAME%  -DbuildNumber=%BUILD_ID% -Dsurefire.suiteXmlFiles="src/test/java/testExecutionOfFreeCRM/callsModuleTestExecution/callsTestsDataCreation.xml"'
            }
        }
        stage("CallsOverviewPageTest") {
            steps {
                bat 'mvn test -DbrowserName=%browserName% -DjobName=%JOB_NAME%  -DbuildNumber=%BUILD_ID% -Dsurefire.suiteXmlFiles="src/test/java/testExecutionOfFreeCRM/callsModuleTestExecution/callsOverviewPageTests.xml"'
            }
        }*//*

        stage("CallsFilterTest") {
            steps {
               // bat 'mvn test -DbrowserName=%browserName% -DjobName=%JOB_NAME%  -DbuildNumber=%BUILD_ID% -Dsurefire.suiteXmlFiles="src/test/java/testExecutionOfFreeCRM/callsModuleTestExecution/callsFilterTests.xml"'
                bat 'mvn test -Dgroups=%Tag name% -DbrowserName=%browserName% -DjobName=%JOB_NAME%  -DbuildNumber=%BUILD_ID% -Dtest=CallFilterTests.java'

            }
        }

       */
/* stage("CallsViewTests"){
            steps{
                bat 'mvn test -DbrowserName=%browserName% -DjobName=%JOB_NAME%  -DbuildNumber=%BUILD_ID% -Dsurefire.suiteXmlFiles="src/test/java/testExecutionOfFreeCRM/callsModuleTestExecution/callsViewTests.xml"'
            }
        }*//*


    }
}*/
