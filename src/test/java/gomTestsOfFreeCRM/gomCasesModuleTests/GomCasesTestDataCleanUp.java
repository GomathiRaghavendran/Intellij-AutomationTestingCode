package gomTestsOfFreeCRM.gomCasesModuleTests;

import frameworkOfFreeCRM.base.Base;
import frameworkOfFreeCRM.resources.globalResource.CommonXpath;
import frameworkOfFreeCRM.resources.globalResource.GLOBAL_GENERIC;
import frameworkOfFreeCRM.resources.staticResource.GLOBAL_STATIC;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class GomCasesTestDataCleanUp extends Base {
    @BeforeMethod
    public void testSetUp() throws IOException,InterruptedException{
        launchBrowser().enterValidCredentials();
        GLOBAL_GENERIC.navigateToModule(GLOBAL_STATIC.nameOfModule[4]);
    }

    @Test
    public void cleanUpTestData(){
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
    @AfterMethod
    public void tearDown()
    {
        GLOBAL_STATIC.driver.close();
    }

}
