package testsOfFreeCRM.contactModuleTests;

import frameworkOfFreeCRM.base.Base;
import frameworkOfFreeCRM.resources.casesModuleResource.CasesGlobalResource;
import frameworkOfFreeCRM.resources.casesModuleResource.CasesOverview;
import frameworkOfFreeCRM.resources.contactsModuleResource.ContactFilterResource;
import frameworkOfFreeCRM.resources.contactsModuleResource.ContactViewResource;
import frameworkOfFreeCRM.resources.contactsModuleResource.ContactsGlobalResource;
import frameworkOfFreeCRM.resources.contactsModuleResource.ContactsOverviewResource;
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
public class ContactsViewTests extends Base {

    ContactsOverviewResource  cop;
    ContactViewResource  cvr;

    @BeforeMethod(alwaysRun = true)
    public void testSetUp() throws IOException, InterruptedException {
        launchBrowser().enterValidCredentials();
        GLOBAL_GENERIC.navigateToModule(GLOBAL_STATIC.nameOfModule[0]);
        cop = new ContactsOverviewResource();
        cvr = new ContactViewResource();


    }

    @Test(groups = {"regression","contactsModule"})
    public void deleteRecordFromContactViewPage() throws InterruptedException {
        GLOBAL_STATIC.assignStaticContent(712);
        cvr.deleteRecordFromViewPage("Madhavi Kurra");
    }

    @Test(groups = {"regression","contactsModule"})
    public void validateCreationOfCaseFromContactViewScreen() throws InterruptedException {
        GLOBAL_STATIC.assignStaticContent(713);
        cvr.addCaseFromContactViewPage("Garima Wate",9);
    }

    @Test(groups = {"regression","contactsModule"})
    public void validateTheAddNotesIconFunctionality(){
        GLOBAL_STATIC.assignStaticContent(714);
        cop.navigateToContactDetails("Ankita Kumar");
        cvr.addNotesOnContactRecord("Please remember basic course session always start at 5PM");
    }


    @Test(groups = {"sanity","contactsModule"})
    public void validateTheAvailableTabsInContactViewPage(){
        GLOBAL_STATIC.assignStaticContent(715);
        cop.navigateToContactDetails("Priyanka Srinivas");
        cvr.validateTheTabsOnContactsViewPage();
    }

    @AfterMethod(alwaysRun = true)
    public void testTearDown(){
        GLOBAL_STATIC.driver.close();
    }


}
