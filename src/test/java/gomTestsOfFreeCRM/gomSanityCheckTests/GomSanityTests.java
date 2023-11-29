package gomTestsOfFreeCRM.gomSanityCheckTests;

import frameworkOfFreeCRM.resources.staticResource.GLOBAL_STATIC;
import gomframeworkOfFreeCRM.gomBase.GomBase;

import gomframeworkOfFreeCRM.gomResources.globalResource.GomHomePageResource;
import gomframeworkOfFreeCRM.gomResources.staticReource.GomGLOBAL_STATIC;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class GomSanityTests extends GomBase {

    GomHomePageResource hps;


    @BeforeMethod
    public void setup() throws IOException, InterruptedException {
      hps=launchBrowser().enterValidCredentials();
      //  hps=launchBrowser().enterUserNameAndPassword(GomGLOBAL_STATIC.prop.getProperty("invalidusername"), GomGLOBAL_STATIC.prop.getProperty("password"));

    }


    @Test
    public void loginToFreeCrmApplication() {
      GomGLOBAL_STATIC.driver.findElement(By.xpath(hps.xpathOfTR)).isDisplayed();

    }

    @Test
    public void validateTheModulesOfApplication() throws InterruptedException {
        hps.validateLeftSideMenuItems();
    }

   /** @AfterMethod
    public void teardown(){
      GomGLOBAL_STATIC.driver.close();
    }*/


}
