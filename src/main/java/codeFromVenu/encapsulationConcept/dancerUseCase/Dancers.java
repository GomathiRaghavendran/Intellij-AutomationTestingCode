package codeFromVenu.encapsulationConcept.dancerUseCase;

public class Dancers {

    String  leadDancerFitnessStatus = "not good";
    private String leadDancer = "Devika";
    private String secondLeadDancer = "Krithika";
    private String  groupDancer1 = "Bhavitha";
    private String  groupDancer2 = "Santhosh";




    String getLeadDancerName(){
        if (leadDancerFitnessStatus == "good")
        return   leadDancer;
        else
           return secondLeadDancer;
    }

    String  getSecondLeadDancer(){
        return secondLeadDancer;
    }

    String   setSecondLeadDancer(String name){
        secondLeadDancer = name;
        return  secondLeadDancer;
    }



}
