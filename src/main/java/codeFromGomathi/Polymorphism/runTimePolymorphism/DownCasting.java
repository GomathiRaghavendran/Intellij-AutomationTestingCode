package codeFromGomathi.Polymorphism.runTimePolymorphism;


//Using Overriding concept, we can achieve runtime polymorphism
//its changing the behavior at the run time

//Overloading- It will never update the value during compile time polymorphism
public class DownCasting {
    public static void main(String[] args) {
        Sports ss= new Cricket();


        Cricket ct=(Cricket) ss;
        ct.play();
        ct.rules();
        ct.nameOfGroundsInIndia();

        Sports ss1= new Volleyball();

        Volleyball vb =(Volleyball) ss1;
        ss1.rules();
        vb.numberOfPlayers();
    }
}
