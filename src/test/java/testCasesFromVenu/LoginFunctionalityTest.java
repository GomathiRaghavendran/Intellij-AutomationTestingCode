package testCasesFromVenu;

import codeFromVenu.seleniumConcept.LoginPageResource.DataTravelUseCase;
import codeFromVenu.seleniumConcept.LoginPageResource.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

@Listeners({codeFromVenu.seleniumConcept.Listeners.TellingLies.class,frameworkOfFreeCRM.utilities.extentReports.ExternalReports.class})
public class LoginFunctionalityTest {
    String invalidUserName = "tammivnu@gmail.com";
    String invalidPassword = "Tirpathi1@";
    String xpathOfTR = "//b[text()='TechRadar']";
    WebDriver driver;
    LoginPage  lp;
    Properties  prop;

    void launchBrowser(){
        String  browser = prop.getProperty("browser");
        if(browser.equals("Chrome")|| browser.equals("chrome") ) {
            driver = new ChromeDriver();
        }
        if(browser.equals("FireFox")|| browser.equals("Firefox") )
        {
            driver = new FirefoxDriver();
        }
        if (browser == "Edge") {
            driver = new EdgeDriver();
        }
    }

    @BeforeMethod(alwaysRun = true)
    public void setup() throws IOException {
        FileInputStream file = new FileInputStream("src/main/java/codeFromVenu/propertiesConcept/config.properties");
        prop = new Properties();
        prop.load(file);
        launchBrowser();
        lp = new LoginPage();
        driver.manage().window().maximize();
        driver.get(prop.getProperty("applicationURL"));
    }
    @AfterMethod(alwaysRun = true)
    public void teardown(){
        driver.close();
    }

    @Test (priority=1,groups ={"positiveCase"})
    public void validUserNameAndValidPassword() throws InterruptedException {
        lp.enterUserNameAndPassword(driver,prop.getProperty("username"), prop.getProperty("password"));
        Thread.sleep(3000);
        driver.findElement(By.xpath(xpathOfTR)).isDisplayed();
    }

    @Test(priority=2,groups = {"negativeCase"})
    public void validUserNameAndInvalidPassword() throws InterruptedException {
        lp.enterUserNameAndPassword(driver,prop.getProperty("username"),invalidPassword);
        boolean returnFlag = lp.validErrorMessage(driver);
        Assert.assertEquals(returnFlag,true);
    }

    @Test(priority=3,groups = {"negativeCase"})
    public void InvalidUserNameAndValidPassword() throws InterruptedException {
        lp.enterUserNameAndPassword(driver,invalidUserName, prop.getProperty("password"));
        boolean returnFlag = lp.validErrorMessage(driver);
        Assert.assertEquals(returnFlag,true);
    }

    @Test(priority=4,groups = {"negativeCase"})
    public void invalidUserNameAndInvalidPassword() throws InterruptedException {
        lp.enterUserNameAndPassword(driver,invalidUserName,invalidPassword);
        boolean returnFlag = lp.validErrorMessage(driver);
        Assert.assertEquals(returnFlag,true);
    }

    @Test
    public void printTheName(){
        String  z = "Elipse";
        DataTravelUseCase  dtuc = new DataTravelUseCase();
        dtuc.myName(z);
    }

}
