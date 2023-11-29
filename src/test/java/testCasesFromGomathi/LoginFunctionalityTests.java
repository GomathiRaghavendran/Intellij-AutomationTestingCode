package testCasesFromGomathi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginFunctionalityTests {


    @Test
    void validUsernameAndValidPassword() throws InterruptedException {
        WebDriver d = new ChromeDriver(); //Type Casting
        d.manage().window().maximize(); //this method maximizes the window
        d.get("https://www.freecrm.com/");//URL to open in the browser
        d.findElement(By.xpath("//span[text()=\"Log In\"]")).click();// Click on login button on the home page to navigate to login page
        d.findElement(By.xpath(" //input[@name=\"email\"]")).sendKeys("Gomathi.Balasubramanianmvs@gmail.com");//Enter the value of mail id by using send keys method
        d.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys("Iniyal@2511");//Enter the value of password by using send keys method
        d.findElement(By.xpath("//div[text()=\"Login\"]")).click();//Click on login button to enter into home page of free CRM
        Thread.sleep(3000);
        d.findElement(By.xpath("//b[text()=\"Gomathi\"]")).isDisplayed();////Checking weather the title is displayed or not.
        d.close();
    }

    @Test
    void  InvalidUsernameAndValidPassword() throws InterruptedException {

        String expectedErrorMessage="Something went wrong...";
        WebDriver d = new ChromeDriver(); //Type Casting
        d.manage().window().maximize(); //this method maximizes the window
        d.get("https://www.freecrm.com/");//URL to open in the browser
        d.findElement(By.xpath("//span[text()=\"Log In\"]")).click();
        d.findElement(By.xpath(" //input[@name=\"email\"]")).sendKeys("Gomathi.Balasubramanian@gmail.com");//Enter invalid user name
        d.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys("Iniyal@2511");
        d.findElement(By.xpath("//div[text()=\"Login\"]")).click();
        Thread.sleep(3000);
        String acutalErrorMessage= d.findElement(By.xpath("//div[@class=\"header\"]")).getText();
        Assert.assertEquals(acutalErrorMessage,expectedErrorMessage);
        d.close();

    }
    @Test
    void  validUsernameAndInValidPassword() throws InterruptedException {
        String  expectedErrorMessage = "Something went wrong...";
        WebDriver d = new ChromeDriver(); //Type Casting
        d.manage().window().maximize(); //this method maximizes the window
        d.get("https://www.freecrm.com/");//URL to open in the browser
        d.findElement(By.xpath("//span[text()=\"Log In\"]")).click();
        d.findElement(By.xpath(" //input[@name=\"email\"]")).sendKeys("Gomathi.Balasubramanianmvs@gmail.com");
        d.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys("Ini@2511");//Enter the invalid
        d.findElement(By.xpath("//div[text()=\"Login\"]")).click();
        Thread.sleep(3000);
        String actualErrorMessage=d.findElement(By.xpath("//div[@class=\"header\"]")).getText();
        Assert.assertEquals(actualErrorMessage,expectedErrorMessage);//To Compare any two values, we can use Assertion in TestNG.
        d.close();
    }

    @Test
    void InvalidUsernameAndInvalidPassword() throws InterruptedException {
        String expectedErrorMessage = "Something went wrong...";
        WebDriver d = new ChromeDriver(); //Type Casting
        d.manage().window().maximize(); //this method maximizes the window
        d.get("https://www.freecrm.com/");//URL to open in the browser
        d.findElement(By.xpath("//span[text()=\"Log In\"]")).click();
        d.findElement(By.xpath(" //input[@name=\"email\"]")).sendKeys("Gomathi.Basubramanianmvs@gmail.com");//Enter invalid mail id
        d.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys("Ini@2511");//Enter invalida password
        d.findElement(By.xpath("//div[text()=\"Login\"]")).click();
        Thread.sleep(3000);
        String actualErrorMessage = d.findElement(By.xpath("//div[@class='header']")).getText();
        Assert.assertEquals(actualErrorMessage,expectedErrorMessage);
        d.close();
    }
    }

