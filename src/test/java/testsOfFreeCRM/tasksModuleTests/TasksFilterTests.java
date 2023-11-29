package testsOfFreeCRM.tasksModuleTests;

import frameworkOfFreeCRM.base.Base;
import frameworkOfFreeCRM.resources.contactsModuleResource.ContactFilterResource;
import frameworkOfFreeCRM.resources.globalResource.CommonXpath;
import frameworkOfFreeCRM.resources.globalResource.GLOBAL_GENERIC;
import frameworkOfFreeCRM.resources.staticResource.GLOBAL_STATIC;
import frameworkOfFreeCRM.resources.tasksModuleResource.TasksFilterResource;
import frameworkOfFreeCRM.resources.tasksModuleResource.TasksGlobalResource;
import frameworkOfFreeCRM.utilities.screenshotUtilities.ScreenshotUtility;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;
@Listeners({frameworkOfFreeCRM.utilities.extentReports.ExternalReports.class})
public class TasksFilterTests extends Base {

    TasksFilterResource tfr;

    @BeforeMethod(alwaysRun = true)
    public void testSetUp() throws IOException, InterruptedException {
        launchBrowser().enterValidCredentials();
        GLOBAL_GENERIC.navigateToModule(GLOBAL_STATIC.nameOfModule[3]);
        tfr = new TasksFilterResource();
        GLOBAL_GENERIC.locateAndGetWebElement(CommonXpath.xpathOfShowFilterButton).click();
    }
    // In this method we are validating the functionality of AddFilterRow button. when we click on AddFilterRow button
    //we can see  searchRows having search dropdown, operator dropdown .

    @Test(groups={"sanity","tasksModule"})
    public void validateAddFilterRowButtonFunctionality() {
        GLOBAL_STATIC.assignStaticContent(207);
       // ScreenshotUtility.chalBetaSelfielelele("beforeClickingOnAddFilterRowButton");
        tfr.clicksOnAddFilterRowButton(4);
        int actualCountOfSearchRows = GLOBAL_GENERIC.getTheWebElementsCount(ContactFilterResource.xpathOfFilterRow);
        int actualCountOfSearchDropdowns = GLOBAL_GENERIC.getTheWebElementsCount(ContactFilterResource.xpathOfSearchDropDown);
        int actualCountOfOperatorDropDowns = GLOBAL_GENERIC.getTheWebElementsCount(ContactFilterResource.xpathOfOperatorDropDown);
        Assert.assertEquals(actualCountOfSearchRows, 5);
        Assert.assertEquals(actualCountOfSearchDropdowns, 5);
        Assert.assertEquals(actualCountOfOperatorDropDowns, 5);
        ScreenshotUtility.chalBetaSelfielelele("afterClickingOnAddFilterRowButton");


    }

    @Test(groups={"regression","tasksModule"})
    //in this method we are validating Search filter
    public void validateSearchFilterWithSingleRow() {
        GLOBAL_STATIC.assignStaticContent(208);
        tfr.addSearchCriteria(tfr.searchDropDownValues[0], tfr.operatorDropDownValues[0], "T");
        tfr.searchButtonXpath.click();
        int getCountOfRecords = GLOBAL_GENERIC.getTheWebElementsCount(CommonXpath.xpathOfDeleteIcon);
        Assert.assertEquals(2, getCountOfRecords);
        Assert.assertEquals(true, TasksGlobalResource.checkForTitleRecord("Testing"));
        Assert.assertEquals(true, TasksGlobalResource.checkForTitleRecord("TrackingDefects"));
        //here we are searching Titles Starting letter with R
        ScreenshotUtility.chalBetaSelfielelele("validatingSearchFilterWithSingleRow");
    }
    @Test(groups={"regression","tasksModule"})
    /*We are validating the search filter functionality for multiple filter rows*/
    public void validateSearchFilterWithMultipleRowCriteria()
    {
        GLOBAL_STATIC.assignStaticContent(209);
        ScreenshotUtility.chalBetaSelfielelele("beforeSearchFilterAction");
        tfr.addSearchCriteria(tfr.searchDropDownValues[0],tfr.operatorDropDownValues[0],"T");
        tfr.clicksOnAddFilterRowButton(1);

        tfr.addMultipleSearchCriteria(2,tfr.searchDropDownValues[0],tfr.operatorDropDownValues[1],"S");
        tfr.searchButtonXpath.click();
        int getCountOfRecords=GLOBAL_GENERIC.getTheWebElementsCount(CommonXpath.xpathOfDeleteIcon);
        Assert.assertEquals(1, getCountOfRecords);

        Assert.assertEquals(false, TasksGlobalResource.checkForTitleRecord("Testing"));

        Assert.assertEquals(true, TasksGlobalResource.checkForTitleRecord("TrackingDefects"));
        ScreenshotUtility.chalBetaSelfielelele("afterMultipleRowSearchCriteria");


    }
    //we are validating clear button functionality in this method. first we are counting the record of before search criteria
    //then we are counting the record with searchCriteria then in last we are validating count of
    // record before and after search criteria
    @Test(groups={"regression","tasksModule"})
    public void validateClearFilterButtonFunctionality()  {
        GLOBAL_STATIC.assignStaticContent(210);
        try {
            GLOBAL_GENERIC.takeCareOfLoadingTableRow();
        } catch (NoSuchElementException e) {

        }
            int recordCountBeforeSearchCriteria = GLOBAL_GENERIC.
                    getTheWebElementsCount("//tbody/tr");
            ScreenshotUtility.chalBetaSelfielelele("recordCountBeforeSearchCriteria");
            tfr.addSearchCriteria(tfr.searchDropDownValues[0]
                    , tfr.operatorDropDownValues[0],
                    "T");
            tfr.searchButtonXpath.click();
            GLOBAL_GENERIC.takeCareOfLoadingTableRow();
            int recordCountBasedOnSearchCriteria = GLOBAL_GENERIC.getTheWebElementsCount("//tbody/tr");
            Assert.assertEquals(2, recordCountBasedOnSearchCriteria);
            ScreenshotUtility.chalBetaSelfielelele("recordCountWithSearchCriteria");
            tfr.clearButton.click();
            GLOBAL_GENERIC.takeCareOfLoadingTableRow();
            int recordCountAfterSearchCriteria = GLOBAL_GENERIC.getTheWebElementsCount("//tbody/tr");
            Assert.assertEquals(recordCountBeforeSearchCriteria, recordCountAfterSearchCriteria);
            ScreenshotUtility.chalBetaSelfielelele("recordCountAfterSearchCriteria");

    }
    //In this method we are validating the remove filter row button functionality for this we have to click on add filter row
    //and count the total rows then click on remove button and then validate the total rows

    @Test(groups={"regression","tasksModule"})
    public void validateRemoveFilterRowButtonFunctionality(){
        GLOBAL_STATIC.assignStaticContent(211);
        tfr.clicksOnAddFilterRowButton(6);
        int initialFilterRows = GLOBAL_GENERIC.getTheWebElementsCount(TasksFilterResource.xpathOfFilterRow);
        Assert.assertEquals(7,initialFilterRows);
        ScreenshotUtility.chalBetaSelfielelele("filterRowCountBeforeRemovalOfFilterRows");
        tfr.clicksOnRemoveFilterRowButton(4);
        int countOfFilterRowsAfterRemoval = GLOBAL_GENERIC.getTheWebElementsCount(TasksFilterResource.xpathOfFilterRow);
        Assert.assertEquals(3,countOfFilterRowsAfterRemoval);
        ScreenshotUtility.chalBetaSelfielelele("filterRowCountAfterRemovalOfFilterRows");
    }

    @AfterMethod(alwaysRun = true)
    public void teardown() {
        GLOBAL_STATIC.driver.close();
    }
}