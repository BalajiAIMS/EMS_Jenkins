package Report;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentReportManager {
    private static ExtentReports extent;

    public static ExtentReports getInstance() {
        if (extent == null) {
            // Create Reports directory if it doesn't exist
            String reportDir = System.getProperty("user.dir") + "\\Reports\\";
            new java.io.File(reportDir).mkdirs();

            // Create a timestamped report file
            String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            ExtentSparkReporter spark = new ExtentSparkReporter(reportDir + "Report_" + timeStamp + ".html");

            spark.config().setDocumentTitle("Automation Report");
            spark.config().setReportName("Automation Testing");

            extent = new ExtentReports();
            extent.attachReporter(spark);
            extent.setSystemInfo("Tester Name", "Balaji Naik");
            extent.setSystemInfo("Environment", "DEV Server");
            extent.setSystemInfo("Browser", "Chrome");
            extent.setSystemInfo("Platform", System.getProperty("os.name"));
        }
        return extent;
    }
}
