package codeFromGomathi.MethodConcepts.Usecase.level2.beautyParlour;

public class MakeUp {

    void typeOfMakeUp(String makeUpType) {

        if (makeUpType == "HD" || makeUpType == "hd") {
            System.out.println("Charges for service of hd makeup " + 6000);
        }
        if (makeUpType == "Oled" || makeUpType == "oled" ||makeUpType == "OLED" ) {
            System.out.println("Charges for service of oled makeup" + 8000);
        }
        if (makeUpType == "3D" || makeUpType == "3d") {
            System.out.println("Charges for service of 3d makeup  " + 12000);
        }
    }
}
