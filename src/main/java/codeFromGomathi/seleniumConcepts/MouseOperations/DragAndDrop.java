package codeFromGomathi.seleniumConcepts.MouseOperations;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://jqueryui.com/droppable/");
        driver.manage().window().maximize();
        Thread.sleep(1000);
        driver.switchTo().frame(0);
       WebElement source = driver.findElement(By.xpath("//p[text()='Drag me to my target']"));
        WebElement destination = driver.findElement(By.xpath("//p[text()='Drop here']"));
        Actions ac = new Actions(driver);
       Action builder = ac.moveToElement(source)
                .clickAndHold()
                .moveToElement(destination)
                .release()
                .build();

        builder.perform();



    }
}
