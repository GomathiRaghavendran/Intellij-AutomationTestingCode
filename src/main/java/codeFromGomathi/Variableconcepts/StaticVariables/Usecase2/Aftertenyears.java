package codeFromGomathi.Variableconcepts.StaticVariables.Usecase2;



public class Aftertenyears {
    public void ageafter10years(){
        System.out.println("Nameof the baby:"+ StaticVariables.babyname);
        System.out.println("Born year:"+StaticVariables.bornyear);
        StaticVariables.age=15;
        System.out.println("Baby age:"+StaticVariables.age);



    }
}
