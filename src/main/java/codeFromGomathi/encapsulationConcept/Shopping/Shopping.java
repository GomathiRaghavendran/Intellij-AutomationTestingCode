package codeFromGomathi.encapsulationConcept.Shopping;

public class Shopping {

    private String  occasion = "Wedding";
    private String apparelsFirstChoice= "ethnicDresses";
    private String apparelsSecondChoice="Chudidhar";
    private String apparelsThirdChoice = "westernDresses";
    private String  apparelChoices = "bothEthnicAndWestern";

    String getApparelsChoices(){
        if (occasion == "Wedding")
        return   apparelsFirstChoice;
        else if(occasion =="Diwali" || occasion=="SanKrAnThi")
           return apparelsSecondChoice;
        else
            return apparelChoices;
    }

    String   setApparelsBasedOnOccasion(String occasion){
     this.occasion=occasion;
     return  occasion;
    }

}
