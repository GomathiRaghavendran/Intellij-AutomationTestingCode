package frameworkOfFreeCRM.resources.globalResource;
import frameworkOfFreeCRM.resources.staticResource.GLOBAL_STATIC;
import frameworkOfFreeCRM.utilities.screenshotUtilities.ScreenshotUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageResource {
       public LoginPageResource(){
           PageFactory.initElements(GLOBAL_STATIC.driver,this);
       }

       @FindBy(xpath = "//span[text()='Log In']") WebElement  xpathOfLoginButton;
       @FindBy(xpath = "//input[@name='email']") WebElement  xpathOfUserNameTextBox;
       @FindBy(xpath = "//input[@name='password']") WebElement  xpathOfPasswordTextBox;
       @FindBy(xpath = "//div[text()='Login']") WebElement  xpathOfSubmitButton;
       @FindBy(xpath = "Something went wrong...") WebElement  expectedErrorMessage;

        public HomePageResource  enterUserNameAndPassword( String  un, String pwd) throws InterruptedException {
          xpathOfLoginButton.click();
          String  user = System.getProperty("username");
          String  pass = System.getProperty("password");
            if(user == null ) {
                xpathOfUserNameTextBox.sendKeys(un);
                xpathOfPasswordTextBox.sendKeys(pwd);
            } else {
                xpathOfUserNameTextBox.sendKeys(user);
                xpathOfPasswordTextBox.sendKeys(pass);
            }

            xpathOfSubmitButton.click();

            return   new HomePageResource();
        }

        public boolean validErrorMessage(){
            String actualErrorMessage = GLOBAL_STATIC.driver.findElement(By.xpath("//div[@class='header']")).getText();
            boolean  flag = actualErrorMessage.equals(expectedErrorMessage);
            return  flag;
        }

    public HomePageResource  enterValidCredentials( ) throws InterruptedException {

        String  user = System.getProperty("username");
        String  pass = System.getProperty("password");

        String un = GLOBAL_STATIC.prop.getProperty("username");
        String  pwd = GLOBAL_STATIC.prop.getProperty("password");

        if(user == null ) {
            xpathOfUserNameTextBox.sendKeys(un);
            xpathOfPasswordTextBox.sendKeys(pwd);
        } else {
            xpathOfUserNameTextBox.sendKeys(user);
            xpathOfPasswordTextBox.sendKeys(pass);
        }

        xpathOfSubmitButton.click();

        GLOBAL_GENERIC.locateAndGetWebElement(CommonXpath.xpathOfHomeIcon).isDisplayed();
        ScreenshotUtility.chalBetaSelfielelele("afterLogin");
        return   new HomePageResource();
    }


    }


