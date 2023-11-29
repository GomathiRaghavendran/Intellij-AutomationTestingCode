package frameworkOfFreeCRM.resources.contactsModuleResource;

import frameworkOfFreeCRM.resources.globalResource.CommonXpath;
import frameworkOfFreeCRM.resources.staticResource.GLOBAL_STATIC;
import frameworkOfFreeCRM.resources.globalResource.GLOBAL_GENERIC;
import frameworkOfFreeCRM.utilities.screenshotUtilities.ScreenshotUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ContactsGlobalResource {
    public ContactsGlobalResource(){

        PageFactory.initElements(GLOBAL_STATIC.driver,this);
    }

    @FindBy(xpath = "//input[@name='first_name']")  WebElement  firstNameTextBox;
    @FindBy(xpath = "//input[@name='last_name']")  WebElement  lastNameTextBox;
    @FindBy(xpath = "//label[text()='Status']/following-sibling::div[@name='status']")  WebElement  statusDropDown;
    @FindBy(xpath = "//input[@placeholder='Number']")  WebElement  phoneNumberTextBox;
    @FindBy(xpath = "//i[@class='save icon']")  WebElement  saveButton;


    private String  getDataFromExcel(int rowNum,int colNum){
        String  textRetrievedFromExcel = GLOBAL_STATIC.testData.getCellData("contactsTestData",rowNum,colNum);
        return  textRetrievedFromExcel;
    }

    public void createContact(int excelTestDataRowNum) throws InterruptedException {
        String fn = getDataFromExcel(excelTestDataRowNum,1);
        String ln = getDataFromExcel(excelTestDataRowNum,2);
        String  nameOfTheContact =    fn +" "+ln;
        boolean  flag = checkForContactRecord(nameOfTheContact);
        if(flag == false) {
            GLOBAL_GENERIC.locateAndGetWebElement(CommonXpath.xpathOfCreateButton).click();
            firstNameTextBox.sendKeys(fn);
            lastNameTextBox.sendKeys(ln);
            statusDropDown.click();
            String statusDropDownValue = getDataFromExcel(excelTestDataRowNum, 3);
            GLOBAL_STATIC.driver.findElement(By.xpath("//span[text()='" + statusDropDownValue + "']")).click();
            phoneNumberTextBox.sendKeys(getDataFromExcel(excelTestDataRowNum, 4));
            saveButton.click();
            GLOBAL_GENERIC.navigateToModule(GLOBAL_STATIC.nameOfModule[0]);
            boolean status = GLOBAL_STATIC.driver.findElement(By.xpath("//a[text()='" + nameOfTheContact + "']")).isDisplayed();
            Assert.assertEquals(status, true);
        }

    }

    public static boolean checkForContactRecord(String name){
        boolean statusOfContact = false;
        try
        {
            statusOfContact = GLOBAL_STATIC.driver.findElement(By.xpath("//a[text()='" + name + "']")).isDisplayed();
            ScreenshotUtility.chalBetaSelfielelele(name+"_contactRecordExists.png");
        } catch (NoSuchElementException e){
            System.out.println("No, We didn't have a record with name of "+name);
            ScreenshotUtility.chalBetaSelfielelele(name+"_contactRecordNotExists.png");
        }
        return statusOfContact;
    }

}
