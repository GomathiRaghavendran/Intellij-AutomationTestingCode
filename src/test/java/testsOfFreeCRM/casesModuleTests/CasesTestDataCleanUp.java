package testsOfFreeCRM.casesModuleTests;

import frameworkOfFreeCRM.base.Base;
import frameworkOfFreeCRM.resources.globalResource.CommonXpath;
import frameworkOfFreeCRM.resources.globalResource.GLOBAL_GENERIC;
import frameworkOfFreeCRM.resources.staticResource.GLOBAL_STATIC;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;
@Listeners({frameworkOfFreeCRM.utilities.extentReports.ExternalReports.class})

public class CasesTestDataCleanUp extends Base {
    @BeforeMethod(alwaysRun = true)
    public void testSetUp() throws IOException,InterruptedException{
        launchBrowser().enterValidCredentials();
        GLOBAL_GENERIC.navigateToModule(GLOBAL_STATIC.nameOfModule[4]);
    }

    @Test(groups = {"casesModule"})
    public void cleanUpTestData(){
        GLOBAL_STATIC.assignStaticContent(417);
        int countOfPages=GLOBAL_GENERIC.getTheWebElementsCount(CommonXpath.xpathOfPagination);
        for(int j=0;j<countOfPages-2;j++)
        {
            int countOfDeleteIcons = GLOBAL_GENERIC.getTheWebElementsCount(CommonXpath.xpathOfDeleteIcon);
            for (int i = 0; i < countOfDeleteIcons; i++)
            {
                GLOBAL_GENERIC.locateAndGetWebElement(CommonXpath.xpathOfDeleteIcon).click();
                GLOBAL_GENERIC.deleteConfirmationPopUp(true);
            }
        }

    }
    @AfterMethod(alwaysRun = true)
    public void tearDown()
    {
        GLOBAL_STATIC.driver.close();
    }

}
