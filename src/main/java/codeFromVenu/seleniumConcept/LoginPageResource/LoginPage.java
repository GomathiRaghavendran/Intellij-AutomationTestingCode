package codeFromVenu.seleniumConcept.LoginPageResource;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    String  xpathOfLoginButton = "//span[text()='Log In']";
    String  xpathOfUserNameTextBox = "//input[@name='email']";
    String  xpathOfPasswordTextBox = "//input[@name='password']";
    String  xpathOfSubmitButton = "//div[text()='Login']";
    String  expectedErrorMessage = "Something went wrong...";
    String  xpathOfHeaderInHomePage = "//div[@class='header']";


    public void  enterUserNameAndPassword(WebDriver d, String  un, String pwd) throws InterruptedException {
        d.findElement(By.xpath(xpathOfLoginButton)).click();
        Thread.sleep(3000);
        d.findElement(By.xpath(xpathOfUserNameTextBox)).sendKeys(un);
        d.findElement(By.xpath(xpathOfPasswordTextBox)).sendKeys(pwd);
        d.findElement(By.xpath(xpathOfSubmitButton)).click();
        Thread.sleep(2000);
    }

    public boolean validErrorMessage(WebDriver d){
        String actualErrorMessage = d.findElement(By.xpath("//div[@class='header']")).getText();
        boolean  flag = actualErrorMessage.equals(expectedErrorMessage);
        return  flag;
    }


}
