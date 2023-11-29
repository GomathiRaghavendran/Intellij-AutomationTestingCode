package codeFromVenu.thisKeywordConcept;

public class BasicRunner {

    public static void main(String[] args) {
        BasicThisVariableConcept  btvc = new BasicThisVariableConcept("5:15","Thursday");
         btvc.getClassTimings();
        BasicThisVariableConcept  btvc1 = new BasicThisVariableConcept("4:30","Friday");
        btvc1.getClassTimings();

        BasicThisVariableConcept  btvc2 = new BasicThisVariableConcept();
        btvc2.getClassTimings();
    }


}
