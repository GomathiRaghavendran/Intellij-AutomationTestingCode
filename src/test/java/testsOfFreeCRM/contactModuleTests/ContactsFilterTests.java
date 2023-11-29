package testsOfFreeCRM.contactModuleTests;

import frameworkOfFreeCRM.base.Base;
import frameworkOfFreeCRM.resources.contactsModuleResource.ContactFilterResource;
import frameworkOfFreeCRM.resources.contactsModuleResource.ContactsGlobalResource;
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
import java.time.Duration;

@Listeners({frameworkOfFreeCRM.utilities.extentReports.ExternalReports.class})
public class ContactsFilterTests extends Base {
    ContactFilterResource   cfr;

    @BeforeMethod(alwaysRun = true)
    public void testSetUp() throws IOException, InterruptedException {
        launchBrowser().enterValidCredentials();
        GLOBAL_GENERIC.navigateToModule(GLOBAL_STATIC.nameOfModule[0]);
        cfr = new ContactFilterResource();
        GLOBAL_GENERIC.locateAndGetWebElement(CommonXpath.xpathOfShowFilterButton).click();
    }

    @Test(groups = {"sanity","contactsModule",})
    public void validateAddFilterRowButtonFunctionality(){
        GLOBAL_STATIC.assignStaticContent(707);
        cfr.clicksOnAddFilterRowButton(10);
        int actualCountOfSearchRows =  GLOBAL_GENERIC.getTheWebElementsCount(ContactFilterResource.xpathOfFilterRow);
        int actualCountOfSearchDropdowns = GLOBAL_GENERIC.getTheWebElementsCount(ContactFilterResource.xpathOfSearchDropDown);
        int  actualCountOfOperatorDropDowns = GLOBAL_GENERIC.getTheWebElementsCount(ContactFilterResource.xpathOfOperatorDropDown);
        Assert.assertEquals(actualCountOfSearchRows,11);
        Assert.assertEquals(actualCountOfSearchDropdowns,11);
        Assert.assertEquals(actualCountOfOperatorDropDowns,11);
    }

    @Test(groups = {"regression","contactsModule"})
    public void validateSearchFilterWithSingleFilterRowCriteria() throws InterruptedException {
        GLOBAL_STATIC.assignStaticContent(708);
        cfr.addSearchCriteria(cfr.searchDropDownValues[0],cfr.operatorDropDownValues[0],"D");
        cfr.searchButton.click();
        int getCountOfRecords = GLOBAL_GENERIC.getTheWebElementsCount(CommonXpath.xpathOfDeleteIcon);
        Assert.assertEquals(2,getCountOfRecords);
        Assert.assertEquals(true,ContactsGlobalResource.checkForContactRecord("Divya Chartuvedi"));
        Assert.assertEquals(true,ContactsGlobalResource.checkForContactRecord("Devika Naidu")); ;
    }


    @Test(groups = {"regression","contactsModule"})
    public void validateSearchFilterWithMultipleFilterRowCriteria() throws InterruptedException {
        GLOBAL_STATIC.assignStaticContent(709);
        cfr.addSearchCriteria(cfr.searchDropDownValues[0]
                        ,cfr.operatorDropDownValues[0],
                "D");
        cfr.clicksOnAddFilterRowButton(1);
        cfr.addMultpleSearchCriteria(2,
                cfr.searchDropDownValues[1],
                cfr.operatorDropDownValues[1],
                "i");
        cfr.searchButton.click();
        int getCountOfRecords = GLOBAL_GENERIC.getTheWebElementsCount(CommonXpath.xpathOfDeleteIcon);
        Assert.assertEquals(1,getCountOfRecords);
        Assert.assertEquals(true,ContactsGlobalResource.checkForContactRecord("Divya Chartuvedi"));
        Assert.assertEquals(false,ContactsGlobalResource.checkForContactRecord("Devika Naidu")); ;
    }

    @Test(groups = {"regression","contactsModule"})
    public void validateClearFilterButtonFunctionality() throws InterruptedException {
        GLOBAL_STATIC.assignStaticContent(710);
        GLOBAL_GENERIC.takeCareOfLoadingTableRow();
        int recordCountBeforeSearchCriteria = GLOBAL_GENERIC.
                getTheWebElementsCount("//tbody/tr");
        ScreenshotUtility.
                chalBetaSelfielelele("recordCountBeforeSearchCriteria.png");
        cfr.addSearchCriteria(cfr.searchDropDownValues[1]
                ,cfr.operatorDropDownValues[1],
                "i");
        cfr.searchButton.click();
        GLOBAL_GENERIC.takeCareOfLoadingTableRow();
        int recordCountBasedOnSearchCriteria = GLOBAL_GENERIC.getTheWebElementsCount("//tbody/tr");
        Assert.assertEquals(2,recordCountBasedOnSearchCriteria);
        ScreenshotUtility.chalBetaSelfielelele("recordCountWithSearchCriteria.png");
        cfr.clearButton.click();
        GLOBAL_GENERIC.takeCareOfLoadingTableRow();
        int recordCountAfterSearchCriteria = GLOBAL_GENERIC.getTheWebElementsCount("//tbody/tr");
        Assert.assertEquals(recordCountBeforeSearchCriteria,recordCountAfterSearchCriteria);
        ScreenshotUtility.chalBetaSelfielelele("recordCountAfterSearchCriteria.png");
    }

    @Test(groups = {"regression","contactsModule"})
    public void validateRemoveFilterRowButtonFunctionality(){
        GLOBAL_STATIC.assignStaticContent(711);
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
