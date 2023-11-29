package codeFromGomathi.encapsulationConcept.NameOfTheMemebersInFamily;
public class FamilyMembers{

    private  int age;

    private String grandParentsName="sanKaranPilLaiAndMaanIcKam";

    private  String parentsName="subBaiAhAndValli";

    private String  ChildrenName="GeethaAndRamYa";

    private String grandKidsName="AmmUAndPapPu";


    String getNames(){
        if(age>=70) {
            System.out.println("Grand Parents Names are:" + grandParentsName);
            return grandParentsName;
        }
        else if (age >=55 && age <70) {
            System.out.println("Parents Names are:" + parentsName);
            return parentsName;
        }
        else if(age>=30 && age<55) {
            System.out.println("Children Names are: "+ChildrenName);
            return ChildrenName;
        }
        else
            System.out.println("Grand Kids Names are: "+grandKidsName);
        return grandKidsName;
    }

    void setAge(int age){
        this.age=age;
    }
}



