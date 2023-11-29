package frameworkOfFreeCRM.resources.globalResource;

import frameworkOfFreeCRM.resources.staticResource.GLOBAL_STATIC;
import org.openqa.selenium.By;
import org.testng.Assert;

public class HomePageResource {
   public String  xpathOfCalenderFromLeftSideMenu = "//span[text()='Calendar']";
   public  String xpathOfContactsFromLeftSideMenu = "//span[text()='Contacts']";
   public  String xpathOfCompaniesFromLeftSideMenu = "//span[text()='Companies']";
   public  String xpathOfDealsFromLeftSideMenu = "//span[text()='Deals']";
   public  String xpathOfTasksFromLeftSideMenu = "//span[text()='Tasks']";
   public  String xpathOfCasesFromLeftSideMenu = "//span[text()='Cases']";
   public  String xpathOfCallsFromLeftSideMenu = "//span[text()='Calls']";

   String  listOfLeftSideMenuoption[] = {"Calendar","Contacts","Companies","Deals","Tasks","Cases","Calls","Documents","Email","Campaigns"};


   public void  validateLeftSideMenuItems_v1() throws InterruptedException {
      int length = listOfLeftSideMenuoption.length;
      for (int i = 0; i < length; i++) {
         Thread.sleep(3000);
         String  buildXpath = "//span[text()='"+listOfLeftSideMenuoption[i]+"']";
         System.out.println("Iteration "+i+" this is the xpath "+buildXpath);
         String  buildXpathOfComponentHeader = "//div/following-sibling::span[text()='"+listOfLeftSideMenuoption[i]+"']";
         GLOBAL_STATIC.driver.findElement(By.xpath(buildXpath)).click();
         boolean flag = GLOBAL_STATIC.driver.findElement(By.xpath(buildXpathOfComponentHeader)).isDisplayed();
         Assert.assertEquals(flag,true);

      }
   }

   public void validateLeftSideMenuItems() throws InterruptedException {
      Thread.sleep(3000);
      GLOBAL_STATIC.driver.findElement(By.xpath(xpathOfCalenderFromLeftSideMenu)).isDisplayed();
      GLOBAL_STATIC.driver.findElement(By.xpath(xpathOfContactsFromLeftSideMenu)).isDisplayed();
      GLOBAL_STATIC.driver.findElement(By.xpath(xpathOfCompaniesFromLeftSideMenu)).isDisplayed();
      GLOBAL_STATIC.driver.findElement(By.xpath(xpathOfDealsFromLeftSideMenu)).isDisplayed();
      GLOBAL_STATIC.driver.findElement(By.xpath(xpathOfTasksFromLeftSideMenu)).isDisplayed();
      GLOBAL_STATIC.driver.findElement(By.xpath(xpathOfCasesFromLeftSideMenu)).isDisplayed();
      GLOBAL_STATIC.driver.findElement(By.xpath(xpathOfCallsFromLeftSideMenu)).isDisplayed();


   }

   public void navigateToContacts(){
      GLOBAL_STATIC.driver.findElement(By.xpath(xpathOfContactsFromLeftSideMenu)).click();
   }

   public void navigateToDeals(){
      GLOBAL_STATIC.driver.findElement(By.xpath(xpathOfContactsFromLeftSideMenu)).click();
   }



}
