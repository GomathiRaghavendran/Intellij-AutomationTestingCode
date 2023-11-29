package gomTestsOfFreeCRM.gomCompaniesModuleTests;

import frameworkOfFreeCRM.utilities.screenshotUtilities.ScreenshotUtility;
import gomframeworkOfFreeCRM.gomBase.GomBase;

import gomframeworkOfFreeCRM.gomResources.companiesModuleResource.GomCompaniesGlobalResource;
import gomframeworkOfFreeCRM.gomResources.globalResource.GomHomePageResource;
import gomframeworkOfFreeCRM.gomResources.globalResource.GomGLOBAL_GENERIC;
import gomframeworkOfFreeCRM.gomResources.staticReource.GomGLOBAL_STATIC;
import gomframeworkOfFreeCRM.gomUtilities.ScreenshotUtility.GomScreenshotUtility;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;

@Listeners(gomframeworkOfFreeCRM.gomUtilities.GomextentReports.GomExternalReports.class)
public class GomCreateCompaniesTestData extends GomBase {
    GomHomePageResource hpr;

        @BeforeMethod(alwaysRun = true)
        public void testSetUp() throws IOException, InterruptedException {
            hpr =  launchBrowser().enterValidCredentials();
        }
        @Test(groups={"testDataCreation","companyModule"})
        public void createTestData() throws InterruptedException {
            GomGLOBAL_STATIC.assignStaticContent(2);
            GomGLOBAL_GENERIC.navigateToModule(GomGLOBAL_STATIC.nameOfModule[1]);
            GomCompaniesGlobalResource gcgr=new GomCompaniesGlobalResource();
           for(int i=2;i<=9;i++) {
                gcgr.createCompany(i);
           }
            GomScreenshotUtility.chaLBetaSelfieLeLele("Create TestData");
        }


      /**  @Test
    public void createTestData1() throws InterruptedException {
            GomGLOBAL_STATIC.navigateToModule(GomGLOBAL_STATIC.nameOfModule[1]);
            GomCompaniesGlobalResource gcgr=new GomCompaniesGlobalResource();
            gcgr.createCompany(5);
        }*/


        @AfterMethod(alwaysRun = true)
    public void tearDown(){
            GomGLOBAL_STATIC.driver.close();
        }
}

