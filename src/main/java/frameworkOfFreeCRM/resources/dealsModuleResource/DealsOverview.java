package frameworkOfFreeCRM.resources.dealsModuleResource;


import frameworkOfFreeCRM.resources.globalResource.CommonXpath;
import frameworkOfFreeCRM.resources.globalResource.GLOBAL_GENERIC;
import frameworkOfFreeCRM.resources.staticResource.GLOBAL_STATIC;
import frameworkOfFreeCRM.utilities.screenshotUtilities.ScreenshotUtility;
import org.openqa.selenium.By;


public class DealsOverview {
    /*This method is to validate the column name in the dealsModulePipeline module overview screen.
     Default column is an array with the list of different column names.
     captures Screenshot and save the evidence by using method chalBetaSelfielelele */


    String[] defaultColoumns={"Title","Company","Close Date","Amount","Status","Stage","Options"};
    public void validateDealsGridDefaultColumn()
    {
        for(int columnnName=0;columnnName<defaultColoumns.length;columnnName++)
        {
            GLOBAL_STATIC.driver.findElement(By.xpath("//th[text()='"+defaultColoumns[columnnName]+"']")).isDisplayed();
        }
        ScreenshotUtility.chalBetaSelfielelele("DefaultColumnOfDealsOverviewPage");
    }
     /* >This method is to click the view icon for specific record in the deal module.
        >check whether it is navigating to specific record or not
        >captures Screenshot and save the evidence by using method chalBetaSelfielelele */

    public void navigateToDealsDetails(String name) throws InterruptedException {
        GLOBAL_STATIC.driver.findElement(By.xpath("//a[text()='"+name+"']/../following-sibling::td/a/button/i[@class='unhide icon']")).click();
        GLOBAL_STATIC.driver.findElement(By.xpath("//span[text()='"+name+"']/i[@class='large money red icon']")).isDisplayed();
        ScreenshotUtility.chalBetaSelfielelele("DealsDetails");
    }
    /*
     >This method is to validate specific edit icon and
     >verify it is navigated to specific deal edit page or not.
     >Here we store the dynamic xpath in a string variable
     >locateAndGetElement we use to generate webElement.*/
    public void navigateToDealsEditScreen(String title){
        String dynamicXpathOfEditIcon = "//a[text()='"+title+"']/../following-sibling::td/a/button/i[@class='edit icon']";
        GLOBAL_GENERIC.locateAndGetWebElement(dynamicXpathOfEditIcon).click();
        ScreenshotUtility.chalBetaSelfielelele("DealsEditPage");
        String dynamicXpathOfDealsTitle = "//span[text()='"+title+"']";
        GLOBAL_GENERIC.locateAndGetWebElement(dynamicXpathOfDealsTitle).isDisplayed();
        GLOBAL_GENERIC.locateAndGetWebElement(CommonXpath.xpathOfSaveButton).isDisplayed();
    }
    // This method is to validate the delete icon for specific deal
    public void deleteTheDealFromOverviewPage(String title){
        String dynamicXpathOfDeleteIcon = "//a[text()='"+title+"']/../following-sibling::td/button/i[@class='trash icon']";
        GLOBAL_GENERIC.locateAndGetWebElement(dynamicXpathOfDeleteIcon).click();
        GLOBAL_GENERIC.deleteConfirmationPopUp(true);
        ScreenshotUtility.chalBetaSelfielelele( "record does not exists");
    }
}



