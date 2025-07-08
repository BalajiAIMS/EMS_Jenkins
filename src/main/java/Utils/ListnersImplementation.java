package Utils;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;

import Base.BaseClass;
import Report.ExtentTestManager;

public class ListnersImplementation extends BaseClass implements ITestListener{
	 public void captureScreenshot(ITestResult result, String status) {
	        try {
	            String name = result.getMethod().getMethodName();
	            LocalDate currentDate = LocalDate.now();
	            String timestamp = LocalTime.now().toString().replace(":", "-") + "-" + LocalDate.now();
	            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	            File dest = new File(System.getProperty("user.dir")+"\\ScreenShots\\"+name+"-"+timestamp+"-"+currentDate+"-"+name+".png");
	            org.openqa.selenium.io.FileHandler.copy(src, dest);
	            ExtentTestManager.getTest().addScreenCaptureFromPath(dest.getAbsolutePath());
	        } catch (IOException e) { e.printStackTrace(); }
	    }

	    @Override
	    public void onTestSuccess(ITestResult result) {
	        captureScreenshot(result, "PASS");
	        ExtentTestManager.getTest().log(Status.PASS, "Test passed");
	    }

	    @Override
	    public void onTestFailure(ITestResult result) {
	        captureScreenshot(result, "FAIL");
	        ExtentTestManager.getTest().log(Status.FAIL, result.getThrowable().getMessage());
	    }

	    @Override
	    public void onTestSkipped(ITestResult result) {
	        captureScreenshot(result, "SKIP");
	        ExtentTestManager.getTest().log(Status.SKIP, result.getThrowable().getMessage());
	    }
}