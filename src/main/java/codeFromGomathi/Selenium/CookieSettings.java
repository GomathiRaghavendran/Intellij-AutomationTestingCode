package codeFromGomathi.Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CookieSettings {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webDriver.Chrome.driver", "C:\\Users\\gomat\\Intellij\\Driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/span/div/div/div/div[3]/div[1]/button[2]/div")).click();
       // driver.findElement(By.xpath("//textarea[@id='APjFqb']")).sendKeys("Selenium");
        //driver.manage().deleteAllCookies();

        //driver.navigate().to("https://demo.applitools.com/");
        //driver.findElement(By.xpath("//*[@id='username']")).sendKeys("Anujan");
        //driver.findElement(By.xpath("//*[@id='password']")).sendKeys("1234");
        //driver.findElement(By.xpath("/html/body/div/div/form/div[3]/div[1]/label/input")).click();
    }
}
