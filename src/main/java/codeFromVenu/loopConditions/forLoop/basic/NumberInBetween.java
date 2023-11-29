package codeFromVenu.loopConditions.forLoop.basic;

public class NumberInBetween {



    void  betweenNumbersIncludingSE(int startingValue, int endingValue){

        for(int i = startingValue;i<=endingValue;i++){
            System.out.println(i);
        }


    }

    void  betweenNumbersWithoutSE(int startingValue, int endingValue){
        startingValue++;
        for(int i =startingValue;i<endingValue;i++){
            System.out.println(i);
        }


    }

    void gomathiWayOfCoding(int startingValue, int endingValue){
        startingValue++;
        for(;startingValue<endingValue;startingValue++){
            System.out.println(startingValue);
        }
    }



    public static void main(String[] args) {
        NumberInBetween r = new NumberInBetween();
//        r.betweenNumbersIncludingSE(5000,5020);
//        r.betweenNumbersIncludingSE(2,3);
        r.betweenNumbersWithoutSE(1,3);
    }



}
