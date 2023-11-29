package codeFromGomathi.seleniumConcepts.ListenersConcept;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TellingLies implements ITestListener {
    @Override
    public void onStart(ITestContext context) {
        System.out.println("Let's start our test run");
        System.out.println("All the best");
    }


    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Good luck"+ result.getName());
    }


    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Congratulations..Your test passed successfully");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("It's a bug");
        System.out.println("Here's your exception" +result.getThrowable());
    }
}
