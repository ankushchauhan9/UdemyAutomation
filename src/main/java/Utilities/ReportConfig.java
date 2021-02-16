package Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ReportConfig {

    static ExtentReports extentReports;
    public static ExtentReports configureReportObejct(){

        String destPath = System.getProperty("user.dir")+"/reports/"+"index.html";
        ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(destPath);
        extentSparkReporter.config().setDocumentTitle("Web Automation");
        extentSparkReporter.config().setReportName("udemy Automation");

        extentReports = new ExtentReports();
        extentReports.attachReporter(extentSparkReporter);
        extentReports.setSystemInfo("Host","localhost");
        extentReports.setSystemInfo("Tester","Ankush");
        return  extentReports;
    }


}
