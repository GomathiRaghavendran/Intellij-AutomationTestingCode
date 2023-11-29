package testCasesFromGomathi;


import gomframeworkOfFreeCRM.gomUtilities.GomExcelUtilities.GomExcelTestDataUtility;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RetrieveTestDataFromExcelPractise {
    String expectedValue="RetrievingData";

    @Test
    public void retrieve(){
        GomExcelTestDataUtility td=new GomExcelTestDataUtility("C:\\Users\\gomat\\Desktop\\Intellij\\TestData\\TestData.xlsx");
        String value1=td.getCellData("Sheet2",25,8);
        System.out.println(value1);
       boolean flag=value1.equals(expectedValue);
       System.out.println(flag);
       Assert.assertEquals(flag,true);

    }
}
