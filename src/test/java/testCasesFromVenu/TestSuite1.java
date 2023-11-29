package testCasesFromVenu;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({frameworkOfFreeCRM.utilities.extentReports.ExternalReports.class})
public class TestSuite1 {


    @Test
    public void testCase1() {
        String  snack = System.getProperty("fody");
        System.out.println("Here is your "+snack);
    }

    /*
    @Test
    public void testCase2(){
        System.out.println("Hello!!! I'm test case no 2 from Test Suite 1");
    }


   @BeforeMethod
    public void setup() {
        System.out.println("Welcome to test run");
    }

    @AfterMethod
    public void teardown() {
        System.out.println("Bye bye to test run");
    }

    @Test
    public void testCase3(){
        System.out.println("Hello!!! I'm test case no 3 from Test Suite 1");
    }


    @Test
    public void testCase4(){
        System.out.println("Hello!!! I'm test case no 4 from Test Suite 1");
    }
*/


}