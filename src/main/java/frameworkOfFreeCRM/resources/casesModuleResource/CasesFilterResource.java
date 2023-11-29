package frameworkOfFreeCRM.resources.casesModuleResource;

import frameworkOfFreeCRM.resources.globalResource.GLOBAL_GENERIC;
import frameworkOfFreeCRM.resources.staticResource.GLOBAL_STATIC;
import frameworkOfFreeCRM.utilities.screenshotUtilities.ScreenshotUtility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

 public class CasesFilterResource {

    String showFilterWebElements[] = {"ban", "columns", "save", "upload", "search", "plus", "Add Filter Row"};
    public CasesFilterResource()
    {
        PageFactory.initElements(GLOBAL_STATIC.driver,this);
    }

    @FindBy(xpath = "//button[text()='Add Filter Row']")
    WebElement addFilterRowButton;
    @FindBy(xpath = "//i[@class='minus small icon']")
    public WebElement removeFilterRowButton;
    @FindBy(xpath = "//button[text()='Hide Filters']")
    WebElement hideFilterButton;
    @FindBy(xpath = "//i[@class='search small icon']")
    public WebElement  searchButtonXpath;
    @FindBy(xpath = "//i[@class='ban small icon']")
    public WebElement clearButton;
    @FindBy(xpath = "//input[@class='search']")
    public WebElement  searchDropDownTextField;
    @FindBy(xpath = "//input[@name='value']")
    public WebElement  searchTextInputbox;

    public static String xpathOfFilterRow = "//div[@role='listitem']";
    public  static  String xpathOfSearchDropdown ="//input[@class='search']/following-sibling::i[@class='dropdown icon']";
    public static String xpathOfOperatorDropDown = "//div[text()='Operator']/following-sibling::i[@class='dropdown icon']";

    public String searchDropDownValues[] = {"Title","Identifier","Status","Assigned To","Company","Contacts"};

    public String operatorDropDownValues[] ={"Ends with","Starts with","Equals","Contains"};

    /**
    validating the show filter button it has some webElements,
    checking the status of the webElements is displayed or not
    **/
    public void validateShowFilterScreenWebElements() {
        String buildXPath;
        int length = showFilterWebElements.length;
        for (int i = 0; i < length; i++) {
            if (showFilterWebElements[i] == "Add Filter Row") {
                buildXPath = "//button[text()='" + showFilterWebElements[i] + "']";
                GLOBAL_GENERIC.locateAndGetWebElement(buildXPath).isDisplayed();
            } else {
                buildXPath = "//i[@class='" + showFilterWebElements[i] + " small icon']";
                GLOBAL_GENERIC.locateAndGetWebElement(buildXPath).isDisplayed();
            }
        }
    }
    /**
    validating the Hide filter Button with add filter row button status
    **/
    public void validateHideFilterScreenFunctionality()
    {
        hideFilterButton.click();
        boolean flag=GLOBAL_GENERIC.getTheWebElementStatus("//button[text()='Add Filter Row']");
        ScreenshotUtility.chalBetaSelfielelele("validateHideFilterScreenFunctionality");
        Assert.assertEquals(flag,false);
        System.out.println(flag);
    }
    /**
    This method is going to click the add filter row button based on the no of clicks passed by parameter
    **/
    public void clickOnCasesAddFilterRowButton(int noOfClicks){
        for(int i=0;i<noOfClicks;i++){
            addFilterRowButton.click();
        }
    }
    /**
     This method is going to click the remove filter row button based on the no of clicks passed by parameter
    **/
    public void clicksOnRemoveFilterRowButton(int noOFClicks)
    {
        for(int i=0;i<noOFClicks;i++)
        {
            removeFilterRowButton.click();
        }
    }
    /**
     Select the value from searchDropdown by passing dropdownValue parameter
     and then click the selected value from the dropdown list .
     **/
    private void selectTheValueFromSearchDropDown(String dropDownValue){
        GLOBAL_GENERIC.locateAndGetWebElement(xpathOfSearchDropdown).click();
        searchDropDownTextField.sendKeys(dropDownValue);
        GLOBAL_GENERIC.locateAndGetWebElement("//span[text()='"+dropDownValue+"']").click();
    }
     /**
     Select the value from multipleSearchDropdown by passing dropdownValue parameter
     and then click the selected value from the dropdown list .
     **/
    private void selectTheValueFromMultipleCriteriaSearchDropDown(int filterRowIndex ,String dropDownValue){
        GLOBAL_GENERIC.
                locateAndGetWebElement("//div[@role='listitem']["+filterRowIndex+"]/div/div/div[@name='name']/i").
                click();
        GLOBAL_GENERIC.
                locateAndGetWebElement("//div[@role='listitem']["+filterRowIndex+"]/div/div/div[@name='name']/input").
                sendKeys(dropDownValue);
        GLOBAL_GENERIC.
                locateAndGetWebElement("//div[@role='listitem']["+filterRowIndex+"]/div/div/div[@name='name']/div/div/span[text()='"+dropDownValue+"']").
                click();
    }
     /**
      Select the value from operatorDropdown by passing operatorDropdownValue parameter
      and then click the selected value from the dropdown list.
      **/
    private void selectTheValueFromOperatorDropDown(String dropDownValue){
        GLOBAL_GENERIC.locateAndGetWebElement(xpathOfOperatorDropDown).click();
        GLOBAL_GENERIC.locateAndGetWebElement("//span[text()='"+dropDownValue+"']").click();
    }
    /**
     Select the value from multipleOperatorDropdown by passing operatorDropdownValue parameter
     and then click the selected value from the dropdown list.
    **/

    private void selectTheValueMultipleCriteriaOperatorDropDown(int filterRowIndex,
                                                                String dropDownValue){
        GLOBAL_GENERIC.
                locateAndGetWebElement("//div[@role='listitem']["+filterRowIndex+"]/div/div/div[@name='operator']/i").click();
        GLOBAL_GENERIC.
                locateAndGetWebElement("//div[@role='listitem']["+filterRowIndex+"]/div/div/div[@name='operator']/div/div/span[text()='"+dropDownValue+"']").click();
    }
   /**
    Enter the text value by passing textValue parameter
   **/
    private void enterTheSearchTextValue(String textValue){
        searchTextInputbox.sendKeys(textValue);
    }
    private void enterTheMultipleCriteriaSearchTextValue(int filterRowIndex, String textValue){
        GLOBAL_GENERIC.locateAndGetWebElement("//div[@role='listitem']["+filterRowIndex+"]/div/div/div[@class='ui input']/input")
                .sendKeys(textValue);
    }
    /**
     Validate the search operation in the show filter option in Cases overview page by
     passing the parameters searchDropdownValue,OperatorDropdownValue and SearchTextValue.
     **/
    public void addCasesSearchCriteria(String searchDropDownValue, String operatorDropDownValue,String searchText){
        selectTheValueFromSearchDropDown(searchDropDownValue);
        selectTheValueFromOperatorDropDown(operatorDropDownValue);
        enterTheSearchTextValue(searchText);

    }
    public void addMultipleSearchCriteria(int indexOfSearchCriteria,
                                         String searchDropDownValue,
                                         String operatorDropDownValue,
                                         String searchText){
        selectTheValueFromMultipleCriteriaSearchDropDown(indexOfSearchCriteria,
                searchDropDownValue);
        selectTheValueMultipleCriteriaOperatorDropDown(indexOfSearchCriteria,
                operatorDropDownValue);
        enterTheMultipleCriteriaSearchTextValue(indexOfSearchCriteria,
                searchText);

    }

}


