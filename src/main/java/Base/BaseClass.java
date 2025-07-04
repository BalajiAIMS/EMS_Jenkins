package Base;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;

import Report.ExtentReportManager;

public class BaseClass {
	   public static WebDriver driver;
	    public static Properties prop = new Properties();
	    public static ExtentReports extent;

	    @BeforeSuite
	    public void setupExtentReport() throws IOException {
	        prop.load(new FileReader(System.getProperty("user.dir") + "\\src\\main\\resources\\config.properties"));
	        extent = ExtentReportManager.getInstance(); // initialize ExtentReports
	    }

	    @BeforeClass
	    public void launchBrowser() {
	        if (driver == null) {
	            String browser = prop.getProperty("Browser").toLowerCase();

	            if (browser.equals("chrome")) {
	                driver = new ChromeDriver();
	            } else if (browser.equals("edge")) {
	                driver = new EdgeDriver();
	            } else {
	                throw new IllegalArgumentException("Unsupported browser specified in config: " + browser);
	            }

	            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	            driver.manage().window().maximize();
	            driver.get(prop.getProperty("url"));
	        }
	    }
    
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    @AfterSuite
    public void tearDownReport() {
        if (extent != null) {
            extent.flush();
        }
    }
}
