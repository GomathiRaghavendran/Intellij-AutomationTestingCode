package codeFromVenu.polymorphism.runTimePolymorphism;
import  codeFromVenu.polymorphism.runTimePolymorphism.Belgium;

public class RunnerWithoutRuntimePolymorphism {
    Belgium b;

    public static void main(String[] args) {
        Belgium  b = new Belgium();
        b.language();
        b.chocolates();
        b.population();


        Wallonia  w = new Wallonia();
        w.language();
        Flanders  fd = new Flanders();
        fd.language();
    }
}
