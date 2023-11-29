package codeFromVenu.seleniumConcept.ScrollDown;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScrollDownInSelenium {

    public static void main(String[] args) throws InterruptedException {
        WebDriver d  = new ChromeDriver();
        d.manage().window().maximize();
        d.get("https://www.worldometers.info/coronavirus/");
        Thread.sleep(2000);
        JavascriptExecutor  jse = (JavascriptExecutor)d;
        jse.executeScript("window.scroll(0,2700)");

    }


}
