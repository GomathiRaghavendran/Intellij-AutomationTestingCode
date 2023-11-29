package testsOfFreeCRM.callsModuleTests;

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
    public class CallsTestDataCleanUp extends Base {
    @BeforeMethod(alwaysRun = true)
    public void testSetUp() throws IOException, InterruptedException {
        launchBrowser().enterValidCredentials();
        GLOBAL_GENERIC.navigateToModule(GLOBAL_STATIC.nameOfModule[5]);
    }
    @Test(groups = {"sanity","callsModule"})
    public void cleanUpCallTestData() {
        int PageCountOnOverview= GLOBAL_GENERIC.getTheWebElementsCount(CommonXpath.xpathOfPagination);
        for (int j=0;j<PageCountOnOverview;j++) {
            int countOfCallsDeleteIcons = GLOBAL_GENERIC.getTheWebElementsCount(CommonXpath.xpathOfDeleteIcon);
            for (int i = 0; i < countOfCallsDeleteIcons; i++) {
                GLOBAL_GENERIC.locateAndGetWebElement(CommonXpath.xpathOfDeleteIcon).click();
                GLOBAL_GENERIC.deleteConfirmationPopUp(true);
            }
        }
    }
        @AfterMethod(alwaysRun = true)
        public void tearDown(){
            GLOBAL_STATIC.driver.close();
        }
}
