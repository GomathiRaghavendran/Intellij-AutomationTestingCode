package codeFromGomathi.seleniumConcepts.MouseOperations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseOperations {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.onlinesbi.sbi/");
        driver.manage().window().maximize();
        WebElement servicesWe=driver.findElement(By.xpath("//a[text()='Services ']"));
        Actions ac=new Actions(driver);
        //ac.moveToElement(servicesWe).build();
        Thread.sleep(2000);
        ac.moveToElement(servicesWe).build().perform();
        Thread.sleep(2000);
        WebElement mobileBankingWe = driver.findElement(By.xpath("//a[text()='Mobile Banking ']"));
        ac.moveToElement(mobileBankingWe).build().perform();


    }
}
