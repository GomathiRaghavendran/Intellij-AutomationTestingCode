package frameworkOfFreeCRM.resources.tasksModuleResource;

import frameworkOfFreeCRM.resources.globalResource.GLOBAL_GENERIC;
import frameworkOfFreeCRM.resources.staticResource.GLOBAL_STATIC;
import frameworkOfFreeCRM.utilities.screenshotUtilities.ScreenshotUtility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

/**we created this filter screen icon array for validating all the icon present in show filters overview page .
 *
 */
public class TasksFilterResource {
    String filterScreenIcon[] = {"plus", "ban", "upload", "search", "columns", "save", "Add Filter Row"};
// page factory identifies the WebElement before performing an action

    public TasksFilterResource() {
        PageFactory.initElements(GLOBAL_STATIC.driver, this);
    }

    @FindBy(xpath = "//button[text()='Hide Filters']")
    WebElement hideFiltersButton;

    @FindBy(xpath = "//button[text()='Add Filter Row']")
    WebElement addFilterRowButton;

    @FindBy(xpath="//i[@class='minus small icon']")
    WebElement removeFilterRowButton;

    @FindBy(xpath = "//i[@class='search small icon']") public WebElement searchButtonXpath;

    @FindBy(xpath = "//input[@class='search']") public WebElement searchDropDownTextField;

    @FindBy(xpath = "//input[@name='value']") public WebElement searchTextInputbox;
    @FindBy(xpath = "//i[@class='ban small icon']")
    public WebElement  clearButton;


    public String searchDropDownValues[] = {"Title", "Assigned To"};

    public String operatorDropDownValues[] = {"Starts with", "Ends with"};


    public static String xpathOfFilterRow = "//div[@role='listitem']";
    public static String xpathOfSearchDropDown = "//input[@class='search']/following-sibling::i[@class='dropdown icon']";
    public static String xpathOfOperatorDropDown = "//div[text()='Operator']/following-sibling::i[@class='dropdown icon']";


    //Here we are validating the show filter screen icons and we are creating dyanamic Xpath for the icons present in
    //show filters page.
    public void validateShowFilterScreenIcons() {
        int len = filterScreenIcon.length;
        String buildDynamicXpath;
        for (int i = 0; i < len; i++) {
            if (filterScreenIcon[i] == "Add Filter Row") {
                buildDynamicXpath = "//button[text()='" + filterScreenIcon[i] + "']";
                GLOBAL_GENERIC.locateAndGetWebElement(buildDynamicXpath).isDisplayed();
            } else {
                buildDynamicXpath = "//i[@class='" + filterScreenIcon[i] + " small icon']";
                GLOBAL_GENERIC.locateAndGetWebElement(buildDynamicXpath).isDisplayed();
            }
        }
        ScreenshotUtility.chalBetaSelfielelele("Show Filter Button functionality of Task");
    }

    //here we are validating functionality of hide filter button .

    public void validateHideFilterButtonFunctionality() {
        hideFiltersButton.click();
        boolean flag = GLOBAL_GENERIC.getTheWebElementStatus("//button[text()='Add Filter Row']");
        Assert.assertEquals(flag, false);
        ScreenshotUtility.chalBetaSelfielelele("Hide Filter Button Functionality");
    }

    // We are performing click action on AddFilterRow button.
    public void clicksOnAddFilterRowButton(int noOfClicks) {
        for (int x = 0; x < noOfClicks; x++) {
            addFilterRowButton.click();
            ScreenshotUtility.chalBetaSelfielelele("AfterFilterRowAdd.png");
        }
    }
    //We are performing click action on clearFilterRow Button.
    public void clicksOnRemoveFilterRowButton(int noOfClicks){
        for(int x=0; x< noOfClicks; x++){
            removeFilterRowButton.click();
            ScreenshotUtility.chalBetaSelfielelele("AfterFilterRowRemoval.png");
        }
    }
    //A method to Select The Value From search Dropdown
    private void selectTheValueFromSearchDropDown(String dropDownValue) {
        GLOBAL_GENERIC.locateAndGetWebElement(xpathOfSearchDropDown).click();
        searchDropDownTextField.sendKeys(dropDownValue);
        GLOBAL_GENERIC.locateAndGetWebElement("//span[text()='" + dropDownValue + "']").click();
    }

    /*Here we are selecting search dropdown for multiple index row*/
    private void selectTheValueFromMultipleSearchDropDown(int filterRowIndex,String dropDownValue)
    {
        GLOBAL_GENERIC.locateAndGetWebElement("//div[@role='listitem']["+filterRowIndex+"]/div/div/div[@name='name']/i").click();
        GLOBAL_GENERIC.locateAndGetWebElement("//div[@role='listitem']["+filterRowIndex+"]/div/div/div[@name='name']/input").sendKeys(dropDownValue);
        GLOBAL_GENERIC.locateAndGetWebElement("//div[@role='listitem']["+filterRowIndex+"]/div/div/div[@name='name']/div/div/span[text()='"+dropDownValue+"']").click();
    }
    //a method to select The Value From Operator DropDown

    private void selectTheValueFromOperatorDropDown(String dropDownValue) {
        GLOBAL_GENERIC.locateAndGetWebElement(xpathOfOperatorDropDown).click();
        GLOBAL_GENERIC.locateAndGetWebElement("//span[text()='" + dropDownValue + "']").click();
    }
    /*Here we are selecting value for operator dropdown  */
    private void selectTheValueForMultipleCriteriaOperatorDropDown(int filterRowIndex,String dropDownValue)

    {
        GLOBAL_GENERIC.locateAndGetWebElement("//div[@role='listitem']["+filterRowIndex+"]/div/div/div[@name='operator']/i").click();
        GLOBAL_GENERIC.locateAndGetWebElement("//div[@role='listitem']["+filterRowIndex+"]/div/div/div[@name='operator']/div/div/span[text()='"+dropDownValue+"']").click();
    }
    /*In this method we are sending data into the value input box*/
    private void enterTheDefaultSearchTextValue(String textValue) {
        searchTextInputbox.sendKeys(textValue);
    }

    private void enterMultipleCriteriaSearchTextValue(int filterRowIndex,String textValue){
        GLOBAL_GENERIC.locateAndGetWebElement("//div[@role='listitem']["+filterRowIndex+"]/div/div/div[@class='ui input']/input").sendKeys(textValue);
    }

    public void addSearchCriteria(String searchDropDownValue, String operatorDropDownValue, String searchText) {
        selectTheValueFromSearchDropDown(searchDropDownValue);
        selectTheValueFromOperatorDropDown(operatorDropDownValue);
        enterTheDefaultSearchTextValue(searchText);

    }
    /*In this method We are adding all the search criteria*/
    public void addMultipleSearchCriteria(int searchCriteriaIndex,String searchDropDownValue,String operatorDropDownValue,String searchText){
        selectTheValueFromMultipleSearchDropDown(searchCriteriaIndex,searchDropDownValue);
        selectTheValueForMultipleCriteriaOperatorDropDown(searchCriteriaIndex,operatorDropDownValue);
        enterMultipleCriteriaSearchTextValue(searchCriteriaIndex,searchText);
    }



}