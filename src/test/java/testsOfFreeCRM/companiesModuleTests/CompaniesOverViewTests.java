package testsOfFreeCRM.companiesModuleTests;

import frameworkOfFreeCRM.base.Base;
import frameworkOfFreeCRM.resources.companiesModuleResource.CompaniesFilterResource;
import frameworkOfFreeCRM.resources.companiesModuleResource.CompaniesOverviewResource;
import frameworkOfFreeCRM.resources.companiesModuleResource.CompaniesGlobalResource;
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
public class CompaniesOverViewTests extends Base {

    CompaniesOverviewResource cpo;

    @BeforeMethod(alwaysRun = true)
    public void testSetUp() throws IOException, InterruptedException {
        launchBrowser().enterValidCredentials();
        GLOBAL_GENERIC.navigateToModule(GLOBAL_STATIC.nameOfModule[1]);
        cpo= new CompaniesOverviewResource();

    }
    /**In below method validating the default columns in companies overview page */
    /** Instead of getting all the evidences in one folder to avoid that mess we are assigning Test Id to the test cases.*/
  @Test(groups = {"sanity","companiesModule"})
  public void validateDefaultCompaniesColumn(){
       GLOBAL_STATIC.assignStaticContent(101);
        cpo.validateCompaniesGridDefaultColumn();
  }

    /**In below method validating the view icon behaviour in companies overview page */
    @Test(groups = {"regression","companiesModule"})
    public void validateTheViewCompaniesIconBehaviour() {
          GLOBAL_STATIC.assignStaticContent(102);
            String fn = GLOBAL_STATIC.testData.getCellData("companiesTestData", 2, 1);
            cpo.navigateToCompaniesDetails(fn);
            ScreenshotUtility.chalBetaSelfielelele("ViewCompaniesIConBehaviour");

    }
    /**In below method validating the edit icon behaviour in companies overview page */
    @Test(groups = {"regression","companiesModule"})
    public  void validateTheEditCompaniesIconBehaviour() {
        GLOBAL_STATIC.assignStaticContent(103);
        String cn=GLOBAL_STATIC.testData.getCellData("companiesTestData",3,1);
        cpo.navigateCompaniesEditModule(cn);

    }
    /**In below method deleting the company from companies overview page */
    @Test(groups = {"regression","companiesModule"})
    public void deleteCompanyFromOverviewPage()  {
       GLOBAL_STATIC.assignStaticContent(104);
        String deleteFileName = GLOBAL_STATIC.testData.getCellData("companiesTestData",7,1);
        cpo.deleteTheCompanyFromOverviewPage(deleteFileName);
        GLOBAL_GENERIC.navigateToModule(GLOBAL_STATIC.nameOfModule[1]);
        boolean statusOfCompaniesRecord = CompaniesGlobalResource.checkForCompanyRecord(deleteFileName);
        Assert.assertEquals(statusOfCompaniesRecord,false);

    }


    /**This method dealsModulePipeline with clicking on show Filter button, and it displays the Web Elements of Show Filter Screen */
    @Test(groups = {"regression","companiesModule"})
    public void showFilterButtonFunctionalityInOverviewPage() {
       GLOBAL_STATIC.assignStaticContent(105);
        GLOBAL_GENERIC.locateAndGetWebElement(CommonXpath.xpathOfShowFilterButton).click();
        CompaniesFilterResource cfr=new CompaniesFilterResource();
        cfr.validateShowFilterScreenWebElements();

    }

    /**This method dealsModulePipeline with clicking on Hide Filter button, and ensure that it does not display the Web Elements of Show Filter in Hide Filter Screen*/
    @Test(groups = {"regression","companiesModule"})
    public void hideFilterButtonFunctionalityInOverviewPage(){
        GLOBAL_STATIC.assignStaticContent(106);
        GLOBAL_GENERIC.locateAndGetWebElement(CommonXpath.xpathOfShowFilterButton).click();
        CompaniesFilterResource cfr=new CompaniesFilterResource();
        cfr.validateShowFilterScreenWebElements();
        cfr.validateHideFilterButtonFunctionality();

    }

    @AfterMethod(alwaysRun = true)
     public void testTearDown(){
         GLOBAL_STATIC.driver.close();
     }

}
