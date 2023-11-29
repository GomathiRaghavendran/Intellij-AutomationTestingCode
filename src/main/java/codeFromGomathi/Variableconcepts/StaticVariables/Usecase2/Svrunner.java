package codeFromGomathi.Variableconcepts.StaticVariables.Usecase2;



public class Svrunner {
    public static void main(String[] args) {
        StaticVariables ageof5= new StaticVariables();
        After5years ageoften=new After5years();
        Aftertenyears ageoffifteen=new Aftertenyears();

        ageof5.attheageoffive();
        ageoften.ageafter5years();
        ageof5.attheageoffive();
        ageoffifteen.ageafter10years();
        ageof5.attheageoffive();

    }

}
