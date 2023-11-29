package codeFromVenu.polymorphism.runTimePolymorphism;

public class DownCasting {

    public static void main(String[] args) {

        Belgium bg = new Wallonia();


        Wallonia  wn = (Wallonia)bg;
        wn.chocolates();

        Wallonia wm1=(Wallonia) new Belgium();
        wm1.chocolates();

        wn.famousFood();

    }
}
