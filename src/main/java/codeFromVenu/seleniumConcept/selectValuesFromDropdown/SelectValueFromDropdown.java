package codeFromVenu.seleniumConcept.selectValuesFromDropdown;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectValueFromDropdown {

    public static void main(String[] args) throws InterruptedException {

        try {
            WebDriver driver = new FirefoxDriver();
            driver.get("https://www.orangehrm.com/en/book-a-free-demo");
            Thread.sleep(1000);
            WebElement element = driver.findElement(By.xpath("//select[@name='Country']"));
            Select dropdown = new Select(element);
            dropdown.selectByValue("Angola");
        } catch (NoSuchElementException e) {
            System.out.println("Your dropdown xpath is not valid or not found in the GUI");
        }


    }
}
