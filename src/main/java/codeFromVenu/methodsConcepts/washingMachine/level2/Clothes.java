package codeFromVenu.methodsConcepts.washingMachine.level2;

public class Clothes {

    WashingMachineSettings cottonClothes(int qoc,String dlc){
        MetaData.quantityOfClothes = qoc;
        MetaData.dirtyLevelOfClothes = dlc;
        MetaData.typeOfClothes= "cotton";
        return  new WashingMachineSettings();
    }

    void  silkClothes(int qoc,String dlc){
        MetaData.quantityOfClothes = qoc;
        MetaData.dirtyLevelOfClothes = dlc;
        MetaData.typeOfClothes = "silk";

    }

    void  woollenClothes(int qoc,String dlc) {
        MetaData.quantityOfClothes = qoc;
        MetaData.dirtyLevelOfClothes = dlc;
        MetaData.typeOfClothes = "woolen";

    }






}
