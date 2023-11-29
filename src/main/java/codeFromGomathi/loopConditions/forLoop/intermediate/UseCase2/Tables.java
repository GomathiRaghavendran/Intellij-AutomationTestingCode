package codeFromGomathi.loopConditions.forLoop.intermediate.UseCase2;

public class Tables {

    void getTheValueOfTables(int tableNumber){
        for (int i=1; i<=15;i++){
            int sum = tableNumber * i;
            System.out.println(tableNumber+" * "+i+ " = "+sum);
        }
    }

    public static void main(String[] args) {
        Tables ts=new Tables();
        ts.getTheValueOfTables(16);
    }
}
