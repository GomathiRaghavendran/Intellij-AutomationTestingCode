package frameworkOfFreeCRM.resources.contactsModuleResource;

import frameworkOfFreeCRM.resources.globalResource.CommonXpath;
import frameworkOfFreeCRM.resources.globalResource.GLOBAL_GENERIC;
import frameworkOfFreeCRM.resources.staticResource.GLOBAL_STATIC;
import frameworkOfFreeCRM.utilities.screenshotUtilities.ScreenshotUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsOverviewResource {

    public ContactsOverviewResource(){

        PageFactory.initElements(GLOBAL_STATIC.driver, this);
    }



    String[]  defaultColumns = {"Name","Address","Category","Status","Phone","Email","Options"};

    public void validateContactsGridDefaultColumn(){
        int  length = defaultColumns.length;
        for (int index = 0;index<length;index++){
            GLOBAL_STATIC.driver.findElement(By.xpath("//th[text()='"+defaultColumns[index]+"']")).isDisplayed();

        }
        ScreenshotUtility.chalBetaSelfielelele("defaultColumnOfContactsOverviewPage");
    }


    public void navigateToContactDetails(String  name) {
        GLOBAL_STATIC.driver.findElement(By.xpath("//a[text()='"+name+"']/../following-sibling::td/a/button/i[@class='unhide icon']")).click();
        GLOBAL_STATIC.driver.findElement(By.xpath("//span[text()='"+name+"']/i[@class='large user red icon']")).isDisplayed();
        ScreenshotUtility.chalBetaSelfielelele("contactDetails");


    }

    public void navigateToContactEditScreen(String  name) {
        /**
         GLOBAL_STATIC.driver.findElement(By.xpath("//a[text()='"+name+"']/../following-sibling::td/a/button/i[@class='edit icon']")).click();
         GLOBAL_STATIC.driver.findElement(By.xpath("//span[text()='"+name+"']")).isDisplayed();
         */

        String dynamicXpathOfEditIcon = "//a[text()='" + name + "']/../following-sibling::td/a/button/i[@class='edit icon']";
        GLOBAL_GENERIC.locateAndGetWebElement(dynamicXpathOfEditIcon).click();

        String dynamicXpathOfContactName = "//span[text()='" + name + "']";
        GLOBAL_GENERIC.locateAndGetWebElement(dynamicXpathOfContactName).isDisplayed();

        GLOBAL_GENERIC.locateAndGetWebElement(CommonXpath.xpathOfSaveButton).isDisplayed();

        }

        public void deleteTheContactFromOverviewPage(String  name) {
            /**
             GLOBAL_STATIC.driver.findElement(By.xpath("//a[text()='"+name+"']/../following-sibling::td/a/button/i[@class='edit icon']")).click();
             GLOBAL_STATIC.driver.findElement(By.xpath("//span[text()='"+name+"']")).isDisplayed();
             */
            String  dynamicXpathOfDeleteIcon = "//a[text()='"+name+"']/../following-sibling::td/button/i[@class='trash icon']";
            GLOBAL_GENERIC.locateAndGetWebElement(dynamicXpathOfDeleteIcon).click();
            GLOBAL_GENERIC.deleteConfirmationPopUp(true);
          }




}
