package testsOfFreeCRM.casesModuleTests;


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
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;
@Listeners({frameworkOfFreeCRM.utilities.extentReports.ExternalReports.class})
public class CasesFilterTests extends Base {
    CasesFilterResource cf;

    @BeforeMethod(alwaysRun = true)
    public void testSetup() throws IOException, InterruptedException {
        launchBrowser().enterValidCredentials();
        GLOBAL_GENERIC.navigateToModule(GLOBAL_STATIC.nameOfModule[4]);
        cf = new CasesFilterResource();
        GLOBAL_GENERIC.locateAndGetWebElement(CommonXpath.xpathOfShowFilterButton).click();

    }
    /** Add Filter functionality test
     * --> This test will click on addFilterRow button to add additional filter values */
    @Test(groups = {"sanity","casesModule"})
    public void addFilterRowButtonFunctionality(){
        GLOBAL_STATIC.assignStaticContent(407);
        cf.clickOnCasesAddFilterRowButton(5);
        ScreenshotUtility.chalBetaSelfielelele("addFilter");
        int actualCountOfSearchRow=GLOBAL_GENERIC.getTheWebElementsCount(CasesFilterResource.xpathOfFilterRow);
        int actualCountOfSearchDropDown=GLOBAL_GENERIC.getTheWebElementsCount(CasesFilterResource.xpathOfSearchDropdown);
        int actualCountOfOperatorDropDown=GLOBAL_GENERIC.getTheWebElementsCount(CasesFilterResource.xpathOfOperatorDropDown);
        Assert.assertEquals(actualCountOfSearchRow,6);
        Assert.assertEquals(actualCountOfSearchDropDown,6);
        Assert.assertEquals(actualCountOfOperatorDropDown,6);

    }
    /**
    Checking the single row search filter functionality by sending value to the searchDropdown ,operatorDropdown
     and textValue to the filter dropDown and validating it by assertion
    **/
    @Test(groups = {"regression","casesModule"})
    public void validateSearchFilterWithSingleFilterRow()
    {
        GLOBAL_STATIC.assignStaticContent(408);
        cf.addCasesSearchCriteria(cf.searchDropDownValues[0],cf.operatorDropDownValues[0],"d");
        cf.searchButtonXpath.click();
        ScreenshotUtility.chalBetaSelfielelele("singleRowSearchFilterRecords");
        int getCountOfRecords = GLOBAL_GENERIC.getTheWebElementsCount(CommonXpath.xpathOfDeleteIcon);
        Assert.assertEquals(1,getCountOfRecords);
        Assert.assertEquals(true, CasesGlobalResource.checkForCasesRecord("CreditCard"));
    }

   /**
   Checking the single and Multiple row search filter functionality by sending value to the searchDropdown ,operatorDropdown
    and textValue to the filter dropDown and validating it by assertion
   **/
    @Test(groups = {"regression","casesModule"})
    public void validateSearchFilterWithMultipleFilterRowCriteria(){
        GLOBAL_STATIC.assignStaticContent(409);
        cf.addCasesSearchCriteria(cf.searchDropDownValues[0],
                cf.operatorDropDownValues[1],
                "F");
        cf.clickOnCasesAddFilterRowButton(1);
        cf.addMultipleSearchCriteria(2,
                cf.searchDropDownValues[1],
                cf.operatorDropDownValues[1],
                "v");
        cf.searchButtonXpath.click();
        ScreenshotUtility.chalBetaSelfielelele("singleAndMultipleRowSearchFilterRecords");
        int getCountOfRecords = GLOBAL_GENERIC.getTheWebElementsCount(CommonXpath.xpathOfDeleteIcon);
        Assert.assertEquals(1,getCountOfRecords);
        Assert.assertEquals(true,CasesGlobalResource.checkForCasesRecord("FinancialPlanning"));

    }
   /**
    Checking clear filter button functionality ,by counting the records before and after clicking the clear
    button and validating it by applying the assertion.
   **/

    @Test(groups = {"regression","casesModule"})
    public void validateClearFilterButtonFunctionality(){
        GLOBAL_STATIC.assignStaticContent(410);
        try {
            GLOBAL_GENERIC.takeCareOfLoadingTableRow();
        }catch(Exception e){
        }
        int recordCountBeforeSearchCriteria=GLOBAL_GENERIC.getTheWebElementsCount("//tbody/tr");
        ScreenshotUtility.chalBetaSelfielelele("recordCountBeforeSearchCriteria");
        cf.addCasesSearchCriteria(cf.searchDropDownValues[0],
                cf.operatorDropDownValues[1],
                "I");
        cf.searchButtonXpath.click();
        try {
            GLOBAL_GENERIC.takeCareOfLoadingTableRow();
        }catch(Exception e){
        }
        int recordCountBasedOnSearchCriteria=GLOBAL_GENERIC.getTheWebElementsCount("//tbody/tr");
        Assert.assertEquals(recordCountBasedOnSearchCriteria,1);
        ScreenshotUtility.chalBetaSelfielelele("recordCountBasedOnSearchCriteria");
        cf.clearButton.click();
        try {
            GLOBAL_GENERIC.takeCareOfLoadingTableRow();
        }catch(Exception e){
        }
        int recordCountAfterSearchCriteria=GLOBAL_GENERIC.getTheWebElementsCount("//tbody/tr");
        Assert.assertEquals(recordCountBeforeSearchCriteria,recordCountAfterSearchCriteria);
        ScreenshotUtility.chalBetaSelfielelele("recordCountAfterSearchCriteria");

    }
    /**
     * First passing the noOfClicks to add the row filter.
     * Validate the Assertion to check the initial count of filter rows.
     * Passing the noOfClicks to remove some row filter.
     * Validate the Assertion to check the count after removal of filter rows.
     * **/
    @Test(groups = {"regression","casesModule"})
    public void validateRemoveFilterRowButtonFunctionality()
    {
        GLOBAL_STATIC.assignStaticContent(411);
        cf.clickOnCasesAddFilterRowButton(6);
        ScreenshotUtility.chalBetaSelfielelele("initialCountOfRows");
        int initialCountOfFilterRows=GLOBAL_GENERIC.getTheWebElementsCount(CasesFilterResource.xpathOfFilterRow);
        Assert.assertEquals(7,initialCountOfFilterRows);
        cf.clicksOnRemoveFilterRowButton(2);
        ScreenshotUtility.chalBetaSelfielelele("AfterRemovingCountOfRows");
        int CountAfterRemovalOfSomeFilterRows=GLOBAL_GENERIC.getTheWebElementsCount(CasesFilterResource.xpathOfFilterRow);
        Assert.assertEquals(5,CountAfterRemovalOfSomeFilterRows);
    }

    @AfterMethod(alwaysRun = true)
    public void testTearDown(){
        GLOBAL_STATIC.driver.close();
    }

}