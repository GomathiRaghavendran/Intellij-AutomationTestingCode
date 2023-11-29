package codeFromGomathi.Polymorphism.MethodOverloading;

//Polymorphism- If some action occurs in different different ways then its called polymorphism
//Poly - many forms (Eg: Brinjal(making many dishes with brinjal)

//Overloading - In a class, if two or three method with same name but with different parameters  and also it satisfies the meaning of polymorphism

import org.checkerframework.checker.units.qual.C;

public class Car {

    void gear(){
        System.out.println("This car goes on a normal speed of 50Km-ph");
            }
    void gear(int gearNo, String speed){
        System.out.println("In gear"+gearNo+" ,this car speed is:"+speed);

    }

    void gear(String speed, int gearNo){
        System.out.println("This car speed is "+speed+" in gear"+ gearNo);

    }

    public static void main(String[] args) {
        Car cr=new Car();
        cr.gear();
        cr.gear(3,"80Km-ph");
        cr.gear("120Km-ph", 5);
    }



}
