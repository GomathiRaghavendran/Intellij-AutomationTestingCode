package codeFromVenu.polymorphism.methodOverloading;

public class KidsInformation {


    void kidsInfo(){
        System.out.println("My kid is studying 7th standard");
    }



    void  kidsInfo(String hobbie){
        System.out.println("He/she is good at"+hobbie);
    }


    void kidsInfo(int  age){
        System.out.println("He/she is now at the age of "+age);
    }


    public static void main(String[] args) {
        KidsInformation  ki  =  new KidsInformation();
        ki.kidsInfo();
        ki.kidsInfo(23);
        ki.kidsInfo("cricket");
    }


}
