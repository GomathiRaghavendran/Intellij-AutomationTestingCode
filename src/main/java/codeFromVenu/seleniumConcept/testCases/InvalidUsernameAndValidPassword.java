package codeFromVenu.seleniumConcept.testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class InvalidUsernameAndValidPassword {

    public static void main(String[] args) throws InterruptedException {
        String  expectedErrorMessage = "Something went wrong...";
        System.setProperty("webdriver.chrome.driver","C:\\Users\\tammi\\chromedriver.exe");
        System.getProperty("webdriver.chrome.driver");
        WebDriver d  = new ChromeDriver();
        d.manage().window().maximize();
        d.get("https://www.freecrm.com/");
        d.findElement(By.xpath("//span[text()='Log In']")).click();
        d.findElement(By.xpath("//input[@name='email']")).sendKeys("tammivnu@gmail.com");
        d.findElement(By.xpath("//input[@name='password']")).sendKeys("Tirupathi1@");
        d.findElement(By.xpath("//div[text()='Login']")).click();
        Thread.sleep(2000);
        String actualErrorMessage = d.findElement(By.xpath("//div[@class='header']")).getText();
        System.out.println(actualErrorMessage);
        boolean  flag = actualErrorMessage.equals(expectedErrorMessage);
        if (flag == false)
            System.exit(1);
        //span[text()="Log In"]
        d.close();

    }


}
