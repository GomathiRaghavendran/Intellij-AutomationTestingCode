package codeFromVenu.loopConditions.forLoop.intermediate;

public class Runner {
    public static void main(String[] args) {
        TeamInformation  t = new TeamInformation();
//        t.getNameOfTheTeam("Priyanka S");
//        t.getNameOfTheTeam("Anusha");
//        t.getNameOfTheTeam("Sia");
//        t.getNameOfTheTeam("Kavitha");

        String  nameOfPerson = "Priyanka S";
        String nameOfTeam = t.getNameOfTheTeam(nameOfPerson);
        System.out.println(nameOfPerson+" belongs to "+nameOfTeam+" team.");

    }
}
