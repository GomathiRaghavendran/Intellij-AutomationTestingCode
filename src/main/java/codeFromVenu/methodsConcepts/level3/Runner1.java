package codeFromVenu.methodsConcepts.level3;

public class Runner1 {

    public static void main(String[] args) {
        KidsInformation kf = new KidsInformation();

       // int countOfKrithikaKids = kf.getInfantInfo("Krithika");
       // int countOfDevikaKids = kf.getInfantInfo("Devika");

        int  value;
        KrithikaKids kk1;

        kk1 =  kf.getKrithikaKidsInfo();
        kk1.getTheNameOfKids();

        //DevikaKids  dk = new DevikaKids();
        DevikaKids dk1= kf.getDevikaKidsInfo();
        dk1.getTheNameOfKids();

       // new SapnaKids().getTheNameOfKids();
        kf.getSapnaKidsInfo().getTheNameOfKids();

    }
}
