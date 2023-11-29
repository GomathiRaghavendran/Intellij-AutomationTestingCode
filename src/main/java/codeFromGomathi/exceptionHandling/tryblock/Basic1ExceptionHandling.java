package codeFromGomathi.exceptionHandling.tryblock;

import java.io.FileInputStream;

public class Basic1ExceptionHandling {
    public static void main(String[] args) {
        try{
            FileInputStream io=new FileInputStream("C:\\Hybrid\\TesData.xlsx");

        } catch (Exception e) {
            System.out.println("The file you specific is not correct or invalid");
        }
    }
}
