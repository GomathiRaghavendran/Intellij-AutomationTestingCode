package codeFromGomathi.seleniumConcepts.DropDown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectValueFromDropdown {
    public static void main(String[] args) {
        String countryname;
        WebDriver driver=new FirefoxDriver();
        driver.get("https://www.orangehrm.com/en/book-a-free-demo");
        WebElement we=driver.findElement(By.xpath("//select[@name='Country']"));
        Select st=new Select(we);
        st.selectByIndex(15);
        System.out.println();



    }
}
