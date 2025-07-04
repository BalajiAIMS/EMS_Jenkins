package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SalaryPage {
	public  WebDriver driver;
    public SalaryPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//*[@id=\"56\"]/span[@class=\"link-title\"]")
    public WebElement managesalaryLink;
    
    @FindBy(xpath = "//span[text()='  Add Salary']")
    public WebElement addSalaryLink;
    
    @FindBy(xpath = "//span[text()='-- Select User --']")
    public WebElement selectuser;
    
    @FindBy(xpath = "//input[@type='search']")
    public WebElement searchBar;
}
