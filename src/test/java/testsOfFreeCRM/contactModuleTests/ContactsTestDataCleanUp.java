package testsOfFreeCRM.contactModuleTests;

import frameworkOfFreeCRM.base.Base;
import frameworkOfFreeCRM.resources.contactsModuleResource.ContactsOverviewResource;
import frameworkOfFreeCRM.resources.globalResource.CommonXpath;
import frameworkOfFreeCRM.resources.globalResource.GLOBAL_GENERIC;
import frameworkOfFreeCRM.resources.staticResource.GLOBAL_STATIC;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;

@Listeners({frameworkOfFreeCRM.utilities.extentReports.ExternalReports.class})
public class ContactsTestDataCleanUp extends Base {
    @BeforeMethod
    public void testSetUp() throws IOException, InterruptedException {
        launchBrowser().enterValidCredentials();
        GLOBAL_GENERIC.navigateToModule(GLOBAL_STATIC.nameOfModule[0]);
    }


    @Test(groups = "contactsModule")
    public void cleanUpTestData() throws InterruptedException {
        Thread.sleep(1000);
        int countOfPages = GLOBAL_GENERIC.getTheWebElementsCount(CommonXpath.xpathOfPagination);
        for(int i=0;i<countOfPages-2;i++){
            int countOfDeleteIcons =  GLOBAL_GENERIC.getTheWebElementsCount(CommonXpath.xpathOfDeleteIcon);
            System.out.println("dummy");
            for (int j =0;j<countOfDeleteIcons;j++){
                GLOBAL_GENERIC.locateAndGetWebElement(CommonXpath.xpathOfDeleteIcon).click();
                GLOBAL_GENERIC.deleteConfirmationPopUp(true);
                Thread.sleep(1000);
            }
        }
    }

    @AfterMethod
    public void testTearDown(){
        GLOBAL_STATIC.driver.close();
    }


}
