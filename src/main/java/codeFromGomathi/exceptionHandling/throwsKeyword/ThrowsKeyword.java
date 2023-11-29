package codeFromGomathi.exceptionHandling.throwsKeyword;
public class ThrowsKeyword {
    public void calculation(int num1,int num2) throws ArithmeticException,RuntimeException{
        int result;
         if (num2==0) {
                result= num1/num2;
                throw new ArithmeticException("Division by zero is not possible");
            }
         if(num2 != 0){
            throw new RuntimeException("Cannot divide small number with bigger number");
        }
    } public static void main(String[] args) throws ArithmeticException,RuntimeException {
        ThrowsKeyword tk = new ThrowsKeyword();
        tk.calculation(2,0);
        tk.calculation(1,2);
    }
}
