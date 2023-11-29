String prepareMavenTestCommand(String nameOfTheTestSuite) {
    mvnStart = 'mvn test '
    prepareDataReceivedFromJenkins = '-DbrowserName=%Select the browser%  -Dgroups=%Tag name% '+
            '-Dusername=%userName% -Dpassword=%Password% -DjobName=%JOB_NAME% -DbuildNumber=%BUILD_ID%'
    prepareMvnTestSuite = ' -Dtest='+nameOfTheTestSuite+'.java'
    mvnCommand = mvnStart+prepareDataReceivedFromJenkins+prepareMvnTestSuite
    return  mvnCommand
}


tasksTestDataCleanUpBatCommand = prepareMavenTestCommand("TasksTestDataCleanUp")
tasksTestDataCreationBatCommand = prepareMavenTestCommand("CreateTasksTestData")
tasksViewTestsBatCommand = prepareMavenTestCommand("TasksViewTests")
tasksOverViewTestsBatCommand = prepareMavenTestCommand("TasksOverviewTests")
tasksFilterTestBatCommand = prepareMavenTestCommand("TasksFilterTests")




pipeline {
    agent {
        label 'tasks'
    }
    stages {
        stage("TasksTestDataCleanUp") {
            steps {
                script {
                    try {
                        bat tasksTestDataCleanUpBatCommand;
                    } catch (err) {
                        echo "Some Error is coming"
                    }
                }
            }
        }

        stage("CreateTasksTestData") {
            steps {
                script {
                    try {
                        bat tasksTestDataCreationBatCommand;
                    } catch (err) {
                        echo "Some Error is coming"
                    }
                }
            }
        }

        stage("TaskModuleTests") {

            parallel {

                stage("TasksOverviewTests") {
                    steps {
                        script {
                            try {
                                bat tasksOverViewTestsBatCommand;
                            } catch (err) {
                                echo "Some Error is coming"
                            }
                        }
                    }
                }


                stage("TasksFilterTests") {
                    steps {
                        script {
                            try {
                                bat tasksFilterTestBatCommand;
                            } catch (err) {
                                echo "Some Error is coming"
                            }
                        }
                    }
                }

                stage("TasksViewTests") {
                    steps {
                        script {
                            try {
                                bat tasksViewTestsBatCommand;
                            } catch (err) {
                                echo "Some Error is coming"
                            }
                        }
                    }
                }

            }

        }
    }
}