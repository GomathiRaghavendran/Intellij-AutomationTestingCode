package gomTestsOfFreeCRM.gomCasesModuleTests;

import frameworkOfFreeCRM.base.Base;
import frameworkOfFreeCRM.resources.casesModuleResource.CasesFilterResource;
import frameworkOfFreeCRM.resources.casesModuleResource.CasesGlobalResource;
import frameworkOfFreeCRM.resources.casesModuleResource.CasesOverview;
import frameworkOfFreeCRM.resources.globalResource.CommonXpath;
import frameworkOfFreeCRM.resources.staticResource.GLOBAL_STATIC;
import gomframeworkOfFreeCRM.gomResources.globalResource.GomGLOBAL_GENERIC;
import gomframeworkOfFreeCRM.gomResources.staticReource.GomGLOBAL_STATIC;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class GomCasesOverviewTests extends Base {
    CasesOverview co;
    @BeforeMethod
    public void testSetup() throws IOException, InterruptedException {
        launchBrowser().enterValidCredentials();
        GomGLOBAL_GENERIC.navigateToModule(GomGLOBAL_STATIC.nameOfModule[4]);
        co=new CasesOverview();
    }

    @Test
    public void validateDefaultColumnsOfCases() throws InterruptedException
    {
        GLOBAL_STATIC.assignStaticContent(1);
        co.validateCasesDefaultColumn();
        }
    @Test
    public void validateTheViewCaseIconBehaviour() throws InterruptedException {
            GLOBAL_STATIC.assignStaticContent(2);
            String caseName = GLOBAL_STATIC.testData.getCellData("TestDataForCases", 2, 1);
            co.navigateToCaseDetails(caseName);
            System.out.println("Handling the exception through Try and catch block");
        }

    @Test
    public void validateTheEditIconBehaviourInOverviewPage(){
        GLOBAL_STATIC.assignStaticContent(3);
        String nameOfEditCases = GLOBAL_STATIC.testData.getCellData("TestDataForCases", 2, 1);
        System.out.println(nameOfEditCases);
        co.validateTheCasesEditIcon(nameOfEditCases);
    }

    @Test
    public void validateTheDeleteIcon() throws InterruptedException {
        String caseName=GomGLOBAL_STATIC.testData.getCellData("TestDataForCases",3,1);
        System.out.println(caseName);
        co.deleteTheCasesFromOverviewPage(caseName);
        GomGLOBAL_GENERIC.navigateToModule(GLOBAL_STATIC.nameOfModule[4]);
        boolean statusOfCasesRecord= CasesGlobalResource.checkForCasesRecord(caseName);
        Assert.assertEquals(statusOfCasesRecord,false);
    }
    @Test
    public void showFilterButtonFunctionalityInCasesOverviewPage()
    {
        GomGLOBAL_GENERIC.locateAndGetWebElement(CommonXpath.xpathOfShowFilterButton).click();
        CasesFilterResource cfr=new CasesFilterResource();
        cfr.validateShowFilterScreenWebElements();
    }
    @Test
    public void hideFilterButtonFunctionalityInCasesOverviewPage() throws InterruptedException {
        GomGLOBAL_GENERIC.locateAndGetWebElement(CommonXpath.xpathOfShowFilterButton).click();
        CasesFilterResource cfr=new CasesFilterResource();
        cfr.validateShowFilterScreenWebElements();
        Thread.sleep(3000);
        cfr.validateHideFilterScreenFunctionality();
    }

    @AfterMethod
    public void tearDown()
    {
        GomGLOBAL_STATIC.driver.close();
    }

}

