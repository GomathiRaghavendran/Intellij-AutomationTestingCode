package codeFromGomathi.Polymorphism.runTimePolymorphism;

public class Cricket extends Sports {

    void play(){
        System.out.println("Playing a Cricket");
    }

    void numberOfPlayers(){
        System.out.println("Always  eleven players in a Cricket Team");
    }

    void typeOfGame(){
        System.out.println("Cricket is played always at the outdoor");
    }

    void nameOfGroundsInIndia(){
        System.out.println("There are many grounds in India (ie) "+ "in chennai its chapeau Stadium"+
                " and in Mumbai its wanKheDe Stadium");
    }

    void rules(){
        System.out.println("To score four or six runs, ball has to hit the boundaries with/without a bounce");
    }
}
