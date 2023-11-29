package frameworkOfFreeCRM.resources.dealsModuleResource;

import frameworkOfFreeCRM.resources.globalResource.GLOBAL_GENERIC;
import frameworkOfFreeCRM.resources.staticResource.GLOBAL_STATIC;
import frameworkOfFreeCRM.utilities.screenshotUtilities.ScreenshotUtility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class DealsFilterResource {
    String filterScreenWebElements[] = {"plus", "ban", "upload", "search", "columns", "save", "Add Filter Row"};
    public DealsFilterResource(){
        PageFactory.initElements(GLOBAL_STATIC.driver,this);
    }
    @FindBy(xpath = "//button[text()='Hide Filters']")
    WebElement hideFiltersButton;
    @FindBy(xpath = "//button[text()='Add Filter Row']")
    WebElement addFilterRowButton;
    @FindBy(xpath = "//i[@class='minus small icon']")
    WebElement  removeFilterRowButton;
    @FindBy(xpath = "//i[@class='search small icon']")
    public WebElement  searchButton;
    @FindBy(xpath = "//i[@class='ban small icon']")
    public WebElement  clearButton;
    @FindBy(xpath = "//input[@class='search']")
    public WebElement  searchDropDownTextField;
    @FindBy(xpath = "//input[@name='value']")
    public WebElement  searchTextInputbox;
    public String searchDropDownValues[]={"Title","Company","Stage","Description","Amount","Type","Identifier"};
    public String operatorDropDownValues[]={"Equals","Starts with","Ends with","Contains"};
    public static String  xpathOfFilterRow = "//div[@role='listitem']";
    public static String  xpathOfSearchDropDown = "//div[@name='name']/i";
    public static String  xpathOfOperatorDropDown =  "//div[@name='operator']/i";

    public void validateShowFilterScreenbuttons()
    {
        String buildDynamicXpath;
        for (int index=0;index<filterScreenWebElements.length;index++)
        {
            if (filterScreenWebElements[index]== "Add Filter Row")
            {
                addFilterRowButton.isDisplayed();
            }
            else
            {
                buildDynamicXpath="//i[@class='" + filterScreenWebElements[index] + " small icon']";
                GLOBAL_GENERIC.
                        locateAndGetWebElement(buildDynamicXpath).isDisplayed();
            }
        }
    }
    public void validateHideFilterScreenbutton()
    {
        hideFiltersButton.click();
        boolean flag=GLOBAL_GENERIC.getTheWebElementStatus("//button[text()='Add Filter Row']");
        Assert.assertEquals(flag,false);
    }

    public void clickOnAddFilterRow(int noOfClicks)
    {
        for(int i=0;i<noOfClicks;i++)
        {
            addFilterRowButton.click();
            ScreenshotUtility.chalBetaSelfielelele("AfterFilterRowAdd.png");
        }
    }
    public void  clicksOnRemoveFilterRowButton(int noOfClicks){
        for (int i =0;i<noOfClicks;i++){
            removeFilterRowButton.click();
            ScreenshotUtility.chalBetaSelfielelele("AfterFilterRowRemoval.png");
        }

    }

    private void selectTheValueFromDefaultCriteriaSearchDropDown(String dropDownValue){
        GLOBAL_GENERIC.
                locateAndGetWebElement(xpathOfSearchDropDown).click();
        searchDropDownTextField.sendKeys(dropDownValue);
        GLOBAL_GENERIC.
                locateAndGetWebElement("//span[text()='"+dropDownValue+"']").click();
    }
    //Below method is to select the value from multiple dropdown values by clicking and then selecting the value by clicking on the available web element.
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

    private void selectTheValueFromDefaultOperatorDropDown(String dropDownValue){
        GLOBAL_GENERIC.
                locateAndGetWebElement(xpathOfOperatorDropDown).click();
        GLOBAL_GENERIC.
                locateAndGetWebElement("//span[text()='"+dropDownValue+"']").click();
    }
    private void selectTheValueMultipleCriteriaOperatorDropDown(int filterRowIndex,
                                                                String dropDownValue){
        GLOBAL_GENERIC.
                locateAndGetWebElement("//div[@role='listitem']["+filterRowIndex+"]/div/div/div[@name='operator']/i").click();
        GLOBAL_GENERIC.
                locateAndGetWebElement("//div[@role='listitem']["+filterRowIndex+"]/div/div/div[@name='operator']/div/div/span[text()='"+dropDownValue+"']").click();
    }

    private void enterTheDefaultSearchTextValue(String textValue) {
        searchTextInputbox.sendKeys(textValue);
    }
    private void enterTheMultipleCriteriaSearchTextValue(int filterRowIndex, String textValue){
        GLOBAL_GENERIC.
                locateAndGetWebElement("//div[@role='listitem']["+filterRowIndex+"]/div/div/div[@class='ui input']/input")
                .sendKeys(textValue);
    }
    public void addSearchCriteria(String searchDropDownValue,
                                  String operatorDropDownValue,
                                  String searchText){
        selectTheValueFromDefaultCriteriaSearchDropDown(searchDropDownValue);
        selectTheValueFromDefaultOperatorDropDown(operatorDropDownValue);
        enterTheDefaultSearchTextValue(searchText);
    }
    // Below method is used to call the above methods by passing the parameters.
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

