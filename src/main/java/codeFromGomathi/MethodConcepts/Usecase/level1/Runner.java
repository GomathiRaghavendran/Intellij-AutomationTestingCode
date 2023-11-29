package codeFromGomathi.MethodConcepts.Usecase.level1;

public class Runner {

    public static void main(String[] args) {
        MathCalculationOfPadma math = new MathCalculationOfPadma();
        String  thirteenSquareByPadma = math.basedOnPadmaTheorySquareOfThirteen();

        System.out.println(thirteenSquareByPadma);


    }
}
