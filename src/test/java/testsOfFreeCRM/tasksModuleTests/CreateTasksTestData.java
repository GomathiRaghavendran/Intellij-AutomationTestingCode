package testsOfFreeCRM.tasksModuleTests;

import frameworkOfFreeCRM.base.Base;
import frameworkOfFreeCRM.resources.globalResource.HomePageResource;
import frameworkOfFreeCRM.resources.globalResource.GLOBAL_GENERIC;
import frameworkOfFreeCRM.resources.staticResource.GLOBAL_STATIC;
import frameworkOfFreeCRM.resources.tasksModuleResource.TasksGlobalResource;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;
@Listeners({frameworkOfFreeCRM.utilities.extentReports.ExternalReports.class})
public class CreateTasksTestData extends Base {
    HomePageResource hp;

    @BeforeMethod(alwaysRun = true)
    public void setup() throws IOException, InterruptedException {
        hp = launchBrowser().enterValidCredentials();
    }

    @Test(groups={"sanity","tasksModule"})
    public void createtestdata() throws InterruptedException {
        GLOBAL_GENERIC.navigateToModule(GLOBAL_STATIC.nameOfModule[3]);
        TasksGlobalResource tgr = new TasksGlobalResource();
        for (int excelTestDataRowNum = 2; excelTestDataRowNum <= 12; excelTestDataRowNum++) {
            tgr.createTasks(excelTestDataRowNum);

        }
    }

   @AfterMethod(alwaysRun = true)
    public void teardown()
    {
        GLOBAL_STATIC.driver.close();
    }

}
