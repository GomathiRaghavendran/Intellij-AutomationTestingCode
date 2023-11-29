package codeFromVenu.exceptionHandling.finallyBlock;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class FinallyBlock {

    public static void main(String[] args) throws FileNotFoundException {

        try {
              FileInputStream file = new  FileInputStream("C:\\Hybrid\\Reports\\temp1.txt");
              System.out.println("I'm from try block");
        }
        catch (FileNotFoundException  e){
            System.out.println("The file path you specific is not correct or invalid");
            System.out.println("I'm from catch block");
        }

        finally {
            System.out.println("I'm from finally block");
        }


         }
    }
