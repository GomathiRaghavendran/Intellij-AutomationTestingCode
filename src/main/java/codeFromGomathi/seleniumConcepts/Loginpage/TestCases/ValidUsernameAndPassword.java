package codeFromGomathi.seleniumConcepts.Loginpage.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ValidUsernameAndPassword {

    public static void main(String[] args) throws InterruptedException {
        WebDriver d = new ChromeDriver(); //Type Casting
        d.manage().window().maximize(); //this method maximizes the window
        d.get("https://www.freecrm.com/");//URL to open in the browser
        d.findElement(By.xpath("//span[text()=\"Log In\"]")).click();// Click on login button on the home page to navigate to login page
        d.findElement(By.xpath(" //input[@name=\"email\"]")).sendKeys("Gomathi.Balasubramanianmvs@gmail.com");//Enter the value of mail id by using send keys method
        d.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys("Iniyal@2511");//Enter the value of password by using send keys method
        d.findElement(By.xpath("//div[text()=\"Login\"]")).click();//Click on login button to enter into home page of free CRM
        Thread.sleep(3000);
        d.findElement(By.xpath("//b[@style=\"display: flex; align-items: center; margin-left: 10px;\"]")).isDisplayed();////Checking weather the title is displayed or not.
        d.close();
    }
}
