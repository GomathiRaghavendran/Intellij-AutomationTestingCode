package codeFromGomathi.Variableconcepts.InstanceVariables.Usecase3;

public class Runner {


    public static void main(String[] args) {

        FamilyYella saranya = new FamilyYella();

        FamilyYella  hareesh = new FamilyYella();

        FamilyYella  nandana = new FamilyYella();


        saranya.myName = "Saranya Narla";
        saranya.myITExperience = 1;
        hareesh.myName = "Hareesh";
        hareesh.myITExperience = 15;
        System.out.println(nandana.myName);
        System.out.println("My IT years of experience: "+nandana.myITExperience);
        System.out.println(hareesh.myName);
        System.out.println("My IT years of experience: "+hareesh.myITExperience);
        System.out.println(saranya.myName);
        System.out.println("My IT years of experience: "+saranya.myITExperience);



    }

}
