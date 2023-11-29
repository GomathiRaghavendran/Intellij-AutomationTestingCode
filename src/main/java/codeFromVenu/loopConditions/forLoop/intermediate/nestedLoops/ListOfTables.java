package codeFromVenu.loopConditions.forLoop.intermediate.nestedLoops;

public class ListOfTables {

    void getListOfTable(int startTable, int endTable) {

        for (int devika = startTable;devika<=endTable;devika++){

            for (int manisha=1 ; manisha<=10;manisha++){
                int sum = devika * manisha;
                System.out.println(devika+" * "+manisha+ " = "+sum);
            }

            System.out.println("------------------------------------");

    }

    }

    public static void main(String[] args) {

        ListOfTables  lt = new ListOfTables();
        lt.getListOfTable(10,20);

    }



}
