package codeFromVenu.thisKeywordConcept;

public class ClassTimings {

    String   timings = "8AM";

    String   tutor = "Venu";


    ClassTimings(String timings,String day){
        timings = timings;
        System.out.println("From constructor timings variable value:"+timings);
    }

    /*
    ClassTimings(String time,String day){
        timings = time;
    }

     */



    void getClassTimings(){
        System.out.println("Session will star sharp at: "+timings);
        System.out.println("tutor will be:"+tutor);
        System.out.println();
    }






}
