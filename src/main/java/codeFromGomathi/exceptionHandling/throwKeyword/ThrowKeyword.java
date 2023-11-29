package codeFromGomathi.exceptionHandling.throwKeyword;

import java.io.FileNotFoundException;
import java.util.NoSuchElementException;

public class ThrowKeyword {



    public void calculation(int num1,int num2) {
    int result;
        try {
            if (num2==0) {
                result= num1/num2;
                throw new ArithmeticException("Division by zero is not possible");
            }

        } catch (ArithmeticException e){
            System.out.println("Exception message1: Division by zero is not possible");
        }
    }


    public static void main(String[] args) throws InterruptedException, FileNotFoundException {
        ThrowKeyword  tkd = new ThrowKeyword();
        tkd.calculation(5,0);


    }





}
