package codeFromGomathi.loopConditions.forLoop.intermediate.UseCase1;

public class Runner {
    public static void main(String[] args) {
        CricketTeam ct=new CricketTeam();
        String nameOfThePerson="MS Dhoni";
        //String nameOfThePerson="Axar Patel";
       // String nameOfThePerson="Umesh Yadhav";
        //String nameOfThePerson="Arjun Tendulkar";
        //String nameOfThePerson="Sai Sudharsan";
        String nameOfTheTeam=ct.getTheNameOfTheTeam(nameOfThePerson);
        System.out.println(nameOfThePerson+" belongs to "+nameOfTheTeam+ " team");
    }
}
