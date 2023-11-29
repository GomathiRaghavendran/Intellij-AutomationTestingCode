package gomframeworkOfFreeCRM.gomJenkins

pipeline {
    agent {
        label 'Gomi'
    }

    stages {

        stage("TestdataCleanUp") {
            steps {
                bat 'mvn test -DbrowserName=%Browser% -DjobName=%JOB_NAME% -DbuildNumber=%BUILD_ID% -Dsurefire.suiteXmlFiles="src/test/java/GomtestExecutionOfFreeCRM/CompaniesModuleTestExecutions/GomCompaniesCleanUpTestData.xml"'
            }
        }

       stage("CreateCompaniesTestData") {
            steps {
                bat 'mvn test -DbrowserName=%Browser% -DjobName=%JOB_NAME% -DbuildNumber=%BUILD_ID% -Dsurefire.suiteXmlFiles="src/test/java/GomtestExecutionOfFreeCRM/CompaniesModuleTestExecutions/GomCreateCompaniesTestData.xml"'
            }
        }

       stage("CompaniesOverViewPageTests") {
            steps {
                bat 'mvn test -DbrowserName=%Browser% -DjobName=%JOB_NAME% -DbuildNumber=%BUILD_ID% -Dsurefire.suiteXmlFiles="src/test/java/GomtestExecutionOfFreeCRM/CompaniesModuleTestExecutions/GomCompaniesOverviewPageTests.xml"'
            }
        }

        stage("CompaniesFilterTests") {
            steps {
                bat 'mvn test -DbrowserName=%Browser% -DjobName=%JOB_NAME% -DbuildNumber=%BUILD_ID% -Dsurefire.suiteXmlFiles="src/test/java/GomtestExecutionOfFreeCRM/CompaniesModuleTestExecutions/GomCompaniesFilterTests.xml"'
            }
        }

        stage("CompaniesViewTests") {
            steps {
                bat 'mvn test -DbrowserName=%Browser% -DjobName=%JOB_NAME% -DbuildNumber=%BUILD_ID% -Dsurefire.suiteXmlFiles="src/test/java/GomtestExecutionOfFreeCRM/CompaniesModuleTestExecutions/GomCompaniesViewTests.xml"'
            }
        }




    }
}