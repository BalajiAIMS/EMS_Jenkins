package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InvoicePage {
	public  WebDriver driver;
    public InvoicePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
	@FindBy(xpath = "//*[@id=\"menu\"]/li[13]/a/i[@class='fa ti ti-user-scan']")
	public WebElement customerIcon;
	
	@FindBy(xpath = "//*[@id=\"80\"]/span[@class='link-title']")
	public WebElement addInvoiceLink;
	
	@FindBy(xpath = "//*[@id=\"79\"]/span[@class='link-title']")
	public WebElement invoiceListLink;
	
	@FindBy(xpath = "//button[@onclick=\"addRow()\"]")
	public WebElement addSymboll;
	
	@FindBy(xpath  = "//*[@id='invoices_list_table']/tbody/tr[1]/td[12]/a[2]/i[@title='Edit']")
	public WebElement editIconLink;
	
	@FindBy(xpath = "//label[text()='TDS']")
	public WebElement tdsEle;
	
	@FindBy(id = "select2-customer-container")
	public WebElement selEmp;
	
	@FindBy(id = "invoice_no")
	public WebElement invoiceNo;
	
	@FindBy(id = "item_name_1")
	public WebElement textFiled;
	
	@FindBy(id = "price_1")
	public WebElement priceEle;
	
	@FindBy(id = "invc_submit")
	public WebElement submitButton;
	
	@FindBy(xpath = "//input[@type=\"search\"]")
	public WebElement searchEle;
	
}
