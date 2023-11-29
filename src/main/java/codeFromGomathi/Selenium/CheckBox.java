package codeFromGomathi.Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckBox {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webDriver.Chrome.driver", "C:\\Users\\gomat\\Desktop\\Intellij\\Drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
       /** driver.get("https://www.google.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/span/div/div/div/div[3]/div[1]/button[2]/div")).click();
        driver.navigate().to("https://demo.guru99.com/test/radio.html");
        driver.manage().window().maximize();
       driver.switchTo().frame("gdpr-consent-notice");
       driver.findElement(By.xpath("/html/body/app-root/app-theme/div/div/app-notice/app-theme/div/div/app-home/div/div[2]/app-footer/div/div[2]/app-action-buttons/div/button[3]")).click();
       //Switching to original window
        driver.switchTo().defaultContent();
        //Clicking on Radio button
       //driver.findElement(By.id("vfb-7-1")).click();
        //driver.findElement(By.id("vfb-7-2")).click();
        driver.findElement(By.id("vfb-7-3")).click();
        //Clicking on Checkbox
        driver.findElement(By.id("vfb-6-0")).click();
        driver.findElement(By.id("vfb-6-1")).click();
        driver.findElement(By.id("vfb-6-2")).click();*/

       driver.get("https://automationstepbystep.com/");
       driver.findElement(By.xpath("//*[@id=\'popmake-1065\']/button")).click();

        

        

    
        
        


    }
}
