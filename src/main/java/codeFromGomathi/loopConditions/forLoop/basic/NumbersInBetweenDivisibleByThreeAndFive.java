package codeFromGomathi.loopConditions.forLoop.basic;

public class NumbersInBetweenDivisibleByThreeAndFive {

    void divisibleByThreeAndFive(){
        for(int i=1;i<=100;i++) {
            if (i % 3 == 0 && (i % 5 == 0)) {
                System.out.println("3 & 5 divisible numbers are:" + i);
            }
        }
}

    public static void main(String[] args) {

        NumbersInBetweenDivisibleByThreeAndFive Nt=new NumbersInBetweenDivisibleByThreeAndFive();
        Nt.divisibleByThreeAndFive();
    }

    }
