package frameworkOfFreeCRM.utilities.screenshotUtilities;

import frameworkOfFreeCRM.resources.staticResource.GLOBAL_STATIC;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class ScreenshotUtility {

    public static void  chalBetaSelfielelele(String  screenshotName) {
        try {
            TakesScreenshot screenshot = (TakesScreenshot) GLOBAL_STATIC.driver;
         /**here we are doing typecast for driver into takesScreenshot*/
            File screenshotSource = screenshot.getScreenshotAs(OutputType.FILE);
          /**screenshot have method called getscreenshotAs using this we are getting screenshot.*/
            File screenshotDestination = new File("C:/TestsRunEvidences/"+GLOBAL_STATIC.TEST_CASE_ID+"/"+screenshotName+".png");
           /**here we give the path of the file */
            FileUtils.copyFile(screenshotSource,screenshotDestination);



        }
        catch(IOException e ){
            System.out.println("Something wrong with source & destination of screenshot location");

        }

    }







}
