package frameworkOfFreeCRM.resources.callModuleResource;

import frameworkOfFreeCRM.resources.globalResource.CommonXpath;
import frameworkOfFreeCRM.resources.globalResource.GLOBAL_GENERIC;
import frameworkOfFreeCRM.resources.staticResource.GLOBAL_STATIC;
import frameworkOfFreeCRM.utilities.screenshotUtilities.ScreenshotUtility;
import org.openqa.selenium.By;

public class CallOverviewResources {
    //Array for call grid overview default column
    String[] defaultCallColumn = {"Participants", "Type", "Status", "Duration", "Call Time", "Options"};


    /** in screenshotUtility we are typecasting our driver to Interface TakesScreenshot, now we can access the
     method getscreenshot. this method helps in capturing the test evidence and storing it into
     given directory.
     */
    public void validateCallsGridDefaultColumn() {

        int length = defaultCallColumn.length;
        for (int index = 0; index < length; index++) {

            GLOBAL_STATIC.driver.findElement(By.xpath("//th[text()='" + defaultCallColumn[index] + "']")).isDisplayed();
        }
        ScreenshotUtility.chalBetaSelfielelele("CallsOverviewDefaultColumn");
    }

    /**
      In this method we are validating calls view icon, when we click on view icon,we are navigated to call details page
      and on this page validating the field call type
     */
    public void navigateToCallsDetails(String typeOfCall) {

        GLOBAL_STATIC.driver.findElement(By.xpath("//td[text()='" + typeOfCall + "']/../td/a/button/i[@class='unhide icon']")).click();
        GLOBAL_STATIC.driver.findElement(By.xpath("//span[text()='Call']")).isDisplayed();
        ScreenshotUtility.chalBetaSelfielelele("ShowCallDetails");
    }

    /**
     * In this method we are validating calls edit icon,
     * when we click on edit icon,we are navigated to call edit page
     * and on this page validating the field call time and save button
     **/
    public void navigateToCallsEditPage(String timeOfCall) {
        String xpathOfEditIcon = "//td[text()='" + timeOfCall + "']/../td/a/button/i[@class='edit icon']";
        GLOBAL_GENERIC.locateAndGetWebElement(xpathOfEditIcon).click();
        GLOBAL_GENERIC.locateAndGetWebElement(CommonXpath.xpathOfSaveButton).isDisplayed();
        ScreenshotUtility.chalBetaSelfielelele("CallsEditPage");
    }

   /**validate the popup message after clicking delete icon on overview page
    if validation is true delete the record**/
    public void deleteTheCallFromOverviewPage(String  calltime) {
        String  dynamicXpathOfDeleteIcon = "//td[text()='"+calltime+"']/../td/button/i[@class='trash icon']";
        GLOBAL_GENERIC.locateAndGetWebElement(dynamicXpathOfDeleteIcon).click();
        GLOBAL_GENERIC.deleteConfirmationPopUp(true);
        ScreenshotUtility.chalBetaSelfielelele("DeletePopUpMessage");

    }
}
