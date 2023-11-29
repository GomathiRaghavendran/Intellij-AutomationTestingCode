package gomframeworkOfFreeCRM.gomResources.companiesModuleResource;

import frameworkOfFreeCRM.resources.globalResource.GLOBAL_GENERIC;
import gomframeworkOfFreeCRM.gomResources.casesModuleResource.GomCasesGlobalResource;
import gomframeworkOfFreeCRM.gomResources.casesModuleResource.GomCasesOverview;
import gomframeworkOfFreeCRM.gomResources.globalResource.GomCommonXpath;
import gomframeworkOfFreeCRM.gomResources.globalResource.GomGLOBAL_GENERIC;
import gomframeworkOfFreeCRM.gomResources.staticReource.GomGLOBAL_STATIC;
import gomframeworkOfFreeCRM.gomUtilities.ScreenshotUtility.GomScreenshotUtility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class GomCompaniesViewResource {
    public GomCompaniesViewResource(){

        PageFactory.initElements(GomGLOBAL_STATIC.driver, this);
    }

    String[]  listOfTabs = {"All","Notes","Events","Deals","Tasks","Cases","Calls",
            "Documents","Contacts"};

    @FindBy(xpath = "//button/i[@class='comments outline icon']")
    public WebElement addNoteButton;


    @FindBy(xpath = "//textarea")
    public WebElement textAreaOfNotes;

    @FindBy(xpath = "//div[@class='ui modal transition visible active']/div[@class='header']")
    public WebElement  addNotePopUpHeader;

    @FindBy(xpath = "//button/i[@class='comments icon']")
    public WebElement addCaseButton;


    @FindBy(xpath = "//div[@class='note-text']/p")
    public WebElement AddedNotes;

    String  xpathOfCountOfNotes = "//div[@class='note-content']";

    /** This method deals with deleting a specific company record from the view page
     * Navigating to specific company record by invoking navigating to company Details method from creating a GomCompaniesOverViewResource class instance
     * After navigation, click on Delete icon in that View page
     * By using Delete confirmation pop up method, validating the confirmation text from pop up message and click on delete button
     * By using Navigate to module method, navigating to companies module page
     * and then validating that whether the deleted company is present in that page
     * or not using assertion*/
    public void deleteRecordFromCompaniesViewPage(String nameOfTheCompany) {
        try {
            new GomCompaniesOverviewResource().navigateToCompanyDetails(nameOfTheCompany);
            GomGLOBAL_GENERIC.
                    locateAndGetWebElement(GomCommonXpath.xpathOfDeleteIconInCompaniesOverviewPage).click();
            // Thread.sleep(1000);
            GomGLOBAL_GENERIC.
                    deleteConfirmationPopUp(true);
            GomGLOBAL_GENERIC.
                    navigateToModule(GomGLOBAL_STATIC.nameOfModule[1]);
            boolean flag = GomCompaniesGlobalResource.
                    checkForCompanyRecord(nameOfTheCompany);
            Assert.assertEquals(false, flag);
            GomScreenshotUtility.chaLBetaSelfieLeLele("DeleteRecordFromCompanyOverViewPage.png");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    /**This method deals with creating a case record from companies view screen by clicking on add case button in that page
 *  For that we need to create an object for cases global resource class to invoke create cases method
 *  and then Delete the same case record by creating a object for cases overview class*/
    public void addCaseFromCompaniesViewPage(String nameOfTheCompany, int casesTestDataRowInExcel){
        try{
            new GomCompaniesOverviewResource().navigateToCompanyDetails(nameOfTheCompany);
            addCaseButton.click();
            GomCasesGlobalResource cgr = new GomCasesGlobalResource();
            cgr.createCases(casesTestDataRowInExcel);
            GomScreenshotUtility.chaLBetaSelfieLeLele("Creating a Case Record");
            GomCasesOverview co = new GomCasesOverview();
            co.deleteTheCasesFromOverviewPage("Personal_Loan");
            GomScreenshotUtility.chaLBetaSelfieLeLele("Deleting a Case Record");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /** This method deals with getting the count of Notes which are already available
     * and then clicks on add Note button
     * Then validating the popup message by getting the text and verifying using assertion
     * after that, adding the notes in text area and then click on save button
     * Using the dynamic path, getting the  text value of recently add notes and validating them using assertion
     */

    public void addNotesOnCompanyRecord(String notes){
        int countOfNotes = GomGLOBAL_GENERIC.getTheWebElementsCount(xpathOfCountOfNotes);
        addNoteButton.click();
        Assert.assertEquals(addNotePopUpHeader.getText(),"Add Note");
        textAreaOfNotes.sendKeys(notes);
        GomGLOBAL_GENERIC.locateAndGetWebElement(GomCommonXpath.xpathOfSaveButton).click();
        countOfNotes = countOfNotes + 1;
        String dynamicXpath = "//div[@class='ui segment custom-note-container']/div[@class='note-content']["
                +countOfNotes+
                "]/div/p";
        Assert.assertEquals(GomGLOBAL_GENERIC.locateAndGetWebElement(dynamicXpath).getText(),notes);
    }
/** This method deals with Validating the available tabs on Companies View page
 * First, storing all the list of elements in array[] variable
 * by using length function,getting the count of number of elements in the array
 * Hence, for loops comes into picture and validates the tabs for each iteration
 * and using if and else if conditions clicking on each tab  and validating the web elements in it.*/
public void validateTheTabsOnCompaniesViewPage(){
        for(int i=0; i<listOfTabs.length;i++){
            String buildDynamicXpath="//a[text()='"+listOfTabs[i]+"']";
            Assert.assertEquals(GomGLOBAL_GENERIC.getTheWebElementStatus(buildDynamicXpath),true);
        if(i==0){
            String buildDynamicXpath1="//i/parent::div[text()='"+listOfTabs[i+1]+"']";
            Assert.assertEquals(GomGLOBAL_GENERIC.getTheWebElementStatus(buildDynamicXpath1),true);
            System.out.println(buildDynamicXpath1);
        } else if(i==1 || i==2){
            String buildDynamicXpath2="//i/parent::div[text()='"+listOfTabs[i]+"']";
            Assert.assertEquals(GomGLOBAL_GENERIC.getTheWebElementStatus(buildDynamicXpath2),true);
            System.out.println(buildDynamicXpath2);
        } else if(i>2 && i<9){
            String buildDynamicXpath3="//i/parent::h4[text()='"+listOfTabs[i]+"']";
            Assert.assertEquals(GomGLOBAL_GENERIC.getTheWebElementStatus(buildDynamicXpath3), true);
            System.out.println(buildDynamicXpath3);
        }

        }
        GomScreenshotUtility.chaLBetaSelfieLeLele("Available list of tabs");

    }
}
