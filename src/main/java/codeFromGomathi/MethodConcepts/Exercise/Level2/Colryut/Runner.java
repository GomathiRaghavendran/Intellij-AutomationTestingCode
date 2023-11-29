package codeFromGomathi.MethodConcepts.Exercise.Level2.Colryut;

public class Runner {
    public static void main(String[] args) {
        Dairy dy=new Dairy();
        dy.brandsOfMilk("JoyValle",true);
        //dy.brandsOfMilk("365",false);
        dy.brandsOfMilk("365",true);
        Fruits fs=new Fruits();
        fs.typesOfFruits("Avacado",3);
        fs.typesOfFruits("Apple",2);
        fs.typesOfFruits("grapes",5);

    }

}
