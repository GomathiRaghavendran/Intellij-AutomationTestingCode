package codeFromGomathi.Variableconcepts.LocalVariables;

public class Runner {
    public static void main(String[] args) {

        ArgumentsConcept math = new ArgumentsConcept();

        int manishaMathCalculation = math.addTwoNumber(10,20);
        int thenMonziMathCalculation = math.addTwoNumber(123,456);
        System.out.println(manishaMathCalculation);
        System.out.println(thenMonziMathCalculation);
        math.kidsName("Venu","Nari");
    }
}
