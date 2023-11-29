package codeFromVenu.methodsConcepts.level2;

public class Facial {

    void typeOfFacial(String shapingType, boolean customerCallOnThisRequest) {

        if (shapingType == "Golden" || shapingType == "golden") {
            System.out.println("Charges for service of golden facial "+ 2);
        }
        if (shapingType == "silver" || shapingType == "Silver") {
            System.out.println("Charges for service of silver facial "+ 1);
        }

        if (shapingType == "fruit" || shapingType == "Fruit") {
            System.out.println("Charges for service of fruit facial is 50 cents");
        }

        if (customerCallOnThisRequest == false){
            System.out.println("Ohh Sorry for poorness! but next time please come with your husband wallet");
            System.out.println("Facial services from us is super duper good");
        } else {
            System.out.println("Thank you for your service MADAM");
        }


    }

}
