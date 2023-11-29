package codeFromVenu.exceptionHandling.throwKeyword;

import java.io.FileNotFoundException;
import java.util.NoSuchElementException;

public class ThrowKeyword {



    public void provideTheStudentAgeAtTheTimeOfGradation(int age) {

        try {
            if (age < 18 || age > 21) {
                throw new NoSuchElementException();
            }

        } catch (NoSuchElementException e){
            System.out.println("Age your provide is not the Graduation student age ");
        }



    }


    public static void main(String[] args) throws InterruptedException, FileNotFoundException {
        ThrowKeyword  tk = new ThrowKeyword();
       tk.provideTheStudentAgeAtTheTimeOfGradation(4);
    }





}
