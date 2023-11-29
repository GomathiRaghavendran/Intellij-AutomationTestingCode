package codeFromGomathi.loopConditions.forLoop.intermediate.nestedLoops;

public class TablesList {

      void getMultiplication( int Start,int end) {
          for ( int i = Start; i <= end; i++) {
              for ( int j = end; j <= 15; j++) {
                 int mul = i * j;
                  System.out.println(i+"*"+j+"="+ mul);
              }
              System.out.println("*************");
          }
      }

    public static void main(String[] args) {
        TablesList tl=new TablesList();
        tl.getMultiplication(10,10);
    }
    }

