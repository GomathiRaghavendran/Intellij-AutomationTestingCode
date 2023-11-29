package testsOfFreeCRM.casesModuleTests;

import frameworkOfFreeCRM.base.Base;
import frameworkOfFreeCRM.resources.casesModuleResource.CasesGlobalResource;
import frameworkOfFreeCRM.resources.globalResource.GLOBAL_GENERIC;
import frameworkOfFreeCRM.resources.staticResource.GLOBAL_STATIC;
import frameworkOfFreeCRM.utilities.screenshotUtilities.ScreenshotUtility;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;
@Listeners({frameworkOfFreeCRM.utilities.extentReports.ExternalReports.class})

public class CreateCasesTestData extends Base {

    @BeforeMethod(alwaysRun = true)
    public void testSetup() throws IOException, InterruptedException
    {
        launchBrowser().enterValidCredentials();
    }

    @Test(groups = {"casesModule"})
    public void createTestData() throws InterruptedException {
        GLOBAL_STATIC.assignStaticContent(416);
        GLOBAL_GENERIC.navigateToModule(GLOBAL_STATIC.nameOfModule[4]);
        CasesGlobalResource cgr=new CasesGlobalResource();
        for(int i=2;i<9;i++)
        {
            cgr.createCases(i);

        }
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown()
    {
     GLOBAL_STATIC.driver.close();
    }

}
