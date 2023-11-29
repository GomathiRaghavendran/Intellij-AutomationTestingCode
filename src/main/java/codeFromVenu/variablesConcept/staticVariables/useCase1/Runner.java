package codeFromVenu.variablesConcept.staticVariables.useCase1;

public class Runner {



    public static void main(String[] args) {
        MemomriesOfSouthAfrica msf = new MemomriesOfSouthAfrica();
        MemoriesOfBelgium  mob = new MemoriesOfBelgium();
        MemoriesOfUAE muae = new MemoriesOfUAE();

        msf.highLevelBriefingOfMemoriesInSA();

        mob.highLevelBriefingOfMemoriesInBE();

        msf.highLevelBriefingOfMemoriesInSA();

        System.out.println("My citizenship status:"+BirthCountry.citizenshipStatus);
    }


}
