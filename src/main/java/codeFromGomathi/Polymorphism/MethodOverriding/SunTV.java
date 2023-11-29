package codeFromGomathi.Polymorphism.MethodOverriding;

//Overriding happens only when inheritance comes into picture
//Parent and child has same method with same parameter but different in logic

public class SunTV {

    void programSchedule(){
        System.out.println("RajaRani serial will be telecasted");

    }

    void  programSchedule(int time){
        System.out.println("Movie time at"+time+"'O Clock");
    }
}
