package testsOfFreeCRM.contactModuleTests;

import frameworkOfFreeCRM.base.Base;
import frameworkOfFreeCRM.resources.contactsModuleResource.ContactsGlobalResource;
import frameworkOfFreeCRM.resources.globalResource.GLOBAL_GENERIC;
import frameworkOfFreeCRM.resources.staticResource.GLOBAL_STATIC;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;
@Listeners({frameworkOfFreeCRM.utilities.extentReports.ExternalReports.class})
public class CreateContactsTestData  extends Base {


    @BeforeMethod
    public void testSetUp() throws IOException, InterruptedException {
       launchBrowser().enterValidCredentials();
    }


    @Test(groups = "contactsModule")
    public void createTestData() throws InterruptedException {
        GLOBAL_GENERIC.navigateToModule(GLOBAL_STATIC.nameOfModule[0]);
        ContactsGlobalResource  cgr = new ContactsGlobalResource();
        for(int i =2;i<=11;i++) {
            cgr.createContact(i);
        }

    }


    @AfterMethod
    public void testTearDown(){
        GLOBAL_STATIC.driver.close();
    }



}
