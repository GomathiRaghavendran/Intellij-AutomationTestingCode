package gomTestsOfFreeCRM.gomCompaniesModuleTests;

import gomframeworkOfFreeCRM.gomBase.GomBase;
import gomframeworkOfFreeCRM.gomResources.companiesModuleResource.GomCompaniesFilterResource;
import gomframeworkOfFreeCRM.gomResources.companiesModuleResource.GomCompaniesGlobalResource;
import gomframeworkOfFreeCRM.gomResources.globalResource.GomCommonXpath;
import gomframeworkOfFreeCRM.gomResources.globalResource.GomGLOBAL_GENERIC;
import gomframeworkOfFreeCRM.gomResources.staticReource.GomGLOBAL_STATIC;
import gomframeworkOfFreeCRM.gomUtilities.ScreenshotUtility.GomScreenshotUtility;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;
@Listeners({gomframeworkOfFreeCRM.gomUtilities.GomextentReports.GomExternalReports.class})
public class GomCompaniesFilterTests extends GomBase {

    GomCompaniesFilterResource gcfr;

    @BeforeMethod(alwaysRun = true)
    public void setup() throws IOException, InterruptedException {
        launchBrowser().enterValidCredentials();
        GomGLOBAL_GENERIC.navigateToModule(GomGLOBAL_STATIC.nameOfModule[1]);
        gcfr = new GomCompaniesFilterResource();
        GomGLOBAL_GENERIC.locateAndGetWebElement(GomCommonXpath.XpathOfShowFilterButton).click();

    }

    /**
     * This method deals with validating the AddFilterRowButton Functionality
     * with Specified no of clicks, Add FilterRowButton will be clicked
     * Storing the actual count of search rows in an int datatype variable
     * then comparing the expected count of search rows with actual using Assert Equals method in Assert class
     */
    @Test(groups ={ "sanity","companyModule"})
    public void validateAddFilterRowButtonFunctionality() {
        GomGLOBAL_STATIC.assignStaticContent(9);
        gcfr.clicksOnAddFilterRowButton(4);
        int actualCountOfSearchRows = GomGLOBAL_GENERIC.getTheWebElementsCount(GomCompaniesFilterResource.xpathOfFilterRow);
        int actualCountOfSearchDropDowns = GomGLOBAL_GENERIC.getTheWebElementsCount(GomCompaniesFilterResource.xpathOfSearchDropDown);
        int actualCountOfOperatorDropDowns = GomGLOBAL_GENERIC.getTheWebElementsCount(GomCompaniesFilterResource.xpathOfOperatorDropDown);
        Assert.assertEquals(actualCountOfSearchRows, 5);
        Assert.assertEquals(actualCountOfSearchDropDowns, 5);
        Assert.assertEquals(actualCountOfOperatorDropDowns, 5);
        GomScreenshotUtility.chaLBetaSelfieLeLele("Add Filter");
    }

    /**
     * This method deals with Validating the Search filter functionality
     * To filter the company name, first selecting the values from search and Operator drop downs and then providing input text value to text box
     * then click on search filter button
     * Upon filtered, counting the records using getTheWebElementsCount method
     * Using Assert.AssertEquals method validating the actual and expected are same
     */
    @Test(groups ={ "regression","companyModule"})
    public void validateSearchFilterWithSingleFilterRow() {
        GomGLOBAL_STATIC.assignStaticContent(10);
        gcfr.addSearchCriteria(gcfr.searchDropDownValues[0], gcfr.operatorDropDownValues[1], "F");
        gcfr.searchButtonXpath.click();
        int getCountOfRecords = GomGLOBAL_GENERIC.getTheWebElementsCount(GomCommonXpath.xpathOfDeleteIconInCompaniesOverviewPage);
        Assert.assertEquals(1, getCountOfRecords);
        Assert.assertEquals(true, GomCompaniesGlobalResource.checkForCompanyRecord("FedEX"));
        GomScreenshotUtility.chaLBetaSelfieLeLele("SearchFilterWithSingleRow");
    }

    /**
     * This method deals with Validating the Search filter with multiple filter row criteria functionality
     * To filter the company name using add search criteria with single row and pass three arguments for search,Operator drop down
     * and then providing input text value to text box
     * then click on search filter button
     * To Filter with multiple search criteria, first click on add filter row button
     * and passing four arguments to it including index on which we
     * want to select drop down.
     * then getting no of search results depends on search criteria then
     * We are validating the number of delete icons in the record available
     * Upon filtered, counting the records using getTheWebElementsCount method
     * Using Assert.AssertEquals method validating the actual and expected are same
     */
    @Test(groups ={ "regression","companyModule"})
    public void validateSearchFilterWithMultipleFilterRowCriteria() {
        GomGLOBAL_STATIC.assignStaticContent(11);
        gcfr.addSearchCriteria(gcfr.searchDropDownValues[0],
                gcfr.operatorDropDownValues[1], "B");
        gcfr.clicksOnAddFilterRowButton(2);
        gcfr.addMultipleSearchCriteria(2,
                gcfr.searchDropDownValues[0],
                gcfr.operatorDropDownValues[2],
                "s");
        gcfr.addMultipleSearchCriteria(3,
                gcfr.searchDropDownValues[4],
                gcfr.operatorDropDownValues[1],
                "BNP");
        gcfr.searchButtonXpath.click();
       int getCountOfRecords = GomGLOBAL_GENERIC.getTheWebElementsCount(GomCommonXpath.xpathOfDeleteIconInCompaniesOverviewPage);
       Assert.assertEquals(1, getCountOfRecords);

        Assert.assertEquals(true, GomCompaniesGlobalResource.checkForCompanyRecord("BNP Paribas"));
        GomScreenshotUtility.chaLBetaSelfieLeLele("FilteredUsingMultipleSearchCriteria");
    }
/** This method deals with clearing the filters using clear button
 * First,Invoking assignStaticContent method to assign test case id to this test case
 * Second,Invoking takeCareOfLoadingTableRow method.. taking care of invisibility of web element using WebdriverWait or explicit wait
 * Third,Taking the record count before search criteria and store it in evidences using chaLBetaSelfieLeLele method in GomScreenshotUtility class
 * Fourth, perform the search operation using search and Operator drop down and click on search Button
 * Fifth, doing validation using Assert Equals method in assert class and store the evidences using chaLBetaSelfieLeLele method in GomScreenshotUtility class
 * then at last verifying that record count after search criteria and record count before search criteria using AsserEquals method*/

    @Test(groups ={ "regression","companyModule"})
    public void validateClearFilterButtonFunctionality()  {
        GomGLOBAL_STATIC.assignStaticContent(12);
     //GomGLOBAL_GENERIC.takeCareOfLoadingTableRow();
        int recordCountBeforeSearchCriteria = GomGLOBAL_GENERIC.
                getTheWebElementsCount("//tbody/tr");
        GomScreenshotUtility.
                chaLBetaSelfieLeLele("recordCountBeforeSearchCriteria.png");
        gcfr.addSearchCriteria(gcfr.searchDropDownValues[0]
                ,gcfr.operatorDropDownValues[1],
                "I");
        gcfr.searchButtonXpath.click();
        GomGLOBAL_GENERIC.takeCareOfLoadingTableRow();
        int recordCountBasedOnSearchCriteria = GomGLOBAL_GENERIC.getTheWebElementsCount("//tbody/tr");
        Assert.assertEquals(1,recordCountBasedOnSearchCriteria);
        GomScreenshotUtility.chaLBetaSelfieLeLele("recordCountWithSearchCriteria.png");
        gcfr.clearButton.click();
        GomGLOBAL_GENERIC.takeCareOfLoadingTableRow();
        int recordCountAfterSearchCriteria = GomGLOBAL_GENERIC.getTheWebElementsCount("//tbody/tr");
        //Thread.sleep(1000);
        Assert.assertEquals(recordCountBeforeSearchCriteria,recordCountAfterSearchCriteria);
        GomScreenshotUtility.chaLBetaSelfieLeLele("recordCountAfterSearchCriteria");
    }
/** This method deals with Removal of filter row
 * First need to add Filter rows using Add filter row button method
 * and validating whether actual no of rows are added and expected are same using Assert equals method
 * and then removing the filter row using Clicks on Remove Filter Button method
 * and validating whether actual no of rows  removed and expected are same using Assert equals method */
    @Test(groups ={ "regression","companyModule"})
    public void validateRemoveFilterRowButtonFunctionality() {
    GomGLOBAL_STATIC.assignStaticContent(13);
    gcfr.clicksOnAddFilterRowButton(7);
    int initialCountOfFilterRows=GomGLOBAL_GENERIC.getTheWebElementsCount(GomCompaniesFilterResource.xpathOfFilterRow);
    Assert.assertEquals(8,initialCountOfFilterRows);
    gcfr.clicksOnRemoveFilterRowButton(5);
    int countAfterRemovalOfSomeFilterRows=GomGLOBAL_GENERIC.getTheWebElementsCount(GomCompaniesFilterResource.xpathOfFilterRow);
    Assert.assertEquals(3,countAfterRemovalOfSomeFilterRows);
        GomScreenshotUtility.chaLBetaSelfieLeLele("RemoveFilter");
    }
    @AfterMethod(alwaysRun = true)
    public void testTearDown(){
        GomGLOBAL_STATIC.driver.close();
    }

}
