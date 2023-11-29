package codeFromVenu.methodsConcepts.washingMachine.level2;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class WashingMachineRunner {

    public static void main(String[] args) {

        Clothes c = new Clothes();
        c.cottonClothes(4,"high").washingSettings(1000,8000,true).addDryer();

        ChromeDriver  driver = new ChromeDriver();
        driver.findElement(By.xpath("")).sendKeys("");


    }
}
