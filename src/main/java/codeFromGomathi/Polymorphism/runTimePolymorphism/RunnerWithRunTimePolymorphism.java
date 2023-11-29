package codeFromGomathi.Polymorphism.runTimePolymorphism;

public class RunnerWithRunTimePolymorphism {
    public static void main(String[] args) {
        Sports s= new Sports();
        s.play();
        s.rules();
        s.matchSchedule();

        s=new Cricket();
        s.play();
        s.rules();



       s=new Volleyball();
        s.play();
        s.rules();

    }
}
