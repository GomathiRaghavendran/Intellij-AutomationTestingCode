package testsOfFreeCRM.companiesModuleTests;

import frameworkOfFreeCRM.base.Base;
import frameworkOfFreeCRM.resources.companiesModuleResource.CompaniesGlobalResource;
import frameworkOfFreeCRM.resources.globalResource.GLOBAL_GENERIC;
import frameworkOfFreeCRM.resources.staticResource.GLOBAL_STATIC;
import frameworkOfFreeCRM.utilities.screenshotUtilities.ScreenshotUtility;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;
@Listeners({frameworkOfFreeCRM.utilities.extentReports.ExternalReports.class})
public class CreateCompaniesTestData extends Base {
    /**In this class we are extending the base class to get data.
    * Creating testData method to navigate to Companies module.
    * Using before method annotation we are calling launchBrowser() and enterValidCredentials().
    * HomePageResource class is used to get data from LoginPage resource because we are retuning
    * the object of HomePageResource.
    * Bellow we are commenting HomePageResource because, as we are getting the data of credentials from Excel.*/
    // HomePageResource hp;
    @BeforeMethod(alwaysRun = true)
    public void testSetUp() throws IOException, InterruptedException {
       launchBrowser().enterValidCredentials();
    }
    /**In below method we are retrieving data from static method to navigateToModule
    * We are using static string[] than the hard coded values which is created in static class as a static array.
    * Here we are iterating the row number as we want to enter all the rows from Excel.*/
    @Test(groups={"sanity","companiesModule"})
    public void createTestData() {
        GLOBAL_STATIC.assignStaticContent(2);
        GLOBAL_GENERIC.navigateToModule(GLOBAL_STATIC.nameOfModule[1]);
        CompaniesGlobalResource cgr=new CompaniesGlobalResource();
        for(int i=2;i<=9;i++) {
            cgr.createCompany(i);
            ScreenshotUtility.chalBetaSelfielelele("Create TestData");
        }


    }
    @AfterMethod(alwaysRun = true)
    public void tearDown(){

        GLOBAL_STATIC.driver.close();
    }
}
