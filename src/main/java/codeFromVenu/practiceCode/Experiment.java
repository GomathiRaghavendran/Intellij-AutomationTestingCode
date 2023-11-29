package codeFromVenu.practiceCode;

public class Experiment {



    String  prepareMvnCommand(String nameOfSuite){

        String startOfMavenTestCommand = "mvn test";
        String midOfMavenTestCommand = " -Dtest=";
        String mvnCommand = startOfMavenTestCommand + midOfMavenTestCommand + nameOfSuite;

        return mvnCommand;
    }


    public static void main(String[] args) {

        Experiment  ep = new Experiment();

        String mvncmd = ep.prepareMvnCommand("ContactsOverViewTests");

        System.out.println(mvncmd);


    }





}
