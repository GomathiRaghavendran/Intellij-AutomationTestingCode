package codeFromGomathi.exceptionHandling.tryblock;

public class IntermediateExceptionHandling {
    public void getThePlayerFromCSK(){
        System.out.println("Jadeja");
    }

    public void getThePlayerMI() {
        try{
            int  i = 100/0;
            System.out.println("RohitSharma");
            System.out.println("I'm statement 1");
            System.out.println("I'm statement 2");
        } catch (ArithmeticException e){
            System.out.println("Something went in wrong, please check again");

        }
    }

    public void getThePlayerGT() throws InterruptedException {
        System.out.println("HardikPandiya");

    }
    public void selectPlayerFromEachTeam() throws InterruptedException {
        getThePlayerGT();
        getThePlayerFromCSK();
        getThePlayerMI();

    }


    public static void main(String[] args) throws InterruptedException {
        IntermediateExceptionHandling neh=new IntermediateExceptionHandling();
        neh.selectPlayerFromEachTeam();
    }



}

