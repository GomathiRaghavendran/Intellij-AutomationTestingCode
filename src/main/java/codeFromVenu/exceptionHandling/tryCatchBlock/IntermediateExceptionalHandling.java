package codeFromVenu.exceptionHandling.tryCatchBlock;

public class IntermediateExceptionalHandling {

    public void getThePlayerKrithika(){
        System.out.println("Krithika");
    }

    public void getThePlayerVandhana() {
        try{
            int  i = 100/0;
            System.out.println("Vandhana");
            System.out.println("I'm statement 1");
            System.out.println("I'm statement 2");
        } catch (ArithmeticException e){

        }
    }

    public void getThePlayerGomathi() throws InterruptedException {
            System.out.println("Gomathi");

    }
    public void selectionOfTeam() throws InterruptedException {
        getThePlayerVandhana();
        getThePlayerKrithika();
        getThePlayerGomathi();
    }


    public static void main(String[] args) throws InterruptedException {
        IntermediateExceptionalHandling  n = new IntermediateExceptionalHandling();
        n.selectionOfTeam();
    }



}
