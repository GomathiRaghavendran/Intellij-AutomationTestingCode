package codeFromVenu.loopConditions.forLoop.intermediate.nestedLoops;

public class Tables{
    void getTheValueOfTables(int tableNumber){
            for (int manisha=1; manisha<=15;manisha++){
                 int sum = tableNumber * manisha;
                System.out.println(tableNumber+" * "+manisha+ " = "+sum);
            }


    }

    public static void main(String[] args) {
        Tables  t = new Tables();
        t.getTheValueOfTables(200);
    }



}
