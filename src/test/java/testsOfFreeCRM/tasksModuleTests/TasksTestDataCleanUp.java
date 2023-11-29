package testsOfFreeCRM.tasksModuleTests;

import frameworkOfFreeCRM.base.Base;
import frameworkOfFreeCRM.resources.globalResource.CommonXpath;
import frameworkOfFreeCRM.resources.globalResource.GLOBAL_GENERIC;
import frameworkOfFreeCRM.resources.staticResource.GLOBAL_STATIC;
import frameworkOfFreeCRM.resources.tasksModuleResource.TasksOverview;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;
@Listeners({frameworkOfFreeCRM.utilities.extentReports.ExternalReports.class})
public class TasksTestDataCleanUp extends Base {

    @BeforeMethod(alwaysRun = true)
    public void testSetUp() throws IOException, InterruptedException {
        launchBrowser().enterValidCredentials();
        GLOBAL_GENERIC.navigateToModule(GLOBAL_STATIC.nameOfModule[3]);
    }


    //In this method we are deleting all the records by clicking on the delete icon of the record
    @Test(groups={"sanity","tasksModule"})
    public void cleanUpTestData() throws InterruptedException {
        Thread.sleep(1000);
        int countOFPages = GLOBAL_GENERIC.getTheWebElementsCount(CommonXpath.xpathOfPagination);
        for (int k = 0; k < countOFPages - 2; k++) {

            int countOfDeleteIcons = GLOBAL_GENERIC.getTheWebElementsCount(CommonXpath.xpathOfDeleteIcon);

            for (int j = 0; j < countOfDeleteIcons; j++) {
                GLOBAL_GENERIC.locateAndGetWebElement(CommonXpath.xpathOfDeleteIcon).click();
                GLOBAL_GENERIC.deleteConfirmationPopUp(true);
            }
        }
        Thread.sleep(1000);
    }
    @AfterMethod(alwaysRun = true)
    public void tearDown(){
      //  GLOBAL_STATIC.driver.close();
    }


}
