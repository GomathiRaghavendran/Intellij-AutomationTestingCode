package testsOfFreeCRM.dealsModuleTests;

import frameworkOfFreeCRM.base.Base;
import frameworkOfFreeCRM.resources.dealsModuleResource.DealsGlobalResource;
import frameworkOfFreeCRM.resources.globalResource.GLOBAL_GENERIC;
import frameworkOfFreeCRM.resources.globalResource.HomePageResource;
import frameworkOfFreeCRM.resources.staticResource.GLOBAL_STATIC;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;
@Listeners({frameworkOfFreeCRM.utilities.extentReports.ExternalReports.class})

public class CreateDealsTestData extends Base {

     HomePageResource hp;
    // Testcase to Launch the Browser and login to FreeCRM page with valid credentials
    @BeforeMethod(alwaysRun = true)
    public void setup() throws IOException, InterruptedException {
        hp= launchBrowser().enterValidCredentials();
    }
    /* Testcase to navigate to Deals Module page.
    Below method is to create dealsModulePipeline data with text fields title and probability,Stage,Status,Type and source drop
    down fields.
    for loop is to retrieve all the data from the Excel otherwise we can use the variable rowNumber to retrieve data
    from one particular row.*/

    @Test(groups = {"sanity","regression","dealsModule"})
    public void createDealsData() throws InterruptedException{
        GLOBAL_GENERIC.navigateToModule(GLOBAL_STATIC.nameOfModule[2]);
        DealsGlobalResource dgr = new DealsGlobalResource();
        for(int i=2;i<=16;i++){
          dgr.createDeals(i);

        }
  }
    @AfterMethod(alwaysRun = true)
    public void tearDown(){
       GLOBAL_STATIC.driver.close();
    }
}
