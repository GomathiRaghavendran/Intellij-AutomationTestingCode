package codeFromGomathi.typeCasting.Basic;

public class DataTypeCheckChild extends DataTypeCheckParent {

    void method2(){
        long l1=25000l;
        float f1;
        //Lower to higher
        f1=l1;
        //l1= (long) f1;
        System.out.println(l1);
        System.out.println(f1);



    }

}
