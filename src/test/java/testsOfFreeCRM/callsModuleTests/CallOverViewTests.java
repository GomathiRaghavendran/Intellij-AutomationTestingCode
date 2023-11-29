package testsOfFreeCRM.callsModuleTests;

import frameworkOfFreeCRM.base.Base;
import frameworkOfFreeCRM.resources.callModuleResource.CallFilterResource;
import frameworkOfFreeCRM.resources.callModuleResource.CallGlobalResource;
import frameworkOfFreeCRM.resources.callModuleResource.CallOverviewResources;
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
public class CallOverViewTests extends Base {
    CallOverviewResources co ;
     @BeforeMethod(alwaysRun = true)
     public void testSetUp() throws IOException, InterruptedException {
        launchBrowser().enterValidCredentials();
         co = new CallOverviewResources();
        GLOBAL_GENERIC.navigateToModule(GLOBAL_STATIC.nameOfModule[5]);
    }
    // Validating default column of calls.
      @Test(groups = {"sanity","callsModule"})
      public void validateDefaultColumnOfCalls() {
         GLOBAL_STATIC.assignStaticContent(301);
        co.validateCallsGridDefaultColumn();
       }
    // Validating view icon on call overview page.
       @Test(groups = {"regression","callsModule"})
       public void validateTheViewCallIconBehaviour()  {
         GLOBAL_STATIC.assignStaticContent(302);
       String callType =GLOBAL_STATIC.testData.getCellData("callstestData",2,1);
            co.navigateToCallsDetails(callType);

       }
       //Validating edit icon on call overview page.
       @Test(groups = {"regression","callsModule"})
       public void validateTheEditCallIconBehavior() {
         GLOBAL_STATIC.assignStaticContent(303);
        String callTime = GLOBAL_STATIC.testData.getCellData("callstestData",5,1);
        co.navigateToCallsEditPage(callTime);
       }
    //delete selected call record and navigate to page and verify if the record is deleted or not
       @Test(groups = {"regression","callsModule"})
    public void deleteTheCallFromOverviewPage() {
         GLOBAL_STATIC.assignStaticContent(304);
        String calltime = GLOBAL_STATIC.testData.getCellData("callstestData", 4, 1);
        GLOBAL_GENERIC.navigateToModule(GLOBAL_STATIC.nameOfModule[5]);
        co.deleteTheCallFromOverviewPage(calltime);
        boolean statusOfCallRecord = CallGlobalResource.checkForCallRecord(calltime);
        Assert.assertEquals(statusOfCallRecord, false);
    }
    @Test(groups = {"regression","callsModule"})
    public void showFilterButtonFunctionalityInOverviewPage() {
        GLOBAL_STATIC.assignStaticContent(305);
        GLOBAL_GENERIC.locateAndGetWebElement(CommonXpath.xpathOfShowFilterButton).click();
        CallFilterResource cfr = new CallFilterResource();
        cfr.validateTheShowFilterWebElement();
    }
    @Test(groups = {"regression","callsModule"})
    public void hideFilterButtonFunctionalityInOverviewPage(){
        GLOBAL_STATIC.assignStaticContent(306);
        GLOBAL_GENERIC.locateAndGetWebElement(CommonXpath.xpathOfShowFilterButton).click();
        CallFilterResource cfr = new CallFilterResource();
        cfr.validateTheShowFilterWebElement();
        cfr.validateHideFilterButton();
    }


      @AfterMethod(alwaysRun = true)
      public void tearDown(){
        GLOBAL_STATIC.driver.close();
     }

     }
