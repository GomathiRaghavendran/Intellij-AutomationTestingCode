package codeFromGomathi.MethodConcepts.Usecase.washingMachine.level2;

public class WashingMachineRunner {

    public static void main(String[] args) {

        Clothes c = new Clothes();
        c.cottonClothes(4,"high").washingSettings(1000,8000,true).addDryer();



    }
}
