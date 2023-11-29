package codeFromVenu.exceptionHandling.throwsBlock;

import codeFromVenu.exceptionHandling.throwKeyword.ThrowKeyword;

import java.io.FileNotFoundException;
import java.util.NoSuchElementException;

public class ThrowsKeyword {

    public void provideTheStudentAgeAtTheTimeOfGradation(int age) throws FileNotFoundException, RuntimeException {

            if (age < 18 || age > 21) {
                throw new FileNotFoundException();
            }

            if (age > 30){
                throw  new RuntimeException();
            }


    }


    public static void main(String[] args) throws FileNotFoundException {
        ThrowsKeyword tk = new ThrowsKeyword();
       tk.provideTheStudentAgeAtTheTimeOfGradation(4);
    }
}
