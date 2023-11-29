package frameworkOfFreeCRM.resources.callModuleResource;

import frameworkOfFreeCRM.resources.globalResource.CommonXpath;
import frameworkOfFreeCRM.resources.globalResource.GLOBAL_GENERIC;
import frameworkOfFreeCRM.resources.staticResource.GLOBAL_STATIC;
import frameworkOfFreeCRM.utilities.screenshotUtilities.ScreenshotUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CallGlobalResource {
    /**initElement is a static method in Page Factory class.
     Using the initElements method, one can initialize all the web elements located by @FindBy annotation .
     calling this method in constructor so that the method is executed as soon as object is created and the driver is mapped to the web elements.
     thus, driver handling is done efficiently at the beginning. **/
public CallGlobalResource(){
    PageFactory.initElements(GLOBAL_STATIC.driver,this);
}


/**locating Web elements and storing into a variable,and initialize web element variables*/

@FindBy(xpath = "//label[contains(.,'Call Time')]/following-sibling::div/div/input[@class='calendarField']") WebElement calendarField;
@FindBy(xpath = "//label[contains(.,'Call Time')]/following-sibling::div/div/input[@class='calendarField react-datepicker-ignore-onclickoutside']") WebElement selectCalendar;
@FindBy(xpath = "//input[@class='calendarField react-datepicker-ignore-onclickoutside']") WebElement DeleteCalendar;
@FindBy(xpath = "//label[contains(.,'Call Time')]/following-sibling::div/div/input[@class='calendarField react-datepicker-ignore-onclickoutside']") WebElement CallTimeField;
@FindBy(xpath = "//input[@name='duration']") WebElement DurationField;
@FindBy(xpath = "//label[text()='Type']/following-sibling::div[@name='type']") WebElement TypeField;
@FindBy(xpath = "//label[text()='Flag']/following-sibling::div[@name='flag']") WebElement flagField;
@FindBy(xpath = "//label[text()='Participants']/following-sibling::div[@role='combobox']")
WebElement participantsSearchButton;
@FindBy(xpath = "//label[text()='Participants']/following-sibling::div[@role=\"combobox\"]/input[@class=\"search\"]")
WebElement participantBox;

@FindBy(xpath = "//div[@name='case']") WebElement CaseSearchButton;
@FindBy(xpath = "//div[@name='case']/input[@class=\"search\"]") WebElement CaseSearchBox;

@FindBy(xpath = "//label[text()='Start Time']/following-sibling::div/div/input[@class='calendarField']") WebElement startTimeField;
@FindBy(xpath = "//label[text()='Start Time']/following-sibling::div/div/input[@type='text']") WebElement startSendKeys;
@FindBy(xpath = "//div[text()='United States']") WebElement countryNameField;
@FindBy(xpath = "//input[@placeholder='Number']") WebElement phoneNumberField;
@FindBy(xpath = "//input[@placeholder='Home, Work, Mobile...']") WebElement workField;
@FindBy(xpath = "//button[@class='ui tiny basic icon button']") WebElement iconButtonField;

    /**method to retrieve test data from excel.*/
    private String  getDataFromExcel(int rowNum,int colNum){
        String  textRetrievedFromExcel = GLOBAL_STATIC.testData.getCellData("callstestData",rowNum,colNum);
        return  textRetrievedFromExcel;
    }
    //creating new calls test data.
    public void createCall(int excelTestDataRowNum) throws InterruptedException {
        String callTime=getDataFromExcel(excelTestDataRowNum,1);
        String callDuration =getDataFromExcel(excelTestDataRowNum,2);
        String typeDropdown =getDataFromExcel(excelTestDataRowNum,3);
        String flagDropdown =getDataFromExcel(excelTestDataRowNum,4);
        String startTime=getDataFromExcel(excelTestDataRowNum,5);
        String countryName= getDataFromExcel(excelTestDataRowNum,6);
        String phoneNum= getDataFromExcel(excelTestDataRowNum,7);

       Boolean flag=checkForCallTime(callTime);

        /**check if given calltime exist or not. create a new call only if the calltime is not available.
         * Using the common xpath for create button, with global static method.*/
           if(flag==false) {
               try {
                   GLOBAL_GENERIC.locateAndGetWebElement(CommonXpath.xpathOfCreateButton).click();
                   calendarField.click();
                   selectCalendar.sendKeys(Keys.CONTROL, "a");
                   DeleteCalendar.sendKeys(Keys.DELETE);
                   CallTimeField.sendKeys(callTime);
                   TypeField.click();
                   GLOBAL_STATIC.driver.findElement(By.xpath("//span[text()='" + typeDropdown + "']")).click();
                   DurationField.sendKeys(callDuration);
                   phoneNumberField.sendKeys(phoneNum);
                   workField.sendKeys("work");
                   iconButtonField.click();

                   //DropDownFields
                   flagField.click();
                   GLOBAL_STATIC.driver.findElement(By.xpath("//span[text()='" + flagDropdown + "']")).click();
                   startTimeField.click();
                   startSendKeys.sendKeys(startTime);
                   countryNameField.click();
                   GLOBAL_STATIC.driver.findElement(By.xpath("//span[text()='" + countryName + "']")).click();

                   // search fields
                   String caseName = getDataFromExcel(excelTestDataRowNum, 9);
                   CaseSearchButton.click();
                   CaseSearchBox.sendKeys(caseName);
                   GLOBAL_STATIC.driver.findElement(By.xpath("//span[text()='" + caseName + "']")).click();
                   String participantsName = getDataFromExcel(excelTestDataRowNum, 8);
                   participantsSearchButton.click();
                   // Thread.sleep(1000);
                   participantBox.sendKeys("a");
                   GLOBAL_STATIC.driver.findElement(By.xpath("//span[text()='" + participantsName + "']")).click();
               } catch (NoSuchElementException e) {
               }

               /**Using the common xpath for save button, with global static method.*/
               GLOBAL_GENERIC.locateAndGetWebElement(CommonXpath.xpathOfSaveButton).click();
               Thread.sleep(2000);
               GLOBAL_GENERIC.navigateToModule(GLOBAL_STATIC.nameOfModule[5]);
               boolean status = GLOBAL_STATIC.driver.findElement(By.xpath("//td[text()='" + typeDropdown + "']")).isDisplayed();
               Assert.assertEquals(status, true);
               ScreenshotUtility.chalBetaSelfielelele("CreatingCall");

           }
        }
       /**To validate that a given call record already created or not,
       and returns status of call record.
       If element is not found in try block,catch block will get executed. **/
        public boolean checkForCallTime(String callTime){

        Boolean statusOfCallTime=false;
        try{
        statusOfCallTime=GLOBAL_STATIC.driver.findElement(By.xpath("//td[text()='"+callTime+"']")).isDisplayed();}
        catch(NoSuchElementException e)
        {
            System.out.println("No, We didn't have record of  " + callTime );
        }
       return statusOfCallTime;
    }
    public static boolean checkForCallRecord(String time) {
        boolean statusOfCallRecord = false;
        try {
            statusOfCallRecord = GLOBAL_STATIC.driver.findElement(By.xpath("//td[text()='" + time + "']")).isDisplayed();
        } catch (NoSuchElementException e) {
            System.out.println("No, We didn't have a record with name of " + time);
        }
        return statusOfCallRecord;
    }
}

