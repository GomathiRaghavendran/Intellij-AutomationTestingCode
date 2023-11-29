package gomframeworkOfFreeCRM.gomResources.companiesModuleResource;

import gomframeworkOfFreeCRM.gomResources.globalResource.GomGLOBAL_GENERIC;
import gomframeworkOfFreeCRM.gomResources.staticReource.GomGLOBAL_STATIC;
import gomframeworkOfFreeCRM.gomUtilities.ScreenshotUtility.GomScreenshotUtility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class GomCompaniesFilterResource {
    String filterScreenWebElements[]={"plus", "ban", "upload", "search", "columns","save", "Add Filter Row"};

    /** This default constructor deals with driver handling using Page factory Class
     * while creating object for the class,default constructor will be executed,
     * and it will handle the driver using initElements method from Page factory class
     * initElements method will take care of providing the mapping between driver and locators which we want to locate by @Find by annotation*/
    public GomCompaniesFilterResource()
    {
        PageFactory.initElements(GomGLOBAL_STATIC.driver,this);
    }
    @FindBy(xpath = "//button[text()='Hide Filters']")
    WebElement  hideFiltersButton;
    @FindBy(xpath="//button[text()='Add Filter Row']")
    WebElement addFilterRowButton;
    @FindBy(xpath = "//i[@class='minus small icon']")
    WebElement removeFilterRowButton;

    @FindBy(xpath = "//i[@class='search small icon']")
    public WebElement  searchButtonXpath;
    @FindBy(xpath = "//i[@class='ban small icon']")
    public WebElement  clearButton;

    @FindBy(xpath = "//input[@class='search']")
    public WebElement  searchDropDownTextField;

    @FindBy(xpath = "//input[@name='value']")
    public WebElement  searchTextInputBox;

    public String searchDropDownValues[] = {"Name","Website","Address","Phone","Email"};

    public String operatorDropDownValues[] ={"Equals","Starts with","Ends with",};


    public static String xpathOfFilterRow="//div[@role='listitem']";
    public static String xpathOfSearchDropDown="//input[@class='search']/following-sibling::i[@class='dropdown icon']";
    public static String xpathOfOperatorDropDown="//div[text()='Operator']/following-sibling::i[@class='dropdown icon']";


    /**This method deals with Validating the web Elements of Show Filter Screen
     * Since we have xpath are same for all the elements except Add Filter row
     * using for loop to achieve dynamic xpath
     * and by using if condition providing two different dynamic xpath  */
    public void validateShowFilterScreenWebElements(){

        int length=filterScreenWebElements.length;
        String buildDynamicXpath;
        for(int i=0;i<length;i++){
            if(filterScreenWebElements[i] == "Add Filter Row"){
                buildDynamicXpath="//button[text()='"+filterScreenWebElements[i]+"']";
                GomGLOBAL_GENERIC.locateAndGetWebElement(buildDynamicXpath).isDisplayed();
            }else{
                buildDynamicXpath="//i[@class='" + filterScreenWebElements[i] + " small icon']";
                GomGLOBAL_GENERIC.locateAndGetWebElement(buildDynamicXpath).isDisplayed();
            }
        }

    }
    /**This method deals with validating the Hide Filter Button
     * and by clicking on it, it's not displaying the Web Elements of Show Filter screen*/
    public void validateHideFilterButtonFunctionality(){
        hideFiltersButton.click();
        boolean flag=GomGLOBAL_GENERIC.getTheWebElementStatus("//button[text()='Add Filter Row']");
        Assert.assertEquals(flag,false);
    }
/** This method clicks on AddFilterRowButton specified number of times using for loop*/
    public void clicksOnAddFilterRowButton(int noOfClicks){
        for(int i=0;i<noOfClicks;i++){
            addFilterRowButton.click();
            GomScreenshotUtility.chaLBetaSelfieLeLele("AfterFilterRowAdd.png");

        }
    }
    /** This method clicks on RemoveFilterRowButton specified number of times using for loop*/
    public void clicksOnRemoveFilterRowButton(int noOfClicks){
        for(int i=0;i<noOfClicks;i++){
            removeFilterRowButton.click();
            GomScreenshotUtility.chaLBetaSelfieLeLele("AfterFilterRemoval.png");
        }
    }


/** This method deals with clicking on the Search dropdown box first
 * then selecting the values from the dropdown
 * Storing all the dropdown values in array variable
 * Using the index, dropdown values are selected and then click the element which is selected*/
    private void selectTheValueFromDefaultCriteriaSearchDropDown(String dropDownValue){
        GomGLOBAL_GENERIC.locateAndGetWebElement(xpathOfSearchDropDown).click();
        searchDropDownTextField.sendKeys(dropDownValue);
        GomGLOBAL_GENERIC.locateAndGetWebElement("//span[text()='"+dropDownValue+"']").click();
    }

    /**This method deals with clicking on multiple Criteria search drop down*/
    private void selectTheValueFromMultipleCriteriaSearchDropDown(int filterRowIndex,String dropDownValue){
        GomGLOBAL_GENERIC.
                locateAndGetWebElement("//div[@role='listitem']["+filterRowIndex+"]/div/div[@class='field']/div[@name='name']/i").
                click();
        GomGLOBAL_GENERIC.locateAndGetWebElement("//div[@role='listitem']["+filterRowIndex+"]/div/div/div[@name='name']/input").
                sendKeys(dropDownValue);
        GomGLOBAL_GENERIC.locateAndGetWebElement("//div[@role='listitem']["+filterRowIndex+"]/div/div[@class='field']/div[@name='name']/div/div/span[text()='"+dropDownValue+"']").
                click();

    }
    /** This method deals with clicking on the Operator dropdown box first
     * then selecting the values from the dropdown
     * Storing all the dropdown values in array variable
     * Using the index, dropdown values are selected and then click the element which is selected*/
    private void selectTheValueFromDefaultCriteriaOperatorDropDown(String dropDownValue){
        GomGLOBAL_GENERIC.locateAndGetWebElement(xpathOfOperatorDropDown).click();
          GomGLOBAL_GENERIC.locateAndGetWebElement("//span[text()='"+dropDownValue+"']").click();
    }
/** This method deals with multiple criteria search in Operator drop down*/
    private void selectTheValueFromMultipleCriteriaOperatorDropDown(int filterRowIndex,String dropDownValue){
        GomGLOBAL_GENERIC.
                locateAndGetWebElement("//div[@role='listitem']["+filterRowIndex+"]/div/div[@class='field']/div[@name='operator']/i").
                click();

        GomGLOBAL_GENERIC.
                locateAndGetWebElement("//div[@role='listitem']["+filterRowIndex+"]/div/div[@class='field']/div[@name='operator']/div/div/span[text()='"+dropDownValue+"']").
                click();

    }
    /** This method deals with Entering text value in the text box*/
    private void enterTheDefaultSearchTextValue(String textValue) {
        searchTextInputBox.sendKeys(textValue);
    }

    private void enterTheMultipleSearchTextValue(int filterRowIndex,String textValue){
    GomGLOBAL_GENERIC.
            locateAndGetWebElement("//div[@role='listitem']["+filterRowIndex+"]/div/div/div[@class='ui input']/input[@name='value']").
            sendKeys(textValue);
    }
/** This method deals with selecting the values from Search and Operator drop down
 * and enter the text value in the text box*/
    public void addSearchCriteria(String searchDropDownValue, String operatorDropDownValue,String searchText){
        selectTheValueFromDefaultCriteriaSearchDropDown(searchDropDownValue);
        selectTheValueFromDefaultCriteriaOperatorDropDown(operatorDropDownValue);
        enterTheDefaultSearchTextValue(searchText);

    }

    public void addMultipleSearchCriteria(int indexOfSearchCriteria,
                                          String searchDropDownValue,
                                          String operatorDropDownValue,
                                          String searchText){
        selectTheValueFromMultipleCriteriaSearchDropDown(indexOfSearchCriteria,searchDropDownValue);
        selectTheValueFromMultipleCriteriaOperatorDropDown(indexOfSearchCriteria,operatorDropDownValue);
        enterTheMultipleSearchTextValue(indexOfSearchCriteria,searchText);
    }
}
