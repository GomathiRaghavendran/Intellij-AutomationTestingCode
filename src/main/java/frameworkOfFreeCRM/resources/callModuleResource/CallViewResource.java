package frameworkOfFreeCRM.resources.callModuleResource;

import frameworkOfFreeCRM.resources.contactsModuleResource.ContactsGlobalResource;
import frameworkOfFreeCRM.resources.contactsModuleResource.ContactsOverviewResource;
import frameworkOfFreeCRM.resources.globalResource.CommonXpath;
import frameworkOfFreeCRM.resources.globalResource.GLOBAL_GENERIC;
import frameworkOfFreeCRM.resources.staticResource.GLOBAL_STATIC;
import frameworkOfFreeCRM.utilities.screenshotUtilities.ScreenshotUtility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CallViewResource {

    public CallViewResource(){
        PageFactory.initElements(GLOBAL_STATIC.driver,this);
    }

    @FindBy(xpath = "//i[@class='comments outline icon']")
    WebElement addNoteButton;

    @FindBy(xpath = "//div[@class='ui modal transition visible active']/div[@class='header']")
    WebElement addNotePopUpHeader;

    @FindBy(xpath = "//textarea")
    public WebElement textAreaOfNotes;

    String xpathOfCountNotes="//div[@class='note-content']";

    String[] ListOfTabs = {"Notes","Call Script"};

    /** In this method we are deleting records from view page.
     * Navigating to the specifc record and deleting the record.
     * validating record is deleted from overview page.
     **/
    public void deleteRecordFromCallViewPage(String recordTime)  {
        try{
        new CallOverviewResources().navigateToCallsDetails(recordTime);
        GLOBAL_GENERIC.
                locateAndGetWebElement(CommonXpath.xpathOfDeleteIcon).click();
            Thread.sleep(2000);
        GLOBAL_GENERIC.
                deleteConfirmationPopUp(true);
        GLOBAL_GENERIC.
                navigateToModule(GLOBAL_STATIC.nameOfModule[5]);
        boolean flag = CallGlobalResource.checkForCallRecord(recordTime);
        Assert.assertEquals(false,flag);}
        catch(InterruptedException e){}

    }

    /** In this method we are adding the notes on the specific call record.
     * Clicking on the add notes button in view page.
     * Validating the popup header.
     * After entering the notes, clicking the save button.
     * Validating the added notes
     *  **/
    public void addNotesOnCallRecord(String notes){
        int countOfNotes =GLOBAL_GENERIC.getTheWebElementsCount(xpathOfCountNotes);
        addNoteButton.click();
        Assert.assertEquals(addNotePopUpHeader.getText(),"Add Note");
        textAreaOfNotes.sendKeys(notes);
        GLOBAL_GENERIC.locateAndGetWebElement(CommonXpath.xpathOfSaveButton).click();
        countOfNotes++;
        String dynamicXpath=" //div[@class='note-content']["+countOfNotes+"]/div/p";
        Assert.assertEquals(GLOBAL_GENERIC.locateAndGetWebElement(dynamicXpath).getText(),notes);
        ScreenshotUtility.chalBetaSelfielelele("CheckingForNote");
    }

    /**Test Case for validating tabs on call view page. Here we click on tab "Notes" and "CallScript" dynamically and checking the webElement and icon.
     */
    public void validateTheTabOnCallViewPage(){
        for(int i=0;i<ListOfTabs.length;i++){
            String buildDynamicXpath = "//a[text()='"
                    + ListOfTabs[i] +
                    "']";
            Assert.assertEquals(GLOBAL_GENERIC.getTheWebElementStatus(buildDynamicXpath), true);
            GLOBAL_GENERIC.locateAndGetWebElement(buildDynamicXpath).click();
            if(i==0){
                String xpathOfNotes= "//h4/div[text()='Notes']";
                Assert.assertEquals(GLOBAL_GENERIC.getTheWebElementStatus(xpathOfNotes), true);
                ScreenshotUtility.chalBetaSelfielelele("Notes");

            } else if (i==1) {
                String xpathOfCallScript= "//div/h4[text()='Call Script']";
                Assert.assertEquals(GLOBAL_GENERIC.getTheWebElementStatus(xpathOfCallScript), true);
                ScreenshotUtility.chalBetaSelfielelele("Call Script");


            }
        }

    }
}
