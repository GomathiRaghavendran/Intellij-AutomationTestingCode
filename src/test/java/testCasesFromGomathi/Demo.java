package testCasesFromGomathi;

import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.chrome.ChromeDriver;
        import org.testng.Assert;
        import org.testng.annotations.AfterClass;
        import org.testng.annotations.BeforeClass;
        import org.testng.annotations.Test;

public class Demo {
    WebDriver driver;
    @BeforeClass
    public void initBrow()
    {
        System.setProperty("WebDriver.Chrome.driver", "C:\\Users\\gomat\\Desktop\\Intellij\\Drivers\\chromedriver.exe");
        driver= new ChromeDriver();
        // driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @Test(priority = 1)
    public void verifyTitle()
    {
        String PageTitle = driver.getTitle();
        System.out.println("Name of the Title :"+PageTitle);
        Assert.assertEquals("OrangeHRM",PageTitle);
    }

    @Test(priority = 2)
    public void verifyLogo() throws InterruptedException {
        Thread.sleep(5000);
        boolean LogoResult = driver.findElement(By.xpath("//img[@alt='company-branding']")).isDisplayed();
        System.out.println("Is logo displayed :"+LogoResult);
        Assert.assertTrue(LogoResult);
        System.out.println("End of the test");
    }

          @AfterClass
            public void tearDown()
            {
                System.out.println("Closing the browser");
               driver.quit();
           }

    @Test (priority = 3)
    public void logIN() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input")).sendKeys("Admin");
        driver.findElement(By.xpath("//*[@id=\'app\']/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input")).sendKeys("admin123");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\'app\']/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
        Thread.sleep(3000);
        boolean HeaderStatus = driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/header/div[1]/div[1]/span/h6")).isDisplayed();
        Assert.assertTrue(HeaderStatus);
        System.out.println("Header status:"+HeaderStatus);
    }

}
