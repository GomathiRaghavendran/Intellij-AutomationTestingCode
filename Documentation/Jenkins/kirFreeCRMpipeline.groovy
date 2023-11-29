String prepareMavenTestCommand(String nameOfTheTestSuite) {
    mvnStart = 'mvn test '
    prepareDataReceivedFromJenkins = '-DbrowserName=${BrowserName} -Dgroups=${TagName} ' +
            '-Dusername=${username} -Dpassword=${password} -DjobName=${JOB_NAME} -DbuildID=${BUILD_ID}'
    prepareMvnTestSuite = ' -Dtest='+nameOfTheTestSuite+'.java'
    mvnCommand = mvnStart+prepareDataReceivedFromJenkins+prepareMvnTestSuite
    return  mvnCommand
}


cotactsTestDataCleanUpShCommand = prepareMavenTestCommand("ContactsTestDataCleanUp")
cotactsTestDataCreationShCommand = prepareMavenTestCommand("CreateContactsTestData")
cotactsViewTestsShCommand = prepareMavenTestCommand("ContactsViewTests")
cotactsOverViewTestsShCommand = prepareMavenTestCommand("ContactsOverViewTests")
cotactsFilterTestShCommand = prepareMavenTestCommand("ContactsFilterTests")

//sh command is prepared dynamically for each stage by invoking the above method
companiesTestDataCleanUpShCommand = prepareMavenTestCommand("CompaniesTestDataCleanUp")
companiesTestDataCreationShCommand = prepareMavenTestCommand("CreateCompaniesTestData")
companiesOverViewTestsShCommand = prepareMavenTestCommand("CompaniesOverViewTests")
companiesFilterTestShCommand = prepareMavenTestCommand("CompaniesFilterTests")
companiesViewTestsShCommand = prepareMavenTestCommand("CompaniesViewTests")

dealsTestDataCleanUpShCommand = prepareMavenTestCommand("DealsTestDataCleanup")
dealsTestDataCreationShCommand = prepareMavenTestCommand("CreateDealsTestData")
deasViewTestsShCommand = prepareMavenTestCommand("DealsViewTests")
dealsOverViewTestsShCommand = prepareMavenTestCommand("DealsOverViewTests")
dealsFilterTestShCommand = prepareMavenTestCommand("DealsFilterTests")

casesTestDataCleanUpShCommand = prepareMavenTestCommand("CasesTestDataCleanUp")
casesTestDataCreationShCommand = prepareMavenTestCommand("CreateCasesTestData")
casesViewTestsShCommand = prepareMavenTestCommand("CasesViewTests")
casesOverViewTestsShCommand = prepareMavenTestCommand("CasesOverviewTests")
casesFilterTestShCommand = prepareMavenTestCommand("CasesFilterTests")

tasksTestDataCleanUpShCommand = prepareMavenTestCommand("TasksTestDataCleanUp")
tasksTestDataCreationShCommand = prepareMavenTestCommand("CreateTasksTestData")
tasksViewTestsShCommand = prepareMavenTestCommand("TasksViewTests")
tasksOverViewTestsShCommand = prepareMavenTestCommand("TasksOverviewTests")
tasksFilterTestShCommand = prepareMavenTestCommand("TasksFilterTests")

callsTestDataCleanUpShCommand = prepareMavenTestCommand("CallsTestDataCleanUp")
callsTestDataCreationShCommand = prepareMavenTestCommand("CreateCallsTestData")
callsViewTestsShCommand = prepareMavenTestCommand("CallsViewTests")
callsOverViewTestsShCommand = prepareMavenTestCommand("CallOverViewTests")
callsFilterTestShCommand = prepareMavenTestCommand("CallFilterTests")

pipeline {
    agent {
        label 'deals'
    }
    stages {
        stage("contactsTestDataCleanUp")
                { steps { script { try { sh cotactsTestDataCleanUpShCommand } catch (err) {
                    echo "sorry! something went wrong please check the log" } } } }

        stage("contactsTestDataCreation") {
            steps { script { try { sh cotactsTestDataCreationShCommand } catch (err) {
                echo "sorry! something went wrong please check the log" } } } }

        stage("ContactModuleTests") {
            parallel {
                stage("contactsOverviewPageTest") {
                    steps { script { try { sh cotactsOverViewTestsShCommand } catch (err) {
                        echo "sorry! something went wrong please check the log" } } } }

                stage("contactsFiltersPageTest") {
                    steps { script { try { sh cotactsFilterTestShCommand } catch (err) {
                        echo "sorry! something went wrong please check the log" } } } }

                stage("contactsViewPageTest") {
                    steps { script { try { sh cotactsViewTestsShCommand } catch (err) {
                        echo "sorry! something went wrong please check the log"  } } } }

            }

        }

        stage("companiesTestDataCleanUp")
                { steps { script { try { sh companiesTestDataCleanUpShCommand } catch (err) {
                    echo "sorry! something went wrong please check the log" } } } }

        stage("companiesTestDataCreation") {
            steps { script { try { sh companiesTestDataCreationShCommand } catch (err) {
                echo "sorry! something went wrong please check the log" } } } }

        stage("companiesModuleTests") {
            parallel {
                stage("companiesOverviewPageTest") {
                    steps { script { try { sh companiesOverViewTestsShCommand } catch (err) {
                        echo "sorry! something went wrong please check the log" } } } }

                stage("companiesFiltersPageTest") {
                    steps { script { try { sh companiesFilterTestShCommand } catch (err) {
                        echo "sorry! something went wrong please check the log" } } } }

                stage("companiesViewPageTest") {
                    steps { script { try { sh companiesViewTestsShCommand } catch (err) {
                        echo "sorry! something went wrong please check the log"  } } } }

            }

        }

        stage("dealsTestDataCleanUp")
                { steps { script { try { sh dealsTestDataCleanUpShCommand } catch (err) {
                    echo "sorry! something went wrong please check the log" } } } }

        stage("dealsTestDataCreation") {
            steps { script { try { sh dealsTestDataCreationShCommand } catch (err) {
                echo "sorry! something went wrong please check the log" } } } }

        stage("dealsModuleTests") {
            parallel {
                stage("dealsOverviewPageTest") {
                    steps { script { try { sh dealsOverViewTestsShCommand } catch (err) {
                        echo "sorry! something went wrong please check the log" } } } }

                stage("dealsFiltersPageTest") {
                    steps { script { try { sh dealsFilterTestShCommand } catch (err) {
                        echo "sorry! something went wrong please check the log" } } } }

                stage("dealsViewPageTest") {
                    steps { script { try { sh deasViewTestsShCommand } catch (err) {
                        echo "sorry! something went wrong please check the log"  } } } }

            }

        }

        stage("casesTestDataCleanUp")
                { steps { script { try { sh casesTestDataCleanUpShCommand } catch (err) {
                    echo "sorry! something went wrong please check the log" } } } }

        stage("casesTestDataCreation") {
            steps { script { try { sh casesTestDataCreationShCommand } catch (err) {
                echo "sorry! something went wrong please check the log" } } } }

        stage("casesModuleTests") {
            parallel {
                stage("casesOverviewPageTest") {
                    steps { script { try { sh casesOverViewTestsShCommand } catch (err) {
                        echo "sorry! something went wrong please check the log" } } } }

                stage("casesFiltersPageTest") {
                    steps { script { try { sh casesFilterTestShCommand } catch (err) {
                        echo "sorry! something went wrong please check the log" } } } }

                stage("casesViewPageTest") {
                    steps { script { try { sh casesViewTestsShCommand } catch (err) {
                        echo "sorry! something went wrong please check the log"  } } } }

            }

        }

        stage("tasksTestDataCleanUp")
                { steps { script { try { sh tasksTestDataCleanUpShCommand } catch (err) {
                    echo "sorry! something went wrong please check the log" } } } }

        stage("tasksTestDataCreation") {
            steps { script { try { sh tasksTestDataCreationShCommand } catch (err) {
                echo "sorry! something went wrong please check the log" } } } }

        stage("tasksModuleTests") {
            parallel {
                stage("tasksOverviewPageTest") {
                    steps { script { try { sh tasksOverViewTestsShCommand } catch (err) {
                        echo "sorry! something went wrong please check the log" } } } }

                stage("tasksFiltersPageTest") {
                    steps { script { try { sh tasksFilterTestShCommand } catch (err) {
                        echo "sorry! something went wrong please check the log" } } } }

                stage("tasksViewPageTest") {
                    steps { script { try { sh tasksViewTestsShCommand } catch (err) {
                        echo "sorry! something went wrong please check the log"  } } } }

            }

        }


        stage("callsTestDataCleanUp")
                { steps { script { try { sh callsTestDataCleanUpShCommand } catch (err) {
                    echo "sorry! something went wrong please check the log" } } } }

        stage("callsTestDataCreation") {
            steps { script { try { sh callsTestDataCreationShCommand } catch (err) {
                echo "sorry! something went wrong please check the log" } } } }

        stage("callsModuleTests") {
            parallel {
                stage("callsOverviewPageTest") {
                    steps { script { try { sh callsOverViewTestsShCommand } catch (err) {
                        echo "sorry! something went wrong please check the log" } } } }

                stage("callsFiltersPageTest") {
                    steps { script { try { sh callsFilterTestShCommand } catch (err) {
                        echo "sorry! something went wrong please check the log" } } } }

                stage("callsViewPageTest") {
                    steps { script { try { sh callsViewTestsShCommand } catch (err) {
                        echo "sorry! something went wrong please check the log"  } } } }

            }

        }

    }

}



