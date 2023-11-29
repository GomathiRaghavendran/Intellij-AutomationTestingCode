package codeFromVenu.InheritanceConcept.expectLevel.mutlilevel;

public class Runner1 {

    public static void main(String[] args) {
        Me  m = new Me();
        m.educationDetails(); // from class Me
        m.menIntheHomeEductationDetails(); // from class Parents
        m.womenEductationDetails(); // from GrandParents class
        m.whoIam(); // from GreatGrand class
    }
}
