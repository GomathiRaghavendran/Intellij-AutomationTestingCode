package codeFromVenu.methodsConcepts.washingMachine.level2;

public class WashingMachineSettings {


    Dryer  washingSettings(int temperature,int  spinLvl, boolean isDryerRequired){
        MetaData.temp = temperature;
        MetaData.spinLevel = spinLvl;
        MetaData.dryerRequired = isDryerRequired;
        finalizeTheTimer();
        return new Dryer();
    }


    void finalizeTheTimer(){

        String  toc = MetaData.typeOfClothes;
        int  qoc = MetaData.quantityOfClothes;
        String dlc = MetaData.dirtyLevelOfClothes;
        int tp = MetaData.temp;
        int rpm = MetaData.spinLevel;

        if(toc == "cotton" && qoc == 4 && dlc == "low" && rpm == 2000  && tp == 40 )
        {
            MetaData.timer = 75;
        }

        if(toc == "cotton" && qoc == 4 && dlc == "medium" && rpm == 6000 && tp == 60)
        {
            MetaData.timer = 90;
        }

        if(toc == "cotton" && qoc == 4 && dlc == "high" && rpm == 8000 && tp == 1000)
        {
            MetaData.timer = 120;
        }

    }


}
