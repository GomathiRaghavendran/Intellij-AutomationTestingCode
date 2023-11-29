package codeFromGomathi.thisKeywordConcept;

public class BasicRunnerWithThisKeyword {

    public static void main(String[] args) {
        BasicThisVariableConcept btvc = new BasicThisVariableConcept("Thursday","fullDay","Melda");
         btvc.schoolTimetable();
        BasicThisVariableConcept btvc1 = new BasicThisVariableConcept("Sunday","Leave","Lenka");
        btvc1.schoolTimetable();

        BasicThisVariableConcept btvc2 = new BasicThisVariableConcept();
        btvc2.schoolTimetable();
    }


}
