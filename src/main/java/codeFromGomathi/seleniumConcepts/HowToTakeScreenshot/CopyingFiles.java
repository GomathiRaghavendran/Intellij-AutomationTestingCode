package codeFromGomathi.seleniumConcepts.HowToTakeScreenshot;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class CopyingFiles {

    public static void main(String[] args) throws IOException {
        File Folder1=new File("C:\\Folder1\\ScreenshotsOfFreeCRMLogin.png");
        File Folder2= new File("C:\\Folder2\\img.png");
        Files.copy(Folder1.toPath(),Folder2.toPath());
    }
}
