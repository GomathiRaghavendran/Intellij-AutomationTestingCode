package testsOfFreeCRM.tasksModuleTests;

import frameworkOfFreeCRM.base.Base;
import frameworkOfFreeCRM.resources.globalResource.CommonXpath;
import frameworkOfFreeCRM.resources.globalResource.GLOBAL_GENERIC;
import frameworkOfFreeCRM.resources.staticResource.GLOBAL_STATIC;
import frameworkOfFreeCRM.resources.tasksModuleResource.TasksFilterResource;
import frameworkOfFreeCRM.resources.tasksModuleResource.TasksGlobalResource;
import frameworkOfFreeCRM.resources.tasksModuleResource.TasksOverview;
import frameworkOfFreeCRM.resources.tasksModuleResource.TasksViewResource;
import frameworkOfFreeCRM.utilities.screenshotUtilities.ScreenshotUtility;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;
@Listeners({frameworkOfFreeCRM.utilities.extentReports.ExternalReports.class})
public class TasksViewTests extends Base {

      TasksOverview  tov;
   TasksViewResource tvr;
    @BeforeMethod(alwaysRun = true)
    public void setup() throws IOException, InterruptedException {
        launchBrowser().enterValidCredentials();
        GLOBAL_GENERIC.navigateToModule(GLOBAL_STATIC.nameOfModule[3]);
        tov = new TasksOverview();
        tvr=new TasksViewResource();
    }
    // In this method we are trying to delete a record from view page, so for that we are navigating to specific record
    // which is going to be deleted.
    @Test(groups={"regression","tasksModule"})
    public void deleteRecordFromTasksViewPage(){
        GLOBAL_STATIC.assignStaticContent(212);
        ScreenshotUtility.chalBetaSelfielelele("beforeDeletingRecordFromViewPage");
        String recordNameToBeDeleted ="Writing";
        tov.navigateToTaskDetails(recordNameToBeDeleted);
        GLOBAL_GENERIC.
                locateAndGetWebElement(CommonXpath.xpathOfDeleteIcon).click();
        GLOBAL_GENERIC.
                deleteConfirmationPopUp(true);
        GLOBAL_GENERIC.
                navigateToModule(GLOBAL_STATIC.nameOfModule[3]);
        boolean recordExists = TasksGlobalResource.checkForTitleRecord(recordNameToBeDeleted);
        Assert.assertEquals(false,recordExists);
        ScreenshotUtility.chalBetaSelfielelele("afterDeletingRecordFromViewPage");

    }
    //This method is to check Add Notes icon functionality in tasks view Page
   @Test(groups={"regression","tasksModule"})
    public void validateTheAddNotesIconFunctionality(){
        GLOBAL_STATIC.assignStaticContent(213);
        tov.navigateToTaskDetails("Delivery");
        tvr.addNotesOnTasksRecord("Hi, This is task ringgit squad");
        ScreenshotUtility.chalBetaSelfielelele("afterAddingNotesInTaskViewPage");

    }
    //Validating default tabs in tasks view page for specific record
    @Test(groups={"sanity","tasksModule"})
    public void validateTheAvailableTabsTaskViewPage(){
        GLOBAL_STATIC.assignStaticContent(214);
        tov.navigateToTaskDetails("Reporting");
        tvr.validateTheTabsOnTaskViewPage();
        ScreenshotUtility.chalBetaSelfielelele("TabScreenshots");
    }

    @AfterMethod(alwaysRun = true)
    public void testTearDown(){

        GLOBAL_STATIC.driver.close();
    }

}
