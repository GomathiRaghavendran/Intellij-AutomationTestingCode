package codeFromVenu.exceptionHandling.tryCatchBlock;

public class BasicExceptionHandling {


    public static void main(String[] args) {
        try {
            int i = 100 / 0;
            System.out.println("I'm from statement 1");
            System.out.println("I'm from statement 2");
        } catch (ArithmeticException e){
            System.out.println("Please go and learn maths");
        }

    }



}
