package testCasesFromVenu;

import codeFromVenu.seleniumConcept.LoginPageResource.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

public class ParameterizedTest {

    WebDriver driver;
    LoginPage  lp;

    void launchBrowser(String browser){

        if(browser.equals("Chrome")|| browser.equals("chrome") ) {
            driver = new ChromeDriver();
        }
        if(browser.equals("FireFox")|| browser.equals("firefox") )
        {
            driver = new FirefoxDriver();
        }
        if (browser == "Edge") {
            driver = new EdgeDriver();
        }
    }

    @Parameters({"applicationUrl","browser"})
    @BeforeMethod(alwaysRun = true)
    public void setup(String website, String br) throws IOException {
        launchBrowser(br);
        lp = new LoginPage();
        driver.manage().window().maximize();
        driver.get(website);
    }

    @Parameters("email")
    @Test
    public void validUserNameAndValidPassword(String un) throws InterruptedException {
        lp.enterUserNameAndPassword(driver,un,"Tirupathi1@");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//b[text()='Tech Radar']")).isDisplayed();
    }

    @AfterMethod
    public void teardown(){
        driver.close();
    }
}
