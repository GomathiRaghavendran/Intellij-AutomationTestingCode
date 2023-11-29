package codeFromVenu.thisKeywordConcept;

public class BasicThisVariableConcept {

    String   time = "8AM";
    String  day = "Saturday or Sunday";
    String   tutor = "Venu";
    BasicThisVariableConcept(String time,String day){
      this.time = time;
      this.day = day;
    }

    BasicThisVariableConcept(){
        System.out.println("Hello, I'm from default constructor");
    }


    void getClassTimings(){
        System.out.println("Session will start sharp at: "+time+" when it is "+day);
        System.out.println("tutor will be:"+tutor);
        System.out.println();
    }




}
