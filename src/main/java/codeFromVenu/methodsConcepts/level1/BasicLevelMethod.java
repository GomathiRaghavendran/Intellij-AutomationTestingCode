package codeFromVenu.methodsConcepts.level1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicLevelMethod {
    /**
     * From below methods I'm learning that method means logic/block of code and
     * we should keep void if we don't return anything
     *
     */

    void coffeePreparationCoffeeBySantosh() {
        System.out.println("First, I will take a bowl");
        System.out.println("I will boil it");
        System.out.println("I will take a cup");
        System.out.println("I will put some sugar");
        System.out.println("and coffee powder");
        System.out.println("Little bit cream");


        WebDriver driver = new ChromeDriver();


    }

    void coffeePreparationCoffeeByFatema(){
        System.out.println("First, I will take a bowl");
        System.out.println("I will pour some milk and boil it");
        System.out.println("I will add a coffee powder and a sugar");
        System.out.println("Boil it some more");
        System.out.println("Pour it in a cup without cream");
    }


}
