package TestCases;

import java.time.Duration;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import com.aventstack.extentreports.ExtentTest;
import Base.BaseClass;
import POM.DashBoardPage;
import POM.InvoicePage;
import POM.LoginPage;
import Report.ExtentTestManager;

@Listeners(Utils.ListnersImplementation.class)
public class AddSymbolUnderDescriptionArea extends BaseClass {

    
    public ExtentTest test;
    WebDriverWait wait;
    LoginPage lp;
   InvoicePage ip;
   DashBoardPage dbp;

    @BeforeClass
    public void setup() {
        launchBrowser();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        ip = new InvoicePage(driver);
        dbp=new DashBoardPage(driver);
        lp= new LoginPage(driver);
    }

    @Test(priority = 1)
    public void checkingInAddInvoicePage() {
        test = extent.createTest("EMS-1369 - Check add symbol in Add Invoice Page");
        ExtentTestManager.setTest(test);

        try {
            // ---------- TRY BLOCK: Main Logic ----------
            lp.userLogin(prop.getProperty("email"), prop.getProperty("password"));
            wait.until(ExpectedConditions.titleContains("Dashboard"));

            // Handle popup
            try {
                if (dbp.birthdayPopupClose.isDisplayed()) {
                	dbp.birthdayPopupClose.click();
                    test.info("Birthday popup closed.");
                }
            } catch (Exception e) {
                test.info("Birthday popup not shown.");
            }

            // Navigate to Add Invoice Page
            wait.until(ExpectedConditions.elementToBeClickable(ip.customerIcon)).click();
            Thread.sleep(1000);
            wait.until(ExpectedConditions.elementToBeClickable(ip.addInvoiceLink)).click();

            // Scroll and click add symbol
            new Actions(driver).moveToElement(ip.tdsEle).perform();

            for (int i = 0; i < 11; i++) {
                wait.until(ExpectedConditions.elementToBeClickable(ip.addSymboll)).click();
            }
            new Actions(driver).scrollToElement(ip.tdsEle).perform();
            Assert.assertTrue(ip.addSymboll.isDisplayed(), "Add Symbol should be visible");

        } catch (Exception e) {
            // ---------- CATCH BLOCK: Handle Errors ----------
            test.fail("Test failed in Add Invoice Page: " + e.getMessage());
            Assert.fail("Test failed: " + e.getMessage());

        } finally {
            // ---------- FINALLY BLOCK: Always Runs ----------
            test.info("The add symbol displayed under the description field at add ivoice page");
            // Optional: Capture screenshot, log info, navigate, reset form, etc.
        }
    }

    @Test(priority = 2)
    public void checkingInEditInvoicePage() {
        test = extent.createTest("EMS-1369 - Check add symbol in Edit Invoice Page");
        ExtentTestManager.setTest(test);

        try {
            // ---------- TRY BLOCK ----------
            driver.get(prop.getProperty("url"));
            wait.until(ExpectedConditions.elementToBeClickable(ip.customerIcon)).click();
            Thread.sleep(1000);
            wait.until(ExpectedConditions.elementToBeClickable(ip.invoiceListLink)).click();
            Thread.sleep(1000);
            wait.until(ExpectedConditions.elementToBeClickable(ip.editIconLink)).click();
            Thread.sleep(1000);
           

            for (int i = 0; i < 4; i++) {
                wait.until(ExpectedConditions.elementToBeClickable(ip.addSymboll)).click();
            }
            new Actions(driver).scrollToElement(ip.tdsEle).perform();
            Thread.sleep(5000);
            Assert.assertTrue(ip.addSymboll.isDisplayed(), "Add Symbol should be visible on edit page");

        } catch (Exception e) {
            // ---------- CATCH BLOCK ----------
            test.fail("Test failed in Edit Invoice Page: " + e.getMessage());
            Assert.fail("Test failed: " + e.getMessage());

        } finally {
            // ---------- FINALLY BLOCK ----------
            test.info("The add symbol displayed under the description field at edit ivoice page");
        }
    }

    @AfterClass
    public void tearDown() {
        closeBrowser();
    }

    @AfterSuite
    public void flushExtent() {
        extent.flush();
    }
}
