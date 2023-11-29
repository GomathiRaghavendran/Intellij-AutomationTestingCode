package gomTestsOfFreeCRM.gomCompaniesModuleTests;


import gomframeworkOfFreeCRM.gomBase.GomBase;
import gomframeworkOfFreeCRM.gomResources.companiesModuleResource.GomCompaniesOverviewResource;
import gomframeworkOfFreeCRM.gomResources.globalResource.GomGLOBAL_GENERIC;
import gomframeworkOfFreeCRM.gomResources.staticReource.GomGLOBAL_STATIC;
import gomframeworkOfFreeCRM.gomUtilities.ScreenshotUtility.GomScreenshotUtility;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;

@Listeners({gomframeworkOfFreeCRM.gomUtilities.GomextentReports.GomExternalReports.class})
public class GomCompaniesTestDataCleanup extends GomBase {


    @BeforeMethod(alwaysRun = true)
    public void testSetUp() throws IOException, InterruptedException {
        launchBrowser().enterValidCredentials();
        GomGLOBAL_GENERIC.navigateToModule(GomGLOBAL_STATIC.nameOfModule[1]);
    }

    @Test(groups ={"cleanUp","companyModule"})
    public void cleanUpTestData() throws InterruptedException {
        //GomCompaniesOverview.forLoop();
        GomGLOBAL_STATIC.assignStaticContent(1);
       GomCompaniesOverviewResource.companiesTestdataCleanup();
        GomScreenshotUtility.chaLBetaSelfieLeLele("TestDataCleanUp");
    }

    @AfterMethod(alwaysRun = true)
            public void tearDown(){
        GomGLOBAL_STATIC.driver.close();
    }
}


