package POM;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public  WebDriver driver;
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
	
	@FindBy(xpath  = "//input[@placeholder=\"Username\"]")
	public WebElement email;
	
	@FindBy(xpath = "//input[@id=\"pass\"]")
	public WebElement password;
	
	public void userLogin(String uemail,String upassword) {
		email.sendKeys(uemail);
		password.sendKeys(upassword);
		password.sendKeys(Keys.ENTER);
	}
	
}
