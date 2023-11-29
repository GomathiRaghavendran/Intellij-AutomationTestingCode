package codeFromVenu.setPropertyFromCmd;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class SetProperty {

    public static void main(String[] args) {

        String browser;

        WebDriver d;
        System.setProperty("browserName","Firefox");
        browser = System.getProperty("browerName");
        if (browser == "chrome"){
             d = new ChromeDriver();
        }

        if (browser == "Firefox"){
            d = new EdgeDriver();
        }


    }


}
