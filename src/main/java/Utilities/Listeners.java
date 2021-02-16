package Utilities;

import academy.BaseClass;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class Listeners extends BaseClass implements ITestListener {

    ExtentTest extentTest;
    ExtentReports listnerExtentReports = Utilities.ReportConfig.configureReportObejct();
    ThreadLocal<ExtentTest> extentThread = new ThreadLocal<ExtentTest>();

    @Override
    public void onTestStart(ITestResult result) {
        String methodName = result.getMethod().getMethodName();
        extentTest = listnerExtentReports.createTest(methodName);
        extentThread.set(extentTest);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        extentThread.get().log(Status.PASS,"Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        extentThread.get().fail(result.getThrowable());
        WebDriver driver = null;
        try {
            driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());

        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            String path = captureScreenshot(result.getMethod().getMethodName(), driver);
            extentThread.get().addScreenCaptureFromPath(path,result.getMethod().getMethodName());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {
        listnerExtentReports.flush();
    }
}
