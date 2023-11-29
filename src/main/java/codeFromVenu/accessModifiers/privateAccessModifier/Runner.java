package codeFromVenu.accessModifiers.privateAccessModifier;


import codeFromVenu.accessModifiers.defaultAccessModifier.ClassWithDefaultAccessModifier;

public class Runner {

    public static void main(String[] args) {
        ClassWithPrivateAccessModifier  c = new ClassWithPrivateAccessModifier();

//          below members not accessible here as those are private member
//        System.out.println(c.age);
//        c.privateAccessModifier();


        ClassWithDefaultAccessModifier c1 = new ClassWithDefaultAccessModifier();

    }
}
