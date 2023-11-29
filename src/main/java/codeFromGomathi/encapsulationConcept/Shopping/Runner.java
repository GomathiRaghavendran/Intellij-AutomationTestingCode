package codeFromGomathi.encapsulationConcept.Shopping;

public class Runner {


    public static void main(String[] args) {
        Shopping we = new Shopping();
        System.out.println("Name Of the Occasion: "+we.setApparelsBasedOnOccasion("Wedding"));
        System.out.println("Choice of Apparels: "+we.getApparelsChoices());

    }
}
