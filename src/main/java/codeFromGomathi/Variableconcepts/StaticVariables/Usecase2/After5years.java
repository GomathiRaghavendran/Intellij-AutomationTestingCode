package codeFromGomathi.Variableconcepts.StaticVariables.Usecase2;



public class After5years {
    public void ageafter5years() {
        System.out.println("Baby name:" + StaticVariables.babyname);
        StaticVariables.age = 10;
        System.out.println("Baby age:" + StaticVariables.age);
    }
}
