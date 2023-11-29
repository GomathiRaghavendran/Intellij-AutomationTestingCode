package gomframeworkOfFreeCRM.gomResources.staticReource;



import frameworkOfFreeCRM.resources.staticResource.GLOBAL_STATIC;
import gomframeworkOfFreeCRM.gomUtilities.GomExcelUtilities.GomExcelTestDataUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Properties;

public class GomGLOBAL_STATIC {

    public static WebDriver driver;

    public static Properties prop;

    public static GomExcelTestDataUtility testData;
    public static String  xpathOfSaveButton;
    public static String[] nameOfModule = {"Contacts", "Companies", "Deals", "Tasks", "Cases", "Calls"};

    public static String xpathOfApplicationHeader = "//div[@class='header item']";

    public static int TEST_CASE_ID;
    public static void assignStaticContent(int id){
        TEST_CASE_ID = id;
    }


}
