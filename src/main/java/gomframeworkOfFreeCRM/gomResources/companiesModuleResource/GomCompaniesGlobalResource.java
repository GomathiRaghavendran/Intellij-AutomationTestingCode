package gomframeworkOfFreeCRM.gomResources.companiesModuleResource;

import frameworkOfFreeCRM.utilities.screenshotUtilities.ScreenshotUtility;
import gomframeworkOfFreeCRM.gomResources.globalResource.GomCommonXpath;
import gomframeworkOfFreeCRM.gomResources.globalResource.GomGLOBAL_GENERIC;
import gomframeworkOfFreeCRM.gomResources.staticReource.GomGLOBAL_STATIC;
import gomframeworkOfFreeCRM.gomUtilities.ScreenshotUtility.GomScreenshotUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class GomCompaniesGlobalResource {
    /** This default constructor deals with handles driver using Page factory Class
     * default constructor will be executed at the time of object creation
     * and it will handle the driver using initElements method from Page factory class
     * initElements method will take care of providing the mapping between driver and locators
     * which we want to locate by @Find by annotation**/



    public GomCompaniesGlobalResource(){
        PageFactory.initElements(GomGLOBAL_STATIC.driver,this);
    }

    /**@Find By -is a annotation provided by Selenium.
     * It will only try to locate the web elements which are annotated with FindBy just before performing action*/
    @FindBy(xpath = "//button[text()='Create']")  WebElement  createButton;
    @FindBy(xpath = "//input[@name='name'][1]")  WebElement  companyName;
    @FindBy(xpath="//input[@placeholder='Street Address']") WebElement streetName;
    @FindBy(xpath = "//input[@placeholder='City']") WebElement city;
    @FindBy(xpath="//input[@placeholder='State / County']") WebElement stateCountry;
    @FindBy(xpath="//input[@placeholder='Post Code']") WebElement postalCode;
    @FindBy(xpath="//input[@placeholder='Email address']") WebElement emailAddress;
    @FindBy(xpath="//label[text()='Status']/following-sibling::div[@name='status']") WebElement statusDropDownBox;
    @FindBy(xpath="//div[@name='channel_type']") WebElement socialChannelDropdownBox;
    @FindBy(xpath="//div[@name='hint']") WebElement phoneDropDownBox;
   @FindBy(xpath = "//div[@name='country']") WebElement countryDropDownValueBox;
    @FindBy(xpath="//label[text()='Category']/following-sibling::div[@name='category']") WebElement categoryDropDownBox;
    @FindBy(xpath = "// label[text()='Priority']/following-sibling::div[@name='priority']") WebElement priorityDropDownBox;
    @FindBy(xpath="//label[text()='Source']/following-sibling::div[@name='source']") WebElement sourceDropDownBox;
    @FindBy(xpath ="//button[text()='Save']") WebElement saveButton;

   // @FindBy(xpath ="//i[@class='search icon']") WebElement tagsSearchButton;

    @FindBy(xpath="//div[contains(@class,'multiple') and @role='combobox']") WebElement tagsTextBox;

    @FindBy(xpath = "//div[contains(@class,' multiple')]/input")WebElement sendKeysTagsTextBox;






    /** This method deals with retrieving the data from excel sheet
     * this method is a private method, hence this method will be used only within this class*/
    private String  getDataFromExcel(int rowNum,int colNum){
        String  textRetrievedFromExcel = GomGLOBAL_STATIC.testData.getCellData("companiesTestData",rowNum,colNum);
        return  textRetrievedFromExcel;
    }

    /**This method deals with creating a new company name
     * Will have click on create button to navigate to create a company name
     * data will be retrieved from Excel sheet for the text boxes and dropdown*/
    public void createCompany(int excelTestDataRowNo) throws InterruptedException {
        //Retrieving Text boxes values from excel sheet
        String cName = getDataFromExcel(excelTestDataRowNo, 1);
        String street = getDataFromExcel(excelTestDataRowNo, 2);
        String cityName = getDataFromExcel(excelTestDataRowNo, 3);
        String state = getDataFromExcel(excelTestDataRowNo, 4);
        String pc = getDataFromExcel(excelTestDataRowNo, 5);
        String email = getDataFromExcel(excelTestDataRowNo, 6);
        //Retrieving dropdown values from excel sheet
        String statusDropDownValue = getDataFromExcel(excelTestDataRowNo, 7);
       // String socialChannelDropdown = getDataFromExcel(excelTestDataRowNo, 8);
       // String phoneDropDownValue = getDataFromExcel(excelTestDataRowNo, 9);
        String categoryDropDown = getDataFromExcel(excelTestDataRowNo, 8);
        String priorityDropDown = getDataFromExcel(excelTestDataRowNo, 9);
        String sourceDropDown = getDataFromExcel(excelTestDataRowNo, 10);
       // String countryDropDownValue = getDataFromExcel(excelTestDataRowNo, 13);
        //Retrieving search field values from Excel sheet
        String tagsData=getDataFromExcel(excelTestDataRowNo,14);
        boolean flag = checkForCompanyRecord(cName);
        if (flag == false) {

            /**Xpaths of text boxes
             * GomGLOBAL_STATIC.driver.findElement(By.xpath("//button[text()='Create']")).click();
             * Xpath to click the Name Text box
             * String cn=GomGLOBAL_STATIC.testData.getCellData("companiesTestData",excelTestDataRowNo,1);
             * GomGLOBAL_STATIC.driver.findElement(By.xpath("//input[@name='name'][1]")).sendKeys(cn);
             * Xpath to click on StreetAddress textbox
             * String street=GomGLOBAL_STATIC.testData.getCellData("companiesTestData",excelTestDataRowNo,2);
             *  GomGLOBAL_STATIC.driver.findElement(By.xpath("//input[@placeholder='Street Address']")).sendKeys(street);
             *  Xpath to click on City textbox
             *  String cityName=GomGLOBAL_STATIC.testData.getCellData("companiesTestData",excelTestDataRowNo,3);
             *  GomGLOBAL_STATIC.driver.findElement(By.xpath("//input[@placeholder='City']")).sendKeys(cityName);
             *  Xpath to click on state/country textbox
             *  String state=GomGLOBAL_STATIC.testData.getCellData("companiesTestData",excelTestDataRowNo,4);
             *  GomGLOBAL_STATIC.driver.findElement(By.xpath("//input[@placeholder='State / County']")).sendKeys(state);
             *  Xpath to click on postal code textbox
             *  String pc=GomGLOBAL_STATIC.testData.getCellData("companiesTestData",excelTestDataRowNo,5);
             *  GomGLOBAL_STATIC.driver.findElement(By.xpath("//input[@placeholder='Post Code']")).sendKeys(pc);
             *  Xpath to click on Email address textbox
             *  String email=GomGLOBAL_STATIC.testData.getCellData("companiesTestData",excelTestDataRowNo,6);
             *  GomGLOBAL_STATIC.driver.findElement(By.xpath("//input[@placeholder='Email address']")).sendKeys(email);*/
            GomGLOBAL_GENERIC.locateAndGetWebElement(GomCommonXpath.xpathOfCreateButton).click();
            companyName.sendKeys(cName);
            streetName.sendKeys(street);
            city.sendKeys(cityName);
            stateCountry.sendKeys(state);
            postalCode.sendKeys(pc);
            emailAddress.sendKeys(email);
           // tagsTextBox.click();
            //Tags search box
           // sendKeysTagsTextBox.sendKeys(tagsData);
            //GomGLOBAL_STATIC.driver.findElement(By.xpath("//span/b[text()='"+tagsData+"']")).click();
            //GomGLOBAL_STATIC.driver.findElement(By.xpath("//span[text()='Add ']")).click();
           // tagsSearchButton.click();
            /**Xpaths of Dropdown
            * String statusDropDownValue = GomGLOBAL_STATIC.testData.getCellData("companiesTestData",excelTestDataRowNo,7);
            * GomGLOBAL_STATIC.driver.findElement(By.xpath("//label[text()='Status']/following-sibling::div[@name='status']")).click();
            * String socialChannelDropdown = GomGLOBAL_STATIC.testData.getCellData("companiesTestData",excelTestDataRowNo,8);
            * boolean status2=GomGLOBAL_STATIC.driver.findElement(By.xpath("//div[@name='channel_type']")).isDisplayed();
            * System.out.println(status2);
            * GomGLOBAL_STATIC.driver.findElement(By.xpath("//div[@name='channel_type']")).click();
            * String phoneDropDownValue=GomGLOBAL_STATIC.testData.getCellData("companiesTestData",excelTestDataRowNo,9);
            * GomGLOBAL_STATIC.driver.findElement(By.xpath("//div[@name='hint']")).click();
            * String categoryDropDown= GomGLOBAL_STATIC.testData.getCellData("companiesTestData",excelTestDataRowNo,10);
            * GomGLOBAL_STATIC.driver.findElement(By.xpath("//label[text()='Category']/following-sibling::div[@name='category']")).click();
            * String priorityDropDown= GomGLOBAL_STATIC.testData.getCellData("companiesTestData",excelTestDataRowNo,11);
            * GomGLOBAL_STATIC.driver.findElement(By.xpath("// label[text()='Priority']/following-sibling::div[@name='priority']")).click();
            * String sourceDropDown= GomGLOBAL_STATIC.testData.getCellData("companiesTestData",excelTestDataRowNo,12);
            * GomGLOBAL_STATIC.driver.findElement(By.xpath("//label[text()='Source']/following-sibling::div[@name='source']")).click();*/
            statusDropDownBox.click();
            GomGLOBAL_STATIC.driver.findElement(By.xpath("//span[text()='" + statusDropDownValue + "']")).click();
            //socialChannelDropdownBox.click();
            //GomGLOBAL_STATIC.driver.findElement(By.xpath("//span[text()='" + socialChannelDropdown + "']")).click();
            //phoneDropDownBox.click();
            //GomGLOBAL_STATIC.driver.findElement(By.xpath("//div[@name='hint']/div[@class='visible menu transition']//span[text()='" + phoneDropDownValue + "']")).click();
            categoryDropDownBox.click();
            GomGLOBAL_STATIC.driver.findElement(By.xpath("//div[@name='category']/span[text()='" + categoryDropDown + "']")).click();
            priorityDropDownBox.click();
            GomGLOBAL_STATIC.driver.findElement(By.xpath("//span[text()='" + priorityDropDown + "']")).click();
            sourceDropDownBox.click();
            GomGLOBAL_STATIC.driver.findElement(By.xpath("//span[text()='" + sourceDropDown + "']")).click();
            //countryDropDownValueBox.click();
            //GomGLOBAL_STATIC.driver.findElement(By.xpath("//div[@name='country']/div[@class='visible menu transition']//span[text()='" + countryDropDownValue + "']")).click();
            //Search box
            //tagsSearchButton.click();
            //GomGLOBAL_STATIC.driver.findElement(By.xpath("//div[@role='combobox']/input[@class='search']")).sendKeys(Tags);
            //GomGLOBAL_STATIC.driver.findElement(By.xpath("//div[@role='option']/span[text()='"+Tags+"']")).click();





            GomGLOBAL_GENERIC.locateAndGetWebElement(GomCommonXpath.xpathOfSaveButton).click();
            /**Invoking navigateTomodule method to refresh the application*/
            GomGLOBAL_GENERIC.navigateToModule(GomGLOBAL_STATIC.nameOfModule[1]);

            /**Validate the company name and address given is same as expected*
             * To validate it using assertEquals method from Assert class*/
            String cn1 = cName;
            boolean status = GomGLOBAL_STATIC.driver.findElement(By.xpath("//td/a[text()='" + cn1 + "'][1]")).isDisplayed();
            Assert.assertEquals(status, true);
            System.out.println(status);
            /** String Address=street+", "+cityName+", "+state+", "+pc;
             //td[text()='Rue de Geneve 4, Brussels, Belgium, "1120"']
             boolean status1=GomGLOBAL_STATIC.driver.findElement(By.xpath("//td[text()='"+Address+"'][1]")).isDisplayed();
             Assert.assertEquals(status1,true);
             System.out.println(status1);*/
        }
    }
    /**This method deals with the company record is available or not*/
    public static boolean checkForCompanyRecord(String companyName) {
       // Thread.sleep(1000);
        boolean statusOfCompany = false;
        // int countOfPages = GomGLOBAL_GENERIC.getTheWebElementsCount(GomCommonXpath.xpathOfPagination);
        //System.out.printf("Total no.of.pages:"+countOfPages);
        //for (int i = 0; i < countOfPages - 2; i++) {
        try {
            statusOfCompany = GomGLOBAL_STATIC.driver.findElement(By.xpath("//a[text()='" + companyName + "']")).isDisplayed();
            GomScreenshotUtility.chaLBetaSelfieLeLele(companyName+"-RecordExists.png");
        } catch (NoSuchElementException e) {
            System.out.println("No, We didn't have a record with company name of " + companyName);
            GomScreenshotUtility.chaLBetaSelfieLeLele(companyName+"-RecordDoesNotExists.png");

        }
        return statusOfCompany;
    }


}
