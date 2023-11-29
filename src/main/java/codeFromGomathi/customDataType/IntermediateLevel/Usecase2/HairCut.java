package codeFromGomathi.customDataType.IntermediateLevel.Usecase2;

public class HairCut {

    HairColour typeOfHairCut(String hairCutType) {

        if (hairCutType == "short" || hairCutType == "Short") {
            System.out.println("Charges for service of short hair cut "+ 50 );
        }
        if (hairCutType == "u shape" || hairCutType == "U shape") {
            System.out.println("Charges for service of u shape hair cut  " + 60);
        }

        if (hairCutType == "step cut" || hairCutType == "Step cut") {
            System.out.println("Charges for service of Step cut "+ 100);
        }
      return   new HairColour();
    }
}
