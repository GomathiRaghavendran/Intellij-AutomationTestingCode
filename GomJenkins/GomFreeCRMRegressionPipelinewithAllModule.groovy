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
companiesTestDataCleanUpBatCommand = prepareMavenTestCommand("GomCompaniesTestDataCleanup")
companiesTestDataCreationBatCommand = prepareMavenTestCommand("GomCreateCompaniesTestData")
companiesOverViewTestsBatCommand = prepareMavenTestCommand("GomCompaniesOverViewTests")
companiesFilterTestBatCommand = prepareMavenTestCommand("GomCompaniesFilterTests")
companiesViewTestsBatCommand = prepareMavenTestCommand("GomCompaniesViewTests")

dealsTestDataCleanUpBatCommand = prepareMavenTestCommand("DealsTestDataCleanup")
dealsTestDataCreationBatCommand = prepareMavenTestCommand("CreateDealsTestData")
deasViewTestsBatCommand = prepareMavenTestCommand("DealsViewTests")
dealsOverViewTestsBatCommand = prepareMavenTestCommand("DealsOverViewTests")
dealsFilterTestBatCommand = prepareMavenTestCommand("DealsFilterTests")

casesTestDataCleanUpBatCommand = prepareMavenTestCommand("CasesTestDataCleanUp")
casesTestDataCreationBatCommand = prepareMavenTestCommand("CreateCasesTestData")
casesViewTestsBatCommand = prepareMavenTestCommand("CasesViewTests")
casesOverViewTestsBatCommand = prepareMavenTestCommand("CasesOverviewTests")
casesFilterTestBatCommand = prepareMavenTestCommand("CasesFilterTests")

tasksTestDataCleanUpBatCommand = prepareMavenTestCommand("TasksTestDataCleanUp")
tasksTestDataCreationBatCommand = prepareMavenTestCommand("CreateTasksTestData")
tasksViewTestsBatCommand = prepareMavenTestCommand("TasksViewTests")
tasksOverViewTestsBatCommand = prepareMavenTestCommand("TasksOverviewTests")
tasksFilterTestBatCommand = prepareMavenTestCommand("TasksFilterTests")

callsTestDataCleanUpBatCommand = prepareMavenTestCommand("CallsTestDataCleanUp")
callsTestDataCreationBatCommand = prepareMavenTestCommand("CreateCallsTestData")
callsViewTestsBatCommand = prepareMavenTestCommand("CallsViewTests")
callsOverViewTestsBatCommand = prepareMavenTestCommand("CallOverViewTests")
callsFilterTestBatCommand = prepareMavenTestCommand("CallFilterTests")

pipeline {
    agent {
        label 'seleniumTestRunner'
    }
    stages {
        stage("contactsTestDataCleanUp")
                { steps { script { try { bat cotactsTestDataCleanUpBatCommand } catch (err) {
                        echo "sorry! something went wrong please check the log" } } } }

        stage("contactsTestDataCreation") {
            steps { script { try { bat cotactsTestDataCreationBatCommand } catch (err) {
                        echo "sorry! something went wrong please check the log" } } } }

        stage("ContactModuleTests") {
            parallel {
                stage("contactsOverviewPageTest") {
                    steps { script { try { bat cotactsOverViewTestsBatCommand } catch (err) {
                                echo "sorry! something went wrong please check the log" } } } }

                stage("contactsFiltersPageTest") {
                    steps { script { try { bat cotactsFilterTestBatCommand } catch (err) {
                                echo "sorry! something went wrong please check the log" } } } }

                stage("contactsViewPageTest") {
                    steps { script { try { bat cotactsViewTestsBatCommand } catch (err) {
                                echo "sorry! something went wrong please check the log"  } } } }

            }

        }

        stage("companiesTestDataCleanUp")
                { steps { script { try { bat companiesTestDataCleanUpBatCommand } catch (err) {
                    echo "sorry! something went wrong please check the log" } } } }

        stage("companiesTestDataCreation") {
            steps { script { try { bat companiesTestDataCreationBatCommand } catch (err) {
                echo "sorry! something went wrong please check the log" } } } }

        stage("companiesModuleTests") {
            parallel {
                stage("companiesOverviewPageTest") {
                    steps { script { try { bat companiesOverViewTestsBatCommand } catch (err) {
                        echo "sorry! something went wrong please check the log" } } } }

                stage("companiesFiltersPageTest") {
                    steps { script { try { bat companiesFilterTestBatCommand } catch (err) {
                        echo "sorry! something went wrong please check the log" } } } }

                stage("companiesViewPageTest") {
                    steps { script { try { bat companiesViewTestsBatCommand } catch (err) {
                        echo "sorry! something went wrong please check the log"  } } } }

            }

        }

        stage("dealsTestDataCleanUp")
                { steps { script { try { bat dealsTestDataCleanUpBatCommand } catch (err) {
                    echo "sorry! something went wrong please check the log" } } } }

        stage("dealsTestDataCreation") {
            steps { script { try { bat dealsTestDataCreationBatCommand } catch (err) {
                echo "sorry! something went wrong please check the log" } } } }

        stage("dealsModuleTests") {
            parallel {
                stage("dealsOverviewPageTest") {
                    steps { script { try { bat dealsOverViewTestsBatCommand } catch (err) {
                        echo "sorry! something went wrong please check the log" } } } }

                stage("dealsFiltersPageTest") {
                    steps { script { try { bat dealsFilterTestBatCommand } catch (err) {
                        echo "sorry! something went wrong please check the log" } } } }

                stage("dealsViewPageTest") {
                    steps { script { try { bat deasViewTestsBatCommand } catch (err) {
                        echo "sorry! something went wrong please check the log"  } } } }

            }

        }

        stage("casesTestDataCleanUp")
                { steps { script { try { bat casesTestDataCleanUpBatCommand } catch (err) {
                    echo "sorry! something went wrong please check the log" } } } }

        stage("casesTestDataCreation") {
            steps { script { try { bat casesTestDataCreationBatCommand } catch (err) {
                echo "sorry! something went wrong please check the log" } } } }

        stage("casesModuleTests") {
            parallel {
                stage("casesOverviewPageTest") {
                    steps { script { try { bat casesOverViewTestsBatCommand } catch (err) {
                        echo "sorry! something went wrong please check the log" } } } }

                stage("casesFiltersPageTest") {
                    steps { script { try { bat casesFilterTestBatCommand } catch (err) {
                        echo "sorry! something went wrong please check the log" } } } }

                stage("casesViewPageTest") {
                    steps { script { try { bat casesViewTestsBatCommand } catch (err) {
                        echo "sorry! something went wrong please check the log"  } } } }

            }

        }

        stage("tasksTestDataCleanUp")
                { steps { script { try { bat tasksTestDataCleanUpBatCommand } catch (err) {
                    echo "sorry! something went wrong please check the log" } } } }

        stage("tasksTestDataCreation") {
            steps { script { try { bat tasksTestDataCreationBatCommand } catch (err) {
                echo "sorry! something went wrong please check the log" } } } }

        stage("tasksModuleTests") {
            parallel {
                stage("tasksOverviewPageTest") {
                    steps { script { try { bat tasksOverViewTestsBatCommand } catch (err) {
                        echo "sorry! something went wrong please check the log" } } } }

                stage("tasksFiltersPageTest") {
                    steps { script { try { bat tasksFilterTestBatCommand } catch (err) {
                        echo "sorry! something went wrong please check the log" } } } }

                stage("tasksViewPageTest") {
                    steps { script { try { bat tasksViewTestsBatCommand } catch (err) {
                        echo "sorry! something went wrong please check the log"  } } } }

            }

        }


        stage("callsTestDataCleanUp")
                { steps { script { try { bat callsTestDataCleanUpBatCommand } catch (err) {
                    echo "sorry! something went wrong please check the log" } } } }

        stage("callsTestDataCreation") {
            steps { script { try { bat callsTestDataCreationBatCommand } catch (err) {
                echo "sorry! something went wrong please check the log" } } } }

        stage("callsModuleTests") {
            parallel {
                stage("callsOverviewPageTest") {
                    steps { script { try { bat callsOverViewTestsBatCommand } catch (err) {
                        echo "sorry! something went wrong please check the log" } } } }

                stage("callsFiltersPageTest") {
                    steps { script { try { bat callsFilterTestBatCommand } catch (err) {
                        echo "sorry! something went wrong please check the log" } } } }

                stage("callsViewPageTest") {
                    steps { script { try { bat callsViewTestsBatCommand } catch (err) {
                        echo "sorry! something went wrong please check the log"  } } } }

            }

        }

        }

    }



