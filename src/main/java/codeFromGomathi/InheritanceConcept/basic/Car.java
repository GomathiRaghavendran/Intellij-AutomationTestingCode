package codeFromGomathi.InheritanceConcept.basic;

public class Car extends Vehicle {


    void speed(){
        System.out.println("IT can go 250kmph");
        drive();
    }

    void gear(){
        System.out.println("Durru durru");
        honk();
        drive();
    }

}
