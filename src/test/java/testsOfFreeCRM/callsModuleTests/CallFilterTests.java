package testsOfFreeCRM.callsModuleTests;

import frameworkOfFreeCRM.base.Base;
import frameworkOfFreeCRM.resources.callModuleResource.CallFilterResource;
import frameworkOfFreeCRM.resources.callModuleResource.CallGlobalResource;
import frameworkOfFreeCRM.resources.contactsModuleResource.ContactFilterResource;
import frameworkOfFreeCRM.resources.globalResource.CommonXpath;
import frameworkOfFreeCRM.resources.globalResource.GLOBAL_GENERIC;
import frameworkOfFreeCRM.resources.staticResource.GLOBAL_STATIC;
import frameworkOfFreeCRM.utilities.screenshotUtilities.ScreenshotUtility;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;
@Listeners({frameworkOfFreeCRM.utilities.extentReports.ExternalReports.class})
public class CallFilterTests extends Base {
    CallFilterResource cfr;

    @BeforeMethod(alwaysRun = true)
    public void testSetUp() throws IOException, InterruptedException {
        launchBrowser().enterValidCredentials();
        GLOBAL_GENERIC.navigateToModule(GLOBAL_STATIC.nameOfModule[5]);
        cfr = new CallFilterResource();
        GLOBAL_GENERIC.locateAndGetWebElement(CommonXpath.xpathOfShowFilterButton).click();
    }

    @Test(groups = {"sanity","callsModule"})
    public void validateAddFilterRowButtonFunctionality() {
        GLOBAL_STATIC.assignStaticContent(307);
        cfr.clicksOnAddFilterRowButton(6);
        int actualCountOfSearchRows = GLOBAL_GENERIC.getTheWebElementsCount(CallFilterResource.xpathOfFilterRow);
        int actualCountOfSearchDropdowns = GLOBAL_GENERIC.getTheWebElementsCount(CallFilterResource.xpathOfSearchDropDown);
        int actualCountOfOperatorDropDowns = GLOBAL_GENERIC.getTheWebElementsCount(CallFilterResource.xpathOfOperatorDropDown);
        Assert.assertEquals(actualCountOfSearchRows, 7);
        Assert.assertEquals(actualCountOfSearchDropdowns, 7);
        Assert.assertEquals(actualCountOfOperatorDropDowns, 7);
    }

    //Test case to validate search data with single filter row.
    @Test(groups = {"regression","callsModule"})
    public void validateSearchFilterWithSingleFilterRow()  {
        GLOBAL_STATIC.assignStaticContent(308);
        cfr.addSearchCriteria(cfr.searchDropDownValues[2], cfr.operatorDropDownValues[0], cfr.valueDropDown[0]);
        cfr.searchButtonXpath.click();
        int getCountOfRecords = GLOBAL_GENERIC.getTheWebElementsCount(CommonXpath.xpathOfDeleteIcon);
        Assert.assertEquals(2, getCountOfRecords);
        Assert.assertEquals(true, CallGlobalResource.checkForCallRecord("CALL"));
        Assert.assertEquals(true,CallGlobalResource.checkForCallRecord("CALL"));

    }

    /** Below test case we are validating multiple Search filter row criteria in  calls overview page.
    then calling MultipleSearchCriteria method and passing arguments to it including index on which we
      want to select the dropdown.*/
    @Test(groups = {"regression","callsModule"})
    public void  validateSearchFilterWithMultipleFilterRowCriteria(){
        GLOBAL_STATIC.assignStaticContent(309);
        cfr.addSearchCriteria(cfr.searchDropDownValues[2], cfr.operatorDropDownValues[0], cfr.valueDropDown[0]);
        cfr.clicksOnAddFilterRowButton(1);
        cfr.addMultipleSearchCriteria(2,cfr.searchDropDownValues[7],cfr.operatorDropDownValues[0],cfr.valueDropDownOfFlagValue[1]);
        cfr.searchButtonXpath.click();
        int getCountOfRecords = GLOBAL_GENERIC.getTheWebElementsCount(CommonXpath.xpathOfDeleteIcon);
        Assert.assertEquals(1, getCountOfRecords);
        Assert.assertEquals(true, CallGlobalResource.checkForCallRecord("CALL"));
        Assert.assertEquals(false,CallGlobalResource.checkForCallRecord("F.Y.I"));
    }

    @Test(groups = {"regression","callsModule"})
    public void validateClearFilterButtonFunctionality() throws InterruptedException {
        try{
        GLOBAL_STATIC.assignStaticContent(310);
        Thread.sleep(2000);
        int recordCountBeforeSearchCriteria = GLOBAL_GENERIC.
                getTheWebElementsCount("//tbody/tr");
        ScreenshotUtility.
                chalBetaSelfielelele("recordCountBeforeSearchCriteria");
        cfr.addSearchCriteria(cfr.searchDropDownValues[2]
                ,cfr.operatorDropDownValues[0],cfr.valueDropDown[0]);
        cfr.searchButton.click();
        GLOBAL_GENERIC.takeCareOfLoadingTableRow();
        int recordCountBasedOnSearchCriteria = GLOBAL_GENERIC.getTheWebElementsCount("//tbody/tr");
        Assert.assertEquals(recordCountBasedOnSearchCriteria,2);
        ScreenshotUtility.chalBetaSelfielelele("recordCountWithSearchCriteria");
        cfr.clearButton.click();
        Thread.sleep(2000);
        GLOBAL_GENERIC.takeCareOfLoadingTableRow();
        int recordCountAfterSearchCriteria = GLOBAL_GENERIC.getTheWebElementsCount("//tbody/tr");
        Assert.assertEquals(recordCountBeforeSearchCriteria,recordCountAfterSearchCriteria);
        ScreenshotUtility.chalBetaSelfielelele("recordCountAfterSearchCriteria");}
        catch(NoSuchElementException e){}
    }

    @Test(groups = {"regression","callsModule"})
    public void validateRemoveFilterRowButtonFunctionality(){
        GLOBAL_STATIC.assignStaticContent(311);
        cfr.clicksOnAddFilterRowButton(5);
        int initialCountOfFilterRows =GLOBAL_GENERIC.getTheWebElementsCount(ContactFilterResource.xpathOfFilterRow);
        Assert.assertEquals(6,initialCountOfFilterRows);
        cfr.clicksOnRemoveFilterRowButton(3);
        int countAfterRemoveSomeFilterRows =GLOBAL_GENERIC.getTheWebElementsCount(ContactFilterResource.xpathOfFilterRow);
        Assert.assertEquals(3,countAfterRemoveSomeFilterRows);
    }

    @AfterMethod(alwaysRun = true)
    public void testTearDown(){
        GLOBAL_STATIC.driver.close();
    }
}

