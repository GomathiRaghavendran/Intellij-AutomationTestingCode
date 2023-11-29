package codeFromGomathi.loopConditions.forLoop.intermediate.nestedLoops;

public class WeeksAndDays {

    String days[]={"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};

    void getWeekAndDay(int weeks, int noosdays){
        for(int i=1;i<=weeks;i++){
            System.out.println("weeks:"+i);
            for (int j=0;j<=days.length;j++){
                //System.out.println("days:"+j);
                System.out.println("Day "+ j +" is "+days[j]);
               }
            }
        }


    public static void main(String[] args) {
        WeeksAndDays wd=new WeeksAndDays();
        wd.getWeekAndDay(1,6);
    }
    }

