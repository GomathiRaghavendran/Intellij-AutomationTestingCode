package codeFromVenu.polymorphism.methodOverriding;

public class Runner {


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
       Runner rn = new Runner();
        MyElderSisterKids  mk;
        mk = rn.getObject();
        mk.kidsInfo();
    }
}
