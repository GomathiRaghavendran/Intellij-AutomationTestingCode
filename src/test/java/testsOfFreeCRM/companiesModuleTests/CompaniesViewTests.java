package testsOfFreeCRM.companiesModuleTests;

import frameworkOfFreeCRM.base.Base;
import frameworkOfFreeCRM.resources.companiesModuleResource.CompaniesOverviewResource;
import frameworkOfFreeCRM.resources.companiesModuleResource.CompaniesViewPageResource;
import frameworkOfFreeCRM.resources.globalResource.GLOBAL_GENERIC;
import frameworkOfFreeCRM.resources.staticResource.GLOBAL_STATIC;
import frameworkOfFreeCRM.utilities.screenshotUtilities.ScreenshotUtility;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;

  //This suite will run test cases related to view icon on the companies records

  /**Extending base class to acquire properties from base class.Base class have launchbrowser method load Properties,
        loadTestData,LoginPageResource and also explicit waits define in launch browser Method
  */
  @Listeners({frameworkOfFreeCRM.utilities.extentReports.ExternalReports.class})
public class CompaniesViewTests extends Base {

      /**
       * Creating object for CompaniesOverview class so that we can use methods related edit,view and delete icon on the
       * companies record
       */

      CompaniesOverviewResource co;
      CompaniesViewPageResource cvp;

      /**
       * Before method is capable to launch browser enter credentials and navigating to the module specify in index
       */

      @BeforeMethod(alwaysRun = true)
      public void testSetup() throws IOException, InterruptedException {
          launchBrowser().enterValidCredentials();
          GLOBAL_GENERIC.navigateToModule(GLOBAL_STATIC.nameOfModule[1]);
          co = new CompaniesOverviewResource();
          cvp = new CompaniesViewPageResource();

      }

      /**
       * This test is navigating to the companies module and clicking on edit view icon of specify record by calling method
       * navigateToCompaniesDetails from companiesOverview class.
       * Then we are clicking on delete icon from edit view page.
       * After deleting record navigating to company overview page and checking with assertion method that record is being deleted or not.
       */


      @Test(groups = {"regression","companiesModule"})
      public void deleteRecordFromCompaniesViewPage() {
          GLOBAL_STATIC.assignStaticContent(112);
          cvp.deleteRecordFromCompaniesViewPage("Proximus");

      }

      /**
       * Here we are creating one case record to retrieving data from excel and
       * deleting the same record
       */

      @Test(groups = {"regression","companiesModule"})
      public void validateCreationOfCaseFromCompaniesViewScreen() throws InterruptedException {
          GLOBAL_STATIC.assignStaticContent(113);
          cvp.addCaseFromCompaniesViewPage("Orange",9);

      }


      /**
       * This method first will navigate the companies details and click on view icon
       * on the view page ,from there it clicks on the add notes.
       */

      @Test(groups = {"regression","companiesModule"})
      public void validateTheAddNotesIconFunctionality() {
          GLOBAL_STATIC.assignStaticContent(114);
          co.navigateToCompaniesDetails("ING");
          cvp.addNotesOnCompaniesPageRecord("Office opens at 10 A.M");

      }

      /**
       * In below method clicks on default tabs on companies view page
       * Then it will click and check details of every tab
       */

      @Test(groups = {"sanity","companiesModule"})
      public void validateTheAvailableTabsInCompaniesViewPage() {
          GLOBAL_STATIC.assignStaticContent(115);
          co.navigateToCompaniesDetails("Toyato");
          cvp.validateTheTabsOnCompaniesViewPage();


      }
          @AfterMethod(alwaysRun = true)
          public void testTearDown () {
              GLOBAL_STATIC.driver.close();
          }

      }
