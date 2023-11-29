package codeFromGomathi.finalKeywordConcept.finalKeywordToVariable;

public  class Television {

    //If we apply Final keyword in-front of the variable then the value of the variable can't be changed at any cost
    final String nameOfTheProgram="Break free songs";

     int timings=4;
    void sunTvProgram(){

    }

    void sunNewsProgram(){

    }

    void  SunMusicProgram(){
        //nameOfTheProgram= "Hit songs";
        System.out.println("Name of the program: "+nameOfTheProgram);

        timings = 5;
        System.out.println("program time:"+timings);

    }


}
