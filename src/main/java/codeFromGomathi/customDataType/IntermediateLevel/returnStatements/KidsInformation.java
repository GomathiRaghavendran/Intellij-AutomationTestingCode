package codeFromGomathi.customDataType.IntermediateLevel.returnStatements;

public class KidsInformation {

    int getInfantInfo(String parentName) {

        int kidsCount = 0;

        if (parentName == "Sapna") {
            kidsCount = 1;
        }

        if (parentName == "Devika") {
            kidsCount = 2;
        }

        if (parentName == "Krithika") {
            kidsCount = 1;
        }

        return kidsCount;
    }


    KrithikaKids  getKrithikaKidsInfo(){

        KrithikaKids   kk;
        kk = new KrithikaKids();
        return  new KrithikaKids() ;
    }

    DevikaKids  getDevikaKidsInfo(){

        DevikaKids   dd;
        dd = new DevikaKids();
        return  dd ;
    }

    SapnaKids  getSapnaKidsInfo(){
        SapnaKids   ss;
        ss = new SapnaKids();
        return  ss;
    }


}
