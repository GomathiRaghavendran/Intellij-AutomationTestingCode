package frameworkOfFreeCRM.resources.casesModuleResource;

import frameworkOfFreeCRM.resources.globalResource.CommonXpath;
import frameworkOfFreeCRM.resources.globalResource.GLOBAL_GENERIC;
import frameworkOfFreeCRM.resources.staticResource.GLOBAL_STATIC;
import frameworkOfFreeCRM.resources.tasksModuleResource.TasksGlobalResource;
import frameworkOfFreeCRM.resources.tasksModuleResource.TasksOverview;
import frameworkOfFreeCRM.utilities.screenshotUtilities.ScreenshotUtility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CasesViewResource {

    public CasesViewResource() {
        PageFactory.initElements(GLOBAL_STATIC.driver, this);
    }

    @FindBy(xpath = "//h4[text()='Tasks']/following-sibling::div/div/a/button")
    public WebElement addTaskButton;
    @FindBy(xpath = "//i[@class='comments outline icon']")
    public WebElement addNoteButton;
    @FindBy(xpath = "//div[@class='ui modal transition visible active']/div[@class='header']")
    public WebElement addNotePopupHeader;
    @FindBy(xpath = "//textarea")
    public WebElement textAreaOfNotes;
    String xpathOfCountOfNotes = "//div[@class='note-text']";

    @FindBy(xpath = "//div[@class='note-text']/p")
    WebElement addedNotes;
    String[] listofviewGridtabs = {"All", "Notes", "Events", "Tasks", "Calls", "Documents"};

    // In below method we create a task record by clicking the task button from the cases view Screen.
    // We pass the task record row number to create a task.
    // After creating the task, we are deleting the same record by passing task name.
    public void createTaskFromCasesViewScreen() throws InterruptedException {
        addTaskButton.click();
        TasksGlobalResource tgr = new TasksGlobalResource();
        tgr.createTasks(13);
        ScreenshotUtility.chalBetaSelfielelele("AfterCreatingTaskRecord");
        TasksOverview to = new TasksOverview();
        to.deleteTheTaskFromOverviewPage("Gmail");
    }

    /**
     * By using below method we are adding the notes on the specific case record.
     * Passing the String Notes as the parameter to enter.
     * Counting the number of notes row (Initially it will be 0 after adding one note it will become 1)
     * Click the add notes button.
     * After entering the text, clicking the save button to add text.
     * Build the dynamic xpath to check the assertion of the added text.
     **/
    public void addNotesOnCaseRecord(String notes) {
        int countOfNotes = GLOBAL_GENERIC.getTheWebElementsCount(xpathOfCountOfNotes);
        addNoteButton.click();
        Assert.assertEquals(addNotePopupHeader.getText(), "Add Note");
        textAreaOfNotes.sendKeys(notes);
        GLOBAL_GENERIC.locateAndGetWebElement(CommonXpath.xpathOfSaveButton).click();
        countOfNotes = countOfNotes + 1;
        String dynamicXpath = "//div[@class='ui segment custom-note-container']/div[@class='note-content']["
                + countOfNotes + "]/div/p";
        Assert.assertEquals(GLOBAL_GENERIC.locateAndGetWebElement(dynamicXpath).getText(), notes);

    }


    public void deleteRecordFromCasesViewPage(String nameofCases) {
        try {
            new CasesOverview().navigateToCaseDetails(nameofCases);
            GLOBAL_GENERIC.locateAndGetWebElement(CommonXpath.xpathOfDeleteIcon).click();
            Thread.sleep(1000);
            GLOBAL_GENERIC.deleteConfirmationPopUp(true);
            GLOBAL_GENERIC.navigateToModule(GLOBAL_STATIC.nameOfModule[4]);
            boolean flag = CasesGlobalResource.checkForCasesRecord(nameofCases);
            Assert.assertEquals(false, flag);
            ScreenshotUtility.chalBetaSelfielelele("validateTabsOnCasesViewPage");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    /**this method will validate the Tabs on the Cases View page
     * we are clicking the Tabs available on the View page and doing Assertion after clicking every Tab
     * //if i=0 the "All" tab doesnt have the "All" view grid(after clicking on tab) that is why i+1 =1 checking after 0 that is from Notes**/

        public void validateTabsOnCasesViewPage() {
            for (int i = 0; i < listofviewGridtabs.length; i++) {
                String buildDynamicXpath = "//a[text()='" + listofviewGridtabs[i] + "']";
                Assert.assertEquals(GLOBAL_GENERIC.getTheWebElementStatus(buildDynamicXpath), true);
                GLOBAL_GENERIC.locateAndGetWebElement(buildDynamicXpath).click();

                if (i == 0) {
                    String buildDynamicxpath1 = "//i/parent::div[text()='" + listofviewGridtabs[i + 1] + "']";
                    ////div[text()='Notes'] can be written like this also
                    //i/parent::div: This part of the XPath expression navigates to the parent element of the <i> element, which should be a <div> element.
                    Assert.assertEquals(GLOBAL_GENERIC.getTheWebElementStatus(buildDynamicxpath1), true);

                } else if (i == 1 || i == 2) {
                    String buildDynamicxpath2 = "//i/parent::div[text()='" + listofviewGridtabs[i] + "']";
                    Assert.assertEquals(GLOBAL_GENERIC.getTheWebElementStatus(buildDynamicxpath2), true);
                } else if (i > 2 && i < 6) {
                    String buildDynamicxpath3 = "//i/parent::h4[text()='" + listofviewGridtabs[i] + "']";
                    Assert.assertEquals(GLOBAL_GENERIC.getTheWebElementStatus(buildDynamicxpath3), true);
                }
                ScreenshotUtility.chalBetaSelfielelele("validateTabsOnCasesViewPage");

            }

        }
    }




