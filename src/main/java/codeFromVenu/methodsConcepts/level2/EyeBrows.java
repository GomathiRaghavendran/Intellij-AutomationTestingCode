package codeFromVenu.methodsConcepts.level2;

public class EyeBrows {

    void typeOfshaping(String shapingType, boolean statusOfEyebrows){

        if (shapingType == "threading" || shapingType == "Threading") {
            System.out.println("Charges for service of eyebrows Threading "+ 100);
        }
        if (shapingType == "waxing" || shapingType == "Waxing") {
            System.out.println("Charges for service of eyebrows Waxing"+ 200);
        }

        if (statusOfEyebrows == false){
            System.out.println("Ohh Sorry for poorness! but next time please come with your husband wallet");
            System.out.println("Eyebrows services from us is very good");
        }





    }

}
