package gomTestsOfFreeCRM.gomCasesModuleTests;

import frameworkOfFreeCRM.base.Base;
import frameworkOfFreeCRM.resources.casesModuleResource.CasesGlobalResource;
import frameworkOfFreeCRM.resources.casesModuleResource.CasesOverview;
import frameworkOfFreeCRM.resources.globalResource.CommonXpath;
import frameworkOfFreeCRM.resources.globalResource.GLOBAL_GENERIC;
import frameworkOfFreeCRM.resources.staticResource.GLOBAL_STATIC;
import frameworkOfFreeCRM.utilities.screenshotUtilities.ScreenshotUtility;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class GomCasesViewTests extends Base {

    CasesOverview cop;
    @BeforeMethod
    public void testSetup() throws IOException, InterruptedException
    {
        launchBrowser().enterValidCredentials();
        GLOBAL_GENERIC.navigateToModule(GLOBAL_STATIC.nameOfModule[4]);
        cop=new CasesOverview();

    }


    /**
     * Passing the name to navigate to case details.
     * Delete the record From cases view page.
     * After Deletion check the status of the record.
     *  **/
    @Test
    public void deleteRecordFromCasesViewPage() throws InterruptedException {
        GLOBAL_STATIC.assignStaticContent(501);
        String recordToBeDeleted="Kavitha";
        cop.navigateToCaseDetails(recordToBeDeleted);
        GLOBAL_GENERIC.locateAndGetWebElement(CommonXpath.xpathOfDeleteIcon).click();
        GLOBAL_GENERIC.deleteConfirmationPopUp(true);
        GLOBAL_GENERIC.navigateToModule(GLOBAL_STATIC.nameOfModule[4]);
        ScreenshotUtility.chalBetaSelfielelele("checkTheRecordAfterDelete.png");
        boolean flag= CasesGlobalResource.checkForCasesRecord(recordToBeDeleted);
        Assert.assertEquals(false,flag);
    }
    @AfterMethod
    public void testTearDown()
    {
        GLOBAL_STATIC.driver.close();
    }


}
