package codeFromGomathi.encapsulationConcept.Family;

public class AgeOfMyFamilyMembers {
    private int age;
    boolean flag = false;



    void setAge(int familyMembersAge){
        if(familyMembersAge >=40 && familyMembersAge <=60){
            age = familyMembersAge;
        } else {
            flag = true;
        }

    }


    void getAge(){
        if (flag == false)
            System.out.println("Members in our family is elderly parents "+age);
        else
            System.out.println("Hooray!Members in our family is Adults and kids");

    }


}
