package codeFromVenu.seleniumConcept.waits.implicitWait;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ImplicitWaitConcept {
    public static void main(String[] args) {
        WebDriver d  = new ChromeDriver();
        d.manage().window().maximize();
        d.get("https://www.freecrm.com/");
        d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        d.findElement(By.xpath("//span[text()='Log In']")).click();
        d.findElement(By.xpath("//input[@name='email']")).sendKeys("tammivenu@gmail.com");
        d.close();
    }
}
