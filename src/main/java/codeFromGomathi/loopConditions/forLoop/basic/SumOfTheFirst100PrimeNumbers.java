package codeFromGomathi.loopConditions.forLoop.basic;

public class SumOfTheFirst100PrimeNumbers {

    int sum = 0;

    // int n;

    /**
     * void primeNumbers1() {
     * for (int i = 1; i <= 100; i++) {
     * for (int j = 2; j <= i - 1; j++) {
     * if (i % j == 0) {
     * System.out.println("not a prime no" + j);
     * }
     * }
     * <p>
     * /*if (i == j) {
     * System.out.println("prime no is:"+j);
     * sum=sum+j;
     * System.out.println("Sum of prime no's"+sum);
     * <p>
     * }
     * }
     * }
     */

    void primeNumbers() {

        for (int n = 1; n <= 10; n++) {
            for (int i = 2; i <= n - 1; i++) {
                if (n % i == 0) {
                    System.out.println(n + " is not a prime no");
                    break;
                }else {
                    System.out.println(n + " is a prime no");
                }
                break;
            }
        }
    }


    public static void main(String[] args) {
        SumOfTheFirst100PrimeNumbers s = new SumOfTheFirst100PrimeNumbers();
        s.primeNumbers();
    }
}








