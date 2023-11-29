package codeFromGomathi.MethodConcepts.Washingmachineproject;

public class Clothes {

    WashingMachineSettings cottonClothes(int qoc,String dlc){
        TopWash.quantityOfClothes = qoc;
        TopWash.dirtyLevelOfClothes = dlc;
        TopWash.typeOfClothes= "cotton";
        return  new WashingMachineSettings();
    }

    void  silkClothes(int qoc,String dlc){
        TopWash.quantityOfClothes = qoc;
        TopWash.dirtyLevelOfClothes = dlc;
        TopWash.typeOfClothes = "silk";

    }

    void  woollenClothes(int qoc,String dlc) {
        TopWash.quantityOfClothes = qoc;
        TopWash.dirtyLevelOfClothes = dlc;
        TopWash.typeOfClothes = "woolen";

    }






}
