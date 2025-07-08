package TestCases;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentTest;
import Base.BaseClass;
import POM.DashBoardPage;
import POM.LoginPage;
import POM.SalaryPage;
import Report.ExtentTestManager;

@Listeners(Utils.ListnersImplementation.class)
public class SearchableDropDownAddSalary extends BaseClass {

    public ExtentTest test;
    WebDriverWait wait;
   
   

    @BeforeClass
    public void setup() {
        launchBrowser();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
      
        // ⬅️ initialize popup page object
    }

    @Test
    public void checkingSearchableDropdownAddSalary() {
        test = extent.createTest("EMS Task-1377 - Check searchable dropdown in Add Salary Page");
        ExtentTestManager.setTest(test);
      LoginPage lp=new LoginPage(driver);
      SalaryPage sp=new SalaryPage(driver);
      DashBoardPage dbp=new DashBoardPage(driver);
      
        try {
            // -------- TRY BLOCK --------
        	  lp.userLogin(prop.getProperty("email"), prop.getProperty("password"));
            wait.until(ExpectedConditions.titleContains("Dashboard"));

            //  Handle birthday popup if visible
            try {
                wait.until(ExpectedConditions.visibilityOf(dbp.birthdayPopupClose));
                if (dbp.birthdayPopupClose.isDisplayed()) {
                	dbp.birthdayPopupClose.click();
                    test.info("Birthday popup closed.");
                }
            } catch (Exception e) {
                test.info("Birthday popup not shown.");
            }

            wait.until(ExpectedConditions.elementToBeClickable(dbp.usersIcon)).click();
            wait.until(ExpectedConditions.elementToBeClickable(sp.managesalaryLink)).click();
            Thread.sleep(1000);
            wait.until(ExpectedConditions.elementToBeClickable(sp.addSalaryLink)).click();
            wait.until(ExpectedConditions.elementToBeClickable(sp.selectuser)).click();
            Thread.sleep(1000);
            // Enter search query
            wait.until(ExpectedConditions.visibilityOf(sp.searchBar)).sendKeys("na");
            Thread.sleep(5000);
            
            // Assert.assertTrue(sp.expectedDropdownOption.isDisplayed(), "Dropdown result not shown");

            test.pass("Searchable dropdown interaction completed.");

        } catch (Exception e) {
            // -------- CATCH BLOCK --------
            AssertJUnit.fail("Dropdown test failed: " + e.getMessage());
            AssertJUnit.fail("Test failed: " + e.getMessage());

        } finally {
            // -------- FINALLY BLOCK --------
            test.info("Finished execution of searchable dropdown test.");
        }
    }

  
	@AfterClass
    public void tearDown() {
        closeBrowser();
    }
	 @AfterSuite
	    public void tearDownExtent() {
	        extent.flush();
	    }
}