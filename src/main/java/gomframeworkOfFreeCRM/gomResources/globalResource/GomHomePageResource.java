package gomframeworkOfFreeCRM.gomResources.globalResource;


import gomframeworkOfFreeCRM.gomResources.staticReource.GomGLOBAL_STATIC;
import org.openqa.selenium.By;
import org.testng.Assert;

public class GomHomePageResource {
    public String xpathOfTR = "//b[text()='Gomathi']";


    String listOfLeftSideMenuOptions[]={"Calendar","Contacts","Companies","Deals","Tasks","Cases","Calls","Documents","Campaigns","Forms"};

    /** This method validates the menu items from the left side menu of our application
     * building a dynamic xpath for all modules using for loop since "text()" value is the only change
     * by clicking on each menu checking whether is it navigating to respective module page
     * comparing the actual component header name against the expected component header name */
    public void validateLeftSideMenuItems() {
        int length= listOfLeftSideMenuOptions.length;
        for(int i=0;i<length;i++){
            String buildXpath="//a/span[text()='"+listOfLeftSideMenuOptions[i]+"']";
            System.out.println("Value of i="+i+" this is xpath of "+listOfLeftSideMenuOptions[i]+"="+buildXpath);
            GomGLOBAL_STATIC.driver.findElement(By.xpath(buildXpath)).click();
            String xpathOFComponentHeaderName="//div/following-sibling::span[text()='"+listOfLeftSideMenuOptions[i]+"']";
            System.out.println("Value of i="+i+" Xpath of Component Headers of "+listOfLeftSideMenuOptions[i]+"="+xpathOFComponentHeaderName);
            boolean flag=GomGLOBAL_STATIC.driver.findElement(By.xpath(xpathOFComponentHeaderName)).isDisplayed();
            Assert.assertEquals(flag,true);
            System.out.println(flag);


        }
    }
}

