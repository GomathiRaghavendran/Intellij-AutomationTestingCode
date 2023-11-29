package codeFromVenu.seleniumConcept.MouseOperations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseOpeerations {

    public static void main(String[] args) throws InterruptedException {

        WebDriver  driver = new ChromeDriver();
        driver.get("https://www.onlinesbi.sbi/");
        driver.manage().window().maximize();
        WebElement servicesWebElement =  driver.findElement(By.xpath("//a[text()='Services ']"));
       Actions  ac = new Actions(driver);
       ac.moveToElement(servicesWebElement).build().perform();
       Thread.sleep(1000);
       WebElement mobileBankingWebElement = driver.findElement(By.xpath("//a[text()='Mobile Banking ']"));
       ac.moveToElement(mobileBankingWebElement).build().perform();
    }
}
