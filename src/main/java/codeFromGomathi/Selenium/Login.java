package codeFromGomathi.Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {
    public static void main(String[] args) throws InterruptedException {
        //To communicate with  chrome browser. so setting up the correct path to execute exe files
        System.setProperty("webDriver.Chrome.driver", "C:\\Users\\gomat\\Intellij\\Driver\\chromedriver.exe");
        //Creating Chromedriver object to access the methods in it
        WebDriver driver = new ChromeDriver();
        // Using the get method, opening the URL
        driver.get("https://www.shopify.com/");
        Thread.sleep(8000);
        //Below line, clicks the accept all button in the cookie setting which is displayed on the browser
        driver.findElement(By.xpath("/html/body/div[3]/section/div/div/button[2]")).click();
        //Entering email id as input in the Enter your email address text box
        driver.findElement(By.xpath("//input[@placeholder='Enter your email address']")).sendKeys("gomi@gmail.com");
        Thread.sleep(3000);
        //driver.findElement(By.xpath("//button[normalize-space()='Reject all']")).isDisplayed();
        //Clicking the start free trial button
        driver.findElement(By.xpath("//*[@id=\'main\']/section[1]/div[2]/div[1]/div[3]/div/form/div[1]/div/button")).click();
    }
}
