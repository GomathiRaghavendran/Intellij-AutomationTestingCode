package testCasesFromGomathi;

import codeFromGomathi.seleniumConcepts.Loginpage.LoginPageResource.CrmLoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class LoginTestCases {

   String userInvalidName="Goamthi.Balasubramanianmvs@gmail.com";

    String inValidPassword="Inial@25";

    String xpathOfCompanyName="//b[text()='Gomathi']";
    WebDriver driver;

    CrmLoginPage clp;

    Properties prop;

    void launchBrowser(){
        String browser= prop.getProperty("browser");

        if(browser.equals("Chrome")|| browser.equals("chrome") ) {
            driver = new ChromeDriver();
        }
        if(browser.equals("FireFox")|| browser.equals("Firefox"))
        {
            driver = new FirefoxDriver();
        }
        if (browser.equals("Edge")|| browser.equals("edge")){
            driver = new EdgeDriver();
        }
    }
    @BeforeMethod(alwaysRun = true)
    public  void setup() throws IOException {
    FileInputStream file= new FileInputStream("src/main/java/codeFromGomathi/PropertiesConcepts/metaData.properties");
    prop= new Properties();
    prop.load(file);
        launchBrowser();
        driver.manage().window().maximize();
        driver.get(prop.getProperty("applicationURL"));
        clp=new CrmLoginPage();
    }

    @AfterMethod(alwaysRun = true)
    public void teardown(){
        driver.close();
    }

    @Test (priority=1,groups ={"positiveCase"})
   public void validUserNameAndValidPassword() throws InterruptedException {
        clp.enterUserNameAndPassword(driver,prop.getProperty("userName"),prop.getProperty("password"));
        driver.findElement(By.xpath(xpathOfCompanyName)).isDisplayed();
    }

    @Test(priority=2,groups = {"negativeCase1"})
    public void invalidUserNameAndValidPassword() throws InterruptedException {
        clp.enterUserNameAndPassword(driver,prop.getProperty("userName"),prop.getProperty("password"));
        boolean returnFlag=clp.validatingErrorMessage(driver);
        Assert.assertEquals(returnFlag,true);
    }
    @Test(priority=3,groups = {"NegativeCase"})
    public void validUserNameAndinValidPassword() throws InterruptedException {
        clp.enterUserNameAndPassword(driver,prop.getProperty("userName"),inValidPassword);
        boolean returnFlag = clp.validatingErrorMessage(driver);
        Assert.assertEquals(returnFlag, true);
    }
    @Test(priority=4,groups = {"NegativeCase"})
    public void inValidUserNameAndinValidPassword() throws InterruptedException {
        clp.enterUserNameAndPassword(driver,userInvalidName,userInvalidName);
        boolean returnFlag=clp.validatingErrorMessage(driver);
        Assert.assertEquals(returnFlag,true);
    }
}

