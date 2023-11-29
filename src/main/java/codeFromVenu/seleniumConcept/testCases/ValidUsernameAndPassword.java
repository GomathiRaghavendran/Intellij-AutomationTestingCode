package codeFromVenu.seleniumConcept.testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ValidUsernameAndPassword {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\tammi\\chromedriver.exe");
        System.getProperty("webdriver.chrome.driver");
        WebDriver d  = new ChromeDriver();
        d.manage().window().maximize();
        d.get("https://www.freecrm.com/");
        d.findElement(By.xpath("//span[text()='Log In']")).click();
        d.findElement(By.xpath(" //input[@name='email']")).sendKeys("tammivenu@gmail.com");
        d.findElement(By.xpath("//input[@name='password']")).sendKeys("Tirupathi1@");
        d.findElement(By.xpath("//div[text()='Login']")).click();
        Thread.sleep(3000);
        d.findElement(By.xpath("//b[text()='Tech Radar']")).isDisplayed();
        d.close();

    }
}
