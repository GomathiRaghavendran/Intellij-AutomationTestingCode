package testCasesFromGomathi;

import codeFromGomathi.seleniumConcepts.Loginpage.LoginPageResource.CrmLoginPage;
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

public class parameterizedTest {
    WebDriver driver;

    CrmLoginPage clp;
    void launchBrowser(String browser){
        if(browser.equals("Chrome")|| browser.equals("chrome") ) {
            driver = new ChromeDriver();
        }
        if(browser.equals("FireFox")|| browser.equals("firefox"))
        {
            driver = new FirefoxDriver();
        }
        if (browser.equals("Edge")|| browser.equals("edge")){
            driver = new EdgeDriver();
        }
    }
    @Parameters({"applicationURL","browser"})
    @BeforeMethod(alwaysRun = true)

    public  void setup(String URL,String br) throws IOException {
       launchBrowser(br);
        driver.manage().window().maximize();
        driver.get(URL);
        clp=new CrmLoginPage();
    }

    @AfterMethod(alwaysRun = true)
    public void teardown(){
       driver.close();
    }

    @Parameters({"email","password"})
    @Test
    public void validUserNameAndValidPassword(String un,String password) throws InterruptedException {
        clp.enterUserNameAndPassword(driver,un,password);
        driver.findElement(By.xpath("//b[text()='Gomathi']")).isDisplayed();
    }
}
