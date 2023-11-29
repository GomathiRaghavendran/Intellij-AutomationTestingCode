package gomTestsOfFreeCRM.gomCasesModuleTests;


import frameworkOfFreeCRM.base.Base;
import frameworkOfFreeCRM.resources.casesModuleResource.CasesFilterResource;
import frameworkOfFreeCRM.resources.casesModuleResource.CasesGlobalResource;
import frameworkOfFreeCRM.resources.globalResource.CommonXpath;
import frameworkOfFreeCRM.resources.globalResource.GLOBAL_GENERIC;
import frameworkOfFreeCRM.resources.staticResource.GLOBAL_STATIC;
import frameworkOfFreeCRM.utilities.screenshotUtilities.ScreenshotUtility;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class GomCasesFilterTests extends Base {
    CasesFilterResource cf;

    @BeforeMethod
    public void testSetup() throws IOException, InterruptedException {
        launchBrowser().enterValidCredentials();
        GLOBAL_GENERIC.navigateToModule(GLOBAL_STATIC.nameOfModule[4]);
        cf = new CasesFilterResource();
        GLOBAL_GENERIC.locateAndGetWebElement(CommonXpath.xpathOfShowFilterButton).click();

    }
    /** Add Filter functionality test
     * --> This test will click on addFilterRow button to add additional filter values */
    @Test
    public void addFilterRowButtonFunctionality(){
        GLOBAL_STATIC.assignStaticContent(401);
        cf.clickOnCasesAddFilterRowButton(5);
        ScreenshotUtility.chalBetaSelfielelele("addFilter.png");
        int actualCountOfSearchRow=GLOBAL_GENERIC.getTheWebElementsCount(CasesFilterResource.xpathOfFilterRow);
        int actualCountOfSearchDropDown=GLOBAL_GENERIC.getTheWebElementsCount(CasesFilterResource.xpathOfSearchDropdown);
        int actualCountOfOperatorDropDown=GLOBAL_GENERIC.getTheWebElementsCount(CasesFilterResource.xpathOfOperatorDropDown);
        Assert.assertEquals(actualCountOfSearchRow,6);
        Assert.assertEquals(actualCountOfSearchDropDown,6);
        Assert.assertEquals(actualCountOfOperatorDropDown,6);

    }
    /*
    Checking the single row search filter functionality by sending value to the searchDropdown ,operatorDropdown
     and textValue to the filter dropDown and validating it by assertion
     */
    @Test
    public void validateSearchFilterWithSingleFilterRow() throws InterruptedException {
        GLOBAL_STATIC.assignStaticContent(402);
        cf.addCasesSearchCriteria(cf.searchDropDownValues[0],cf.operatorDropDownValues[0],"d");
        cf.searchButtonXpath.click();
        ScreenshotUtility.chalBetaSelfielelele("singleRowSearchFilterRecords.png");
        int getCountOfRecords = GLOBAL_GENERIC.getTheWebElementsCount(CommonXpath.xpathOfDeleteIcon);
        Assert.assertEquals(1,getCountOfRecords);
       // Assert.assertEquals(true, CasesGlobalResource.checkForCasesRecord("Banking"));
         Assert.assertEquals(true, CasesGlobalResource.checkForCasesRecord("FinancialPlanning"));
       // Assert.assertEquals(true, CasesGlobalResource.checkForCasesRecord("MobileBanking"));
    }

    /*
   Checking the single and Multiple row search filter functionality by sending value to the searchDropdown ,operatorDropdown
    and textValue to the filter dropDown and validating it by assertion
    */
    @Test
    public void validateSearchFilterWithMultipleFilterRowCriteria() throws InterruptedException {
        GLOBAL_STATIC.assignStaticContent(403);
        cf.addCasesSearchCriteria(cf.searchDropDownValues[0],
                cf.operatorDropDownValues[0],
                "C");
       // Thread.sleep(2000);
        cf.clickOnCasesAddFilterRowButton(1);
        cf.addMultipleSearchCriteria(2,
                cf.searchDropDownValues[1],
                cf.operatorDropDownValues[1],
                "m");
        cf.searchButtonXpath.click();
        ScreenshotUtility.chalBetaSelfielelele("singleAndMultipleRowSearchFilterRecords.png");
        int getCountOfRecords = GLOBAL_GENERIC.getTheWebElementsCount(CommonXpath.xpathOfDeleteIcon);
        Assert.assertEquals(1,getCountOfRecords);
        Assert.assertEquals(true,CasesGlobalResource.checkForCasesRecord("CreditCard"));
      //  Assert.assertEquals(false, CasesGlobalResource.checkForCasesRecord("Banking"));

    }
    /*
    Checking clear filter button functionality ,by counting the records before and after clicking the clear
    button and validating it by applying the assertion.
     */

    @Test
    public void validateClearFilterButtonFunctionality() throws InterruptedException {
        GLOBAL_STATIC.assignStaticContent(404);
        GLOBAL_GENERIC.takeCareOfLoadingTableRow();
        int recordCountBeforeSearchCriteria=GLOBAL_GENERIC.getTheWebElementsCount("//tbody/tr");
        ScreenshotUtility.chalBetaSelfielelele("recordCountBeforeSearchCriteria.png");
        cf.addCasesSearchCriteria(cf.searchDropDownValues[0],
                cf.operatorDropDownValues[0],
                "g");
        cf.searchButtonXpath.click();
       GLOBAL_GENERIC.takeCareOfLoadingTableRow();
        int recordCountBasedOnSearchCriteria=GLOBAL_GENERIC.getTheWebElementsCount("//tbody/tr");
        Assert.assertEquals(2,recordCountBasedOnSearchCriteria);
        ScreenshotUtility.chalBetaSelfielelele("recordCountBasedOnSearchCriteria.png");
        cf.clearButton.click();
       GLOBAL_GENERIC.takeCareOfLoadingTableRow();
        int recordCountAfterSearchCriteria=GLOBAL_GENERIC.getTheWebElementsCount("//tbody/tr");
        Thread.sleep(2000);
        Assert.assertEquals(recordCountBeforeSearchCriteria,recordCountAfterSearchCriteria);
        ScreenshotUtility.chalBetaSelfielelele("recordCountAfterSearchCriteria.png");

    }

    /**
     * First passing the noOfClicks to add the row filter.
     * Validate the Assertion to check the initial count of filter rows.
     * Passing the noOfClicks to remove some row filter.
     * Validate the Assertion to check the count after removal of filter rows.
     * **/
    @Test
    public void validateRemoveFilterRowButtonFunctionality()
    {
        GLOBAL_STATIC.assignStaticContent(405);
        cf.clickOnCasesAddFilterRowButton(6);
        ScreenshotUtility.chalBetaSelfielelele("initialCountOfRows.png");
        int initialCountOfFilterRows=GLOBAL_GENERIC.getTheWebElementsCount(CasesFilterResource.xpathOfFilterRow);
        Assert.assertEquals(7,initialCountOfFilterRows);
        cf.clicksOnRemoveFilterRowButton(2);
        ScreenshotUtility.chalBetaSelfielelele("AfterRemovingCountOfRows.png");
        int CountAfterRemovalOfSomeFilterRows=GLOBAL_GENERIC.getTheWebElementsCount(CasesFilterResource.xpathOfFilterRow);
        Assert.assertEquals(5,CountAfterRemovalOfSomeFilterRows);
    }

    @AfterMethod
    public void testTearDown(){

        GLOBAL_STATIC.driver.close();
    }

}