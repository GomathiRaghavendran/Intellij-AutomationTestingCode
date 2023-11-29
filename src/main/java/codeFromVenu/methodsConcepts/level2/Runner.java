package codeFromVenu.methodsConcepts.level2;

public class Runner {


    public static void main(String[] args) {
        EyeBrows  thenMozhiEyeBrowsInvoice;

        thenMozhiEyeBrowsInvoice = new EyeBrows();

        Facial   thenMozhiFacialInvoice = new Facial();
        HairColour  thenMozhiHairColorInvoice = new HairColour();
        HairCut  thenMozhiHairCutInvoice = new HairCut();
        MakeUp  thenMozhiMakeUpInvoice = new MakeUp();

        thenMozhiHairCutInvoice.typeOfHairCut("short");
        thenMozhiHairColorInvoice.typeOfHairColor("bourgondy");
        thenMozhiFacialInvoice.typeOfFacial("golden",true);
        thenMozhiEyeBrowsInvoice.typeOfshaping("waxing", true);
        thenMozhiMakeUpInvoice.typeOfMakeUp("OLED");

    }

}
