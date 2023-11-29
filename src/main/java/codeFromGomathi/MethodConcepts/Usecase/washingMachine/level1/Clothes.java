package codeFromGomathi.MethodConcepts.Usecase.washingMachine.level1;

public class Clothes {

    void cottonClothes(int qoc,String dlc){
        MetaData.quantityOfClothes = qoc;
        MetaData.dirtyLevelOfClothes = dlc;
        MetaData.typeOfClothes= "cotton";
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
