package frameworkOfFreeCRM.base;
import frameworkOfFreeCRM.resources.staticResource.GLOBAL_STATIC;
import frameworkOfFreeCRM.resources.globalResource.LoginPageResource;
import frameworkOfFreeCRM.utilities.excelUtilities.ExcelTestDataUtility;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Base {
    /** This method dealsModulePipeline with launching the browser in two ways
     * first it will takes the value from command prompt
     * if value is not received via cmd prompt then it will take the value from the config.properties file
     * it returns the object of login page resource, hence we can access methods in that class also. while we are calling this method*/
    public LoginPageResource launchBrowser() throws IOException {
        loadProperties();
        loadTestData();
        String  br = System.getProperty("browserName");
        if(br == null){
            br = GLOBAL_STATIC.prop.getProperty("browser");
            openSpecificBrowser(br);
        } else
        openSpecificBrowser(br);
        /** driver is a static variable declared in Global static class
         driver is patched with implicit wait here, so it will wait for specified time through "No such Element" Exception*/
        GLOBAL_STATIC.driver.manage().window().maximize();
        GLOBAL_STATIC.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        GLOBAL_STATIC.driver.get(GLOBAL_STATIC.prop.getProperty("applicationURL"));
        return  new LoginPageResource();
    }

/**This method dealsModulePipeline with which browser needs to be opened,
 *  it has objects for respective browsers to launch the browser*/
    public void openSpecificBrowser(String browser){
        if(browser.equals("Chrome")|| browser.equals("chrome") ) {
            GLOBAL_STATIC.driver = new ChromeDriver();
        }
        if(browser.equals("Firefox")|| browser.equals("firefox") || browser.equals("FF") )
        {
            GLOBAL_STATIC.driver = new FirefoxDriver();
        }
        if (browser.equals("Edge")) {
            GLOBAL_STATIC.driver = new EdgeDriver();
        }
    }

/** This method dealsModulePipeline with retrieving data from Excel sheet
     *  so creating a method in base class and creating object reference of excelTestUtility within that method
     *  with that object reference variable of the class, storing the values
     *  testdata is a static variable declared in GomGlobalStatic class,access that variable by using its class name*/
    public void loadTestData(){
         GLOBAL_STATIC.testData = new ExcelTestDataUtility("src/main/java/frameworkOfFreeCRM/testData/freeCRMApplicationTestData.xlsx");
    }
    /**This method dealsModulePipeline with loading the data from Excel sheet
     * providing the path of file to object of FileInputStream, File Input stream is  a class
     * load the specified file into properties class using the object ref variable name */
    public void loadProperties() throws IOException {
        FileInputStream file = new FileInputStream("src/main/java/frameworkOfFreeCRM/config/config.properties");
        GLOBAL_STATIC.prop = new Properties();
        GLOBAL_STATIC.prop.load(file);

    }
}
