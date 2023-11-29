package codeFromVenu.encapsulationConcept.selectionOfAgeUsecase;

public class AgeOfYourTeenageSon {
    private int age;
    boolean flag = false;



    void setAge(int ageOfTheSon){
        if(ageOfTheSon >=13 && ageOfTheSon <=19){
            age = ageOfTheSon;
        } else {
            flag = true;
        }

    }


    void getAge(){
        if (flag == false)
            System.out.println("My teenage son is now at the age of "+age);
        else
            System.out.println("Sorry! the age you provided is not a teenage");

    }






}
