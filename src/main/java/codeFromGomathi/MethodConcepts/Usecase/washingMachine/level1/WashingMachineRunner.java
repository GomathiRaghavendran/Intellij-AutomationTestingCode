package codeFromGomathi.MethodConcepts.Usecase.washingMachine.level1;

public class WashingMachineRunner {

    public static void main(String[] args) {

        Clothes  c = new Clothes();
        WashingMachineSettings ws = new WashingMachineSettings();
       // Dryer dr = new Dryer();
        /**
        c.cottonClothes(4,"high");
        ws.washingSettings(1000,8000,true);
        System.out.println("It will take "+MetaData.timer+ " minutes to wash your dirty clothes." );
        System.out.println("Please go and come back after "+MetaData.timer+ " minutes to collect your washed clothes" );
        */

        c.cottonClothes(4,"low");
        ws.washingSettings(40,2000,true);
        System.out.println("It will take "+MetaData.timer+ " minutes to wash your dirty clothes." );
        System.out.println("Please go and come back after "+MetaData.timer+ " minutes to collect your washed clothes" );

    }
}
