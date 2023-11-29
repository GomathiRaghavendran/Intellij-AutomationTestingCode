package gomframeworkOfFreeCRM.gomResources.companiesModuleResource;


import gomframeworkOfFreeCRM.gomResources.globalResource.GomCommonXpath;
import gomframeworkOfFreeCRM.gomResources.globalResource.GomGLOBAL_GENERIC;
import gomframeworkOfFreeCRM.gomResources.staticReource.GomGLOBAL_STATIC;
import gomframeworkOfFreeCRM.gomUtilities.ScreenshotUtility.GomScreenshotUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class GomCompaniesOverviewResource {
    /**
     * This default constructor deals with driver handling using Page factory Class
     * while creating object for the class,default constructor will be executed
     * and it will handle the driver using initElements method from Page factory class
     * initElements method will take care of providing the mapping between driver and locators which we want to locate by using @Find by annotation
     */

    public GomCompaniesOverviewResource() {
        PageFactory.initElements(GomGLOBAL_STATIC.driver, this);
    }

   // public static String xpathOfDeleteIconInCompaniesOverviewPage = "//i[@class='trash icon']";
    //public static String xpathOfNavigationToNextPage = "//div[@class='ui right floated pagination menu custom-pagination']/a[@class='icon item']/i";
    public static String xpathOfTextMessageAfterDeletion = "//p[text()='No records found']";

     String[] defaultColumns = {"Name", "Address", "Options"};

    /**
     * This method deals with default columns of Companies overview screen
     */
    public void validateCompaniesGridDefaultColumns() {
        int length = defaultColumns.length;
        for (int index = 0; index < length; index++) {
            boolean status = GomGLOBAL_STATIC.driver.findElement(By.xpath("//th[text()='" + defaultColumns[index] + "']")).isDisplayed();
            // Assert.assertEquals(status, true);
            //System.out.println(status);
        }
        GomScreenshotUtility.chaLBetaSelfieLeLele("defaultColumnOfCompaniesOverviewPage");
    }

    /**
     * This method deals with click on view icon and check the company name with red icon in Companies overview screen
     */
    public void navigateToCompanyDetails(String companyName)  {
        GomGLOBAL_STATIC.driver.findElement(By.xpath("//a[text()='" + companyName + "']/../following-sibling::td/a/button/i[@class='unhide icon']")).click();
        GomGLOBAL_STATIC.driver.findElement(By.xpath("//span[text()='" + companyName + "']/i[@class='large building red icon']")).isDisplayed();
        GomScreenshotUtility.chaLBetaSelfieLeLele("Companies Details");
    }
/** This method deals with adding Notes in View companies page*/
    public void navigateToRightSideSectionOfCompanyDetailsViewPage(String companyName) {
        GomGLOBAL_GENERIC.locateAndGetWebElement(GomCommonXpath.XpathOfAddIconButton).click();
        GomGLOBAL_GENERIC.locateAndGetWebElement(GomCommonXpath.XpathOfTextArea);
        GomGLOBAL_GENERIC.locateAndGetWebElement(GomCommonXpath.XpathOfSaveButtonInViewOverViewPage).click();
    }

    /**
     * This method deals with click on Edit icon and check the VATNumber text box in Companies overview screen
     */
    public void navigateToCompaniesEditScreen(String companyName) {
        String dynamicXpathOfEditicon = "//a[text()='" + companyName + "']/../following-sibling::td/a/button/i[@class='edit icon']";
        GomGLOBAL_GENERIC.locateAndGetWebElement(dynamicXpathOfEditicon).click();

        String dynamicXpathOfCompanyName = "//input[@value='" + companyName + "']";
        GomGLOBAL_GENERIC.locateAndGetWebElement(dynamicXpathOfCompanyName).isDisplayed();

        String VatNoBox = "//label[text()='VAT Number']";
        boolean flag = GomGLOBAL_GENERIC.locateAndGetWebElement(VatNoBox).isDisplayed();
        System.out.println(flag);

        GomGLOBAL_GENERIC.locateAndGetWebElement(GomCommonXpath.xpathOfSaveButton);
        GomScreenshotUtility.chaLBetaSelfieLeLele("Companies Edit Screen");
    }

    /**
     * This method deals with deleting the company record from Companies overView page
     */
    public void deleteTheCompaniesFromOverViewPage(String cName) {
        String dynamicXpathOfDeleteIcon = "//a[text()='" + cName + "']/../following-sibling::td//button/i[@class='trash icon']";
        GomGLOBAL_GENERIC.locateAndGetWebElement(dynamicXpathOfDeleteIcon).click();
        GomGLOBAL_GENERIC.deleteConfirmationPopUp(true);
    }

    /**public static void companiesTestdataCleanup() {
        try {
            forLoop();
        } catch(NoSuchElementException | InterruptedException e) {
            System.out.println("No records to delete. ");
            String expectedTextMessage="No records found";
            String actualTextMessage=GomGLOBAL_GENERIC.locateAndGetWebElement(GomCompaniesOverview.xpathOfTextMessageAfterDeletion).getText();
            Assert.assertEquals(expectedTextMessage,actualTextMessage);
        }
    }
    public static void forLoop() throws InterruptedException {
       boolean flag = GomGLOBAL_GENERIC.locateAndGetWebElement((GomCompaniesOverview.xpathOfNavigationToNextPage)).isDisplayed();
        System.out.println(flag);

        do {
            int countOfDeleteIcons = GomGLOBAL_GENERIC.getTheWebElementsCount(GomCompaniesOverview.xpathOfDeleteIconInCompaniesOverviewPage);
            System.out.println(countOfDeleteIcons);
            for (int i = 0; i < countOfDeleteIcons; i++) {
                GomGLOBAL_GENERIC.locateAndGetWebElement(GomCompaniesOverview.xpathOfDeleteIconInCompaniesOverviewPage).click();
                GomGLOBAL_GENERIC.deleteConfirmationPopUp(true);
            }
          flag = GomGLOBAL_GENERIC.locateAndGetWebElement((GomCompaniesOverview.xpathOfNavigationToNextPage)).isDisplayed();
          System.out.println(flag);

        } while (flag == true);
    }*/
    // In the below method deleting all the records on companies overview page
    public static void companiesTestdataCleanup() throws InterruptedException {
        Thread.sleep(1000);
    int countOfPages=GomGLOBAL_GENERIC.getTheWebElementsCount(GomCommonXpath.xpathOfPagination);
    System.out.println("Total number of pages: "+countOfPages);
   for (int i=0;i<countOfPages-2;i++){
        int countOfDeleteIcons = GomGLOBAL_GENERIC.getTheWebElementsCount(GomCommonXpath.xpathOfDeleteIconInCompaniesOverviewPage);
       System.out.println(GomCommonXpath.xpathOfDeleteIconInCompaniesOverviewPage);
        System.out.println("Total no.of Delete icons:"+countOfDeleteIcons);
        for (int j = 0; j < countOfDeleteIcons; j++) {
            GomGLOBAL_GENERIC.locateAndGetWebElement(GomCommonXpath.xpathOfDeleteIconInCompaniesOverviewPage).click();
            GomGLOBAL_GENERIC.deleteConfirmationPopUp(true);
        }
    }
    GomScreenshotUtility.chaLBetaSelfieLeLele("CleanupTestData");
}
    }








