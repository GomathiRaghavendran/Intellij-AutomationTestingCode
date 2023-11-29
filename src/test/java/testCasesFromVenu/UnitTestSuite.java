package testCasesFromVenu;

import codeFromVenu.CodeForUnitTesting.UnitTestCaseCode;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UnitTestSuite {

    @Test
    public void validationOnAddingTwoNumber(){
        UnitTestCaseCode  utc = new UnitTestCaseCode();
        int  sum = utc.addTwoNumber(10,20);
        Assert.assertEquals(sum,30);
    }
}
