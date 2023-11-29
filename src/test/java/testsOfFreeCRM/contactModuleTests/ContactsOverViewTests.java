package testsOfFreeCRM.contactModuleTests;
import frameworkOfFreeCRM.base.Base;
import frameworkOfFreeCRM.resources.contactsModuleResource.ContactFilterResource;
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
public class ContactsOverViewTests extends Base {
    ContactsOverviewResource  cop;
    @BeforeMethod(alwaysRun = true)
    public void testSetUp() throws IOException, InterruptedException {
        launchBrowser().enterValidCredentials();
        GLOBAL_GENERIC.navigateToModule(GLOBAL_STATIC.nameOfModule[0]);
        cop = new ContactsOverviewResource();
    }

    @Test(groups = {"sanity","contactsModule"})
    public void validateDefaultColumnsOfContacts() throws InterruptedException {
        GLOBAL_STATIC.assignStaticContent(701);
        cop.validateContactsGridDefaultColumn();
    }


    @Test(groups = {"regression","contactsModule"})
    public void validateTheViewContactIconBehaviour(){
            GLOBAL_STATIC.assignStaticContent(702);
            String fn = GLOBAL_STATIC.testData.getCellData("contactsTestData",7,1);
            String ln = GLOBAL_STATIC.testData.getCellData("contactsTestData",7,2);
            String fullName = fn + " " + ln;
            cop.navigateToContactDetails(fullName);
    }

    @Test(groups = {"regression","contactsModule"})
    public void validateTheEditContactIconBehaviourInOverviewPage() throws InterruptedException {
        GLOBAL_STATIC.assignStaticContent(703);
        String fn = GLOBAL_STATIC.testData.getCellData("contactsTestData",9,1);
        String ln = GLOBAL_STATIC.testData.getCellData("contactsTestData",9,2);
        String fullName = fn + " " + ln;
        cop.navigateToContactEditScreen(fullName);

    }

    @Test(groups = {"regression","contactsModule"})
    public void  deleteTheContactFromOverviewPage() throws InterruptedException {
        GLOBAL_STATIC.assignStaticContent(704);
        String fn = GLOBAL_STATIC.testData.getCellData("contactsTestData",10,1);
        String ln = GLOBAL_STATIC.testData.getCellData("contactsTestData",10,2);
        String fullName = fn + " " + ln;
        cop.deleteTheContactFromOverviewPage(fullName);
        GLOBAL_GENERIC.navigateToModule(GLOBAL_STATIC.nameOfModule[0]);
        boolean  statusOfContactRecord = ContactsGlobalResource.checkForContactRecord(fullName);
        Assert.assertEquals(statusOfContactRecord,false);
    }

    @Test(groups = {"regression","contactsModule"})
    public void  showFilterButtonFunctionalityInOverviewPage() throws InterruptedException {
        GLOBAL_STATIC.assignStaticContent(705);
        GLOBAL_GENERIC.locateAndGetWebElement(CommonXpath.xpathOfShowFilterButton).click();
        ContactFilterResource  cfr = new ContactFilterResource();
        cfr.validateShowFilterScreenWebElements();
    }


    @Test(groups = {"regression","contactsModule"})
    public void hideFilterButtonFunctionalityInOverviewPage(){
        GLOBAL_STATIC.assignStaticContent(706);
        GLOBAL_GENERIC.locateAndGetWebElement(CommonXpath.xpathOfShowFilterButton).click();
        ContactFilterResource  cfr = new ContactFilterResource();
        cfr.validateShowFilterScreenWebElements();
        cfr.validateHideFilterButtonFunctionality();

    }

    @AfterMethod(alwaysRun = true)
    public void testTearDown(){

        GLOBAL_STATIC.driver.close();
    }



}
