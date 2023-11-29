package codeFromVenu.seleniumConcept.Listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TellingLies  implements ITestListener {


    @Override
    public void onStart(ITestContext context) {
        System.out.println("HEY!!! YOU LOOK SO BEAUTIFUL!!! ARE YOU REALLY A TESTER OR SANTOOR MOMMY");
        System.out.println("ALL THE BEST FOR YOU TEST RUN");
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("I WISH YOUR GOOD LUCK ON YOUR "+ result.getName()+" TEST RUN");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("SORRY!!! YOUR TEST GOT FAILED");
        System.out.println("HERE IS THE EXCEPTION OCCURRED: "+result.getThrowable());
        System.out.println("MAYBE, IT'S A BUG PLEASE REVIEW THE REPORT");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("CONGRATULATIONS!!! YOUR TEST IS PASSED ");
        System.out.println("GO AND DO THE FESTIVAL");

    }

    }
