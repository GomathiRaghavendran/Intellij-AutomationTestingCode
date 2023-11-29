package codeFromVenu.encapsulationConcept.dancerUseCase;

public class Runner {


    public static void main(String[] args) {
        Dancers d = new Dancers();
        d.setSecondLeadDancer("Anusha");
        System.out.println("Second lead dancer is "+d.getSecondLeadDancer());
    }
}
