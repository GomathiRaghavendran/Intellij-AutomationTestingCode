package codeFromVenu.polymorphism.runTimePolymorphism;

public class RunnerWithRunTimePolymorphism {
    public static void main(String[] args) {

        Belgium  b = new Wallonia();
        System.out.println(b);
        b.language();


        b = new Flanders();
        System.out.println(b);
        b.language();

        b = new Belgium();
        System.out.println(b);
        b.language();




    }

}
