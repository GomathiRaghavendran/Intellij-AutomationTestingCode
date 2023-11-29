package frameworkOfFreeCRM.resources.tasksModuleResource;

import frameworkOfFreeCRM.resources.globalResource.CommonXpath;
import frameworkOfFreeCRM.resources.globalResource.GLOBAL_GENERIC;
import frameworkOfFreeCRM.resources.staticResource.GLOBAL_STATIC;
import frameworkOfFreeCRM.utilities.screenshotUtilities.ScreenshotUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class TasksOverview {


    public TasksOverview() {

        PageFactory.initElements(GLOBAL_STATIC.driver, this);
    }

    //xpath for delete icon on records row.

    String[] defaultColumns = {"Title", "Type", "Status", "Due Date", "Close Date", "Options"};
    //Validating Tasksgrid default column and taking screenshot as an evidence that all defaults columns displayed or not
    public void validateTasksGridDefaultColumn() {
        int length = defaultColumns.length;
        for (int p = 0; p < length; p++) {
            GLOBAL_STATIC.driver.findElement(By.xpath("//th[text()='" + defaultColumns[p] + "']")).isDisplayed();
        }
        ScreenshotUtility.chalBetaSelfielelele("defaultColumnOfTasksOverviewPage");
    }

    //Navigate to task details screen and taking screenshot of task details page
    public void navigateToTaskDetails(String title) {
        GLOBAL_STATIC.driver.findElement(By.xpath("//a[text()='" + title + "']/../following-sibling::td/a/button/i[@class='unhide icon']")).click();
        GLOBAL_STATIC.driver.findElement(By.xpath("//span[text()='" + title + "']/i[@class='large tasks red icon']")).isDisplayed();

        ScreenshotUtility.chalBetaSelfielelele("taskDetailsOf"+ title +"Task");
    }

    //Navigate to tasks edit screen after clicking the edit button and taking screenshot of edit page of the task
    public void navigateToEditIconTaskScreen(String title) {

        //build dynamicXpath and call the locateandgetwebelement and perform the action

        String dynamicXpathOfEditIcon = "//a[text()='" + title + "']/../following-sibling::td/a/button/i[@class='edit icon']";
        GLOBAL_GENERIC.locateAndGetWebElement(dynamicXpathOfEditIcon).click();
        //In this class we transfer locateAndGetWebElement method and we are calling it.

        String dynamicXpathOfTitleName = "//span[text()='" + title + "']";
        GLOBAL_GENERIC.locateAndGetWebElement(dynamicXpathOfTitleName).isDisplayed();

        GLOBAL_GENERIC.locateAndGetWebElement(CommonXpath.xpathOfSaveButton).isDisplayed();

        ScreenshotUtility.chalBetaSelfielelele("editPageOf"+ title +"Task");
    }

    public void deleteTheTaskFromOverviewPage(String title) {
        //Here we created dynamic xpath method to delete the record of task
        String dynamicXpathOfDeleteIcon = "//a[text()='" + title + "']/../following-sibling::td/button/i[@class='trash icon']";
        GLOBAL_GENERIC.locateAndGetWebElement(dynamicXpathOfDeleteIcon).click();
        //We are calling delete Confirmation pop up method from global generic class.
        //this method is to check Delete confirmation popup is coming or not.If it's true then the process will run line by line.
        GLOBAL_GENERIC.deleteConfirmationPopUp(true);
        ScreenshotUtility.chalBetaSelfielelele("deleted"+ title +"TaskRecord");


    }
}
