package codeFromVenu.exceptionHandling.tryCatchBlock;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Basic1ExceptionalHandling {
    public static void main(String[] args) throws FileNotFoundException {

        try {
            FileInputStream file = new  FileInputStream("c:/text.txt");
        }  catch (FileNotFoundException  e){
            System.out.println("The file path you specific is not correct or invalid");
        }




    }
}
