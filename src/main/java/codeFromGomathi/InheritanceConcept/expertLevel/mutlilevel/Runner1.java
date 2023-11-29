package codeFromGomathi.InheritanceConcept.expertLevel.mutlilevel;

public class Runner1 {

    public static void main(String[] args) {
        Developer d = new Developer();
        d.educationDetails(); //from class Developer
        d.projectsInTribe();//from Product owner class
        d.tribeMembersDetails();// from chapter lead
        d.leader();//from TribeLead

    }
}
