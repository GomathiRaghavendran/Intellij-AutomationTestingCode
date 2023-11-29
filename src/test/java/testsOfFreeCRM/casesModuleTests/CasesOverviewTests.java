package testsOfFreeCRM.casesModuleTests;

import frameworkOfFreeCRM.base.Base;
import frameworkOfFreeCRM.resources.casesModuleResource.CasesFilterResource;
import frameworkOfFreeCRM.resources.casesModuleResource.CasesGlobalResource;
import frameworkOfFreeCRM.resources.casesModuleResource.CasesOverview;
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
 * In Cases Overview we are deleting the Home_Loan record.
 * **/

    public class CasesOverviewTests extends Base {
    CasesOverview co;
    @BeforeMethod(alwaysRun = true)
    public void testSetup() throws IOException, InterruptedException
    {
        launchBrowser().enterValidCredentials();
        GLOBAL_GENERIC.navigateToModule(GLOBAL_STATIC.nameOfModule[4]);
        co=new CasesOverview();
    }


    @Test(groups = {"sanity","casesModule"})
    public void validateDefaultColumnsOfCases()
    {
        GLOBAL_STATIC.assignStaticContent(401);
        co.validateCasesDefaultColumn();
     }
    @Test(groups = {"regression","casesModule"})
    public void validateTheViewCaseIconBehaviour()
    {
        GLOBAL_STATIC.assignStaticContent(402);
        String caseName = GLOBAL_STATIC.testData.getCellData("casesTestData", 6, 1);
        co.navigateToCaseDetails(caseName);
    }

    @Test(groups = {"regression","casesModule"})
    public void validateTheEditIconBehaviourInOverviewPage()
    {
        GLOBAL_STATIC.assignStaticContent(403);
        String nameOfEditCases = GLOBAL_STATIC.testData.getCellData("casesTestData", 5, 1);
        co.validateTheCasesEditIcon(nameOfEditCases);
    }

    @Test(groups = {"regression","casesModule"})
    public void validateTheDeleteIcon()
    {
        GLOBAL_STATIC.assignStaticContent(404);
        String caseName=GLOBAL_STATIC.testData.getCellData("casesTestData",8,1);
        co.deleteTheCasesFromOverviewPage(caseName);
        GLOBAL_GENERIC.navigateToModule(GLOBAL_STATIC.nameOfModule[4]);
        boolean statusOfCasesRecord= CasesGlobalResource.checkForCasesRecord(caseName);
        Assert.assertEquals(statusOfCasesRecord,false);
    }
    @Test(groups = {"regression","casesModule"})
    public void showFilterButtonFunctionalityInCasesOverviewPage()
    {
        GLOBAL_STATIC.assignStaticContent(405);
        GLOBAL_GENERIC.locateAndGetWebElement(CommonXpath.xpathOfShowFilterButton).click();
        ScreenshotUtility.chalBetaSelfielelele("showFilterButtonFunctionalityInCasesOverviewPage");
        CasesFilterResource cfr=new CasesFilterResource();
        cfr.validateShowFilterScreenWebElements();
    }
    @Test(groups = {"regression","casesModule"})
    public void hideFilterButtonFunctionalityInCasesOverviewPage()
    {
        GLOBAL_STATIC.assignStaticContent(406);
        GLOBAL_GENERIC.locateAndGetWebElement(CommonXpath.xpathOfShowFilterButton).click();
        CasesFilterResource cfr=new CasesFilterResource();
        cfr.validateShowFilterScreenWebElements();
        //Thread.sleep(1000);
        cfr.validateHideFilterScreenFunctionality();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown()
    {
        GLOBAL_STATIC.driver.close();
    }

}

