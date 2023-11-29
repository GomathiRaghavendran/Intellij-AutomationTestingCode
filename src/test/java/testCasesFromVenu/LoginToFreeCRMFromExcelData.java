package testCasesFromVenu;

import frameworkOfFreeCRM.base.Base;
import frameworkOfFreeCRM.resources.globalResource.LoginPageResource;
import frameworkOfFreeCRM.resources.staticResource.GLOBAL_STATIC;
import frameworkOfFreeCRM.utilities.excelUtilities.ExcelTestDataUtility;
import org.testng.annotations.*;

import java.io.IOException;
@Listeners({codeFromVenu.seleniumConcept.Listeners.TellingLies.class,frameworkOfFreeCRM.utilities.extentReports.ExternalReports.class})
public class LoginToFreeCRMFromExcelData extends Base {

    LoginPageResource lp;
    String  validUserName;
    String  invalidUserName;
    String  validPassword;
    String  invalidPassword;

    @BeforeSuite
    public void loadTestData(){
        ExcelTestDataUtility   testData = new ExcelTestDataUtility("C:\\Users\\tammi\\OneDrive\\Desktop\\testDataV1.xlsx");
        validUserName = testData.getCellData("freeCRMAppCredentials",2,1);
        validPassword = testData.getCellData("freeCRMAppCredentials",2,2);
        invalidUserName = testData.getCellData("freeCRMAppCredentials",3,1);
        invalidPassword = testData.getCellData("freeCRMAppCredentials",2,2);
    }

    @BeforeMethod
    public void setup() throws IOException, InterruptedException {
        lp = launchBrowser();
    }

    @Test (priority=1,groups ={"positiveCase"})
    public void validUserNameAndValidPassword() throws InterruptedException {
        lp.enterUserNameAndPassword(validUserName,validPassword);
        Thread.sleep(3000);
    }

    @Test(priority=2,groups = {"negativeCase"})
    public void validUserNameAndInvalidPassword() throws InterruptedException {
        lp.enterUserNameAndPassword(validUserName,invalidPassword);
        lp.validErrorMessage();
    }

    @Test(priority=3,groups = {"negativeCase"})
    public void InvalidUserNameAndValidPassword() throws InterruptedException {
        lp.enterUserNameAndPassword(invalidUserName, validPassword);
        lp.validErrorMessage();
    }

    @Test(priority=4,groups = {"negativeCase"})
    public void invalidUserNameAndInvalidPassword() throws InterruptedException {
        lp.enterUserNameAndPassword(invalidUserName,invalidPassword);
        lp.validErrorMessage();
    }
    @Test
    public void retrieveTestDataFromExcelUnderstanding(){
        ExcelTestDataUtility   testData = new ExcelTestDataUtility("C:\\Users\\tammi\\OneDrive\\Desktop\\testDataV1.xlsx");
        String retrivedData = testData.getCellData("Sheet3",13,8);
        System.out.println(retrivedData);
    }

    @AfterMethod(alwaysRun = true)
    public void teardown(){
        GLOBAL_STATIC.driver.close();
    }



}
