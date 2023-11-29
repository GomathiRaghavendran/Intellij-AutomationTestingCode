package codeFromGomathi.Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CrmLoginPage {
    String expectedErrorMessage="Something went wrong...";

    public void enterUserNameAndPassword(WebDriver d,String un, String Pwd) throws InterruptedException {
        d.findElement(By.xpath("//span[text()='Log In']")).click();
        Thread.sleep(3000);
        d.findElement(By.xpath(" //input[@name='email']")).sendKeys(un);
        d.findElement(By.xpath("//input[@name='password']")).sendKeys(Pwd);
        d.findElement(By.xpath("//div[text()='Login']")).click();
        Thread.sleep(3000);

    }

    public boolean validatingErrorMessage(WebDriver d){
        String actualErrorMessage = d.findElement(By.xpath("//div[@class='header']")).getText();
        boolean  flag = actualErrorMessage.equals(expectedErrorMessage);
        return  flag;

    }
}
