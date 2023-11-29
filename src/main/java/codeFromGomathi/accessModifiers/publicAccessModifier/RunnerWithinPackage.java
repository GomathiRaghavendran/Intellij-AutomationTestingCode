package codeFromGomathi.accessModifiers.publicAccessModifier;

public class RunnerWithinPackage {
    public static void main(String[] args) {

        publicAccessModifier pam = new publicAccessModifier();
        //Accessing public variable and its method outside the class and within the package
        System.out.println(pam.streetName);
        pam.method3();
        //Accessing protected variable and its method outside the class and within the package
        System.out.println(pam.age);
        pam.method2();
        //Accessing default variable and its method outside the class and within the package
        System.out.println(pam.sum);
        pam.method4();



    }
}
