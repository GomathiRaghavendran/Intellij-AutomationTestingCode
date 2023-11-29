package codeFromGomathi.typeCasting.Basic;

public class DataTypeRangeCheck {


    public static void main(String[] args) {

        //Lower to higher
        int i1 = 9;
        double d1 = i1;


        System.out.println(i1);
        System.out.println(d1);

        //Higher to lower
        double d2 = 9.87d;
        int i2;
        i2 = (int) d1;

        System.out.println(d2);
        System.out.println(i2);

    }
}


