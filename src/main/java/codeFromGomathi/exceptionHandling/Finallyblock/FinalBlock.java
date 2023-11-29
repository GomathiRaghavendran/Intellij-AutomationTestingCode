package codeFromGomathi.exceptionHandling.Finallyblock;

import java.io.FileInputStream;

public class FinalBlock {
    public static void main(String[] args) {
        try{
            FileInputStream io=new FileInputStream("C:\\Hybrid\\TesData.xlsx");

        } catch (Exception e) {
            System.out.println("The file you specific is not correct or invalid");
        }
        finally {
            System.out.println("I execute always");
        }

    }
}
