package gomframeworkOfFreeCRM.gomResources.globalResource;

import frameworkOfFreeCRM.resources.globalResource.GLOBAL_GENERIC;
import frameworkOfFreeCRM.resources.staticResource.GLOBAL_STATIC;
import gomframeworkOfFreeCRM.gomResources.staticReource.GomGLOBAL_STATIC;
import gomframeworkOfFreeCRM.gomUtilities.ScreenshotUtility.GomScreenshotUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.tracing.opentelemetry.SeleniumSpanExporter;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class GomGLOBAL_GENERIC {
    /**
     * This method deals with  navigating to respective modules
     * after navigating refresh the page
     */

    public static void navigateToModule(String nameOfTheModule) throws InterruptedException {

        GomGLOBAL_STATIC.driver.findElement(By.xpath("//span[text()='" + nameOfTheModule + "']")).click();
        //GomGLOBAL_STATIC.driver.findElement(By.xpath(xpathOfApplicationHeader)).click();
        GomGLOBAL_STATIC.driver.navigate().refresh();
        Thread.sleep(1000);
        GomScreenshotUtility.chaLBetaSelfieLeLele(nameOfTheModule + "_module.png");
    }

    /**
     * This method deals with to get rid of GomGlobalStatic.driver.findElement(By.xpath()) through out the program
     */
    public static WebElement locateAndGetWebElement(String xpathOfTheElement) {
        WebElement element = GomGLOBAL_STATIC.driver.findElement(By.xpath(xpathOfTheElement));
        return element;
    }

    public static boolean deleteConfirmationPopUp(boolean deleteConfirmation) {
        String expectedDeletePopupHeaderText = "Confirm Deletion";
        String actualDeletePopupHeaderText = GomGLOBAL_GENERIC.locateAndGetWebElement(GomCommonXpath.XpathOfDeletePopUpHeader).getText();
        Assert.assertEquals(expectedDeletePopupHeaderText, actualDeletePopupHeaderText);
        String expectedDeletePopUpConfirmationMessage = "Are you sure you want to delete this record? Deleted records can be recovered via the rubbish bin.";
        String actualDeletePopUpConfirmationMessage = GomGLOBAL_GENERIC.locateAndGetWebElement("//div[@class='content']/p").getText();
        Assert.assertEquals(expectedDeletePopUpConfirmationMessage, actualDeletePopUpConfirmationMessage);
        if (deleteConfirmation == true) {
            GomScreenshotUtility.chaLBetaSelfieLeLele("BeforeDeletingTheCompanyName.png");
            GomGLOBAL_GENERIC.locateAndGetWebElement(GomCommonXpath.xpathOfDeleteButton).click();
            GomScreenshotUtility.chaLBetaSelfieLeLele("AfterDeletingTheCompanyName.png");
        } else {
            GomGLOBAL_GENERIC.locateAndGetWebElement(GomCommonXpath.xpathOfCancelButton).click();

        }
        return true;
    }

    public static boolean getTheWebElementStatus(String xpathOfWebElement) {
        boolean statusFlag = false;
        try {
            statusFlag = GomGLOBAL_STATIC.driver.findElement(By.xpath(xpathOfWebElement)).isDisplayed();
        } catch (NoSuchElementException e) {

        }
        return statusFlag;
    }

    /**
     * This method deals with the count of Web Elements
     * FindElements method will return the list of Web Elements
     * Using size method we can get the list of size
     * and it will return in integer
     */
    public static int getTheWebElementsCount(String xpathOfWebElement) {
        int count = GomGLOBAL_STATIC.driver.findElements(By.xpath(xpathOfWebElement)).size();
        return count;

    }

    public static void takeCareOfLoadingTableRow() {
        new WebDriverWait(GomGLOBAL_STATIC.driver, Duration.ofSeconds(4))
                .until(ExpectedConditions.
                        invisibilityOfAllElements(
                                GomGLOBAL_GENERIC.
                                        locateAndGetWebElement("//tr/td[contains(.,'Loading')]")));

    }
}



