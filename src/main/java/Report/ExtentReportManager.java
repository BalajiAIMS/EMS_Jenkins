package Report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportManager {
    private static ExtentReports extent;

    public static ExtentReports getInstance() {
        if (extent == null) {
            String reportDir = "C:/Users/Naik B/.jenkins/workspace/ems-practise/Reports/";
            new java.io.File(reportDir).mkdirs();

            ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(reportDir + "ExtentReport.html");

            htmlReporter.config().setDocumentTitle("Automation Report");
            htmlReporter.config().setReportName("EMS Automation Report");

            extent = new ExtentReports();
            extent.attachReporter(htmlReporter);
            extent.setSystemInfo("Tester", "Balaji Naik");
            extent.setSystemInfo("Environment", "DEV");
            extent.setSystemInfo("Browser", "Chrome");
        }
        return extent;
    }
}
