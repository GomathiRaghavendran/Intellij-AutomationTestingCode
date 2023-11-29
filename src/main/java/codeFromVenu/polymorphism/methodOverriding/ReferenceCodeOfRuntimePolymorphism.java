package codeFromVenu.polymorphism.methodOverriding;

public class ReferenceCodeOfRuntimePolymorphism {

    boolean  flag = true;
    MyElderSisterKids getObject(){
        MyElderSisterKids  mesk = new MyElderSisterKids();
        if(flag == true)
            mesk =  new MyYoungerSisterKids();
        if (flag == false)
            mesk =  new MyKids();
        return mesk;
    }

    public static void main(String[] args) {
        ReferenceCodeOfRuntimePolymorphism rn = new ReferenceCodeOfRuntimePolymorphism();
        MyElderSisterKids  mk;
        mk = rn.getObject();
        mk.kidsInfo();
    }
}
