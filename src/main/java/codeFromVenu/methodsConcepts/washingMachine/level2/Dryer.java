package codeFromVenu.methodsConcepts.washingMachine.level2;

public class Dryer {

    void addDryer(){
        if (MetaData.dryerRequired == true) {
            MetaData.timer = MetaData.timer + 20;
        }

        System.out.println("It will take "+ MetaData.timer+ " minutes to wash your dirty clothes." );
        System.out.println("Please go and come back after "+ MetaData.timer+ " minutes to collect your washed clothes" );
    }




}
