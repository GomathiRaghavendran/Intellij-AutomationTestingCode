package codeFromVenu.typeCasting.UseCase1;

public class RunnerClass {


    public static void main(String[] args) {

        int  j;

        ChainSnatcher cs = new PickPocketer();

        ChainSnatcher cs1 = new ChainSnatcher();

        PickPocketer pp = (PickPocketer)cs1;










    }

}
