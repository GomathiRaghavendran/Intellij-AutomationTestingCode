package codeFromGomathi.Polymorphism.MethodOverriding;

//Overriding-When we have parent and child class with same method name,with same in parameters but different in logic.
//Overriding takes place when inheritance comes into picture.

public class Runner {

    public static void main(String[] args) {

        SunTV sT=new SunMusic();//Upcasting- Storing a child class object in parent class object reference type variable
    sT.programSchedule();

        SunMusic sM=(SunMusic) sT;//Higher- lower(TypeCasting)
        sM.programSchedule();


        SunTV sT1=new SunNews();
        SunNews sN=(SunNews) sT1;
        sN.programSchedule();


        sM.programSchedule(6);
        sN.programSchedule(7);

    }
}
