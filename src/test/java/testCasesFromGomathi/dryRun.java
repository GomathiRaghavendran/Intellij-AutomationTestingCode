package testCasesFromGomathi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class dryRun {
    WebDriver driver;
    @BeforeClass
    public void initBrow() throws InterruptedException {
        System.setProperty("WebDriver.Chrome.driver", "C:\\Users\\gomat\\Desktop\\Intellij\\Drivers\\chromedriver.exe");
        driver= new ChromeDriver();
        Thread.sleep(3000);
        //driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }
    @Test(priority = 1)
    public void verifyTitle()
    {
        String PageTitle = driver.getTitle();
        System.out.println("Name of the Title :"+PageTitle);
        Assert.assertEquals("OrangeHRM", PageTitle);
    }

    @Test(priority = 2)
    public void verifyLogo() throws InterruptedException {
        Thread.sleep(5000);
        boolean LogoResult = driver.findElement(By.xpath("//img[@alt='company-branding']")).isDisplayed();
        System.out.println("Is logo displayed :"+LogoResult);
        Assert.assertTrue(LogoResult);
        System.out.println("End of the test");
    }

   //*@AfterClass
    public void tearDown()
   {
        System.out.println("Closing the browser");
        driver.quit();
    }//

    @Test (priority = 3)
    public void logIN() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(4000);
        boolean HeaderStatus = driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/header/div[1]/div[1]/span/h6")).isDisplayed();
        Assert.assertTrue(HeaderStatus);
    }


    @Test(priority = 4)
    void admin() throws InterruptedException {
        Thread.sleep(5000);
        boolean HeaderStatus1 = driver.findElement(By.xpath("//*[@id='app']/div[1]/div[1]/aside/nav/div[2]/ul/li[1]/a")).isDisplayed();
        driver.findElement(By.xpath("//span[text()='Admin']")).click();
        Thread.sleep(3000);
        boolean HeaderStatus2 = driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/header/div[1]/div[1]/span/h6[2]")).isDisplayed();
        Assert.assertTrue(HeaderStatus1);
        Assert.assertTrue(HeaderStatus2);
        WebElement ele =driver.findElement(By.xpath("//span[@class='oxd-topbar-body-nav-tab-item']"));
        ele.click();
        WebElement ele1=driver.findElement(By.xpath("//*[@id=\'app\']/div[1]/div[1]/header/div[2]/nav/ul/li[1]/ul/li/a"));
        ele1.click();
    }


    }





