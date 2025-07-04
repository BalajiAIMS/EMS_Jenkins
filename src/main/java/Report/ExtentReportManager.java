package Report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {
    private static ExtentReports extent;

public static ExtentReports getInstance() {
    if (extent == null) {
        // ✅ Set absolute path to Jenkins workspace
        String reportDir = "C:/Users/Naik B/.jenkins/workspace/ems-practise/Reports/";
        new java.io.File(reportDir).mkdirs();

        // ✅ Create Spark reporter using full path
        ExtentSparkReporter spark = new ExtentSparkReporter(reportDir + "ExtentReport.html");

        // Optional configs
        spark.config().setDocumentTitle("Automation Report");
        spark.config().setReportName("EMS Automation Report");

        // Setup report
        extent = new ExtentReports();
        extent.attachReporter(spark);
        extent.setSystemInfo("Tester", "Balaji Naik");
        extent.setSystemInfo("Environment", "DEV");
        extent.setSystemInfo("Browser", "Chrome");
    }
    return extent;
}
}
