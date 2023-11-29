package codeFromGomathi.accessModifiers.publicAccessModifier;

public class publicAccessModifier {
    public  String streetName="geneveStraat";
    private String buildingName = "Immpact";

    protected int age = 4;
    int sum=10;

    public void method3() {
        System.out.println("I am from a public method1");
    }
    private void method1() {
        System.out.println("I am from a private method1");
    }

    protected void method2() {
        System.out.println("I am from a protected method1");
    }

    void method4() {
        System.out.println("I am from a default method4");
    }

    public static void main(String[] args) {
        publicAccessModifier pam= new publicAccessModifier();
        //Accessing private variable and its method within the class
        System.out.println(pam.buildingName);
        pam.method1();
        // Accessing public variable  and its method within the class
        System.out.println(pam.streetName);
        pam.method3();
        //Accessing protected variable and its method within the class
        System.out.println(pam.age);
        pam.method2();
        //Accessing default variable and its method within the class
        System.out.println(pam.sum);
        pam.method4();

    }

}

