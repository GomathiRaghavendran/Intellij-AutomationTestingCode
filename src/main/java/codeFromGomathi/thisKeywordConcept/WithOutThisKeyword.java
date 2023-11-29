package codeFromGomathi.thisKeywordConcept;

public class WithOutThisKeyword {

    String  day= "Wednesday";

    String   schoolCalender = "halfDay";


    WithOutThisKeyword(String day, String schoolCalender){
       day=day;
        System.out.println("From constructor day variable value:"+day);
    }




    void schoolTimetable(){
        System.out.println("Today is: "+day);
        System.out.println("Today is :"+schoolCalender);
    }






}
