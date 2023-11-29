package gomframeworkOfFreeCRM.gomBase;


import frameworkOfFreeCRM.utilities.excelUtilities.ExcelTestDataUtility;
import gomframeworkOfFreeCRM.gomResources.globalResource.GomLoginPageResource;
import gomframeworkOfFreeCRM.gomResources.staticReource.GomGLOBAL_STATIC;
import gomframeworkOfFreeCRM.gomUtilities.GomExcelUtilities.GomExcelTestDataUtility;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class GomBase {
/** Launching the browser either via cmd prompt or via properties file**/
      public GomLoginPageResource launchBrowser() throws IOException {
        loadProperties();
        loadTestData();
          /** -will decide at runtime which browser to open frm CMD prompt by using mvn test commands.
           * -BrowserName should be given through command prompt(using mvn test -Dkey='value pair')*/
          String  br = System.getProperty("browserName");
        if(br == null) {
            /**prop is a static variable declared in GomGlobalStatic class.
             *  hence using it throughout the program with the class name
             *  it will take the value frm the properties files to the key name "browser" and launch the browser with specified browser name
             *  here data (browser) will travel from properties file so we have created object for the Properties class and accessing get property method in it*/
            br = GomGLOBAL_STATIC.prop.getProperty("browser");
            openSpecificBrowser(br);
        } else
            /**The value we provided should be taken into account from cmd prompt
             *  and launch the browser with specified browser name*/
        openSpecificBrowser(br);
          /**driver is a static variable declared in GomGlobalStatic class.
           *  hence using it throughout the program with the class name
           *  maximize method is used to get the maximized window of the application*/
          GomGLOBAL_STATIC.driver.manage().window().maximize();
          /**Implicit wait is a global wait
           * here, driver is patched with implicit wait ,then the driver will wait for specified time(10seconds) to through "No such element Exception"*/
           GomGLOBAL_STATIC.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
          /** it will take the value frm the properties files to the key name "application URL"
          * and it launches the application URL  specified in config.properties class*/
           GomGLOBAL_STATIC.driver.get(GomGLOBAL_STATIC.prop.getProperty("applicationURL"));
        return new GomLoginPageResource();
    }

/**This method deals with all the supported browser that can be launched
 *  it has objects for respective browsers to launch the browser*/
    public void openSpecificBrowser(String browser){


        if(browser.equals("Chrome")|| browser.equals("chrome") ) {
            GomGLOBAL_STATIC.driver = new ChromeDriver();
        }
        if(browser.equals("FireFox")|| browser.equals("firefox") )
        {
            GomGLOBAL_STATIC.driver = new FirefoxDriver();
        }
        if (browser.equals("Edge")|| browser.equals("edge")) {
            GomGLOBAL_STATIC.driver = new EdgeDriver();
        }
    }

    /** This method locates the excel from the specified path
    /** An object for the class "GomExcelTestDataUtility" is created and assigned
     *  to the Static Variable "testData" of the class "GomGlobal_STATIC" */
    public void loadTestData(){
        GomGLOBAL_STATIC.testData=new GomExcelTestDataUtility("C:/Hybrid1/Mybranch/TestData.xlsx");
    }
    /**This method locates the config properties file from the specified path and loads the data
     * -- Locate : An object for the class "FileInputStream" is created and assigned to the local variable "file"
     *             of the "loadProperties()" method
     * -- Load   : An object for the class "Properties" is created and assigned to that static variable "prop"
     *             of the class "Properties"
     *             Accessing the load method By passing the object reference variable name "file" **/
    public void loadProperties() throws IOException {

        FileInputStream file = new FileInputStream("src/main/java/gomframeworkOfFreeCRM/gomConfig/GomConfig.properties");
        GomGLOBAL_STATIC.prop = new Properties();
        GomGLOBAL_STATIC.prop.load(file);

    }
}
