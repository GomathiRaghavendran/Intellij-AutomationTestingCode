package codeFromGomathi.MethodConcepts.Exercise.Level1;

public class Runner {
    public static void main(String[] args) {
        //Method with return and storing the return value in another variable
       MethodwithReturn MR=new MethodwithReturn();
        int value =MR.newmethod();
        System.out.println(value);
        //Method with void
        //MethodWithVoid MV=new MethodWithVoid();
        //MV.calculations();
        //Method with return statement
        MathCalculation math=new MathCalculation();
        System.out.println(math.basedOnMyTheory());
    }
}
