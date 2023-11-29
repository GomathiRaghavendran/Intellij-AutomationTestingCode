package frameworkOfFreeCRM.resources.globalResource;

import frameworkOfFreeCRM.resources.globalResource.CommonXpath;
import frameworkOfFreeCRM.resources.staticResource.GLOBAL_STATIC;
import frameworkOfFreeCRM.utilities.screenshotUtilities.ScreenshotUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class GLOBAL_GENERIC {

    public static void navigateToModule(String nameOfTheModule)  {
        GLOBAL_STATIC.driver.findElement(By.xpath("//span[text()='"+nameOfTheModule+"']")).click();
        // GLOBAL_STATIC.driver.findElement(By.xpath(xpathOfApplicationHeader)).click();
        GLOBAL_STATIC.driver.navigate().refresh();
        GLOBAL_STATIC.driver.findElement(By.xpath("//span[@class='selectable ']")).isDisplayed();
        ScreenshotUtility.chalBetaSelfielelele(nameOfTheModule +"_module");
    }

    public static WebElement locateAndGetWebElement(String xpathOfTheElement){
        WebElement element = GLOBAL_STATIC.driver.findElement(By.xpath(xpathOfTheElement));
        return  element;
    }
    /** Created below method to confirm whether delete confirmation popup is appeared once after clicking on the delete icon  */
    public static void deleteConfirmationPopUp(boolean deleteConfirmation){
        String  expectedDeletePopUpHeaderText = "Confirm Deletion";
        String  actualDeletePopUpHeaderText = locateAndGetWebElement(CommonXpath.xpathOfDeletePopUpHeader).getText();
        Assert.assertEquals(expectedDeletePopUpHeaderText,actualDeletePopUpHeaderText);
        String  expectedDeletePopUpConfirmationMessage = "Are you sure you want to delete this record? Deleted records can be recovered via the rubbish bin.";
        String  actualDeletePopUpConfirmationMessage = locateAndGetWebElement(" //div[@class='content']/p").getText();
        Assert.assertEquals(expectedDeletePopUpConfirmationMessage,actualDeletePopUpConfirmationMessage);
        if(deleteConfirmation == true) {
            locateAndGetWebElement(CommonXpath.xpathOfDeleteButton).click();
            ScreenshotUtility.chalBetaSelfielelele("afterDeletingTheRecord");
        }
        else
         locateAndGetWebElement(CommonXpath.xpathOfCancelButton).click();

    }

    public static boolean getTheWebElementStatusV1(WebElement  wb){
        boolean  statusFlag = false;
        try {
           statusFlag = wb.isDisplayed();
        } catch (NoSuchElementException e){

        }
        return  statusFlag;
    }

    public static boolean getTheWebElementStatus(String  xpathOfWebElement){
        boolean  statusFlag = false;
        try {
            statusFlag = GLOBAL_STATIC.driver.findElement(By.xpath(xpathOfWebElement)).isDisplayed();
        } catch (NoSuchElementException e){
            System.out.println(e);
        }
        return  statusFlag;
    }


    public static int getTheWebElementsCount(String xpathOfWebElement) {
        int count = GLOBAL_STATIC.driver.findElements(By.xpath(xpathOfWebElement)).size();
        return  count;
    }



    public static void takeCareOfLoadingTableRow(){
        new WebDriverWait(GLOBAL_STATIC.driver, Duration.ofSeconds(2))
                .until(ExpectedConditions.
                        invisibilityOfAllElements(
                                GLOBAL_GENERIC.
                                        locateAndGetWebElement("//tr/td[contains(.,'Loading')]")));
    }





}
