package frameworkOfFreeCRM.resources.dealsModuleResource;

import frameworkOfFreeCRM.resources.globalResource.CommonXpath;
import frameworkOfFreeCRM.resources.globalResource.GLOBAL_GENERIC;
import frameworkOfFreeCRM.resources.staticResource.GLOBAL_STATIC;
import frameworkOfFreeCRM.utilities.screenshotUtilities.ScreenshotUtility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import static frameworkOfFreeCRM.resources.globalResource.CommonXpath.xpathOfSaveButton;

public class DealsViewResource {

    public DealsViewResource(){
        PageFactory.initElements(GLOBAL_STATIC.driver,this);
    }
    String[] tabsINDealsViewPage = {"All","Notes","Events","Contacts",
            "Products","Tasks","Cases","Calls","Documents"};

    @FindBy(xpath = "//button/i[@class='comments outline icon']")
    public WebElement addNotesButton;
    @FindBy(xpath ="//textarea")
    public WebElement textAreaOfNotes;
    @FindBy(xpath = "//div[@class='ui modal transition visible active']/div[@class='header']")
    public WebElement addNotePopUpHeader;
    @FindBy(xpath = "//div[@class='note-text']/p")
    public WebElement AddedNotes;
    String  xpathOfCountOfNotes = "//div[@class='note-content']";
    //Below method is to delete the specific record from dealsModulePipeline view page.
    public void deleteARecordFromDealsViewPage(String recordTitleToBeDeleted) throws InterruptedException {
        new DealsOverview().navigateToDealsDetails(recordTitleToBeDeleted);
        GLOBAL_GENERIC.
                locateAndGetWebElement(CommonXpath.xpathOfDeleteIcon).click();
        Thread.sleep(1000);
        GLOBAL_GENERIC.
                deleteConfirmationPopUp(true);
        GLOBAL_GENERIC.
                navigateToModule(GLOBAL_STATIC.nameOfModule[0]);
        boolean flag = DealsGlobalResource.checkDealsRecord(recordTitleToBeDeleted);
        Assert.assertEquals(false,flag);
        ScreenshotUtility.chalBetaSelfielelele("checkOnDeletedRecord_"+recordTitleToBeDeleted);
    }
    //Below method is to add notes to the dealsModulePipeline record from the dealsModulePipeline view page
    public void addNotesOnDealsRecord(String notes){
        int countOfNotes = GLOBAL_GENERIC.getTheWebElementsCount(xpathOfCountOfNotes);
        addNotesButton.click();
        Assert.assertEquals(addNotePopUpHeader.getText(),"Add Note");
        textAreaOfNotes.sendKeys(notes);
        GLOBAL_GENERIC.locateAndGetWebElement(CommonXpath.xpathOfSaveButton).click();
        countOfNotes = countOfNotes+1;
        //This dynamic xpath helps to verify the note added latest
        String dynamicXpath = "//div[@class='ui segment custom-note-container']/div[@class='note-content']["
                +countOfNotes+
                "]/div/p";
        Assert.assertEquals(GLOBAL_GENERIC.locateAndGetWebElement(dynamicXpath).getText(),notes);
    }
    //Below method is to validate available tabs in a specific deal from the dealsModulePipeline view page.
    public void validateTheTabsOnDealsViewPage(){
        for (int i = 0; i <tabsINDealsViewPage.length; i++) {
            String buildDynamicXpath = "//a[text()='"
                    + tabsINDealsViewPage[i] +
                    "']";
            Assert.assertEquals(GLOBAL_GENERIC.getTheWebElementStatus(buildDynamicXpath), true);
            GLOBAL_GENERIC.locateAndGetWebElement(buildDynamicXpath).click();
            if(i == 0) {
                String xpath1 = "//h4/div[text()='" + tabsINDealsViewPage[i+1] + "']/i";
                Assert.assertEquals(GLOBAL_GENERIC.getTheWebElementStatus(xpath1), true);

            }
            else if (i==1 || i==2){
                String xpath1 = "//h4/div[text()='" + tabsINDealsViewPage[i] + "']/i";
                Assert.assertEquals(GLOBAL_GENERIC.getTheWebElementStatus(xpath1), true);
            }
            else if(i>=3 && i<=7){
                String xpath1 = "//div/h4[text()='"+ tabsINDealsViewPage[i] +"']/i";
                Assert.assertEquals(GLOBAL_GENERIC.getTheWebElementStatus(xpath1), true);
            } else if (i==8) {
                String xpath1 = "//div/i[@class= 'clone big icon']";
                Assert.assertEquals(GLOBAL_GENERIC.getTheWebElementStatus(xpath1), true);
            }

        }
        ScreenshotUtility.chalBetaSelfielelele("TabsInDealsViewPage");


    }
}
