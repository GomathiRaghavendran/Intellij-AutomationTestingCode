package codeFromGomathi.accessModifiers.protectedAccessModifier;

import codeFromGomathi.accessModifiers.defaultAccessModifier.defaultClass;
import codeFromGomathi.accessModifiers.publicAccessModifier.publicAccessModifier;

public class RunnerForPublic {
    public static void main(String[] args) {
        publicAccessModifier pam = new publicAccessModifier();
        //Accessing public variable and its method outside the package
        System.out.println(pam.streetName);
        pam.method3();

        //No access to default variables and its method outside the package
        //defaultClass dc =new defaultClass();
        //dc.

    }
}
