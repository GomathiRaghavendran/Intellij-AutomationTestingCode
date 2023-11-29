package frameworkOfFreeCRM.resources.companiesModuleResource;

import frameworkOfFreeCRM.resources.globalResource.CommonXpath;
import frameworkOfFreeCRM.resources.globalResource.GLOBAL_GENERIC;
import frameworkOfFreeCRM.resources.staticResource.GLOBAL_STATIC;
import frameworkOfFreeCRM.utilities.screenshotUtilities.ScreenshotUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CompaniesOverviewResource {
    /**Storing the dynamic xpath in string variable and calling in a method.*/
    /**Creating a constructor to call the pageFactory class initElements method for mapping the driver to webElement.*/

    public CompaniesOverviewResource(){
        PageFactory.initElements(GLOBAL_STATIC.driver,this);
    }
    @FindBy(xpath = "//button/i[@class='comments icon']")
    public WebElement addCaseButton;
    String[]  defaultColumns = {"Name","Address","Options"};

    //xpath of delete icon on companies overview page
    public static String xpathOfDeleteIconInCompaniesOverviewPage = "//i[@class='trash icon']";

    /**Method to verify default columns in companies grid page.*/
   /**Taking screenshot by using screenshotUtility for the companiesTestCase Evidence*/
    public void validateCompaniesGridDefaultColumn(){
        int  length = defaultColumns.length;
        for (int index = 0;index<length;index++){
            GLOBAL_STATIC.driver.findElement(By.xpath("//th[text()='"+defaultColumns[index]+"']")).isDisplayed();
        }
        ScreenshotUtility.chalBetaSelfielelele("defaultCompaniesOverViewPage");
}
    /**Creating a method to navigate to view screen.*/
    /**Taking screenshot by using screenshotUtility for the companiesTestCase Evidence*/
    public void navigateToCompaniesDetails(String name)  {
        GLOBAL_STATIC.driver.findElement(By.xpath("//a[text()='"+name+"']/../following-sibling::td/a/button/i[@class='unhide icon']")).click();

        GLOBAL_STATIC.driver.findElement(By.xpath("//span[text()='"+name+"']/i[@class='large building red icon']")).isDisplayed();
        ScreenshotUtility.chalBetaSelfielelele("companiesDetails");
    }

    /**Creating  below method to navigate to edit screen.
     *Initializing the  values of Dynamic Xpath of Edit Icon and Name .
     *Calling LocateAndGetWebElement method which is returning the WebElement.*/
    /**Taking screenshot by using screenshotUtility for the companiesTestCase Evidence*/
    public void navigateCompaniesEditModule(String name){
        String dynamicXpathOfEditIcon="//a[text()='"+name+"']/../following-sibling::td/a/button/i[@class='edit icon']";
        GLOBAL_GENERIC.locateAndGetWebElement(dynamicXpathOfEditIcon).click();

        String dynamicXpathOfCompaniesName="//input[@value='"+name+"']";
        GLOBAL_GENERIC.locateAndGetWebElement(dynamicXpathOfCompaniesName);

        GLOBAL_GENERIC.locateAndGetWebElement(CommonXpath.xpathOfSaveButton).isDisplayed();
        ScreenshotUtility.chalBetaSelfielelele("companiesEdit");
    }
    /**Creating below method to delete the company.*/
    /**Taking screenshot by using screenshotUtility for the companiesTestCase Evidence*/
    public void deleteTheCompanyFromOverviewPage(String name){
        /**
        String dynamicXpathOfDeleteIcon = "//td/a[text()='"+name+"']/../following-sibling::td/button/i[@class='trash icon']";
        GLOBAL_GENERIC.locateAndGetWebElement(dynamicXpathOfDeleteIcon).click();
        GLOBAL_GENERIC.deleteConfirmationPopUp(true);
       ScreenshotUtility.chalBetaSelfielelele("deleteCompanyFromOverViewPage");
         **/
        String  dynamicXpathOfDeleteIcon = "//a[text()='"+name+"']/../following-sibling::td/button/i[@class='trash icon']";
        GLOBAL_GENERIC.locateAndGetWebElement(dynamicXpathOfDeleteIcon).click();
        GLOBAL_GENERIC.deleteConfirmationPopUp(true);
        ScreenshotUtility.chalBetaSelfielelele("DeleteCompany");
    }
}

