package codeFromGomathi.MethodConcepts.Washingmachineproject;

public class WashingMachineSettings {


    Dryer  washingSettings(int temperature,int  spinLvl, boolean isDryerRequired){
        TopWash.temp = temperature;
        TopWash.spinLevel = spinLvl;
        TopWash.dryerRequired = isDryerRequired;
        finalizeTheTimer();
        return new Dryer();
    }


    void finalizeTheTimer(){

        String  toc = TopWash.typeOfClothes;
        int  qoc = TopWash.quantityOfClothes;
        String dlc = TopWash.dirtyLevelOfClothes;
        int tp = TopWash.temp;
        int rpm = TopWash.spinLevel;

        if(toc == "cotton" && qoc == 4 && dlc == "low" && rpm == 2000  && tp == 40 )
        {
            TopWash.timer = 75;
        }

        if(toc == "cotton" && qoc == 4 && dlc == "medium" && rpm == 6000 && tp == 60)
        {
            TopWash.timer = 90;
        }

        if(toc == "cotton" && qoc == 4 && dlc == "high" && rpm == 8000 && tp == 1000)
        {
            TopWash.timer = 120;
        }

    }


}
