package gomframeworkOfFreeCRM.gomResources.casesModuleResource;

import frameworkOfFreeCRM.resources.globalResource.GLOBAL_GENERIC;
import frameworkOfFreeCRM.resources.staticResource.GLOBAL_STATIC;
import gomframeworkOfFreeCRM.gomResources.globalResource.GomGLOBAL_GENERIC;
import gomframeworkOfFreeCRM.gomResources.staticReource.GomGLOBAL_STATIC;
import gomframeworkOfFreeCRM.gomUtilities.ScreenshotUtility.GomScreenshotUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

    /**Create New Cases by fetching values from ExcelData.**/

public class GomCasesGlobalResource {
        public GomCasesGlobalResource() {
            PageFactory.initElements(GomGLOBAL_STATIC.driver, this);
        }
/** We are using FindBY annotations with the help of PageFactory to handle the driver.**/

        @FindBy(xpath = "//button[text()='Create']")
        WebElement createNewCases;
        @FindBy(xpath = "//input[@name='title']")
        WebElement titleName;
        @FindBy(xpath = "//label[text()='Assigned To']/following-sibling::div[@role='listbox']")
        WebElement assignedTo;
        @FindBy(xpath = "//div[@class='visible menu transition']//div[@role='option']//span")
         WebElement assignedToValue;
        @FindBy(xpath = "//label[text()='Type']/following-sibling::div[@name='type']")
        WebElement typeDropDown;
        @FindBy(xpath = "//label[text()='Status']/following-sibling::div[@name='status']")
        WebElement statusDropDown;
        @FindBy(xpath ="//label[text()='Priority']/following-sibling::div[@name='priority']")
        WebElement priorityDropDown;
        @FindBy(xpath = "//label[text()='Company']/following-sibling::div/input[@class='search']")
        WebElement companySearchIcon;
        @FindBy(xpath = "//label[text()='Contact']/following-sibling::div/input[@class='search']")
        WebElement contactSearchIcon;
        @FindBy(xpath = "//label[text()='Deal']/following-sibling::div/input[@class='search']")
        WebElement dealSearchIcon;
        @FindBy(xpath = "//label[@for='tags']//div[@role='combobox']//input[@class='search']")
        WebElement tagsSearchIcon;
        @FindBy(xpath = "//label[text()='Close Date']/following-sibling::div[@class='react-datepicker-wrapper']")
        WebElement closeDate;
        @FindBy(xpath = " //div[@class='react-datepicker__month-container']//div[@class='react-datepicker__month']//div[@class='react-datepicker__week']//div[@class='react-datepicker__day react-datepicker__day--002']")
        WebElement monthDatePickerCloseDate;
        @FindBy(xpath = "//div[@class='react-datepicker__time-container ']//li[text()='00:30']")
        WebElement timePickerForCloseDate;
        @FindBy(xpath = "//label[text()='Deadline']/following-sibling::div[@class='react-datepicker-wrapper']")
        WebElement deadLine;
       @FindBy(xpath = "//div[@class='react-datepicker__month-container']//div[@class='react-datepicker__month']//div[@class='react-datepicker__week']//div[@class='react-datepicker__day react-datepicker__day--002']")
       WebElement monthDatePickerDeadLine;
       // @FindBy(xpath = "//div[@class='react-datepicker__time-container ']//li[text()='00:15']")
      //  WebElement timePickerForDeadline;
        @FindBy(xpath = "//textarea[@name='description']")
        WebElement description;
        @FindBy(xpath = "//input[@name='identifier']")
        WebElement identifier;
        @FindBy(xpath = "//button[text()='Save']")
        WebElement saveButton;


        /** Fetch Data From Excel.
        Calling getCellData method from ExcelTestDataUtility by passing the parameters sheetName, rowNumber, columnNumber
        and storing that value in one variable.**/
        private String getDataFromExcel(int rowNum, int colNum) {
            String textRetrievedFromExcel = GomGLOBAL_STATIC.testData.getCellData("casesTestData",rowNum,colNum);
            return textRetrievedFromExcel;
        }
/** Create cases after checking whether the record is existing or not. **/
        public void createCases(int excelTestDataRowNum) throws InterruptedException {
            String title = getDataFromExcel(excelTestDataRowNum, 1);
            boolean flag = checkForCasesRecord(title);
            if (flag == false) {
                //Control  ---->CreateNewCases


                boolean statusOfCreateButton = GomGLOBAL_GENERIC.getTheWebElementStatus("//button[text()='Create']");
                if(statusOfCreateButton == true)
                    createNewCases.click();
                //Control   ----->title
                titleName.sendKeys(title);
                //Control ---->AssignedTo
                assignedTo.click();
                assignedToValue.click();

                //Control  ----typeDropDownValue
                String typeDropDownValue = getDataFromExcel(excelTestDataRowNum, 2);
                typeDropDown.click();
                GomGLOBAL_STATIC.driver.findElement(By.xpath("//span[text()='" + typeDropDownValue + "']")).click();
                //Control  ---->statusDropdown
                String statusDropDownValue = getDataFromExcel(excelTestDataRowNum, 3);
                statusDropDown.click();
                GomGLOBAL_STATIC.driver.findElement(By.xpath("//span[text()='" + statusDropDownValue + "']")).click();
                //Control  --->priorityDropDown
                String priorityDropDownValue=getDataFromExcel(excelTestDataRowNum,4);
                priorityDropDown.click();
                GomGLOBAL_STATIC.driver.findElement(By.xpath("//span[text()='"+priorityDropDownValue+"']")).click();

                //Control  ---->CompanySearchIcon
                String companyName = getDataFromExcel(excelTestDataRowNum,5);
                companySearchIcon.sendKeys(companyName);
                Thread.sleep(2000);
                GomGLOBAL_STATIC.driver.findElement(By.xpath("//span[text()='"+companyName+"']")).click();
                //Control  ---->ContactSearchIcon
                String contactValue = getDataFromExcel(excelTestDataRowNum,6);
                contactSearchIcon.sendKeys(contactValue);
                Thread.sleep(3000);
                GomGLOBAL_STATIC.driver.findElement(By.xpath("//span[text()='"+contactValue+"']")).click();
                //Contact  ---->DealSearchIcon
                String dealValue = getDataFromExcel(excelTestDataRowNum,7);
                dealSearchIcon.sendKeys(dealValue);
                GomGLOBAL_STATIC.driver.findElement(By.xpath("//input[@value='"+dealValue+"']")).click();
                //Control  --->TagsSearchIcon
                String tagValue = getDataFromExcel(excelTestDataRowNum,8);
                tagsSearchIcon.sendKeys(tagValue);
                Thread.sleep(3000);
                //GLOBAL_STATIC.driver.findElement(By.xpath("//div[@role='option']//span[text()='"+tagValue+"']")).click();

               //Control  --->CloseDate
                closeDate.click();
                monthDatePickerCloseDate.click();
                timePickerForCloseDate.click();

                //Control  --->DeadLine
                deadLine.click();
                monthDatePickerDeadLine.click();
               // timePickerForDeadline.click();

                //Control ---->Description
                String descriptionValue = getDataFromExcel(excelTestDataRowNum,10);
                description.sendKeys(descriptionValue);

                //Control ---->Identifier
                String identifierValue=getDataFromExcel(excelTestDataRowNum,9);
                identifier.sendKeys(identifierValue);

                //Control   ---->SaveButton
                saveButton.click();
                Thread.sleep(3000);

                //navigateToCasesModuleAndValidateWithTitle
                GomGLOBAL_GENERIC.navigateToModule(GLOBAL_STATIC.nameOfModule[4]);
                boolean flagTitle = GomGLOBAL_STATIC.driver.findElement(By.xpath("//a[text()='" +title+ "']")).isDisplayed();
                Assert.assertEquals(flagTitle, true);
                boolean flagStatus = GomGLOBAL_STATIC.driver.findElement(By.xpath("//td[text()='" + statusDropDownValue + "']")).isDisplayed();
                Assert.assertEquals(flagStatus, true);
            }
        }
/** Checking whether the record is already exist or not by passing the caseName and also returning the boolean value. **/
        public static boolean checkForCasesRecord(String nameoftitle) {
            boolean statusOfCases = false;
            try {
                statusOfCases = GomGLOBAL_STATIC.driver.findElement(By.xpath("//a[text()='"+nameoftitle+"']")).isDisplayed();
                System.out.println("The Record already Exists");
                GomScreenshotUtility.chaLBetaSelfieLeLele(nameoftitle+ "RecordAlreadyExists.png");

            } catch (NoSuchElementException e) {
                System.out.println("No, We didn't have a record with name of " + nameoftitle);
                GomScreenshotUtility.chaLBetaSelfieLeLele(nameoftitle+ "RecordNotExists.png");

            }
           return statusOfCases;
        }
    }









