package codeFromVenu.accessModifiers.protectedAccessModifier;

public class Runner {

    public static void main(String[] args) {
        ClassWithProtectedAccessModifier  c = new ClassWithProtectedAccessModifier();
        System.out.println(c.age);
       c.protectedAccessModifier();

    }
}
