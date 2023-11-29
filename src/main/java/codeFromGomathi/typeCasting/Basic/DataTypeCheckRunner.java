package codeFromGomathi.typeCasting.Basic;

public class DataTypeCheckRunner {

    public static void main(String[] args) {
       //DataTypeCheckChild dTcc= (DataTypeCheckChild)new DataTypeCheckParent();

        //dTcc.method2();
        //dTcc.method1();
        //Lower to higher
        DataTypeCheckParent dTCP = new DataTypeCheckChild();
        dTCP.method1();

    }
}
