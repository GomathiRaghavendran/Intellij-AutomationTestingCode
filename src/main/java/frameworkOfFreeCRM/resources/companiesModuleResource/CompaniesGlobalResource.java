package frameworkOfFreeCRM.resources.companiesModuleResource;

import frameworkOfFreeCRM.resources.globalResource.GLOBAL_GENERIC;
import frameworkOfFreeCRM.resources.staticResource.GLOBAL_STATIC;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CompaniesGlobalResource {

  /**Creating a constructor to call the pageFactory class initElements method for mapping the driver to webElement.*/
  public CompaniesGlobalResource(){ PageFactory.initElements(GLOBAL_STATIC.driver,this);}
  @FindBy(xpath = "//button[text()='Create']") WebElement createButton;
  //Xpath to click the Name Text box
  @FindBy(xpath = "//input[@name='name'][1]") WebElement CompanyName;
  //Xpath to enter the values in Street
  @FindBy(xpath = "//input[@placeholder='Street Address']") WebElement streetName;
  //Xpath to enter the values in City
  @FindBy(xpath = "//input[@placeholder='City']") WebElement cityName;
  //Xpath to enter the values in State/Country
  @FindBy(xpath = "//input[@placeholder='State / County']") WebElement SCName;
  //Xpath to enter the values in postal code
  @FindBy(xpath = "//input[@placeholder='Post Code']") WebElement PCName;
  //Xpath to click on Email address textBox
  @FindBy(xpath = "//input[@placeholder='Email address']") WebElement EmailAddress;
  //Xpath to click on status dropdown
  @FindBy(xpath = "//label[text()='Status']/following-sibling::div[@name='status']") WebElement statusDropDown;
  //Xpath to click on category dropdown
  @FindBy(xpath = "//label[text()='Category']/following-sibling::div[@name='category']") WebElement categoryDropDown;
  //Xpath to click on priority dropdown
  @FindBy(xpath = "//label[text()='Priority']/following-sibling::div[@name='priority']") WebElement priorityDropDown;
  //Xpath to click on source drop down
  @FindBy(xpath = "//label[text()='Source']/following-sibling::div[@name='source']") WebElement sourceDropDown;
  //xpath to click on Save button after entering the company name
  @FindBy(xpath = "//button[text()='Save']") WebElement saveButton;

  /** Getting the data from Excel in below method */
  public String getDataFromExel(int rowNumber, int colonNumber){
    String textRetrievedFromExel=GLOBAL_STATIC.testData.getCellData("companiesTestData",rowNumber,colonNumber);
    return textRetrievedFromExel;
  }
  public void createCompany(int excelTestDataRowNo) {
      String cn = getDataFromExel(excelTestDataRowNo, 1);
      String street = getDataFromExel(excelTestDataRowNo, 2);
      String city = getDataFromExel(excelTestDataRowNo, 3);
      String sc = getDataFromExel(excelTestDataRowNo, 4);
      String pc = getDataFromExel(excelTestDataRowNo, 5);
      String email = getDataFromExel(excelTestDataRowNo, 6);

      String nameOfTheCompany = cn;
      boolean flag = checkForCompanyRecord(nameOfTheCompany);
      if (flag == false) {
        createButton.click();
        CompanyName.sendKeys(cn);
        streetName.sendKeys(street);
        cityName.sendKeys(city);
        SCName.sendKeys(sc);
        PCName.sendKeys(pc);
        EmailAddress.sendKeys(email);
        statusDropDown.click();
        String statusDropDown = getDataFromExel(excelTestDataRowNo, 7);
        GLOBAL_STATIC.driver.findElement(By.xpath("//span[text()='" + statusDropDown + "']")).click();
        categoryDropDown.click();
        String categoryDropDown = getDataFromExel(excelTestDataRowNo, 8);
        GLOBAL_STATIC.driver.findElement(By.xpath("//div[@name='category']/span[text()='" + categoryDropDown + "']")).click();
        priorityDropDown.click();
        String priorityDropDown = getDataFromExel(excelTestDataRowNo, 9);
        GLOBAL_STATIC.driver.findElement(By.xpath("//span[text()='" + priorityDropDown + "']")).click();
        sourceDropDown.click();
        String sourceDropDown = getDataFromExel(excelTestDataRowNo, 10);
        GLOBAL_STATIC.driver.findElement(By.xpath("//span[text()='" + sourceDropDown + "']")).click();
        saveButton.click();

        GLOBAL_GENERIC.navigateToModule(GLOBAL_STATIC.nameOfModule[1]);
        String cn1 = cn;
        boolean status = GLOBAL_STATIC.driver.findElement(By.xpath("//td/a[text()='" + cn1 + "'][1]")).isDisplayed();
        Assert.assertEquals(status, true);
      }
    }
       /** In below method we are checking if the company record is available or not */
        public static boolean checkForCompanyRecord(String name) {
          boolean statusOfCompany = false;
          try {
            statusOfCompany=GLOBAL_STATIC.driver.findElement(By.xpath("//a[text()='" + name + "']")).isDisplayed();

          } catch (NoSuchElementException e) {
            System.out.println(name+" record is not found");
          }
          return statusOfCompany;
        }

/**     Just for squad reference:
 *
        //Xpath to click the Name Text box
        String cn=GLOBAL_STATIC.testData.getCellData("companiesTestData",excelTestDataRowNo,1);
        GLOBAL_STATIC.driver.findElement(By.xpath("//input[@name='name'][1]")).sendKeys(cn);
        //Xpath to enter the values in Street
        String street=GLOBAL_STATIC.testData.getCellData("companiesTestData",excelTestDataRowNo,2);
        GLOBAL_STATIC.driver.findElement(By.xpath("//input[@placeholder='Street Address']")).sendKeys(street);
        //Xpath to enter the values in City
        String city=GLOBAL_STATIC.testData.getCellData("companiesTestData",excelTestDataRowNo,3);
        GLOBAL_STATIC.driver.findElement(By.xpath("//input[@placeholder='City']")).sendKeys(city);
        //Xpath to enter the values in State/Country
        String sc=GLOBAL_STATIC.testData.getCellData("companiesTestData",excelTestDataRowNo,4);
        GLOBAL_STATIC.driver.findElement(By.xpath("//input[@placeholder='State / County']")).sendKeys(sc);
        //Xpath to enter the values in postal code
        String pc=GLOBAL_STATIC.testData.getCellData("companiesTestData",excelTestDataRowNo,5);
        GLOBAL_STATIC.driver.findElement(By.xpath("//input[@placeholder='Post Code']")).sendKeys(pc);
         //Xpath to click on Email address textbox
        String email=GLOBAL_STATIC.testData.getCellData("companiesTestData",excelTestDataRowNo,6);
        GLOBAL_STATIC.driver.findElement(By.xpath("//input[@placeholder='Email address']")).sendKeys(email);
         //Xpath to click on status dropdown
        String statusDropDown=GLOBAL_STATIC.testData.getCellData("companiesTestData",excelTestDataRowNo,7);
        GLOBAL_STATIC.driver.findElement(By.xpath("//label[text()='Status']/following-sibling::div[@name='status']")).click();
        GLOBAL_STATIC.driver.findElement(By.xpath("//span[text()='"+statusDropDown+"']")).click();
        //Xpath to click on category dropdown
        String categoryDropDown=GLOBAL_STATIC.testData.getCellData("companiesTestData",excelTestDataRowNo,8);
        GLOBAL_STATIC.driver.findElement(By.xpath("//label[text()='Category']/following-sibling::div[@name='category']")).click();
        GLOBAL_STATIC.driver.findElement(By.xpath("//div[@name='category']/span[text()='"+categoryDropDown+"']")).click();
        //Xpath to click on priority dropdown
        String priorityDropDown=GLOBAL_STATIC.testData.getCellData("companiesTestData",excelTestDataRowNo,9);
        GLOBAL_STATIC.driver.findElement(By.xpath("//label[text()='Priority']/following-sibling::div[@name='priority']")).click();
        GLOBAL_STATIC.driver.findElement(By.xpath("//span[text()='"+priorityDropDown+"']")).click();
        //Xpath to click on source drop down
        String sourceDropDown=GLOBAL_STATIC.testData.getCellData("companiesTestData",excelTestDataRowNo,10);
        GLOBAL_STATIC.driver.findElement(By.xpath("//label[text()='Source']/following-sibling::div[@name='source']")).click();
        GLOBAL_STATIC.driver.findElement(By.xpath("//span[text()='"+sourceDropDown+"']")).click();
        //xpath to click on Save button after entering the company name
        GLOBAL_STATIC.driver.findElement(By.xpath("//button[text()='Save']")).click();
        Thread.sleep(1000);
        GLOBAL_STATIC.navigateToModule(GLOBAL_STATIC.nameOfModule[1]);
        Thread.sleep(2000);
        //To Verify if the company name of actual and expected is same
      String cn1 = cn;
        boolean status = GLOBAL_STATIC.driver.findElement(By.xpath("//td/a[text()='"+cn1+"'][1]")).isDisplayed();
        Assert.assertEquals(status,true);
        System.out.println(status);
        //To verify if the value of actual and expected Address is same
        String Address=street+", "+city+", "+sc+", "+pc;
        boolean status1=GLOBAL_STATIC.driver.findElement(By.xpath("//td[text()='"+Address+"'][1]")).isDisplayed();
        Assert.assertEquals(status1,true);
        System.out.println(status1);
    }
**/

    }


