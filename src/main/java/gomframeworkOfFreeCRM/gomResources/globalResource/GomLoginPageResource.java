package gomframeworkOfFreeCRM.gomResources.globalResource;


import frameworkOfFreeCRM.resources.staticResource.GLOBAL_STATIC;
import gomframeworkOfFreeCRM.gomResources.staticReource.GomGLOBAL_STATIC;
import gomframeworkOfFreeCRM.gomUtilities.ScreenshotUtility.GomScreenshotUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GomLoginPageResource {

    public GomLoginPageResource() {
        PageFactory.initElements(GomGLOBAL_STATIC.driver,this);
    }

    //String xpathOfLoginButton = "//span[text()='Log In']";
   // String xpathOfSignupButton="//a[text()='Sign Up']";
@FindBy(xpath = "//a[text()='Sign Up']")WebElement XpathOfSignupButton;
    @FindBy(xpath="//span[text()='Log In']")WebElement xpathOfLoginButton;
    @FindBy(xpath="//input[@name='email']") WebElement xpathOfUserNameTextBox;
    @FindBy(xpath = "//input[@name='password']") WebElement xpathOfPasswordTextBox;
    @FindBy (xpath="//div[text()='Login']")WebElement xpathOfSubmitButton;
    @FindBy(xpath="Something went wrong...") WebElement expectedErrorMessage;

    //String  xpathOfUserNameTextBox="//input[@name='email']";
    //String xpathOfPasswordTextBox = "//input[@name='password']";
    //String xpathOfSubmitButton = "//div[text()='Login']";
    //String expectedErrorMessage = "Something went wrong...";

/**This method deals with entering Username and password via config.properties file
 * if user is not equal to null then it will pick the value from the parameters(username and password) defined in Jenkins*/
    public GomHomePageResource enterUserNameAndPassword(String un, String Pwd) throws InterruptedException {
       // GomGLOBAL_STATIC.driver.findElement(By.xpath(xpathOfLoginButton)).click();
        //GomGLOBAL_STATIC.driver.findElement(By.xpath(xpathOfSignupButton)).click();
        XpathOfSignupButton.click();

        String user = System.getProperty("username");
        String pass = System.getProperty("password");
        if (user == null) {
           xpathOfUserNameTextBox.sendKeys(un);
           xpathOfPasswordTextBox.sendKeys(Pwd);

        } else {
            xpathOfUserNameTextBox.sendKeys(user);
            xpathOfPasswordTextBox.sendKeys(pass);

        }
       xpathOfSubmitButton.click();

        return new GomHomePageResource();

    }
/** This method deals with validating the error message if user provides invalid credentials*/
    public boolean validErrorMessage() {
        String actualErrorMessage = GomGLOBAL_STATIC.driver.findElement(By.xpath("//div[@class='header']")).getText();
        boolean flag = actualErrorMessage.equals(expectedErrorMessage);
        return flag;
    }
    /**This method deals with entering valid Username and password via config.properties file
     * if user is not equal to null then it will pick the value from the parameters(username and password) defined in Jenkins
     * navigates to homepage after the successful login
     * it returns the object of GomHomepage resource,we can access method by using this object reference in that class*/
    public GomHomePageResource enterValidCredentials() throws InterruptedException {
        //GomGLOBAL_STATIC.driver.findElement(By.xpath(xpathOfLoginButton)).click();
        //GomGLOBAL_STATIC.driver.findElement(By.xpath(xpathOfSignupButton)).click();
       // XpathOfSignupButton.click();
        String user = System.getProperty("username");
        String pass = System.getProperty("password");

        String un = GomGLOBAL_STATIC.prop.getProperty("username");
        String  pwd = GomGLOBAL_STATIC.prop.getProperty("password");

        if (user == null) {
            //String username = GomGLOBAL_STATIC.testData.getCellData("freeCRMAppCredentials", 3, 1);
            //String password = GomGLOBAL_STATIC.testData.getCellData("freeCRMAppCredentials", 3, 2);
           xpathOfUserNameTextBox.sendKeys(un);
           xpathOfPasswordTextBox.sendKeys(pwd);

        }else {
          xpathOfUserNameTextBox.sendKeys(user);
          xpathOfPasswordTextBox.sendKeys(pass);

        }
            xpathOfSubmitButton.click();
            GomScreenshotUtility.chaLBetaSelfieLeLele("After login page");

            return new GomHomePageResource();
        }


    }


