package codeFromGomathi.seleniumConcepts.Loginpage.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class InvalidUsernameAndInvalidPassword {

    public static void main(String[] args) throws InterruptedException {
        String  expectedErrorMessage = "Something went wrong...";
        WebDriver d = new ChromeDriver(); //Type Casting
        d.manage().window().maximize(); //this method maximizes the window
        d.get("https://www.freecrm.com/");//URL to open in the browser
        d.findElement(By.xpath("//span[text()=\"Log In\"]")).click();
        d.findElement(By.xpath(" //input[@name=\"email\"]")).sendKeys("Gomathi.Basubramanianmvs@gmail.com");//Enter invalid mail id
        d.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys("Ini@2511");//Enter invalida password
        d.findElement(By.xpath("//div[text()=\"Login\"]")).click();
        Thread.sleep(3000);
         String actualErrorMessage = d.findElement(By.xpath("//div[@class='header']")).getText();
        System.out.println(actualErrorMessage);
        boolean  flag = actualErrorMessage.equals(expectedErrorMessage);
        if (flag == false)
            System.exit(1);
        d.close();
    }
}
