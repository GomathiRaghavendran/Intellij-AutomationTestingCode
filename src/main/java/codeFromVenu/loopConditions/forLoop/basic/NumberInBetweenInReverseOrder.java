package codeFromVenu.loopConditions.forLoop.basic;

public class NumberInBetweenInReverseOrder {


    void  betweenNumbersIncludingSE(int startingValue, int endingValue) {
        for (int i = endingValue; i >= startingValue; i--) {
            System.out.println(i);
        }
    }

        void  betweenNumbersWithoutSE(int startingValue, int endingValue){
            endingValue--;
            for(int i =endingValue;i>startingValue;i--){
                System.out.println(i);
            }

    }

    public static void main(String[] args) {
        NumberInBetweenInReverseOrder  n = new NumberInBetweenInReverseOrder();
      //  n.betweenNumbersIncludingSE(1,5);
        n.betweenNumbersWithoutSE(2,10);
    }




}
