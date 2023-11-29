package codeFromGomathi.seleniumConcepts.Loginpage.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ValidUsernameAndInvalidPassword {

    public static void main(String[] args) throws InterruptedException {
        String  expectedErrorMessage = "Something went wrong...";
        WebDriver d = new ChromeDriver(); //Type Casting
        d.manage().window().maximize(); //this method maximizes the window
        d.get("https://www.freecrm.com/");//URL to open in the browser
        d.findElement(By.xpath("//span[text()=\"Log In\"]")).click();
        d.findElement(By.xpath(" //input[@name=\"email\"]")).sendKeys("Gomathi.Balasubramanianmvs@gmail.com");
        d.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys("Ini@2511");//Enter the invalid
        d.findElement(By.xpath("//div[text()=\"Login\"]")).click();
        Thread.sleep(3000);
        String ActualErrorMessage=d.findElement(By.xpath("//div[@class=\"header\"]")).getText();
        System.out.println(ActualErrorMessage);
        boolean flag=ActualErrorMessage.equals(expectedErrorMessage);
        if(flag==false)
            System.exit(1);
        d.close();
    }
}
