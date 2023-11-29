package codeFromGomathi.customDataType.IntermediateLevel.returnStatements;

public class Runner {

    public static void main(String[] args) {
        KidsInformation kf = new KidsInformation();

        int countOfKrithikaKids = kf.getInfantInfo("Krithika");

        int countOfDevikaKids = kf.getInfantInfo("Devika");

        System.out.println("Kids count of krithika " +countOfKrithikaKids);
        System.out.println("Krithika kids count " +countOfKrithikaKids);

        System.out.println("Kids count of devika " +countOfDevikaKids);



    }

}
