package frameworkOfFreeCRM.resources.companiesModuleResource;

import frameworkOfFreeCRM.resources.globalResource.GLOBAL_GENERIC;
import frameworkOfFreeCRM.resources.staticResource.GLOBAL_STATIC;
import frameworkOfFreeCRM.utilities.screenshotUtilities.ScreenshotUtility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CompaniesFilterResource {
    String filterScreenWebelements[] = {"plus", "ban", "upload", "search", "columns", "save", "Add Filter Row"};

    /**
     * This default constructor dealsModulePipeline with driver handling using Page factory Class
     * while creating object for the class,default constructor will be executed,
     * and it will handle the driver using initElements method from Page factory class
     * initElements method will take care of providing the mapping between driver and locators which we want to locate by @Find by annotation
     */

    public CompaniesFilterResource() {
        PageFactory.initElements(GLOBAL_STATIC.driver, this);
    }

    @FindBy(xpath = "//button[text()='Hide Filters']")
    WebElement hideFiltersButton;

    @FindBy(xpath = "//button[text()='Add Filter Row']")
    WebElement addFilterRowButton;
    @FindBy(xpath = "//i[@class='minus small icon']")
    WebElement removeFilterRowButton;

    @FindBy(xpath = "//i[@class='ban small icon']")
    public WebElement  clearButton;

    @FindBy(xpath = "//i[@class='search small icon']")
    public WebElement  searchButtonXpath;

    @FindBy(xpath = "//input[@class='search']")
    public WebElement  searchDropDownTextField;

    @FindBy(xpath = "//input[@name='value']")
    public WebElement  searchTextInputbox;

    public static String xpathOfFilterRow = "//div[@role='listitem']";
    public static String xpathOfSearchDropDown = "//input[@class='search']/following-sibling::i[@class='dropdown icon']";
    public static String xpathOfOperatorDropDown = "//div[text()='Operator']/following-sibling::i[@class='dropdown icon']";

    public String searchDropDownValues[] = {"Name","VAT Number","Address","Email"};
    public String operatorDropDownValues[]={"Starts with","Ends with"};

    /**
     * This method dealsModulePipeline with Validating the web Elements of Show Filter Screen
     * Since we have xpath are same for all the elements except Add Filter row
     * using for loop to achieve dynamic xpath
     * and by using if condition providing two different dynamic xpath
     */
/** Taking screenshot by using screenshotUtility for the companiesTestCase Evidence*/
    public void validateShowFilterScreenWebElements() {
        int len = filterScreenWebelements.length;
        String buildDynamicXpath;
        for (int i = 0; i < len; i++) {
            if (filterScreenWebelements[i] == "Add Filter Row") {
                buildDynamicXpath = "//button[text()='" + filterScreenWebelements[i] + "']";
                GLOBAL_GENERIC.locateAndGetWebElement(buildDynamicXpath).isDisplayed();
            } else {
                buildDynamicXpath = "//i[@class='" + filterScreenWebelements[i] + " small icon']";
                GLOBAL_GENERIC.locateAndGetWebElement(buildDynamicXpath).isDisplayed();
            }
        }
        ScreenshotUtility.chalBetaSelfielelele("showFilterScreen");
    }

    /**
     * This method dealsModulePipeline with validating the Hide Filter Button
     * and by clicking on it, it's not displaying the Web Elements of Show Filter screen
     */
    /** Taking screenshot by using screenshotUtility for the companiesTestCase Evidence*/
    public void validateHideFilterButtonFunctionality() {
        hideFiltersButton.click();
        boolean flag = GLOBAL_GENERIC.getTheWebElementStatus("//button[text()='Add Filter Row']");
        Assert.assertEquals(flag, false);
       ScreenshotUtility.chalBetaSelfielelele("hideFilterButton");
    }

    /**After clicking hideFilter button on companies overview page now validating Add Filter Row Button By clicking on it
    //Here in method it will iterate on number of clicks perform on the Add Filter Row Button no of clicks is define
    //in parameters of the method
     */

    public void clicksOnAddFilterRowButton(int noOfClicks) {
        for (int i = 0; i < noOfClicks; i++) {
            addFilterRowButton.click();
            ScreenshotUtility.chalBetaSelfielelele("AfterFilterRowAdd.png");
        }
    }
    /** This method clicks on RemoveFilterRowButton specified number of times using for loop*/
    public void  clicksOnRemoveFilterRowButton(int noOfClicks) {
        for (int i = 0; i < noOfClicks; i++) {
            removeFilterRowButton.click();
            ScreenshotUtility.chalBetaSelfielelele("AfterFilterRowRemoval.png");
        }
    }

    /** Below two dropdown method is used to select a value from a dropdown element,
     * it is first open the dropdown menu and takes a required value.
     */
    private void selectTheValueFromSearchDropDown(String dropDownValue){
        GLOBAL_GENERIC.locateAndGetWebElement(xpathOfSearchDropDown).click();
        searchDropDownTextField.sendKeys(dropDownValue);
        GLOBAL_GENERIC.locateAndGetWebElement("//span[text()='"+dropDownValue+"']").click();
    }
    private void  selectTheValueFromMultipleCriteriaSearchDropdown(int filterRowIndex, String dropDownValue){
        GLOBAL_GENERIC.locateAndGetWebElement("//div["+filterRowIndex+"]/div/div/div[@name='name']/i").
                click();
        GLOBAL_GENERIC.locateAndGetWebElement("//div["+filterRowIndex+"]/div/div/div[@name='name']/input").
                sendKeys(dropDownValue);
        GLOBAL_GENERIC.locateAndGetWebElement("//div["+filterRowIndex+"]/div/div/div[@name='name']/div/div/span[text()='"+dropDownValue+"']").
                click();
    }
    private void selectTheValueFromOperatorDropDown(String dropDownValue){
        GLOBAL_GENERIC.locateAndGetWebElement(xpathOfOperatorDropDown).click();
        GLOBAL_GENERIC.locateAndGetWebElement("//span[text()='"+dropDownValue+"']").click();
    }
    private void selectTheValueFromMultipleCriteriaOperatorDropdown(int filterRowIndex, String dropDownValue){
        GLOBAL_GENERIC.locateAndGetWebElement("//div["+filterRowIndex+"]/div/div/div[@name='operator']/i").
                click();
        GLOBAL_GENERIC.locateAndGetWebElement("//div["+filterRowIndex+"]/div/div/div[@name='operator']/div/div/span[text()='"+dropDownValue+"']").
                click();
    }

    private void enterTheSearchTextValue(String textValue){
        searchTextInputbox.sendKeys(textValue);
    }
    private void enterTheMultipleSearchTextValue(int filterRowIndex, String textValue){
        GLOBAL_GENERIC.locateAndGetWebElement("//div["+filterRowIndex+"]/div/div/div[@class='ui input']/input[@name='value']").
                sendKeys(textValue);
    }

    /** Below public method is used to call above private methods single searchDropdown, operatorDropdown and searchTextValue.
     * In this method we pass three parameters-search dropdown values, search operator Dropdown values and search text.
     *  we stored the value of Search dropdropdown and Operator dropdown in an array
     */
    public void addSearchCriteria(String searchDropDownValue, String operatorDropDownValue,String searchText){
        selectTheValueFromSearchDropDown(searchDropDownValue);
        selectTheValueFromOperatorDropDown(operatorDropDownValue);
        enterTheSearchTextValue(searchText);

    }
     /** Below public method is used for calling above private methods,MultipleSearchDropdown,MultipleOperatorDropdown
      *  and MultipleSearchTextValue.
     */

    public void addMultipleSearchCriteria(int filterRowIndex,String searchDropDownValue, String operatorDropDownValue,String searchText){
        selectTheValueFromMultipleCriteriaSearchDropdown(filterRowIndex,searchDropDownValue);
        selectTheValueFromMultipleCriteriaOperatorDropdown(filterRowIndex,operatorDropDownValue);
        enterTheMultipleSearchTextValue(filterRowIndex,searchText);
    }

}
