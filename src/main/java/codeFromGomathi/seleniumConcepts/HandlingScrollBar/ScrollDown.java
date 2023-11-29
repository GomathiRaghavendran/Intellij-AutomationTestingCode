package codeFromGomathi.seleniumConcepts.HandlingScrollBar;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class ScrollDown {
    public static void main(String[] args) throws InterruptedException, IOException {

        WebDriver d=new ChromeDriver();
        d.manage().window().maximize();
        d.get("https://www.worldometers.info/coronavirus/");
        Thread.sleep(1000);
        JavascriptExecutor je= (JavascriptExecutor)d;
        je.executeScript("window.scroll(0,2500)");

        //Taking screenshot using Takescreenshot interface
        TakesScreenshot ts=(TakesScreenshot) d;
        File src=ts.getScreenshotAs(OutputType.FILE);
        File des=new File("C:\\ScrollbarEvidence\\ScrollDown.png");
        Files.copy(src.toPath(),des.toPath());
    }
}
