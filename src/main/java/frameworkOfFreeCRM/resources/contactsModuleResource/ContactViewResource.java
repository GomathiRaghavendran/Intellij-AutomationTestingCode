package frameworkOfFreeCRM.resources.contactsModuleResource;

import frameworkOfFreeCRM.resources.casesModuleResource.CasesGlobalResource;
import frameworkOfFreeCRM.resources.casesModuleResource.CasesOverview;
import frameworkOfFreeCRM.resources.globalResource.CommonXpath;
import frameworkOfFreeCRM.resources.globalResource.GLOBAL_GENERIC;
import frameworkOfFreeCRM.resources.staticResource.GLOBAL_STATIC;
import frameworkOfFreeCRM.utilities.screenshotUtilities.ScreenshotUtility;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactViewResource {

    public ContactViewResource(){

        PageFactory.initElements(GLOBAL_STATIC.driver, this);
    }

    String[]  listOfTabs = {"All","Notes","Events","Deals","Tasks","Cases","Calls",
                 "Documents","Emails","WhatsApp","Texts","Campaigns","Credentials"};

    @FindBy(xpath = "//button/i[@class='comments outline icon']")
    public WebElement addNoteButton;


    @FindBy(xpath = "//textarea")
    public WebElement textAreaOfNotes;

    @FindBy(xpath = "//div[@class='ui modal transition visible active']/div[@class='header']")
    public WebElement  addNotePopUpHeader;

    @FindBy(xpath = "//button/i[@class='comments icon']")
    public WebElement addCaseButton;


    @FindBy(xpath = "//div[@class='note-text']/p")
    public WebElement AddedNotes;



    String  xpathOfCountOfNotes = "//div[@class='note-content']";

    public void addNotesOnContactRecord(String notes){
    int countOfNotes = GLOBAL_GENERIC.getTheWebElementsCount(xpathOfCountOfNotes);
        //div[@class='ui segment custom-note-container']/div[@class='note-content']/div/p
        addNoteButton.click();
        Assert.assertEquals(addNotePopUpHeader.getText(),"Add Note");
        textAreaOfNotes.sendKeys(notes);
        GLOBAL_GENERIC.locateAndGetWebElement(CommonXpath.xpathOfSaveButton).click();
        countOfNotes = countOfNotes + 1;
        String dynamicXpath = "//div[@class='ui segment custom-note-container']/div[@class='note-content']["
                               +countOfNotes+
                                "]/div/p";
        Assert.assertEquals(GLOBAL_GENERIC.locateAndGetWebElement(dynamicXpath).getText(),notes);
        ScreenshotUtility.chalBetaSelfielelele("AddedNotesOnContactOverviewPage");
    }

    public void deleteRecordFromViewPage(String nameOfTheContact) {
        try {
            new ContactsOverviewResource().navigateToContactDetails(nameOfTheContact);
            GLOBAL_GENERIC.
                    locateAndGetWebElement(CommonXpath.xpathOfDeleteIcon).click();
            Thread.sleep(1000);
            GLOBAL_GENERIC.
                    deleteConfirmationPopUp(true);
            GLOBAL_GENERIC.
                    navigateToModule(GLOBAL_STATIC.nameOfModule[0]);
            boolean flag = ContactsGlobalResource.
                    checkForContactRecord(nameOfTheContact);
            Assert.assertEquals(false,flag);
            ScreenshotUtility.chalBetaSelfielelele("checkOnDeletedRecord_"+nameOfTheContact);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        }

    public void addCaseFromContactViewPage(String nameOfTheContact, int  casesTestDataRowInExcel){
        try{
            new ContactsOverviewResource().navigateToContactDetails(nameOfTheContact);
            addCaseButton.click();
            CasesGlobalResource cgr = new CasesGlobalResource();
            cgr.createCases(casesTestDataRowInExcel);
            CasesOverview co = new CasesOverview();
            co.deleteTheCasesFromOverviewPage("Personal_Loan");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public void validateTheTabsOnContactsViewPage() {
        for (int i = 0; i <listOfTabs.length; i++) {
            String buildDynamicXpath = "//a[text()='" + listOfTabs[i] + "']";
            Assert.assertEquals(GLOBAL_GENERIC.getTheWebElementStatus(buildDynamicXpath), true);
            GLOBAL_GENERIC.locateAndGetWebElement(buildDynamicXpath).click();

            if (i == 0) {
                String buildDynamicXpath1 = "//i/parent::div[text()='" + listOfTabs[i+1] + "']";
                Assert.assertEquals(GLOBAL_GENERIC.getTheWebElementStatus(buildDynamicXpath1), true);

            } else if (i == 1 || i == 2) {
                String buildDynamicXpath1 = "//i/parent::div[text()='" + listOfTabs[i] + "']";
                Assert.assertEquals(GLOBAL_GENERIC.getTheWebElementStatus(buildDynamicXpath1), true);

            } else if(i>2 && i<9){
                String buildDynamicXpath2 = "//i/parent::h4[text()='" +listOfTabs[i]+ "']";
                Assert.assertEquals(GLOBAL_GENERIC.getTheWebElementStatus(buildDynamicXpath2), true);
            }
        }

        ScreenshotUtility.chalBetaSelfielelele("TabsInContactViewPage");

    }







}
