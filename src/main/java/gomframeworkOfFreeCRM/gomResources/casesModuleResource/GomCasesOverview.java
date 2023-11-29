package gomframeworkOfFreeCRM.gomResources.casesModuleResource;

import frameworkOfFreeCRM.resources.globalResource.CommonXpath;
import frameworkOfFreeCRM.resources.globalResource.GLOBAL_GENERIC;
import frameworkOfFreeCRM.resources.staticResource.GLOBAL_STATIC;
import frameworkOfFreeCRM.utilities.screenshotUtilities.ScreenshotUtility;
import gomframeworkOfFreeCRM.gomResources.globalResource.GomGLOBAL_GENERIC;
import org.openqa.selenium.By;
import org.testng.Assert;

//Validating the default columns values of Cases module Homepage screen.
public class GomCasesOverview {

  //  public casesOverview(){PageFactory.initElements(GLOBAL_STATIC.driver, this);}


    String[] defaultColumns = {"Title", "Status", "Close Date", "Options"};

    /**
     * Validate the cases default columns in cases overview screen.
     * Taking Screenshot by using ScreenshotUtility for the testcase Evidence */
    public void validateCasesDefaultColumn() throws InterruptedException {
        int length = defaultColumns.length;
        for (int index = 0; index < length; index++) {
            boolean defaultFlag =GLOBAL_STATIC.driver.findElement(By.xpath("//th[text()='" + defaultColumns[index] + "']")).isDisplayed();
            Assert.assertEquals(defaultFlag,true);
        }
        ScreenshotUtility.chalBetaSelfielelele("DefaultColumnOfCasesOverviewPage");

    }

    /**
     * Validate the view icon behaviour by passing case name from the Excel data
     *Taking Screenshot by using ScreenshotUtility for the testcase Evidence */
    public void navigateToCaseDetails(String titleName) throws InterruptedException {
        GLOBAL_STATIC.driver.findElement(By.xpath("//a[text()='" + titleName + "']/../following-sibling::td/a/button/i[@class='unhide icon']")).click();
        GLOBAL_STATIC.driver.findElement(By.xpath("//span[text()='" + titleName + "']/i[@class='large comments red icon']")).isDisplayed();
        ScreenshotUtility.chalBetaSelfielelele("ValidatingCasesViewIcon");
    }

    /**
     * Validate the Edit icon behaviour by passing case name from the Excel data
     * We are passing the xpathOf edit icon to the method(locateAndGetWebElement).
     * Taking Screenshot by using ScreenshotUtility for the testcase Evidence */
    public void validateTheCasesEditIcon(String name) {
        String casesXpathOfEditIcon = "//a[text()='" + name + "']/../following-sibling::td/a/button/i[@class='edit icon']";
        GLOBAL_GENERIC.locateAndGetWebElement(casesXpathOfEditIcon).click();
        String dynamicXpathOfContactName = "//span[text()='" + name + "']";
        GLOBAL_GENERIC.locateAndGetWebElement(dynamicXpathOfContactName).isDisplayed();
        GLOBAL_GENERIC.locateAndGetWebElement(CommonXpath.xpathOfSaveButton).isDisplayed();
        ScreenshotUtility.chalBetaSelfielelele("ValidatingCasesEditIcon");
    }

    /**
     * validate the delete icon behaviour by clicking delete icon in the cases overview screen
     * Getting the case name as a parameter from the Excel data and delete the case record.
     * After deleting the record,we are checking whether the record is exists or not.
     **/
    public void deleteTheCasesFromOverviewPage(String name) {
        String dynamicXpathOfDeleteIcon = "//a[text()='"+name+"']/../following-sibling::td/button/i[@class='trash icon']";
        GomGLOBAL_GENERIC.locateAndGetWebElement(dynamicXpathOfDeleteIcon).click();
        GomGLOBAL_GENERIC.deleteConfirmationPopUp(true);
    }
}