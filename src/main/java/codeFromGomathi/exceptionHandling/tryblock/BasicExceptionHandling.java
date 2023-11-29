package codeFromGomathi.exceptionHandling.tryblock;

public class BasicExceptionHandling {
    public static void main(String[] args) {
        try{
            int i=5/0;
            System.out.println("Hi");
            System.out.println("Hello");

        } catch (Exception e) {
            System.out.println("Please check the arithmetic operations provided");
        }
    }
}
