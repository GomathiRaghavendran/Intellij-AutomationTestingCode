package testsOfFreeCRM.dealsModuleTests;

import frameworkOfFreeCRM.base.Base;
import frameworkOfFreeCRM.resources.dealsModuleResource.DealsFilterResource;
import frameworkOfFreeCRM.resources.dealsModuleResource.DealsGlobalResource;
import frameworkOfFreeCRM.resources.dealsModuleResource.DealsOverview;
import frameworkOfFreeCRM.resources.globalResource.CommonXpath;
import frameworkOfFreeCRM.resources.globalResource.GLOBAL_GENERIC;
import frameworkOfFreeCRM.resources.staticResource.GLOBAL_STATIC;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;
@Listeners({frameworkOfFreeCRM.utilities.extentReports.ExternalReports.class})

public class DealsOverViewTests extends Base {
     DealsOverview dov;

    /* This testcase is to Launch the Browser and login to FreeCRM page with valid credentials
     > Navigate to dealsModulePipeline module page - @before method ln.no:34
     > Validate Deals Default Columns in the Deals Overview screen - @Test ln.no:38
     > Validates Deals View Icon in the Deals Overview screen-  @Test ln.no:42
     > Validate dealsModulePipeline edit icon in the Deals Overview screen- @Test ln.no:47
     > Validate dealsModulePipeline delete icon in the Deals Overview screen-  @Test ln.no:53
     > Validate the show filter functionality in the Deals Overview screen - @Test ln.no:63
     > Validate the hide filter functionality in the  Deals Overview screen - @Test ln.no:70*/


    @BeforeMethod(alwaysRun = true)
    public void testSetUp() throws IOException, InterruptedException {
        launchBrowser().enterValidCredentials();
        GLOBAL_GENERIC.navigateToModule(GLOBAL_STATIC.nameOfModule[2]);
        dov = new DealsOverview();
    }
    @Test(groups = {"sanity","dealsModule"})
    public void validateDealsDefaultColumns(){
        GLOBAL_STATIC.assignStaticContent(505);
        dov.validateDealsGridDefaultColumn();
    }
    @Test(groups = {"sanity","dealsModule"})
    public void validateDealsViewIcon() throws InterruptedException {
        GLOBAL_STATIC.assignStaticContent(506);
        String titleName = GLOBAL_STATIC.testData.getCellData("dealsTestData",7 , 1);
        dov.navigateToDealsDetails(titleName);
    }
    @Test(groups = {"regression","dealsModule"})
    public void validateTheBehaviourOfEditIconInDealsOverviewPage(){
        GLOBAL_STATIC.assignStaticContent(507);
        String titleName = GLOBAL_STATIC.testData.getCellData("dealsTestData",8,1);

        dov.navigateToDealsEditScreen(titleName);
    }
    @Test(groups = {"regression","dealsModule"})
    public void deleteTheDealFromOverviewPage()throws InterruptedException{
        GLOBAL_STATIC.assignStaticContent(508);
        String titleName = GLOBAL_STATIC.testData.getCellData("dealsTestData",14,1);
        dov.deleteTheDealFromOverviewPage(titleName);
        GLOBAL_GENERIC.navigateToModule(GLOBAL_STATIC.nameOfModule[2]);
        boolean statusOfDealRecord = DealsGlobalResource.checkDealsRecord(titleName);
        Assert.assertEquals(statusOfDealRecord,false);
    }
    @Test(groups = {"regression","dealsModule"})
    public void validateTheShowFilterFunctionality() throws InterruptedException {
        GLOBAL_STATIC.assignStaticContent(509);
        GLOBAL_GENERIC.locateAndGetWebElement(CommonXpath.xpathOfShowFilterButton).click();
        DealsFilterResource dfr = new DealsFilterResource();
        dfr.validateShowFilterScreenbuttons();
    }
    @Test(groups = {"sanity","dealsModule"})
    public void validateTheHideFilterFunctionality(){
        GLOBAL_STATIC.assignStaticContent(510);
        GLOBAL_GENERIC.locateAndGetWebElement(CommonXpath.xpathOfShowFilterButton).click();
        DealsFilterResource dfr = new DealsFilterResource();
        dfr.validateShowFilterScreenbuttons();
        dfr.validateHideFilterScreenbutton();

    }
    @AfterMethod(alwaysRun = true)
    public void testTearDown()
    {
        GLOBAL_STATIC.driver.close();
    }
}
