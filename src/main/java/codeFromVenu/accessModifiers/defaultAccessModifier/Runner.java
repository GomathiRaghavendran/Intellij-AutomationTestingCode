package codeFromVenu.accessModifiers.defaultAccessModifier;

import codeFromVenu.accessModifiers.publicAccessModifier.ClassWithPublicAccesModifier;

public class Runner {


    public static void main(String[] args) {

        ClassWithPublicAccesModifier   c = new ClassWithPublicAccesModifier();
        System.out.println(c.age);
        c.publicAccessModifier();

    }
}
