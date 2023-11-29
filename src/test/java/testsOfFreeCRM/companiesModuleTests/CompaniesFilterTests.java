package testsOfFreeCRM.companiesModuleTests;

import frameworkOfFreeCRM.base.Base;
import frameworkOfFreeCRM.resources.companiesModuleResource.CompaniesFilterResource;
import frameworkOfFreeCRM.resources.companiesModuleResource.CompaniesGlobalResource;
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

/**Extending base class to acquire properties from base class.Base class have launchbrowser method load Properties,
   loadTestData,LoginPageResource and also explicit waits define in launch browser Method
  *To get the extent report we are Adding @Listeners to the class
 */
@Listeners({frameworkOfFreeCRM.utilities.extentReports.ExternalReports.class})
public class CompaniesFilterTests extends Base {

    /**
     * Creating object for ContactFilterResource class so that we can use methods related to filter button functionality
     * in this testSuite
     */
    CompaniesFilterResource cfr;

    @BeforeMethod(alwaysRun = true)
    public void testSetup() throws IOException, InterruptedException {
        launchBrowser().enterValidCredentials();
        GLOBAL_GENERIC.navigateToModule(GLOBAL_STATIC.nameOfModule[1]);
        cfr = new CompaniesFilterResource();
        GLOBAL_GENERIC.locateAndGetWebElement(CommonXpath.xpathOfShowFilterButton).click();
    }

    /**
     * This test case will validate AddFilterButton on companies overviewpage.
     * First it will click on AddFilterButton and no of clicks is define in parameter of the method
     * Depends on the click the list of  web-elements displayed is checked with Assertion including default web
     * element and also searchDropdowns and operatorDropdowns webelements count are checked with Assert method
     */
    @Test (groups = {"sanity","companiesModule",})
    public void validateAddFilterRowButtonFunctionality() {
        GLOBAL_STATIC.assignStaticContent(107);
        cfr.clicksOnAddFilterRowButton(5);
        int actualCountOfSearchRows = GLOBAL_GENERIC.getTheWebElementsCount(CompaniesFilterResource.xpathOfFilterRow);
        Assert.assertEquals(actualCountOfSearchRows, 6);
        int actualCountOfSearchDropdowns = GLOBAL_GENERIC.getTheWebElementsCount(CompaniesFilterResource.xpathOfSearchDropDown);
        Assert.assertEquals(actualCountOfSearchDropdowns, 6);
        int actualCountOfOperatorDropdowns = GLOBAL_GENERIC.getTheWebElementsCount(CompaniesFilterResource.xpathOfOperatorDropDown);
        Assert.assertEquals(actualCountOfOperatorDropdowns, 6);
        ScreenshotUtility.chalBetaSelfielelele("AddFilterRow");
    }

    /**
     * In below test case we  validate Search single filter row on companies overiew page.
     * we are calling addSearchCriteria Method, and we pass three arguments.
     * We validate the counts of delete icon after search.
     */

    @Test(groups = {"regression","companiesModule"})
    public void validateSearchFilterWithSingleFilterRow()  {
        GLOBAL_STATIC.assignStaticContent(108);
        cfr.addSearchCriteria(cfr.searchDropDownValues[0], cfr.operatorDropDownValues[0], "F");
        cfr.searchButtonXpath.click();
        int getCountOfRecords = GLOBAL_GENERIC.getTheWebElementsCount(CommonXpath.xpathOfDeleteIcon);
        Assert.assertEquals(1, getCountOfRecords);
        Assert.assertEquals(true, CompaniesGlobalResource.checkForCompanyRecord("FedEX"));
        ScreenshotUtility.chalBetaSelfielelele("SearchFilterWithSingleRow");
    }

    /**
     * In below method we  validate Search multiple filter rows.
     * we are calling addSearchCriteria Method, and we pass three arguments.
     * We are calling clicksOnAddFilterRowButton method for adding multiple search filters.
     * we are calling addMultipleSearchCriteria Method, and we pass four arguments.
     * We validate the counts of delete icon after search.
     */
    @Test(groups = {"regression","companiesModule"})
    public void validateSearchFilterWithMultipleFilterRows(){
        GLOBAL_STATIC.assignStaticContent(109);
        cfr.addSearchCriteria(cfr.searchDropDownValues[0],cfr.operatorDropDownValues[0],"B");
        cfr.clicksOnAddFilterRowButton(3);
        cfr.addMultipleSearchCriteria(3,cfr.searchDropDownValues[0],cfr.operatorDropDownValues[1],"as");
        cfr.searchButtonXpath.click();
        ScreenshotUtility.chalBetaSelfielelele("Searched record from multiple filter rows");
        int getCountOfRecords = GLOBAL_GENERIC.getTheWebElementsCount(CommonXpath.xpathOfDeleteIcon);
        Assert.assertEquals(1, getCountOfRecords);
        Assert.assertEquals(false, CompaniesGlobalResource.checkForCompanyRecord("Belfius"));
        Assert.assertEquals(true, CompaniesGlobalResource.checkForCompanyRecord("BNP Paribas"));
        ScreenshotUtility.chalBetaSelfielelele("SearchFilterWithMultipleRows");
    }

    /**This method dealsModulePipeline with clear of filter row button and is capable upto clicking on showFilter Button.
     *First we are checking the number of records in overview page and taking evidence of it by taking ScreenShot
     * Then we are calling addSearchCriteria Method, and we pass three arguments
     * clicking on Search button.
     * After record is being found we are doing assertion to get actual and expected count and taking evidence as screenShot on it.
     * Then clicking on clear button and performing assertion on afterSearch records and before search records on overview page.
     */

     @Test(groups = {"regression","companiesModule"})
    public void validateClearFilterButtonFunctionality() {
        GLOBAL_STATIC.assignStaticContent(110);
            try {
                GLOBAL_GENERIC.takeCareOfLoadingTableRow();
            }catch (NoSuchElementException e){

            }
        int recordCountBeforeSearchCriteria =GLOBAL_GENERIC.
                getTheWebElementsCount("//tbody/tr");
        ScreenshotUtility.chalBetaSelfielelele
                ("recordCountBeforeSearchCriteria.png");
        cfr.addSearchCriteria(cfr.searchDropDownValues[0],
                cfr.operatorDropDownValues[0],
                "O");
        cfr.searchButtonXpath.click();
       GLOBAL_GENERIC.takeCareOfLoadingTableRow();
        int recordCountBasedSearchCriteria = GLOBAL_GENERIC.
                getTheWebElementsCount("//tbody/tr");
        Assert.assertEquals(1,recordCountBasedSearchCriteria);
        ScreenshotUtility.chalBetaSelfielelele
               ("recordCountWithSearchCriteria.png");
        cfr.clearButton.click();
        GLOBAL_GENERIC.takeCareOfLoadingTableRow();
        int recordCountAfterSearchCriteria = GLOBAL_GENERIC.
                getTheWebElementsCount("//tbody/tr");
                Assert.assertEquals(recordCountBeforeSearchCriteria,recordCountAfterSearchCriteria);
        ScreenshotUtility.chalBetaSelfielelele
                ("recordCountAfterSearchCriteria");


    }

    /**This method dealsModulePipeline with Removal of filter row
     * First need to add Filter rows using Add filter row button method
     * and validating whether actual no of rows are added and expected are same using Assert equals method
     * and then removing the filter row using Clicks on Remove Filter Button method
     * and validating whether actual no of rows  removed and expected are same using Assert equals method */
    @Test(groups = {"regression","companiesModule"})
    public void validateRemoveFilterRowButtonFunctionality() {
        GLOBAL_STATIC.assignStaticContent(111);
        cfr.clicksOnAddFilterRowButton(10);
        int initialCountOfFilterRows =GLOBAL_GENERIC.getTheWebElementsCount(ContactFilterResource.xpathOfFilterRow);
        Assert.assertEquals(11,initialCountOfFilterRows);
        cfr.clicksOnRemoveFilterRowButton(3);
        int countAfterRemoveSomeFilterRows =GLOBAL_GENERIC.getTheWebElementsCount(ContactFilterResource.xpathOfFilterRow);
        Assert.assertEquals(8,countAfterRemoveSomeFilterRows);
        ScreenshotUtility.chalBetaSelfielelele("RemoveFilter");
    }




    @AfterMethod(alwaysRun = true)
   public void testTearDown() {
       GLOBAL_STATIC.driver.close();
    }
}






