package testsOfFreeCRM.sanityCheckTests;

import frameworkOfFreeCRM.base.Base;
import frameworkOfFreeCRM.resources.staticResource.GLOBAL_STATIC;
import frameworkOfFreeCRM.resources.globalResource.HomePageResource;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class SanityTests extends Base {

    HomePageResource  hp;

    @BeforeMethod
    public void setup() throws IOException, InterruptedException {
          hp = launchBrowser().enterUserNameAndPassword(GLOBAL_STATIC.prop.getProperty("invalidusername"),GLOBAL_STATIC.prop.getProperty("password"));
    }

    @Test
    public void loginToFreeCrmApplication() throws InterruptedException {
        // GLOBAL_STATIC.driver.findElement(By.xpath(hp.xpathOfTR)).isDisplayed();
    }

    @Test
    public void validateTheLeftMenuOptions() throws InterruptedException {
       // hp.validateLeftSideMenuItems_v1();
    }

    @AfterMethod
    public  void teardown(){
        GLOBAL_STATIC.driver.close();
    }


}
