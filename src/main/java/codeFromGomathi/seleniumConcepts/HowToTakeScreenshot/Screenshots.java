package codeFromGomathi.seleniumConcepts.HowToTakeScreenshot;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class Screenshots {

    public static void main(String[] args) throws IOException {

        WebDriver d  = new ChromeDriver();
        d.manage().window().maximize();
        d.get("https://ui.cogmento.com/");
        TakesScreenshot  selfie =(TakesScreenshot)d;
        File f = selfie.getScreenshotAs(OutputType.FILE);
        File des=new File("C:\\ScreenshotReport\\img.png");
        Files.copy(f.toPath(),des.toPath());
    }
}
