package codeFromGomathi.customDataType.IntermediateLevel.returnStatements;

public class Runner1 {

    public static void main(String[] args) {
        KidsInformation kf = new KidsInformation();

       // int countOfKrithikaKids = kf.getInfantInfo("Krithika");
       // int countOfDevikaKids = kf.getInfantInfo("Devika");

        KrithikaKids kk1;
        kk1 =  kf.getKrithikaKidsInfo();
        kk1.getTheNameOfKids();

        DevikaKids dk1= kf.getDevikaKidsInfo();
        dk1.getTheNameOfKids();


        kf.getSapnaKidsInfo().getTheNameOfKids();

    }
}
