package codeFromGomathi.loopConditions.forLoop.basic;

public class FindingOddAndEvenNumbers {

    void getOddAndEvenNumbers(int startValue, int endValue){
        for (int i = startValue; i <= endValue; i++) {
            if(i%2!=0){
                System.out.println("Odd numbers:"+i);
            }
            else {
                System.out.println("Even numbers:"+i);
            }
        }
    }
    public static void main(String[] args) {
        FindingOddAndEvenNumbers on= new FindingOddAndEvenNumbers();
        on.getOddAndEvenNumbers(10,50);
    }
}
