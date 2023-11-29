package frameworkOfFreeCRM.resources.contactsModuleResource;
import frameworkOfFreeCRM.resources.globalResource.GLOBAL_GENERIC;
import frameworkOfFreeCRM.resources.staticResource.GLOBAL_STATIC;
import frameworkOfFreeCRM.utilities.screenshotUtilities.ScreenshotUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class ContactFilterResource {
    String  filterScreenWebelements[]  = {"plus", "ban", "upload", "search", "columns","save", "Add Filter Row"};

    public  ContactFilterResource(){
        PageFactory.initElements(GLOBAL_STATIC.driver, this);
    }
    @FindBy(xpath = "//button[text()='Hide Filters']")
    WebElement  hideFiltersButton;

    @FindBy(xpath = "//button[text()='Add Filter Row']")
    WebElement  addFilterRowButton;

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



    public String searchDropDownValues[] = {"First Name","Last Name"};

    public String operatorDropDownValues[] ={"Starts with","Ends with"};



    public static String  xpathOfFilterRow = "//div[@role='listitem']";


    public static String  xpathOfSearchDropDown = "//div[@name='name']/i";
    public static String  xpathOfOperatorDropDown =  "//div[@name='operator']/i";


    public void validateShowFilterScreenWebElements(){
        int  len = filterScreenWebelements.length;
        String  buildDynamicXpath;
        for(int i = 0; i<len;i++){
            if(filterScreenWebelements[i] == "Add Filter Row"){
                buildDynamicXpath = "//button[text()='"+filterScreenWebelements[i]+"']";
                GLOBAL_GENERIC.locateAndGetWebElement(buildDynamicXpath).isDisplayed();
            } else {
                buildDynamicXpath = "//i[@class='" + filterScreenWebelements[i] + " small icon']";
                GLOBAL_GENERIC.locateAndGetWebElement(buildDynamicXpath).isDisplayed();
            }
        }
    }


    public void validateHideFilterButtonFunctionality(){
        hideFiltersButton.click();
        boolean flag = GLOBAL_GENERIC.getTheWebElementStatus("//button[text()='Add Filter Row']");
        Assert.assertEquals(flag, false);
    }

    public void  clicksOnAddFilterRowButton(int noOfClicks){
        for (int i =0;i<noOfClicks;i++){
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
        GLOBAL_GENERIC.locateAndGetWebElement(xpathOfSearchDropDown).click();
        searchDropDownTextField.sendKeys(dropDownValue);
        GLOBAL_GENERIC.locateAndGetWebElement("//span[text()='"+dropDownValue+"']").click();
    }

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
                locateAndGetWebElement(xpathOfOperatorDropDown).
                click();
         GLOBAL_GENERIC.
                 locateAndGetWebElement("//span[text()='"+dropDownValue+"']").
                 click();
    }

    private void selectTheValueMultipleCriteriaOperatorDropDown(int filterRowIndex,
                                                                String dropDownValue){
        GLOBAL_GENERIC.
                locateAndGetWebElement("//div[@role='listitem']["+filterRowIndex+"]/div/div/div[@name='operator']/i").click();
        GLOBAL_GENERIC.
                locateAndGetWebElement("//div[@role='listitem']["+filterRowIndex+"]/div/div/div[@name='operator']/div/div/span[text()='"+dropDownValue+"']").click();
    }

    private void enterTheDefaultSearchTextValue(String textValue){
        searchTextInputbox.sendKeys(textValue);
    }

    private void enterTheMultipleCriteriaSearchTextValue(int filterRowIndex, String textValue){
        GLOBAL_GENERIC.locateAndGetWebElement("//div[@role='listitem']["+filterRowIndex+"]/div/div/div[@class='ui input']/input")
                .sendKeys(textValue);
    }





    public void addSearchCriteria(String searchDropDownValue,
                                  String operatorDropDownValue,
                                  String searchText){
        selectTheValueFromDefaultCriteriaSearchDropDown(searchDropDownValue);
        selectTheValueFromDefaultOperatorDropDown(operatorDropDownValue);
        enterTheDefaultSearchTextValue(searchText);

    }



    public void addMultpleSearchCriteria(int indexOfSearchCriteria,
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
