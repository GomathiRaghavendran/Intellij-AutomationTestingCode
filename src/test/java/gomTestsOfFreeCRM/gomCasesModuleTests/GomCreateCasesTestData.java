package gomTestsOfFreeCRM.gomCasesModuleTests;

import frameworkOfFreeCRM.resources.casesModuleResource.CasesGlobalResource;
import gomframeworkOfFreeCRM.gomBase.GomBase;
import gomframeworkOfFreeCRM.gomResources.globalResource.GomGLOBAL_GENERIC;
import gomframeworkOfFreeCRM.gomResources.staticReource.GomGLOBAL_STATIC;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class GomCreateCasesTestData extends GomBase {

    @BeforeMethod
    public void testSetup() throws IOException, InterruptedException
    {
        launchBrowser().enterValidCredentials();
    }

    @Test
    public void createTestData() throws InterruptedException
    {
        GomGLOBAL_GENERIC.navigateToModule(GomGLOBAL_STATIC.nameOfModule[4]);
        CasesGlobalResource cgr=new CasesGlobalResource();
        for(int i=2;i<9;i++)
        {
            cgr.createCases(i);
        }
    }

    @AfterMethod
    public void tearDown()
    {
        GomGLOBAL_STATIC.driver.close();
    }

}
