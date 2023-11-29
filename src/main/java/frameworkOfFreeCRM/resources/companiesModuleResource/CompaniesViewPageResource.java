package frameworkOfFreeCRM.resources.companiesModuleResource;

import frameworkOfFreeCRM.resources.casesModuleResource.CasesGlobalResource;
import frameworkOfFreeCRM.resources.casesModuleResource.CasesOverview;
import frameworkOfFreeCRM.resources.globalResource.CommonXpath;
import frameworkOfFreeCRM.resources.globalResource.GLOBAL_GENERIC;
import frameworkOfFreeCRM.resources.staticResource.GLOBAL_STATIC;
import frameworkOfFreeCRM.utilities.screenshotUtilities.ScreenshotUtility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CompaniesViewPageResource {

    /**
     * Creating a constructor to call the pageFactory class initElements method for mapping the driver to webElement.
     */


    public CompaniesViewPageResource() {
        PageFactory.initElements(GLOBAL_STATIC.driver, this);
    }

    CompaniesOverviewResource co;

    /**
     * Created an arrey for default tabs on companies view page
     */
    String[] listOfTabs = {"All", "Notes", "Events", "Contacts", "Deals", "Tasks", "Cases", "Calls", "Documents"};
    @FindBy(xpath = "//button/i[@class='comments icon']")
    public WebElement addCaseButton;
    @FindBy(xpath = "//button/i[@class='comments outline icon']")
    public WebElement addNotesIcon;

    @FindBy(xpath = "//div[@class='ui modal transition visible active']/div[@class='header']")
    public WebElement addNotesPopUpHeader;

    @FindBy(xpath = "//textarea")
    public WebElement textAreaOfNotes;

    @FindBy(xpath = "//div[@class='note-text']/p")
    public WebElement AddedNotes;

    String xpathOfCountOfNotes = "//div[@class='note-content']";

    /**
     * This method is to add notes to the company record from the companies view page.
     * It retrieves the count of  existing notes by using  getTheWebElementCount() .
     * It creates a dynamic xpath in the method to locate the added note based on the updated count
     */
    public void addNotesOnCompaniesPageRecord(String notes) {

        int countOfNotes = GLOBAL_GENERIC.getTheWebElementsCount(xpathOfCountOfNotes);
        addNotesIcon.click();
        Assert.assertEquals(addNotesPopUpHeader.getText(), "Add Note");
        textAreaOfNotes.sendKeys(notes);
        GLOBAL_GENERIC.locateAndGetWebElement(CommonXpath.xpathOfSaveButton).click();
        countOfNotes = countOfNotes + 1;
        String dynamicXpath = "//div[@class='ui segment custom-note-container']/div[@class='note-content']["
                + countOfNotes +
                "]/div/p";
        Assert.assertEquals(GLOBAL_GENERIC.locateAndGetWebElement(dynamicXpath).getText(), notes);
        ScreenshotUtility.chalBetaSelfielelele("TheAddNotesIconFunctionality");


    }

    /**
     * Bellow method first will navigate the companies details and click on view icon
     * on the view page we click on the add cases
     * creating object for cases-global-resource and creating one case record retrieving from excel
     * and deleting the record from casesOverViewPage by creating object of case-overview
     */


    /**
     * This method is navigating to the companies module and clicking on edit view icon of specify record by calling method
     * navigateToCompaniesDetails from companiesOverview class.
     * Then we are clicking on delete icon from edit view page.
     * After deleting record navigating to company overview page and checking with assertion method that record is being deleted or not.
     */

    public void deleteRecordFromCompaniesViewPage(String nameOfTheCompany) {

            co = new CompaniesOverviewResource();
            co.navigateToCompaniesDetails(nameOfTheCompany);
            GLOBAL_GENERIC.locateAndGetWebElement(CommonXpath.xpathOfDeleteIcon).click();
            GLOBAL_GENERIC.deleteConfirmationPopUp(true);
            GLOBAL_GENERIC.navigateToModule(GLOBAL_STATIC.nameOfModule[1]);
            boolean flag = CompaniesGlobalResource.checkForCompanyRecord(nameOfTheCompany);
            Assert.assertEquals(false, flag);
            ScreenshotUtility.chalBetaSelfielelele("deleteRecord");
        }


    public void addCaseFromCompaniesViewPage(String nameOfTheContact, int  casesTestDataRowInExcel){
        try{
            new CompaniesOverviewResource().navigateToCompaniesDetails(nameOfTheContact);
            addCaseButton.click();
            CasesGlobalResource cgr = new CasesGlobalResource();
            cgr.createCases(casesTestDataRowInExcel);
            CasesOverview co = new CasesOverview();
            co.deleteTheCasesFromOverviewPage("Personal_Loan");

        } catch (InterruptedException e) {

        }
        ScreenshotUtility.chalBetaSelfielelele("creationOfCasesFromCompaniesViewScreen");

    }

    /**
     * In below method loop iterates through each elements in the defaults listOfTabs
     */

    public void validateTheTabsOnCompaniesViewPage(){
        for (int i = 0; i < listOfTabs.length; i++) {
            String buildDynamicXpath = "//a[text()='"
                    + listOfTabs[i] +
                    "']";
            Assert.assertEquals(GLOBAL_GENERIC.getTheWebElementStatus(buildDynamicXpath), true);
            GLOBAL_GENERIC.locateAndGetWebElement(buildDynamicXpath).click();

            if (i == 0) {
                String buildDynamicXpath1 = "//div[text()='"
                        + listOfTabs[i + 1] +
                        "']";
                Assert.assertEquals(GLOBAL_GENERIC.getTheWebElementStatus(buildDynamicXpath1), true);

            } else if (i==1 || i == 2) {
                String buildDynamicXpath1 = "//div[text()='"
                        + listOfTabs[i] +
                        "']";
                Assert.assertEquals(GLOBAL_GENERIC.getTheWebElementStatus(buildDynamicXpath1), true);

            } else if (i > 2 && i < 9) {
                String buildDynamicXpath2 = "//div/h4[text()='"
                        + listOfTabs[i] +
                        "']";
                Assert.assertEquals(GLOBAL_GENERIC.getTheWebElementStatus(buildDynamicXpath2), true);
            }
        }
        /**
         * It will take screenShot for Tabs which are available in companies view page
         */
        ScreenshotUtility.chalBetaSelfielelele("TabsInCompaniesViewPage");

    }
}
