package codeFromGomathi.xpathConcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class xpathConcepts {

    public static void main(String[] args) {
        WebDriver d = new ChromeDriver();
        d.manage().window().maximize();
        d.get("https://www.freecrm.com/");
        //xpath for login button (parent to child)
        d.findElement(By.xpath("//ul[@class='rd-navbar-nav']/a")).click();
        //xpath for younger one using following sibiling
        d.findElement(By.xpath("//i[@class='user icon']/following-sibling::input")).sendKeys("Gomathi.Balasubramanianmvs@gmail.com");
        //xpath for elder sibling
        d.findElement(By.xpath("//i[@class='lock icon']/following-sibling::input")).sendKeys("Iniyal@2511");
        //xpath using contains method
        //d.findElement(By.xpath("//div[contains(text(), 'Log')]")).click();
        //xpath using preceding sibiling
        //d.findElement(By.xpath("//div[@class='ui message']/preceding-sibling::div[@class='login-with']")).click();
        //Xpath using parent ot child using contains for forgot ur password
        d.findElement(By.xpath("//div[@class='ui message']/a[contains(., 'Forgot')]")).click();
        //Xpath to check company name is displayed or not
        d.findElement(By.xpath("//div[@class='header item']/following-sibling::b")).isDisplayed();



    }
}
