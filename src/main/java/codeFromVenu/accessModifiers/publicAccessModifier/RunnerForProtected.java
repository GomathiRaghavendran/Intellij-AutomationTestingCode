package codeFromVenu.accessModifiers.publicAccessModifier;

import codeFromVenu.accessModifiers.protectedAccessModifier.ClassWithProtectedAccessModifier;
import codeFromVenu.accessModifiers.protectedAccessModifier.Runner;

public class RunnerForProtected extends ClassWithProtectedAccessModifier{

    public static void main(String[] args) {
        RunnerForProtected  r = new RunnerForProtected();
        System.out.println(r.age);
        r.protectedAccessModifier();


    }
}
