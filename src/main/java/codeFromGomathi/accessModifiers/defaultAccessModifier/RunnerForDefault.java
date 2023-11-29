package codeFromGomathi.accessModifiers.defaultAccessModifier;

public class RunnerForDefault {
    public static void main(String[] args) {
       defaultClass dc=new defaultClass();
        //Accessing default variable and its method outside the class and within package
        System.out.println(dc.sum);
        dc.method5();
    }
}
