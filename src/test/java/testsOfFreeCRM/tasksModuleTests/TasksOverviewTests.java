package testsOfFreeCRM.tasksModuleTests;

import frameworkOfFreeCRM.base.Base;
import frameworkOfFreeCRM.resources.globalResource.CommonXpath;
import frameworkOfFreeCRM.resources.globalResource.GLOBAL_GENERIC;
import frameworkOfFreeCRM.resources.staticResource.GLOBAL_STATIC;
import frameworkOfFreeCRM.resources.tasksModuleResource.TasksFilterResource;
import frameworkOfFreeCRM.resources.tasksModuleResource.TasksGlobalResource;
import frameworkOfFreeCRM.resources.tasksModuleResource.TasksOverview;
import frameworkOfFreeCRM.utilities.screenshotUtilities.ScreenshotUtility;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.util.TimeUtils;

import java.io.IOException;
@Listeners({frameworkOfFreeCRM.utilities.extentReports.ExternalReports.class})

public class TasksOverviewTests extends Base {
    TasksOverview to;

    @BeforeMethod(alwaysRun = true)
    public void setup() throws IOException, InterruptedException {
        launchBrowser().enterValidCredentials();
        GLOBAL_GENERIC.navigateToModule(GLOBAL_STATIC.nameOfModule[3]);
        to = new TasksOverview();
    }

    //This method is to validate Tasks grid default column
    @Test(groups={"sanity","tasksModule"})
    public void validateDefaultColumnOfTasks()  {
        GLOBAL_STATIC.assignStaticContent(201);
        to.validateTasksGridDefaultColumn();
    }


//This method is to click the view icon in the tasks overview page and verify the Task details page is displayed

   @Test(groups={"regression","tasksModule"})
   public void validateTheTasksViewIconBehavior() {
           GLOBAL_STATIC.assignStaticContent(202);
           String title = GLOBAL_STATIC.testData.getCellData("tasksTestData", 9, 1);
           to.navigateToTaskDetails(title);

       }


//This method is to click the Edit icon in the tasks overview page and verify the tasks details page is displayed

   @Test(groups={"regression","tasksModule"})
   public void validateTheEditTaskIconBehaviorInOverviewPage()throws InterruptedException{
       GLOBAL_STATIC.assignStaticContent(203);
        String title=GLOBAL_STATIC.testData.getCellData("tasksTestData",9,1);
        to.navigateToEditIconTaskScreen(title);


   }
   @Test(groups={"regression","tasksModule"})
   public void deleteTheTaskFromOverviewPage() throws InterruptedException {
       /*we are checking title name from tasks global resource and checking the title record name is there. if we give boolean
        and check for value assert if its false it should not display the record of the title*/
       GLOBAL_STATIC.assignStaticContent(204);
       String title=GLOBAL_STATIC.testData.getCellData("tasksTestData",3,1);
        to.deleteTheTaskFromOverviewPage(title);
        GLOBAL_GENERIC.navigateToModule(GLOBAL_STATIC.nameOfModule[3]);
        boolean statusOfTaskRecord = TasksGlobalResource.checkForTitleRecord(title);
       Assert.assertEquals(statusOfTaskRecord,false);
   }

   //here we are clicking on Show Filters button and validating the functionality of that button.
    @Test(groups={"regression","tasksModule"})
    public void  functionalityOfShowFilterButton() throws InterruptedException {
        GLOBAL_STATIC.assignStaticContent(205);
        GLOBAL_GENERIC.locateAndGetWebElement(CommonXpath.xpathOfShowFilterButton).click();
        TasksFilterResource tfr=new TasksFilterResource();
        tfr .validateShowFilterScreenIcons();
        Thread.sleep(3000);
    }


    // once we click on show filter button  we get the hide filter button and then validate its functionality .
    @Test(groups={"regression","tasksModule"})
    public void functionalityOfHideFilterButton() {
        GLOBAL_STATIC.assignStaticContent(206);
        GLOBAL_GENERIC.locateAndGetWebElement(CommonXpath.xpathOfShowFilterButton).click();
        TasksFilterResource tfr=new TasksFilterResource();
        tfr.validateShowFilterScreenIcons();
        tfr.validateHideFilterButtonFunctionality();
    }
        @AfterMethod(alwaysRun = true)
    public void tearDown(){
        GLOBAL_STATIC.driver.close();
    }
}
