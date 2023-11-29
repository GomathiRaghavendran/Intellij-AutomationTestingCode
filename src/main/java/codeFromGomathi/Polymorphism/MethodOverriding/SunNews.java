package codeFromGomathi.Polymorphism.MethodOverriding;

public class SunNews extends SunTV {

    void programSchedule(){
        System.out.println("Live news will be read by Newsreader");

    }
    void  programSchedule(int time){
        System.out.println("Head News at"+time+"'O Clock");
    }
}
