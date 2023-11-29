package codeFromGomathi.Polymorphism.MethodOverriding;

public class SunMusic extends SunTV {
    void programSchedule(){
        System.out.println("Non Stop Hits will be telecasted");

    }
    void programSchedule(int time){
        System.out.println("Break Free songs at "+time+"'O Clock");
    }
}
