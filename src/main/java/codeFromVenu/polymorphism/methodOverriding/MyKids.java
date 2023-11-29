package codeFromVenu.polymorphism.methodOverriding;

public class MyKids extends MyElderSisterKids {

  @Override
    void kidsInfo(){
        System.out.println("My kid is studying 8th standard");
    }

//    void  kidsInfo(String hobbie){
//        System.out.println("He/she is good at"+hobbie);
//    }
//
//
//    void kidsInfo(int  age){
//        System.out.println("He/she is now at the age of "+age);
//    }
}
