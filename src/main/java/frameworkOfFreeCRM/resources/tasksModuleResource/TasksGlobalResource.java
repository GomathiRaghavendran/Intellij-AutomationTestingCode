package frameworkOfFreeCRM.resources.tasksModuleResource;

import frameworkOfFreeCRM.resources.globalResource.GLOBAL_GENERIC;
import frameworkOfFreeCRM.resources.staticResource.GLOBAL_STATIC;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class TasksGlobalResource {
    /**
     * >This method is to create a new task
     *
     * @parameter excelTestDataRowNum , This is the row number of Excel sheet.
     * ExcelSheet name:FieldsOnTaskModule.
     * this method will retrieve data from Excel to fields(title,Due Date,Close Date,type,priority,status,identifier,completion)
     * Creating tasks record and validating the record.
     * Page Factory: It is a Class in selenium, which has one method called initElements having two parameters "WebDriver" &
     * "Object". This initElements method is a "static method".
     *  This method will take care of mapping the driver to the WebElement, which you want to locate by @FindBy annotation in
    selenium.
     */
    public TasksGlobalResource() {
        PageFactory.initElements(GLOBAL_STATIC.driver, this);
    }
    @FindBy(xpath = "//button[text()='Create']")
    WebElement createButton;
    @FindBy(xpath = "//input[@name='title']")
    WebElement titleName;
    @FindBy(xpath = "//label[text()='Due Date']/following-sibling::div/div/input[@type='text']")
    WebElement dueDates;
    @FindBy(xpath = "//label[text()='Close Date']/following-sibling::div/div/input[@type='text']")
    WebElement closeDates;
    @FindBy(xpath = "//span[text()='Create new Task']")   WebElement createNewTask;
    @FindBy(xpath="//div[@name='company']/input[@class='search']")
    WebElement companySearchBox;
    @FindBy(xpath="//div[@name='deal']/input[@class='search']")
    WebElement dealSearchBox;
    @FindBy(xpath="//div[@name='case']/input[@class='search']")
    WebElement caseSearchBox;
    @FindBy(xpath = "//label[text()='Type']/following-sibling::div[@name='type']")
    WebElement typeDropDown;
    @FindBy(xpath = "//div[@class='ui field']/div[@name='priority']")
    WebElement priorityDropDown;
    @FindBy(xpath = "//div[@class='ui field']/div[@name='status']")
    WebElement statusDropDown;
    @FindBy(xpath="//button[text()='Save']") WebElement saveButton;
    @FindBy(xpath="//input[@name='identifier']") WebElement identifierValue;
    @FindBy(xpath="//input[@name='completion']") WebElement completionValue;

    /** Fetch Data From Excel.
     Calling getCellData method from ExcelTestDataUtility Class by passing the parameters sheetName, rowNumber, columnNumber
     and stored that value in one variable.**/
    public String getDataFromExcel(int rowNum, int column) {
        String textRetrievedFromExcel = GLOBAL_STATIC.testData.getCellData("tasksTestData", rowNum, column);
        return textRetrievedFromExcel;
    }
    public void createTasks(int excelTestDataRowNum) throws InterruptedException {

        // WebElement createButton=GLOBAL_STATIC.driver.findElement(By.xpath("//button[text()='Create']"));

        String title = getDataFromExcel(excelTestDataRowNum, 1);
        boolean flag = checkForTitleRecord(title);

        if (flag == false) {
            // Below two lines of code is added for creating a task from cases view page by Cases_Franc1 squad.
            // It will check whether the create button is present or not,using getTheWebElementStatus method.
            Boolean statusOfCreateButton=GLOBAL_GENERIC.getTheWebElementStatus("//button[text()='Create']");
            if(statusOfCreateButton==true)
                createButton.click();

            titleName.sendKeys(title);

            String DueDate = getDataFromExcel(excelTestDataRowNum, 2);
            dueDates.sendKeys(DueDate);

            String closeDate = getDataFromExcel(excelTestDataRowNum, 3);
            closeDates.sendKeys(closeDate);

            // because of screen resolution issue we are clicking on one element.
            createNewTask.click();

            String typeDropDownValue = getDataFromExcel(excelTestDataRowNum, 4);
            typeDropDown.click();
            GLOBAL_STATIC.driver.findElement(By.xpath("//span[text()='" + typeDropDownValue + "']")).click();

            companySearchBox.click();
            String company=getDataFromExcel(excelTestDataRowNum,9);
            companySearchBox.sendKeys(company);
            boolean statusOfCompanyDropDownValueVisibility= GLOBAL_GENERIC.getTheWebElementStatus("//div[@name='company']/div/div/span[text()='"+company+"']");

            // we are handling companies field properly by passing one condition.

            if(statusOfCompanyDropDownValueVisibility == true)
                GLOBAL_STATIC.driver.findElement(By.xpath("//div[@name='company']/div/div/span[text()='"+company+"']")).click();
            else
                GLOBAL_STATIC.driver.findElement(By.xpath("//span[text()='Add ']")).click();

            dealSearchBox.click();
            String deal=getDataFromExcel(excelTestDataRowNum,10);
            dealSearchBox.sendKeys(deal);
            boolean statusOfDealDropDownValueVisibility= GLOBAL_GENERIC.getTheWebElementStatus("//div[@name='deal']/div/div/span[text()='"+deal+"']");
            //we are handling deals field properly

            if(statusOfDealDropDownValueVisibility == true)
                GLOBAL_STATIC.driver.findElement(By.xpath("//div[@name='deal']/div/div/span[text()='"+deal+"']")).click();
            else
                GLOBAL_STATIC.driver.findElement(By.xpath("//span[text()='Add ']")).click();

            caseSearchBox.click();
            String cases=getDataFromExcel(excelTestDataRowNum,11);
            caseSearchBox.sendKeys(cases);
            boolean statusOfCasesDropDownValueVisibility= GLOBAL_GENERIC.getTheWebElementStatus("//div[@name='case']/div/div/span[text()='"+cases+"']");
            //we are handling cases field properly

            if(statusOfCasesDropDownValueVisibility == true)
                GLOBAL_STATIC.driver.findElement(By.xpath("//div[@name='case']/div/div/span[text()='"+cases+"']")).click();
            else
                GLOBAL_STATIC.driver.findElement(By.xpath("//span[text()='Add ']")).click();


            String priorityDropDownValue = getDataFromExcel(excelTestDataRowNum, 5);
            priorityDropDown.click();
            GLOBAL_STATIC.driver.findElement(By.xpath("//span[text()='" + priorityDropDownValue + "']")).click();

            String statusDropDownValue = getDataFromExcel(excelTestDataRowNum, 6);
            statusDropDown.click();
            GLOBAL_STATIC.driver.findElement(By.xpath("//span[text()='" + statusDropDownValue + "']")).click();

            String identifier=getDataFromExcel(excelTestDataRowNum,7);
            identifierValue.sendKeys(identifier);

            String completion=getDataFromExcel(excelTestDataRowNum,8);
            completionValue.sendKeys(completion);

            saveButton.click();
            Thread.sleep(2000);

            GLOBAL_GENERIC.navigateToModule(GLOBAL_STATIC.nameOfModule[3]);

            boolean status = GLOBAL_STATIC.driver.findElement(By.xpath("//a[text()='" + title + "']")).isDisplayed();
            Assert.assertEquals(status, true);
        }
    }

    /**
     In below method we are checking for title record is exist or not
     */
    public static boolean checkForTitleRecord(String name) {
        boolean statusOfTitle = false;
        try {
            statusOfTitle = GLOBAL_STATIC.driver.findElement(By.xpath("//a[text()='" + name + "']")).isDisplayed();
        } catch (NoSuchElementException e) {
            System.out.println("This record "+name+" does not exist" );
        }

        return statusOfTitle;

    }
}