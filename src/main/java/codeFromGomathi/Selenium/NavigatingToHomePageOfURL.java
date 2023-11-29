package codeFromGomathi.Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigatingToHomePageOfURL {


    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webDriver.Chrome.driver","C:\\Users\\gomat\\Intellij\\Driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com");
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input")).sendKeys("Admin");
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input")).sendKeys("admin123");
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();

        Thread.sleep(3000);
        //Printing the page title
        String gettitle=driver.getTitle();
        System.out.println("PageTitle:"+gettitle);
        Boolean Title1=driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[1]")).isDisplayed();
        System.out.println("PageTitle:"+Title1);
        //Printing the text of the page
        String Title2=driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[1]")).getText();
        System.out.println("text of the page:"+Title2);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[2]/ul/li/span/i")).click();

        driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/header/div[1]/div[2]/ul/li/ul/li[2]/a")).click();
        Thread.sleep(3000);
        //clicking the backward button to navigate to previous page
        driver.navigate().back();
        Thread.sleep(3000);
        //
        Boolean value=driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/aside/nav/div[2]/div/div/input")).isDisplayed();
        System.out.println("Value:"+value);
        driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/aside/nav/div[2]/div/div/input")).sendKeys("Time");
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li/a/span")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("#app > div.oxd-layout > div.oxd-layout-navigation > aside > nav > div.oxd-sidepanel-body > div > div > svg")).click();
        //

        //driver.close();
        //driver.quit();

        }
        }

