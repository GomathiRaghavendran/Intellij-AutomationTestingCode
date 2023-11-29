package testsOfFreeCRM.callsModuleTests;

import frameworkOfFreeCRM.base.Base;
import frameworkOfFreeCRM.resources.callModuleResource.CallGlobalResource;
import frameworkOfFreeCRM.resources.globalResource.GLOBAL_GENERIC;
import frameworkOfFreeCRM.resources.globalResource.HomePageResource;
import frameworkOfFreeCRM.resources.staticResource.GLOBAL_STATIC;
import frameworkOfFreeCRM.resources.staticResource.GLOBAL_STATIC;
import org.jsoup.Connection;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;
@Listeners({frameworkOfFreeCRM.utilities.extentReports.ExternalReports.class})
public class CreateCallsTestData extends Base {


    @BeforeMethod(alwaysRun = true)
    public void setUp() throws IOException, InterruptedException {
        /**1. launchBrowser(); method belongs to base class,
         since we are extending the base class we can call this method.
         2. Credential data is inserted from Excel sheet, when we call "enterValidCredentials".
          */
        launchBrowser().enterValidCredentials();
    }
    /** 1.we are taking dynamic xpath with this method.
            for find element we need to enter namOfTheModule dynamically in xpath which this is retrieving from the argument of method i.e. nameOfTheModule.
            and again we are not writing hardCoded data instead extracting data from the array nameOfModule.
            so while calling method we are passing argument nameOfModule[indexNumber]
            2. Iterating data from excelSheet repeatedly, using loop.
            */
    @Test(groups = {"sanity","callsModule"})
    public void callsModuleTestData() throws InterruptedException {
        GLOBAL_STATIC.assignStaticContent(300);
        GLOBAL_GENERIC.navigateToModule(GLOBAL_STATIC.nameOfModule[5]);
        CallGlobalResource cgr=new CallGlobalResource();
        for (int a=2;a<=8;a++){
        cgr.createCall(a);
    }
    }

   @AfterMethod(alwaysRun = true)
    public  void  tearDown() throws InterruptedException {
       // Thread.sleep(2000);
        GLOBAL_STATIC.driver.close();
    }


}
