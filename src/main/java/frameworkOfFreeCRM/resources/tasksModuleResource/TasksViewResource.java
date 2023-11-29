package frameworkOfFreeCRM.resources.tasksModuleResource;

import frameworkOfFreeCRM.resources.globalResource.CommonXpath;
import frameworkOfFreeCRM.resources.globalResource.GLOBAL_GENERIC;
import frameworkOfFreeCRM.resources.staticResource.GLOBAL_STATIC;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class TasksViewResource {

    public TasksViewResource() {
        PageFactory.initElements(GLOBAL_STATIC.driver, this);
    }

    String[] listOfTabs = {"All", "Notes", "Events", "Calls", "Documents"};


    @FindBy(xpath = "//i[@class='comments outline icon']")
    public WebElement addNotesIcon;
    @FindBy(xpath = "//textarea")
    public WebElement textAreaOfNotes;
    @FindBy(xpath = "//div[@class='note-text']/p")
    public WebElement addedNotes;
    @FindBy(xpath = "//div[@class='ui modal transition visible active']/div[@class='header']")
    public WebElement addNotePopUpHeader;
    String xpathOfCountOfNotes = "//div[@class='note-content']";

    public void addNotesOnTasksRecord(String notes) {
        int countOfNotes = GLOBAL_GENERIC.getTheWebElementsCount(xpathOfCountOfNotes);
        addNotesIcon.click();
        Assert.assertEquals(addNotePopUpHeader.getText(), "Add Note");
        textAreaOfNotes.sendKeys(notes);
        GLOBAL_GENERIC.locateAndGetWebElement(CommonXpath.xpathOfSaveButton).click();
        countOfNotes = countOfNotes + 1;
        String dynamicXpath = "//div[@class='ui segment custom-note-container']/div[@class='note-content']["
                + countOfNotes + "]/div/p";
        Assert.assertEquals(GLOBAL_GENERIC.locateAndGetWebElement(dynamicXpath).getText(), notes);

    }

    public void validateTheTabsOnTaskViewPage() {

        for (int i = 0; i < listOfTabs.length; i++) {
            String buildDynamicXpath = "//a[text()='"
                    + listOfTabs[i] +
                    "']";
            Assert.assertEquals(GLOBAL_GENERIC.getTheWebElementStatus(buildDynamicXpath), true);
            GLOBAL_GENERIC.locateAndGetWebElement(buildDynamicXpath).click();

            if (i == 0) {
                String buildDynamicXpath1 = "//i/parent::div[text()='"
                        + listOfTabs[i + 1] +
                        "']";
                Assert.assertEquals(GLOBAL_GENERIC.getTheWebElementStatus(buildDynamicXpath1), true);

            } else if (i == 1 || i == 2) {
                String buildDynamicXpath1 = "//i/parent::div[text()='"
                        + listOfTabs[i] +
                        "']";
                Assert.assertEquals(GLOBAL_GENERIC.getTheWebElementStatus(buildDynamicXpath1), true);

            } else if (i >= 3 && i < 5) {
                String buildDynamicXpath2 = "//i/parent::h4[text()='"
                        + listOfTabs[i] +
                        "']";
                Assert.assertEquals(GLOBAL_GENERIC.getTheWebElementStatus(buildDynamicXpath2), true);
            }
        }
    }
}