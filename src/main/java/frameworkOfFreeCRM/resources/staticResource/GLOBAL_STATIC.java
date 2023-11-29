package frameworkOfFreeCRM.resources.staticResource;

import frameworkOfFreeCRM.utilities.excelUtilities.ExcelTestDataUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Properties;

public class GLOBAL_STATIC {

    public static WebDriver driver;
    public static Properties  prop;
    public static ExcelTestDataUtility testData;
    public static String[]  nameOfModule = {"Contacts","Companies","Deals","Tasks","Cases","Calls"};
    public static int TEST_CASE_ID;

    public static void assignStaticContent(int id){
        TEST_CASE_ID = id;
    }






}
