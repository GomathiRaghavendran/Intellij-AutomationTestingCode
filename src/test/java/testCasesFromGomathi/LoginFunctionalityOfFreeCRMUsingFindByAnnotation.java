package testCasesFromGomathi;


import frameworkOfFreeCRM.resources.staticResource.GLOBAL_STATIC;
import gomframeworkOfFreeCRM.gomBase.GomBase;
import gomframeworkOfFreeCRM.gomResources.globalResource.GomLoginPageResource;
import gomframeworkOfFreeCRM.gomResources.staticReource.GomGLOBAL_STATIC;
import gomframeworkOfFreeCRM.gomUtilities.GomExcelUtilities.GomExcelTestDataUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;

import java.io.IOException;

public class LoginFunctionalityOfFreeCRMUsingFindByAnnotation extends GomBase {

    public void LoginFunctionalityOfFreeCRMUsingFindByAnnotation() {
        PageFactory.initElements(GomGLOBAL_STATIC.driver, this);

    }

    @FindBy(xpath = "//span[text()='Log In']")
    WebElement LogIn;
    @FindBy(xpath = "//input[@name='email']")
    WebElement userName;
    @FindBy(xpath = "//input[@name='password']")
    WebElement Password;
    @FindBy(xpath = "//div[text()='Login']")
    WebElement Submit;
    @FindBy(xpath = "//button[text()='Create']")
    WebElement createCompany;
    @FindBy(xpath = "//input[@name='name'][1]")
    WebElement companyNameTextBox;
    @FindBy(xpath = "//input[@placeholder='Street Address']")
    WebElement StreetAddress;
    @FindBy(xpath = "//input[@placeholder='City']")
    WebElement cityName;
    @FindBy(xpath = "//input[@placeholder='State / County']")
    WebElement sc;

    @FindBy(xpath = "//input[@placeholder='Post Code']")
    WebElement pc;
    @FindBy(xpath = "//i[@class='save icon']")
    WebElement saveButton;


    private String getDataFromExcel1(int rowNum, int colNum) {
        String textRetrievedFromExcel1 = GomGLOBAL_STATIC.testData.getCellData("TestDataOfCompaniesName", rowNum, colNum);
        return textRetrievedFromExcel1;
    }

    @Test
    public void createCompanies() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.freecrm.com/");
        PageFactory.initElements(driver, this);
        LogIn.click();
        userName.sendKeys("Gomathi.Balasubramanianmvs@gmail.com");
        Password.sendKeys("Iniyal@2511");
        Submit.click();
        /**GomGLOBAL_STATIC.navigateToModule(GomGLOBAL_STATIC.nameOfModule[1]);
        Thread.sleep(1000);

        createCompany.click();
         Thread.sleep(1000);
         String fn = getDataFromExcel1(2,1);
         companyNameTextBox.sendKeys(fn);
         String ad=getDataFromExcel1(2,2);
         StreetAddress.sendKeys(ad);
         String city=getDataFromExcel1(2,3);
         cityName.sendKeys(city);
         String sc1=getDataFromExcel1(2,4);
         sc.sendKeys(sc1);
         String pc=getDataFromExcel1(2,5);
         sc.sendKeys(pc);*/
    }

}
