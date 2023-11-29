package codeFromVenu.customDataType.IntermediateLevel;

public class Runner1 {


    public static void main(String[] args) {



        HairCut  hc = new HairCut();
        hc.typeOfHairCut("medium");
        hc.sampleMethod();


        new HairCut().typeOfHairCut("High");
        new HairCut().sampleMethod();


    }
}
