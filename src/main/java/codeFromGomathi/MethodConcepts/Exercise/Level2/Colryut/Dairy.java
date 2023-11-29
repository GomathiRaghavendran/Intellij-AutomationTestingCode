package codeFromGomathi.MethodConcepts.Exercise.Level2.Colryut;

public class Dairy {
    void brandsOfMilk(String milkbrand, boolean availability) {

        if (milkbrand == "JoyValle" || milkbrand == "joyValle") {
            System.out.println("Cost of JoyValle milk:" + 2);
        }
        if (milkbrand == "Everyday" || milkbrand == "everyday") {
            System.out.println("Cost of Everyday milk:" + 1);
        }

        if (availability == false) {
            System.out.println(" Sorry!!Milk stock is over for today");
            System.out.println("Please come tomorrow morning");
        }
    }

    }
