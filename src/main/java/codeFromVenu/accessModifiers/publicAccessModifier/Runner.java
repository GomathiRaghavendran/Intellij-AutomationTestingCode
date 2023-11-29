package codeFromVenu.accessModifiers.publicAccessModifier;

import org.checkerframework.checker.units.qual.C;

public class Runner {


    public static void main(String[] args) {
        ClassWithPublicAccesModifier   c = new ClassWithPublicAccesModifier();
        System.out.println(c.age);
        c.publicAccessModifier();

    }
}
