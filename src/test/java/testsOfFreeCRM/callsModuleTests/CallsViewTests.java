package testsOfFreeCRM.callsModuleTests;

import frameworkOfFreeCRM.base.Base;
import frameworkOfFreeCRM.resources.callModuleResource.CallGlobalResource;
import frameworkOfFreeCRM.resources.callModuleResource.CallOverviewResources;
import frameworkOfFreeCRM.resources.callModuleResource.CallViewResource;
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
public class CallsViewTests extends Base {
    CallOverviewResources cop;
    CallViewResource cvr;
    @BeforeMethod(alwaysRun = true)
    public void testSetUp() throws IOException, InterruptedException {
        launchBrowser().enterValidCredentials();
        GLOBAL_GENERIC.navigateToModule(GLOBAL_STATIC.nameOfModule[5]);
        cop = new CallOverviewResources();
        cvr=new CallViewResource();
    }

    /** deleting record from the view page after opening the calls detail page */
    @Test(groups = {"regression","callsModule"})
    public void ValidateDeleteRecordFromCallsViewPage() throws InterruptedException {
        GLOBAL_STATIC.assignStaticContent(312);
        //Thread.sleep(2000);
        cvr.deleteRecordFromCallViewPage("11/11/2023 08:30");
    }
    /** Adding notes on call record from the view page */
    @Test(groups = {"regression","callsModule"})
    public void validateTheAddNotesIconFunctionality(){
        GLOBAL_STATIC.assignStaticContent(313);
        cop.navigateToCallsDetails("15/07/2023 15:30");
        cvr.addNotesOnCallRecord("Hello! Calls squad");
    }
    /** Validating Tabs from the view page */
    @Test(groups = {"sanity","callsModule"})
    public void validateTheAvailableTabsInCallsViewPage(){
        GLOBAL_STATIC.assignStaticContent(314);
        cop.navigateToCallsDetails("15/07/2023 15:30");
        cvr.validateTheTabOnCallViewPage();
    }
    @AfterMethod(alwaysRun = true)
    public void testTearDown(){
        GLOBAL_STATIC.driver.close();
    }
}
