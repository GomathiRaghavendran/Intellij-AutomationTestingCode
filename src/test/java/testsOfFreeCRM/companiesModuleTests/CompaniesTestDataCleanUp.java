package testsOfFreeCRM.companiesModuleTests;

import frameworkOfFreeCRM.base.Base;
import frameworkOfFreeCRM.resources.globalResource.CommonXpath;
import frameworkOfFreeCRM.resources.globalResource.GLOBAL_GENERIC;
import frameworkOfFreeCRM.resources.staticResource.GLOBAL_STATIC;
import frameworkOfFreeCRM.utilities.screenshotUtilities.ScreenshotUtility;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;
@Listeners({frameworkOfFreeCRM.utilities.extentReports.ExternalReports.class})
public class CompaniesTestDataCleanUp extends Base {

    @BeforeMethod(alwaysRun = true)
    public void testSetUp() throws IOException, InterruptedException {
        launchBrowser().enterValidCredentials();
        GLOBAL_GENERIC.navigateToModule(GLOBAL_STATIC.nameOfModule[1]);
    }

    //In below method we are deleting all the records on companies overview page
    @Test (groups={"sanity","companiesModule"})
    public void cleanUpTestData() throws InterruptedException {
        /**
        GLOBAL_STATIC.assignStaticContent(218);
        int countOfDeleteIcons =  GLOBAL_GENERIC.getTheWebElementsCount(CompaniesOverview.xpathOfDeleteIconInCompaniesOverviewPage);
        for (int i =0;i<countOfDeleteIcons;i++){
            GLOBAL_GENERIC.locateAndGetWebElement(CompaniesOverview.xpathOfDeleteIconInCompaniesOverviewPage).click();
            GLOBAL_GENERIC.deleteConfirmationPopUp(true);
        }
        //taking the screenshot after deleting all the records on companies overview page
        ScreenshotUtility.chalBetaSelfielelele("CleanUp testData");
         **/
        //In this method we can delete the companies record pages
        GLOBAL_STATIC.assignStaticContent(1);
        Thread.sleep(1000);
        int countOfPages = GLOBAL_GENERIC.getTheWebElementsCount(CommonXpath.xpathOfPagination);
        System.out.println(countOfPages);
        for(int i=0;i<countOfPages-2;i++){
            int countOfDeleteIcons = GLOBAL_GENERIC.getTheWebElementsCount(CommonXpath.xpathOfDeleteIcon);
            System.out.println(countOfDeleteIcons);
            for(int j=0;j<countOfDeleteIcons;j++){
                GLOBAL_GENERIC.locateAndGetWebElement(CommonXpath.xpathOfDeleteIcon).click();
                GLOBAL_GENERIC.deleteConfirmationPopUp(true);
                ScreenshotUtility.chalBetaSelfielelele("TestDataCleanup");

            }
        }

    }

    @AfterMethod(alwaysRun = true)
    public void testTearDown(){

        GLOBAL_STATIC.driver.close();
    }




}
