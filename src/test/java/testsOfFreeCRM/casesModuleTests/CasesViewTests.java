package testsOfFreeCRM.casesModuleTests;

import frameworkOfFreeCRM.base.Base;
import frameworkOfFreeCRM.resources.casesModuleResource.CasesGlobalResource;
import frameworkOfFreeCRM.resources.casesModuleResource.CasesOverview;
import frameworkOfFreeCRM.resources.casesModuleResource.CasesViewResource;
import frameworkOfFreeCRM.resources.globalResource.CommonXpath;
import frameworkOfFreeCRM.resources.globalResource.GLOBAL_GENERIC;
import frameworkOfFreeCRM.resources.staticResource.GLOBAL_STATIC;
import frameworkOfFreeCRM.utilities.screenshotUtilities.ScreenshotUtility;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;


@Listeners({frameworkOfFreeCRM.utilities.extentReports.ExternalReports.class})

/**
 * In cases view tests we are deleting the Banking record.
 * **/

public class CasesViewTests extends Base {

    CasesOverview cop;
    CasesViewResource cvr;

    @BeforeMethod(alwaysRun = true)
    public void testSetup() throws IOException, InterruptedException
    {
        launchBrowser().enterValidCredentials();
        GLOBAL_GENERIC.navigateToModule(GLOBAL_STATIC.nameOfModule[4]);
        cop=new CasesOverview();
        cvr=new CasesViewResource();
    }
    /**
     * Passing the name to navigate to case details.
     * Delete the record From cases view page.
     * After Deletion check the status of the record.
     *  **/
    @Test(groups = {"regression","casesModule"})
    public void deleteRecordFromCasesViewPage()
    {
        GLOBAL_STATIC.assignStaticContent(412);
        cvr.deleteRecordFromCasesViewPage("Banking");
    }

/**
    Connecting with the task module data
    Create a task record by clicking the task button from the cases view Screen.
    We pass the titleName and navigate to the particular case view page. **/

    @Test(groups = {"regression","casesModule"})
    public void validateCreationOfTaskFromCasesViewScreen() throws InterruptedException {
        GLOBAL_STATIC.assignStaticContent(413);
        cop.navigateToCaseDetails("MobileBanking");
        cvr.createTaskFromCasesViewScreen();
    }
    @Test(groups = {"regression","casesModule"})
    public void validateTheAddNotesIconFunctionality()
    {
        GLOBAL_STATIC.assignStaticContent(414);
        cop.navigateToCaseDetails("MobileBanking");
        cvr.addNotesOnCaseRecord("Making easy transactions using mobile Banking");
        ScreenshotUtility.chalBetaSelfielelele("AfterAddedNotes");
    }
    @Test(groups = {"sanity","casesModule"})
    public void validateTheAvailableTabsInCasesViewPage(){
        GLOBAL_STATIC.assignStaticContent(415);
        cop.navigateToCaseDetails("CreditCard");
        cvr.validateTabsOnCasesViewPage();
    }
    @AfterMethod(alwaysRun = true)
    public void testTearDown()
    {
        GLOBAL_STATIC.driver.close();
    }
}
