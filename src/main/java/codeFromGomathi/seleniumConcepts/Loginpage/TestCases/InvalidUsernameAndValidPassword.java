package codeFromGomathi.seleniumConcepts.Loginpage.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class InvalidUsernameAndValidPassword {

    public static void main(String[] args) throws InterruptedException {
        String ExpectedErrorMessage="Something went wrong...";
            WebDriver d = new ChromeDriver(); //Type Casting
            d.manage().window().maximize(); //this method maximizes the window
            d.get("https://www.freecrm.com/");//URL to open in the browser
            d.findElement(By.xpath("//span[text()=\"Log In\"]")).click();
            d.findElement(By.xpath(" //input[@name=\"email\"]")).sendKeys("Gomathi.Balasubramanian@gmail.com");//Enter invalid user name
            d.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys("Iniyal@2511");
            d.findElement(By.xpath("//div[text()=\"Login\"]")).click();
            Thread.sleep(3000);
           String acutalErrorMessage= d.findElement(By.xpath("//div[@class=\"header\"]")).getText();
            System.out.println(acutalErrorMessage);
            boolean flag=acutalErrorMessage.equals(ExpectedErrorMessage);
            if (flag == false)
            System.exit(1);
            d.close();
        }

    }



