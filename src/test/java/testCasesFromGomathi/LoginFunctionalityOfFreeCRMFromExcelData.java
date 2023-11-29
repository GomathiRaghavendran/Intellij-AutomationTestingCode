package testCasesFromGomathi;


import gomframeworkOfFreeCRM.gomBase.GomBase;

import gomframeworkOfFreeCRM.gomResources.globalResource.GomLoginPageResource;
import gomframeworkOfFreeCRM.gomResources.staticReource.GomGLOBAL_STATIC;
import gomframeworkOfFreeCRM.gomUtilities.GomExcelUtilities.GomExcelTestDataUtility;
import org.testng.annotations.*;

import java.io.IOException;

@Listeners({codeFromGomathi.seleniumConcepts.ListenersConcept.TellingLies.class,gomframeworkOfFreeCRM.gomUtilities.GomextentReports.GomExternalReports.class})
public class LoginFunctionalityOfFreeCRMFromExcelData extends GomBase {

    GomLoginPageResource glp;
    String  validUserName;
    String  invalidUserName;
    String  validPassword;
    String  invalidPassword;

    @BeforeSuite
    public void loadTestData(){
    GomExcelTestDataUtility testData=new GomExcelTestDataUtility("C:\\Users\\gomat\\Desktop\\Intellij\\TestData\\TestData.xlsx");
    validUserName=testData.getCellData("LoginCredentialsOfFreeCRM",2,1);
    validPassword=testData.getCellData("LoginCredentialsOfFreeCRM",2,2);
    invalidPassword=testData.getCellData("LoginCredentialsOfFreeCRM",3,2);
    invalidUserName=testData.getCellData("LoginCredentialsOfFreeCRM",3,1);
    }

    @BeforeMethod
    public  void setUp() throws IOException {
        glp=launchBrowser();

    }

    @Test(priority=1,groups = {"positiveCase"})
    public void ValidUserNameAndValidPassword() throws InterruptedException {
        glp.enterUserNameAndPassword(validUserName,validPassword);
        Thread.sleep(3000);
    }

    @Test(priority=2,groups = {"negativeCase"})
    public void validUserNameAndInvalidPassword() throws InterruptedException {
        glp.enterUserNameAndPassword(validUserName,invalidPassword);
        glp.validErrorMessage();
    }

    @Test(priority=3,groups = {"negativeCase"})
    public void invalidUserNameAndValidPassword() throws InterruptedException {
        glp.enterUserNameAndPassword(invalidUserName,validPassword);
        glp.validErrorMessage();
    }
    @Test(priority=4,groups = {"negativeCase"})
    public void invalidUserNameAndinValidPassword() throws InterruptedException {
        glp.enterUserNameAndPassword(invalidUserName,invalidPassword);
        glp.validErrorMessage();
    }
    @AfterMethod
    public void tearDown(){
        GomGLOBAL_STATIC.driver.close();
    }




}
