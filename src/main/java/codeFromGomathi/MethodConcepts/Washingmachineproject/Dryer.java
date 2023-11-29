package codeFromGomathi.MethodConcepts.Washingmachineproject;

public class Dryer {

    void addDryer(){
        if (TopWash.dryerRequired == true) {
            TopWash.timer = TopWash.timer + 20;
        }

        System.out.println("It will take "+ TopWash.timer+ " minutes to wash your dirty clothes." );
        System.out.println("Please go and come back after "+ TopWash.timer+ " minutes to collect your washed clothes" );
    }




}
