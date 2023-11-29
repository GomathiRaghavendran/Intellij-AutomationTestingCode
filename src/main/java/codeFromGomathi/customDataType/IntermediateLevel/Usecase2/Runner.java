package codeFromGomathi.customDataType.IntermediateLevel.Usecase2;

public class Runner {

    public static void main(String[] args) {

        HairCut  hCut;

        hCut = new HairCut();

        HairColour  hColour;
        // String  address;
        hColour = hCut.typeOfHairCut("short");
       // address = ds.addressOfSapna();

        hColour.typeOfHairColor("purple");


    }
}
