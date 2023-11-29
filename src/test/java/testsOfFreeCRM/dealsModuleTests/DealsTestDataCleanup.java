package testsOfFreeCRM.dealsModuleTests;

import frameworkOfFreeCRM.base.Base;
import frameworkOfFreeCRM.resources.globalResource.CommonXpath;
import frameworkOfFreeCRM.resources.globalResource.GLOBAL_GENERIC;
import frameworkOfFreeCRM.resources.staticResource.GLOBAL_STATIC;
import frameworkOfFreeCRM.utilities.screenshotUtilities.ScreenshotUtility;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;
@Listeners({frameworkOfFreeCRM.utilities.extentReports.ExternalReports.class})

public class DealsTestDataCleanup extends Base {

    @BeforeMethod(alwaysRun = true)
    public void testSetUp() throws IOException, InterruptedException {
        launchBrowser().enterValidCredentials();
        GLOBAL_GENERIC.navigateToModule(GLOBAL_STATIC.nameOfModule[2]);
    }

    @Test(groups = {"sanity","regression","dealsModule"})
    //Below method will delete all the dealsModulePipeline test data from dealsModulePipeline overview page.
    public void cleanUpTestData() throws InterruptedException {
        String totalCountOfRecords=GLOBAL_GENERIC.locateAndGetWebElement(CommonXpath.xpathOfTotalRecordsCreated).getText();
        //  System.out.println(totalCountOfRecords);
        int count=Integer.parseInt(totalCountOfRecords);
        //  System.out.println(count);
        for(int i=1;i<=count;i++)
        {
            GLOBAL_GENERIC.locateAndGetWebElement(CommonXpath.xpathOfDeleteIconInDealsOverviewPage).click();
            GLOBAL_GENERIC.deleteConfirmationPopUp(true);
            Thread.sleep(1000);
        }
        boolean status = GLOBAL_STATIC.driver.findElement(By.xpath("//p[text()='No records found']")).isDisplayed();
        Assert.assertEquals(status, true);

            }
    @AfterMethod(alwaysRun = true)
    public void testTearDown(){

        GLOBAL_STATIC.driver.close();
    }



}
