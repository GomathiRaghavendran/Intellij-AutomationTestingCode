package codeFromGomathi.MethodConcepts.Usecase.level2.beautyParlour;

public class HairCut {

    void typeOfHairCut(String hairCutType) {

        if (hairCutType == "short" || hairCutType == "Short") {
            System.out.println("Charges for service of short hair cut "+ 50 );
        }
        if (hairCutType == "u shape" || hairCutType == "U shape") {
            System.out.println("Charges for service of u shape hair cut  " + 60);
        }

        if (hairCutType == "step cut" || hairCutType == "Step cut") {
            System.out.println("Charges for service of Step cut "+ 100);
        }

    }
}
