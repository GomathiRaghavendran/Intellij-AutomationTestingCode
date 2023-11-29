package codeFromVenu.seleniumConcept.waits.ExplicitWait;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class ExplictWaitConcept {

    public static void main(String[] args) {
        WebDriver d  = new ChromeDriver();
        d.manage().window().maximize();
        d.get("https://www.freecrm.com/");
        d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        d.findElement(By.xpath("//span[text()='Log In']")).click();

        WebDriverWait  wait = new WebDriverWait(d, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='email']")));

        d.close();
    }
}
