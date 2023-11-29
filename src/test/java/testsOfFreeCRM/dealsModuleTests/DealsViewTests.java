package testsOfFreeCRM.dealsModuleTests;

import frameworkOfFreeCRM.base.Base;
import frameworkOfFreeCRM.resources.dealsModuleResource.DealsGlobalResource;
import frameworkOfFreeCRM.resources.dealsModuleResource.DealsOverview;
import frameworkOfFreeCRM.resources.dealsModuleResource.DealsViewResource;
import frameworkOfFreeCRM.resources.globalResource.CommonXpath;
import frameworkOfFreeCRM.resources.globalResource.GLOBAL_GENERIC;
import frameworkOfFreeCRM.resources.staticResource.GLOBAL_STATIC;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;
@Listeners({frameworkOfFreeCRM.utilities.extentReports.ExternalReports.class})

public class DealsViewTests extends Base {
    DealsOverview dop;
    DealsViewResource dvr;
    @BeforeMethod(alwaysRun = true)
    public void testSetUp() throws IOException, InterruptedException {
        launchBrowser().enterValidCredentials();
        GLOBAL_GENERIC.navigateToModule(GLOBAL_STATIC.nameOfModule[2]);
      dop = new  DealsOverview();
      dvr = new DealsViewResource();
    }
  /*Below method navigates to a specific deals details page and deletes it from there and verifies whether the record is
    deleted successfully from the deals overview page*/
    @Test(groups = {"sanity","dealsModule"})
    public void deleteARecordFromDealsViewPage() throws InterruptedException {
        GLOBAL_STATIC.assignStaticContent(511);
        dvr.deleteARecordFromDealsViewPage("AmazonDeal");
    }
    /*Below method navigates to the specific deals details page and adds notes to the record,
    also validates the added notes*/
    @Test(groups = {"sanity","dealsModule"})
    public void validateAddNotesFunctionality() throws InterruptedException {
        GLOBAL_STATIC.assignStaticContent(512);
        dop.navigateToDealsDetails("ZaraDeal");
        dvr.addNotesOnDealsRecord("Added Notes for ZaraDeal");
    }
    /*Below method navigates to the specific deals details page and verify
     the tabs available in the view page of the particular record,
   also click on each tab and validates the icon corresponds to that tab.*/
    @Test(groups = {"regression","dealsModule"})
    public  void validateAvailableTabsInDealsViewPage() throws InterruptedException {
        GLOBAL_STATIC.assignStaticContent(513);
        dop.navigateToDealsDetails("ExpressDeal");
        dvr.validateTheTabsOnDealsViewPage();
    }

   @AfterMethod(alwaysRun = true)
    public void testTearDown(){
        GLOBAL_STATIC.driver.close();
    }

}
