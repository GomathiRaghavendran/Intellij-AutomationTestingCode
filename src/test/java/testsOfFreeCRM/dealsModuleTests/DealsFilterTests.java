package testsOfFreeCRM.dealsModuleTests;

import frameworkOfFreeCRM.base.Base;
import frameworkOfFreeCRM.resources.dealsModuleResource.DealsFilterResource;
import frameworkOfFreeCRM.resources.dealsModuleResource.DealsGlobalResource;
import frameworkOfFreeCRM.resources.contactsModuleResource.ContactFilterResource;
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
@Listeners(frameworkOfFreeCRM.utilities.extentReports.ExternalReports.class)
public class DealsFilterTests extends Base {
    DealsFilterResource dfr;
    @BeforeMethod(alwaysRun = true)
    public void testSetUp() throws IOException, InterruptedException {
        //This test case is to launch the browser and login to freeCRM application page with valid credentials
        launchBrowser().enterValidCredentials();
        // Below method is to navigate to the dealsModulePipeline module in freeCRM application.
        GLOBAL_GENERIC.navigateToModule(GLOBAL_STATIC.nameOfModule[2]);
        dfr = new DealsFilterResource();
        GLOBAL_GENERIC.locateAndGetWebElement(CommonXpath.xpathOfShowFilterButton).click();
    }
    @Test(groups = {"sanity","dealsModule"})
    // Below test case is to validate add filter row button functionality in dealsModulePipeline overview page
    public void validateAddFilterRowButtonFunctionality(){
        GLOBAL_STATIC.assignStaticContent(500);
        dfr.clickOnAddFilterRow(7);
        int actualCountOfSearchRows =  GLOBAL_GENERIC.
                getTheWebElementsCount(ContactFilterResource.xpathOfFilterRow);
        int actualCountOfSearchDropdowns = GLOBAL_GENERIC.
                getTheWebElementsCount(ContactFilterResource.xpathOfSearchDropDown);
        int  actualCountOfOperatorDropDowns = GLOBAL_GENERIC.
                getTheWebElementsCount(ContactFilterResource.xpathOfOperatorDropDown);
        Assert.assertEquals(actualCountOfSearchRows,8);
        Assert.assertEquals(actualCountOfSearchDropdowns,8);
        Assert.assertEquals(actualCountOfOperatorDropDowns,8);
    }
    @Test(groups = {"sanity","dealsModule"})
    // Below test case is to validate search filter row button functionality in dealsModulePipeline overview page
    public void validateSingleSearchFilterRow() throws InterruptedException {
        GLOBAL_STATIC.assignStaticContent(501);
        dfr.addSearchCriteria(dfr.searchDropDownValues[0],dfr.operatorDropDownValues[1],"C");
        dfr.searchButton.click();
        Thread.sleep(1000);
        int getCountOfRecords = GLOBAL_GENERIC.getTheWebElementsCount(CommonXpath.xpathOfDeleteIcon);
        Assert.assertEquals(3,getCountOfRecords);
        Assert.assertEquals(true, DealsGlobalResource.checkDealsRecord("ColrytDeal"));
        Assert.assertEquals(true,DealsGlobalResource.checkDealsRecord("ChaithuDeal")); ;
    }
    @Test(groups = {"dealsModule"})
    //Below Test case is to validate multiple search filter row criteria in dealsModulePipeline overview page. We are calling
    //multiple search criteria by passing parameters to it with index for selecting the dropdown.
    public void validateSearchFilterWithMultipleFilterRowCriteria() throws InterruptedException {
        GLOBAL_STATIC.assignStaticContent(502);
        dfr.addSearchCriteria(dfr.searchDropDownValues[0],
                dfr.operatorDropDownValues[1],
                "C");
        dfr.clickOnAddFilterRow(1);
        dfr.addMultipleSearchCriteria(2,
                dfr.searchDropDownValues[0],
                dfr.operatorDropDownValues[2],
                "l");
        dfr.searchButton.click();
        int getCountOfRecords = GLOBAL_GENERIC.getTheWebElementsCount(CommonXpath.xpathOfDeleteIcon);
        Assert.assertEquals(3,getCountOfRecords);
        Assert.assertEquals(true, DealsGlobalResource.checkDealsRecord("ColrytDeal"));
        Assert.assertEquals(true,DealsGlobalResource.checkDealsRecord("ChaithuDeal"));
    }
    //Below testcase is to clear the search filters and validate the number of records before
    //and after clearing the filter
    @Test(groups = {"regression","dealsModule"})
    public void validateClearFilterButtonFunctionality() throws InterruptedException {
        GLOBAL_STATIC.assignStaticContent(503);
       //GLOBAL_GENERIC.takeCareOfLoadingTableRow();
        Thread.sleep(2000);
        int recordCountBeforeSearchCriteria = GLOBAL_GENERIC.getTheWebElementsCount("//tbody/tr");
        ScreenshotUtility.chalBetaSelfielelele("recordCountBeforeSearchCriteria.png");
        dfr.addSearchCriteria(dfr.searchDropDownValues[0]
                ,dfr.operatorDropDownValues[1],
                "C");
        dfr.searchButton.click();
      // GLOBAL_GENERIC.takeCareOfLoadingTableRow();
        Thread.sleep(2000);
        int recordCountBasedOnSearchCriteria = GLOBAL_GENERIC.getTheWebElementsCount("//tbody/tr");

        Assert.assertEquals(3,recordCountBasedOnSearchCriteria);
        ScreenshotUtility.chalBetaSelfielelele("recordCountWithSearchCriteria.png");
        dfr.clearButton.click();
        Thread.sleep(2000);
       //GLOBAL_GENERIC.takeCareOfLoadingTableRow();
        int recordCountAfterSearchCriteria = GLOBAL_GENERIC.getTheWebElementsCount("//tbody/tr");
        Assert.assertEquals(recordCountBeforeSearchCriteria,recordCountAfterSearchCriteria);
        ScreenshotUtility.chalBetaSelfielelele("recordCountAfterSearchCriteria.png");
    }
    //Below method is to validate the remove filter icon based on the clicks
    @Test(groups = {"regression","dealsModule"})
    public void validateRemoveFilterRowButtonFunctionality(){
        GLOBAL_STATIC.assignStaticContent(504);
        dfr.clickOnAddFilterRow(5);
        int initialCountOfFilterRows =GLOBAL_GENERIC.getTheWebElementsCount(ContactFilterResource.xpathOfFilterRow);
        Assert.assertEquals(6,initialCountOfFilterRows);
        dfr.clicksOnRemoveFilterRowButton(3);
        int countAfterRemoveSomeFilterRows =GLOBAL_GENERIC.getTheWebElementsCount(ContactFilterResource.xpathOfFilterRow);
        Assert.assertEquals(3,countAfterRemoveSomeFilterRows);
    }

    @AfterMethod(alwaysRun = true)
    public void testTearDown(){
        GLOBAL_STATIC.driver.close();
    }
}
