package codeFromGomathi.accessModifiers.defaultAccessModifier;

public class defaultClass {
    int sum=10;

    void method5(){
        int a =50;
        int b=50;
        int c =a*b;
        System.out.println("Value is:"+c);
    }

    public static void main(String[] args) {
        defaultClass dc=new defaultClass();
        //Accessing default variable and its method within the class
        System.out.println(dc.sum);
        dc.method5();

    }
}
