package codeFromGomathi.Polymorphism.runTimePolymorphism;

public class RunnerWithOutRunTimePolymorphism {

    public static void main(String[] args) {
        Sports ss=new Sports();
        ss.rules();;
        ss.play();

        Cricket ct =new Cricket();
        ct.play();
        ct.rules();

        Volleyball vb= new Volleyball();
        vb.play();
        vb.rules();
    }
}
