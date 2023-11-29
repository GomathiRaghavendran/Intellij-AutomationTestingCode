package gomTestsOfFreeCRM.gomCompaniesModuleTests;


import gomframeworkOfFreeCRM.gomBase.GomBase;
import gomframeworkOfFreeCRM.gomResources.companiesModuleResource.GomCompaniesOverviewResource;
import gomframeworkOfFreeCRM.gomResources.companiesModuleResource.GomCompaniesViewResource;
import gomframeworkOfFreeCRM.gomResources.globalResource.GomGLOBAL_GENERIC;
import gomframeworkOfFreeCRM.gomResources.staticReource.GomGLOBAL_STATIC;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;
@Listeners(gomframeworkOfFreeCRM.gomUtilities.GomextentReports.GomExternalReports.class)
public class GomCompaniesViewTests extends GomBase {
    GomCompaniesOverviewResource gco;

    GomCompaniesViewResource gcvr;

    @BeforeMethod(alwaysRun = true)
    public void testSetUp() throws IOException, InterruptedException {
        launchBrowser().enterValidCredentials();
        GomGLOBAL_GENERIC.navigateToModule(GomGLOBAL_STATIC.nameOfModule[1]);
        gco= new GomCompaniesOverviewResource();
        gcvr=new GomCompaniesViewResource();

    }

/**First,Invoking assignStaticContent method to assign test case id to this test case
 * and using it to generate evidence on that id for each test case
 * providing a company name to be deleted by invoking deleteRecordFromCompaniesViewPage method*/
    @Test(groups={"regression","companyModule"})
    public void deleteRecordFromCompanyOverViewPage()  {
        GomGLOBAL_STATIC.assignStaticContent(14);
        gcvr.deleteRecordFromCompaniesViewPage("Orange");
    }
/** First,Invoking assignStaticContent method to assign test case id to this test case
 * and using it to generate evidence on that id for each test case
 * providing a company name and cases to be created from Excel by invoking add case From Companies View Page method*/
    @Test(groups={"regression","companyModule"})
    public void validateCreationOfCaseFromCompanyViewScreen() throws InterruptedException {
        GomGLOBAL_STATIC.assignStaticContent(15);
        gcvr.addCaseFromCompaniesViewPage("ING",9);
    }
    /**First,Invoking assignStaticContent method to assign test case id to this test case
            * and using it to generate evidence on that id for each test case
            * providing a company name to be navigated by invoking navigating to company Details method
     * and Notes to be created by invoking addNotesOnCompanyRecord method*/
    @Test(groups={"regression","companyModule"})
    public void validateTheAddNotesIconFunctionality() {
        GomGLOBAL_STATIC.assignStaticContent(16);
        gco.navigateToCompanyDetails("Belfius");
        gcvr.addNotesOnCompanyRecord("No class on sunday");
    }
    /**First,Invoking assignStaticContent method to assign test case id to this test case
     * and using it to generate evidence on that id for each test case
     * providing a company name to be navigated by invoking navigating to company Details method
     * and by clicking on each tab and validating the web elements in it*/
    @Test(groups={"sanity","companyModule"})
    public void validateTheAvailableTabsInCompanyViewPage(){
        GomGLOBAL_STATIC.assignStaticContent(17);
        gco.navigateToCompanyDetails("Belfius");
        gcvr.validateTheTabsOnCompaniesViewPage();
    }

   @AfterMethod(alwaysRun = true)
    public void testTearDown(){
        GomGLOBAL_STATIC.driver.close();
    }
}
