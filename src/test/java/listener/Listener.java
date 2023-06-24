package listener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener
{

    public String getName(ITestResult result)
    {
        return result.getName();
    }
    @Override
    public void onFinish(ITestContext arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onStart(ITestContext context) {

        System.out.println("test started");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onTestFailure(ITestResult arg0) {

        System.out.println("arg0.getName() "+arg0.getName());
        System.out.println("arg0.getMethod() "+arg0.getMethod());
        System.out.println("arg0.getTestName() "+arg0.getTestName());
        System.out.println("arg0.getInstanceName() "+arg0.getInstanceName());
        System.out.println("arg0.getStatus() "+arg0.getStatus());
        System.out.println("arg0.getStatus() "+arg0.getTestContext().getAttributeNames().toString());
    }

    @Override
    public void onTestSkipped(ITestResult arg0) {


    }

    @Override
    public void onTestStart(ITestResult arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onTestSuccess(ITestResult arg0) {
        // TODO Auto-generated method stub

    }
}
