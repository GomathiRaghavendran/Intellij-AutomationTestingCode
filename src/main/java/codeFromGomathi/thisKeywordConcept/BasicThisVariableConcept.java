package codeFromGomathi.thisKeywordConcept;

public class BasicThisVariableConcept {

    String  day= "Wednesday";

    String   schoolCalender = "halfDay";

    String  Juf="Melda";
    BasicThisVariableConcept(String day,String schoolCalender,String juf){
      this.day = day;
      this.schoolCalender = schoolCalender;
      this.Juf=juf;
    }

    BasicThisVariableConcept(){

        System.out.println("Hello, I'm from default constructor");
    }




    void schoolTimetable(){
        System.out.println("Today is "+day);
        System.out.println(day+ " is "+ schoolCalender);
        System.out.println(day+" is "+ Juf+" class");
    }




}
