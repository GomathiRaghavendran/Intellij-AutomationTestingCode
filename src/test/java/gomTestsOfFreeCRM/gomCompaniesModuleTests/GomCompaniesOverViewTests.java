package gomTestsOfFreeCRM.gomCompaniesModuleTests;

import gomframeworkOfFreeCRM.gomResources.globalResource.GomGLOBAL_GENERIC;
import gomframeworkOfFreeCRM.gomBase.GomBase;
import gomframeworkOfFreeCRM.gomResources.companiesModuleResource.GomCompaniesFilterResource;
import gomframeworkOfFreeCRM.gomResources.companiesModuleResource.GomCompaniesGlobalResource;
import gomframeworkOfFreeCRM.gomResources.companiesModuleResource.GomCompaniesOverviewResource;
import gomframeworkOfFreeCRM.gomResources.globalResource.GomCommonXpath;
import gomframeworkOfFreeCRM.gomResources.staticReource.GomGLOBAL_STATIC;
import gomframeworkOfFreeCRM.gomUtilities.ScreenshotUtility.GomScreenshotUtility;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;

@Listeners(gomframeworkOfFreeCRM.gomUtilities.GomextentReports.GomExternalReports.class)
public class GomCompaniesOverViewTests extends GomBase {
    GomCompaniesOverviewResource co;

/** This @before method deals with launching the browser with valid credentials
 * and navigate to company modules and refresh the page
 * then created the object of GomCompanies overview Class to access method in it*/

    @BeforeMethod(alwaysRun = true)
    public void setup() throws IOException, InterruptedException {
        launchBrowser().enterValidCredentials();
        GomGLOBAL_GENERIC.navigateToModule(GomGLOBAL_STATIC.nameOfModule[1]);
        co = new GomCompaniesOverviewResource();

    }
    /** This test is to Verify the default columns of companies overview screen */
    @Test(groups={"sanity","companyModule"})
    public void validateDefaultColumnsOfCompanies()  {
       GomGLOBAL_STATIC.assignStaticContent(3);
        co.validateCompaniesGridDefaultColumns();
        GomScreenshotUtility.chaLBetaSelfieLeLele("DefaultColumnOfCompaniesOverviewPage");
    }
    /** This test is to verify view icon to be clicked and to check the company name with red icon*/
    @Test(groups={"regression","companyModule"})
    public void validateTheViewCompanyIconBehaviour()  {
        GomGLOBAL_STATIC.assignStaticContent(4);
        String cName = GomGLOBAL_STATIC.testData.getCellData("companiesTestData", 4, 1);
       // Thread.sleep(1000);
        co.navigateToCompanyDetails(cName);
        String companyName = GomGLOBAL_STATIC.testData.getCellData("companiesTestData", 5, 1);
       co.navigateToRightSideSectionOfCompanyDetailsViewPage(companyName);
        GomScreenshotUtility.chaLBetaSelfieLeLele("ViewCompanyIconBehaviour");


    }
    /** This test is to verify the Edit icon to be clicked and navigated to intended record and click on save button*/
    @Test(groups={"regression","companyModule"})
    public void validateTheEditIconBehaviourInOverviewPage()  {
        GomGLOBAL_STATIC.assignStaticContent(5);
        String cName = GomGLOBAL_STATIC.testData.getCellData("companiesTestData", 6, 1);
        //Thread.sleep(1000);
        co.navigateToCompaniesEditScreen(cName);
        GomScreenshotUtility.chaLBetaSelfieLeLele("EditCompanyIconBehaviour");
    }

    /** This method deals with click on Delete icon and check if the specified record is deleted in Companies overview screen*/
    @Test(groups={"regression","companyModule"})
    public void deleteTheCompanyFromOverViewPage() {
        GomGLOBAL_STATIC.assignStaticContent(6);
        try {
            String cName = GomGLOBAL_STATIC.testData.getCellData("companiesTestData", 7, 1);
            // Thread.sleep(1000);
            co.deleteTheCompaniesFromOverViewPage(cName);
            GomGLOBAL_GENERIC.navigateToModule(GomGLOBAL_STATIC.nameOfModule[1]);
            boolean statusOfContactRecord = GomCompaniesGlobalResource.checkForCompanyRecord(cName);
            System.out.println(statusOfContactRecord);
            Assert.assertEquals(statusOfContactRecord, false);
        }catch (InterruptedException e){
            System.out.println(e);
        }
        GomScreenshotUtility.chaLBetaSelfieLeLele("DeleteCompanyFromOVerViewPage");
    }
/**This method deals with clicking on show Filter button, and it displays the Web Elements of Show Filter Screen */
    @Test(groups={"regression","companyModule"})
    public void showFilterButtonFunctionalityInOverviewPage()  {
        GomGLOBAL_STATIC.assignStaticContent(7);
        GomGLOBAL_GENERIC.locateAndGetWebElement(GomCommonXpath.XpathOfShowFilterButton).click();
        GomCompaniesFilterResource gcfr=new GomCompaniesFilterResource();
        gcfr.validateShowFilterScreenWebElements();
        //Thread.sleep(3000);
        GomScreenshotUtility.chaLBetaSelfieLeLele("ShowFilter");
    }

    /**This method deals with clicking on Hide Filter button, and ensure that it does not display the Web Elements of Show Filter in Hide Filter Screen*/
    @Test(groups={"regression","companyModule"})
    public void hideFilterButtonFunctionalityInOverviewPage(){
        GomGLOBAL_STATIC.assignStaticContent(8);
        GomGLOBAL_GENERIC.locateAndGetWebElement(GomCommonXpath.XpathOfShowFilterButton).click();
        GomCompaniesFilterResource gcfr=new GomCompaniesFilterResource();
        gcfr.validateShowFilterScreenWebElements();
        gcfr.validateHideFilterButtonFunctionality();
        GomScreenshotUtility.chaLBetaSelfieLeLele("hideFilter");
    }

    /** @After method deals with close the browser irrespective of test status*/
    @AfterMethod(alwaysRun = true)
    public void testTearDown() {
            GomGLOBAL_STATIC.driver.close();
        }
    }

