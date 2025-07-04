package Report;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentReportManager {
    private static ExtentReports extent;

    public static ExtentReports getInstance() {
        if (extent == null) {
            String reportDir = System.getProperty("user.dir") + "/Reports/";
            new java.io.File(reportDir).mkdirs();

            ExtentSparkReporter spark = new ExtentSparkReporter(reportDir+"ExtentReport.html");

            spark.config().setDocumentTitle("Automation Report");
            spark.config().setReportName("EMS Automation Report");

            extent = new ExtentReports();
            extent.attachReporter(spark);
            extent.setSystemInfo("Tester", "Balaji Naik");
            extent.setSystemInfo("Environment", "DEV");
            extent.setSystemInfo("Browser", "Chrome");
        }
        return extent;
    }
}

