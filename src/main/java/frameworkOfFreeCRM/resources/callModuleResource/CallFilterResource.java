package frameworkOfFreeCRM.resources.callModuleResource;

import frameworkOfFreeCRM.resources.globalResource.GLOBAL_GENERIC;
import frameworkOfFreeCRM.resources.staticResource.GLOBAL_STATIC;
import frameworkOfFreeCRM.utilities.screenshotUtilities.ScreenshotUtility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CallFilterResource {
       String filterScreenWebelements[] = {"plus", "ban", "upload", "search", "columns", "save", "Add Filter Row"};
    /** verifying if the defined icon are visible on the show filter screen. these icons have a dynamic xpath
     which we can iterate through array.
     */
       public CallFilterResource() {
           PageFactory.initElements(GLOBAL_STATIC.driver, this);
       }

       @FindBy(xpath = "//button[text()='Hide Filters']")
       WebElement hideFiltersButton;
       @FindBy(xpath = "//button[text()='Add Filter Row']")
       WebElement addFilterRowButton;
       @FindBy(xpath = "//i[@class='search small icon']")
       public WebElement  searchButtonXpath;
       @FindBy(xpath = "//input[@class='search']")
       public WebElement  searchDropDownTextField;
       @FindBy(xpath = "//i[@class='search small icon']")
        public WebElement  searchButton;
       @FindBy(xpath = "//i[@class='ban small icon']")
        public WebElement  clearButton;
       @FindBy(xpath = "//i[@class='minus small icon']")
         WebElement  removeFilterRowButton;
      public String searchDropDownValues[] = {"Call Time","Assigned To","Type","Status","Call Script","Duration","Start Time","Flag"};
      public String operatorDropDownValues[] ={"Equals","in"};
      public String valueDropDown[]= {"CALL","CONFERENCE","SKYPE","HANGOUT"};
      public String valueDropDownOfFlagValue[]={"F.Y.I","Important","Urgent"};
      public static String  xpathOfFilterRow = "//div[@role='listitem']";
      public static String  xpathOfSearchDropDown = "//div[@name='name']/i";
      public static String  xpathOfOperatorDropDown =  "//div[@name='operator']/i";
      public static String  xpathOfValueDropDown =  "//div[@name='value']";

    /**after click on show filter button validating if one filter is added on overview page and search icon is
      present there
    */
    public void validateTheShowFilterWebElement() {
           int length = filterScreenWebelements.length;
           String dynamicXpath;
           for (int lengthOfElements = 0; lengthOfElements < length; lengthOfElements++) {
               if (filterScreenWebelements[lengthOfElements] == "Add Filter Row") {
                   dynamicXpath = "//button[text()='" + filterScreenWebelements[lengthOfElements] + "']";
                   GLOBAL_GENERIC.locateAndGetWebElement(dynamicXpath).click();
               }
               else {
                   dynamicXpath = "//i[@class='" + filterScreenWebelements[lengthOfElements] + " small icon']";
                   GLOBAL_GENERIC.locateAndGetWebElement(dynamicXpath).isDisplayed();
               }
           }
       }

    /**after click on hide filter button add filter row is not displayed on page anymore.here storing that value in flag
    and validating through assertion*/
    public void validateHideFilterButton(){
           hideFiltersButton.click();
           boolean flag = GLOBAL_GENERIC.getTheWebElementStatus("//button[text()='Add Filter Row']");
           Assert.assertEquals(flag, false);
       }

    public void  clicksOnAddFilterRowButton(int noOfClicks){
           for(int i=0;i<noOfClicks;i++){
               addFilterRowButton.click();
           }
        ScreenshotUtility.chalBetaSelfielelele("AddFilter");
    }
    public void  clicksOnRemoveFilterRowButton(int noOfClicks){
        for (int i =0;i<noOfClicks;i++){
            removeFilterRowButton.click();
            ScreenshotUtility.chalBetaSelfielelele("AfterFilterRowRemoval");
        }

    }
    /**Method to select the value from search drop down.*/
    private void selectTheValueFromSearchDropDown(String dropDownValue){
        GLOBAL_GENERIC.locateAndGetWebElement(xpathOfSearchDropDown).click();
        searchDropDownTextField.sendKeys(dropDownValue);
        GLOBAL_GENERIC.locateAndGetWebElement("//span[text()='"+dropDownValue+"']").click();

    }
   /** Below method is to select the value from multiple searchDropDown by clicking it first,then we are passing send keys to the value
    then it will select the values by clicking on it.*/
    private void selectTheValueFromMultipleCriteriaInSearchDropDown(int filterRowIndexNumber,String dropdownValue){
        GLOBAL_GENERIC.locateAndGetWebElement("//div[@role='listitem']["+filterRowIndexNumber+"]/div/div/div[@name='name']/i").click();
        GLOBAL_GENERIC.locateAndGetWebElement("//div[@role='listitem']["+filterRowIndexNumber+"]/div/div/div[@name='name']/input").sendKeys(dropdownValue);
        GLOBAL_GENERIC.locateAndGetWebElement("//div[@role='listitem']["+filterRowIndexNumber+"]/div/div/div[@name='name']/div/div/span[text()='"+dropdownValue+"']").click();
    }
    /**Method to select the value from operator drop down*/
    private void selectTheValueFromOperatorDropDown(String dropDownValue){
        GLOBAL_GENERIC.locateAndGetWebElement(xpathOfOperatorDropDown).click();
        GLOBAL_GENERIC.locateAndGetWebElement("//span[text()='"+dropDownValue+"']").click();
    }
    /**Below method is to select the value from multiple operatorDropDown by clicking it first,then selecting that value by
     clicking on the web element available in that dropdown*/
    private void selectTheValueMultipleCriteriaOperatorDropDown(int filterRowIndexNumber,String dropdownValue){
        GLOBAL_GENERIC.locateAndGetWebElement("//div[@role='listitem']["+filterRowIndexNumber+"]/div/div/div[@name='operator']/i").click();
        GLOBAL_GENERIC.locateAndGetWebElement("//div[@role='listitem']["+filterRowIndexNumber+"]/div/div/div[@name='operator']/div/div/span[text()='"+dropdownValue+"']").click();
    }
    //Method to select the value from value drop down ( based on above selection).
    private void selectTheValueFromValueDropDown(String dropDownValue){
        GLOBAL_GENERIC.locateAndGetWebElement(xpathOfValueDropDown).click();
        GLOBAL_GENERIC.locateAndGetWebElement("//span[text()='"+dropDownValue+"']").click();
    }
    /**Below method is to select the value from multiple valueDropDown by clicking it first,then selecting that value by
    clicking on the web element available in that dropdown*/
    private void selectTheValueMultipleCriteriaValueDropDown(int filterRowIndexNumber,String dropdownValue){
        GLOBAL_GENERIC.locateAndGetWebElement("//div[@role='listitem']["+filterRowIndexNumber+"]/div/div/div[@name='value']/i").click();
        GLOBAL_GENERIC.locateAndGetWebElement("//div[@role='listitem']["+filterRowIndexNumber+"]/div/div/div[@name='value']/div/div/span[text()='"+dropdownValue+"']").click();
    }
    /**Below method is used to call above three methods of single filter,In this method
     we are  pass three parameters like searchdropdownValue, operaterDropDownValue and valueDropDownValue*/
    public void addSearchCriteria(String searchDropDownValue, String operatorDropDownValue,String valueDropDown){
        selectTheValueFromSearchDropDown(searchDropDownValue);
        selectTheValueFromOperatorDropDown(operatorDropDownValue);
        selectTheValueFromValueDropDown(valueDropDown);
        ScreenshotUtility.chalBetaSelfielelele("SingleFilter");
    }
    /**Below method is used to call above three methods of multiple filter,In this method
     we are  pass three parameters like searchdropdownValue, operaterDropDownValue and valueDropDownValue*/
    public void addMultipleSearchCriteria(int filterRowIndexNumber,String searchdropdownValue, String operaterDropDownValue,String valueDropDownValue){
        selectTheValueFromMultipleCriteriaInSearchDropDown(filterRowIndexNumber,searchdropdownValue);
        selectTheValueMultipleCriteriaOperatorDropDown(filterRowIndexNumber,operaterDropDownValue);
        selectTheValueMultipleCriteriaValueDropDown(filterRowIndexNumber,valueDropDownValue);
        ScreenshotUtility.chalBetaSelfielelele("MultipleFilter");
    }
   }