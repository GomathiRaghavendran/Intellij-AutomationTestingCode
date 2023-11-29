package codeFromGomathi.accessModifiers.privateAccessModifier;

import codeFromGomathi.accessModifiers.protectedAccessModifier.ProtectedClass;

public class RunnerForProtected extends ProtectedClass {

    public static void main(String[] args) {

        //Accessing protected variable and its method outside the package by extending protected class
        RunnerForProtected rp=new RunnerForProtected();
        System.out.println(rp.name);
        System.out.println(rp.yearsInBelgium);
        rp.info("phoenix",15);



    }
}
