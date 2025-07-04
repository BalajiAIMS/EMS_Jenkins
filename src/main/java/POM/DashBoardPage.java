package POM;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashBoardPage {
	  public WebDriver driver;
	  public WebDriverWait wait;

	    public DashBoardPage(WebDriver driver) {
	        this.driver = driver;
	        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        PageFactory.initElements(driver, this);
	    }

	    // WebElements
	    @FindBy(xpath = "//i[@class='fa ti ti-users']")
	    public WebElement usersIcon;

	    @FindBy(xpath = "//h5[text()='User Activity']")
	    public WebElement userActivityEle;

	    @FindBy(xpath = "//span[@class='button b-close']")
		public WebElement birthdayPopupClose;

	    @FindBy(xpath = "//*[@id=\"menu\"]/li[13]/a/i[@class='fa ti ti-user-scan']")
	    public WebElement customerIcon;

	    @FindBy(xpath = "//*[@id=\"80\"]/span[@class='link-title']")
	    public WebElement addInvoiceLink;

	    @FindBy(xpath = "//*[@id=\"79\"]/span[@class='link-title']")
	    public WebElement invoiceListLink;

}
