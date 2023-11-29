package gomframeworkOfFreeCRM.gomUtilities.ScreenshotUtility;

import gomframeworkOfFreeCRM.gomResources.staticReource.GomGLOBAL_STATIC;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class GomScreenshotUtility {
    /** This method is used to take a snap shot of each test cases and store it in specified location
     * if something goes wrong then it displays the error message*/
    public static void  chaLBetaSelfieLeLele(String  screenshotName){
        try {
            TakesScreenshot screenshot = (TakesScreenshot) GomGLOBAL_STATIC.driver;
            File screenshotSource = screenshot.getScreenshotAs(OutputType.FILE);
            File screenshotDestination = new File("C:/testEvidences/"+GomGLOBAL_STATIC.TEST_CASE_ID+"/"+screenshotName+".png");
            FileUtils.copyFile(screenshotSource,screenshotDestination);

        }
        catch(IOException e ){
            System.out.println("Something wrong with source & destination of screenshot location");

        }

    }
}
