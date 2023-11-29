package frameworkOfFreeCRM.resources.dealsModuleResource;


import frameworkOfFreeCRM.resources.globalResource.GLOBAL_GENERIC;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import frameworkOfFreeCRM.resources.staticResource.GLOBAL_STATIC;
import org.openqa.selenium.By;

public class DealsGlobalResource {
    // Below method is to 'Create new Deal' and assign values for Deals module in free CRM application.
    public DealsGlobalResource() {
        PageFactory.initElements(GLOBAL_STATIC.driver,this);
    }
    // Page Factory is a class provided by Selenium WebDriver.
    // The initElements method is used to initialize web elements.
    // we used @FindBy annotation,to find web elements and perform actions on them.
    @FindBy(xpath = "//button[text()='Create']") WebElement createNewDeal;
    @FindBy(xpath = "//input[@name='title']") WebElement title;
    @FindBy(xpath = "//input[@class='calendarField']") WebElement calender;
    @FindBy(xpath = "//input[@class='calendarField react-datepicker-ignore-onclickoutside']") WebElement closeDateValue;
    @FindBy(xpath = "//textarea[@name='description']") WebElement inputDescription;
    @FindBy(xpath = "//input[@name='probability']") WebElement inputProbability;
    @FindBy(xpath = "//input[@name='amount']") WebElement amountValue;
    @FindBy(xpath = "//input[@name='commission']") WebElement commissionValue;
    @FindBy(xpath = "//textarea[@name='next_step']") WebElement next_stepValue;
    @FindBy(xpath = "//input[@name='identifier']") WebElement identifierValue;
    @FindBy(xpath = "//div[@name='company']/i[@class='search icon']") WebElement CompanySearch;
    @FindBy(xpath = "//div[@name='company']/input[@class='search']") WebElement Company;
    @FindBy(xpath = "//div[@name='products']/i[@class='search icon']") WebElement ProductSearch;
    @FindBy(xpath = "//div[@name='products']/input[@class='search']") WebElement Product;
    @FindBy(xpath = "//div[@name='contacts']/i") WebElement ContactSearch;
    @FindBy(xpath = "//div[@name='contacts']/input") WebElement Contact;
    @FindBy(xpath= "//label/div[@role='combobox']/i[@class='search icon']") WebElement TagSearch;
    @FindBy(xpath = "//label/div[@role='combobox']/input[@class='search']") WebElement Tags;
    @FindBy(xpath = "//label[text()='Stage']/following-sibling::div[@name='stage']") WebElement stageDropDownValue;
    @FindBy(xpath = "//label[text()='Status']/following-sibling::div[@name='status']") WebElement statusDropDownValue;
    @FindBy(xpath = "//label[text()='Type']/following-sibling::div[@name='type']") WebElement typeDropDownValue;
    @FindBy(xpath = "//label[text()='Source']/following-sibling::div[@name='source']") WebElement sourceDropDownValue;
    @FindBy(xpath = "//button[text()='Save']") WebElement SaveButton;

    public String getDataFromExcel(int rowNum,int columnNum){
        String textFromExcel = GLOBAL_STATIC.testData.getCellData("dealsTestData",rowNum,columnNum);
        return   textFromExcel;
    }

    public void createDeals(int excelTestDataRowNo) throws InterruptedException {
        String nameOfTheTitle= getDataFromExcel(excelTestDataRowNo, 1); ;
        boolean flag = checkDealsRecord(nameOfTheTitle);
        if(flag==false) {

            createNewDeal.click();

            /* Code to Retrieve Title Values from Excel sheet */
            String titleName = getDataFromExcel(excelTestDataRowNo, 1);
            title.sendKeys(titleName);

            /* Retrieving CloseDate Values from Excel sheet */

            String closeDate = getDataFromExcel(excelTestDataRowNo, 9);
            String closeTime = getDataFromExcel(excelTestDataRowNo, 10);
            calender.click();
            closeDateValue.sendKeys(Keys.CONTROL, "a");
            closeDateValue.sendKeys(Keys.DELETE);
            closeDateValue.sendKeys(closeDate);
            GLOBAL_STATIC.driver.findElement(By.xpath("//li[text()=" + closeTime + "]")).click();

            //Code for selecting value from Search DropDown

            String contact = getDataFromExcel(excelTestDataRowNo, 17);
            ContactSearch.click();
            Contact.sendKeys(contact);
            boolean statusOfContactDropDownValueVisibility = GLOBAL_GENERIC.
                    getTheWebElementStatus("//div[@name='contacts']/div/div/span[text()='" + contact + "']");
            try {
                if (statusOfContactDropDownValueVisibility == true)
                    GLOBAL_STATIC.driver.findElement(By.xpath("//div[@name='contacts']/div/div/span[text()='" + contact + "']")).click();
                else
                    GLOBAL_STATIC.driver.findElement(By.xpath("//span[text()='Add ']")).click();
            } catch (NoSuchElementException e){
        }


            String company = getDataFromExcel(excelTestDataRowNo,11);
            CompanySearch.click();
            Company.sendKeys(company);
            boolean statusOfCompanyDropDownValueVisibility = GLOBAL_GENERIC.
                    getTheWebElementStatus("//div[@name='company']/div/div/span[text()='"+company+"']");
            try{
            if(statusOfCompanyDropDownValueVisibility == true )
                GLOBAL_STATIC.driver.findElement(By.xpath("//div[@name='company']/div/div/span[text()='"+company+"']")).click();
            else
                GLOBAL_STATIC.driver.findElement(By.xpath("//span[text()='Add ']")).click();
        }
            catch(NoSuchElementException e){

        }


        String product = getDataFromExcel(excelTestDataRowNo,15);
            ProductSearch.click();
            Product.sendKeys(product);
            boolean statusOfProductDropDownValueVisibility = GLOBAL_GENERIC.
                    getTheWebElementStatus("//div[@name='products']/div/div/span[text()='"+product+"']");
            try {

                if (statusOfProductDropDownValueVisibility == true)
                    GLOBAL_STATIC.driver.findElement(By.xpath("//div[@name='products']/div/div/span[text()='" + product + "']")).click();
                else
                    GLOBAL_STATIC.driver.findElement(By.xpath("//span[text()='Add ']")).click();

            }
            catch(NoSuchElementException e){

            }

            String tags = getDataFromExcel(excelTestDataRowNo,16);
            TagSearch.click();
            Tags.sendKeys(tags);

            boolean statusOfTagsDropDownValueVisibility = GLOBAL_GENERIC.
                    getTheWebElementStatus("//label/div[@role='combobox']/div[@role='listbox']/div/span/b[text()='" + tags + "']");
            if(statusOfTagsDropDownValueVisibility == true)
            GLOBAL_STATIC.driver.findElement(By.xpath("//label/div[@role='combobox']/div[@role='listbox']/div/span/b[text()='" + tags + "']")).click();
            else
                GLOBAL_STATIC.driver.findElement(By.xpath("//span[text()='Add ']")).click();

            // Code for input values and textarea

            String description = getDataFromExcel( excelTestDataRowNo, 2);
            inputDescription.sendKeys(description);

            String Probability = getDataFromExcel( excelTestDataRowNo, 3);
            inputProbability.sendKeys(Probability);

            String amount =getDataFromExcel( excelTestDataRowNo, 8);
            amountValue.sendKeys(amount);

            String commission = getDataFromExcel( excelTestDataRowNo, 12);
            commissionValue.sendKeys(commission);

            String nextSteps = getDataFromExcel( excelTestDataRowNo, 13);
            next_stepValue.sendKeys(nextSteps);

            String identifier = getDataFromExcel( excelTestDataRowNo, 14);
            identifierValue.sendKeys(identifier);

            // Code for selecting value from DropDown

            String stageDropdown = getDataFromExcel( excelTestDataRowNo, 4);
            stageDropDownValue.click();
            GLOBAL_STATIC.driver.findElement(By.xpath("//span[text()='" + stageDropdown + "']")).click();

            String statusDropdown = getDataFromExcel( excelTestDataRowNo, 5);
            statusDropDownValue.click();
            GLOBAL_STATIC.driver.findElement(By.xpath("//span[text()='" + statusDropdown + "']")).click();

            String typeDropdown = getDataFromExcel( excelTestDataRowNo, 6);
            typeDropDownValue.click();
            GLOBAL_STATIC.driver.findElement(By.xpath("//span[text()='" + typeDropdown + "']")).click();

            String sourceDropdown = getDataFromExcel( excelTestDataRowNo, 7);
            sourceDropDownValue.click();
            GLOBAL_STATIC.driver.findElement(By.xpath("//span[text()='" + sourceDropdown + "']")).click();

            SaveButton.click();
            Thread.sleep(1000);


            // code to validate right Deals page is displayed or not
            GLOBAL_GENERIC.navigateToModule(GLOBAL_STATIC.nameOfModule[2]);
            String title = titleName;
            boolean status = GLOBAL_STATIC.driver.findElement(By.xpath("//a[text()='" + nameOfTheTitle + "']")).isDisplayed();
            Assert.assertEquals(status, true);}
    }
    // Method to check the existence of specific record in dealsModulePipeline overview page
    public static boolean checkDealsRecord(String name) {
        boolean statusOfTitle = false;
        try {
            statusOfTitle = GLOBAL_STATIC.driver.findElement(By.xpath("//a[text()='" + name + "']")).isDisplayed();
        } catch (NoSuchElementException e) {
            System.out.println("No,the record with name " + name + " does not exists ");
        }
        return statusOfTitle;
    }

}