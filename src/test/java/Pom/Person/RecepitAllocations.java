package Pom.Person;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RecepitAllocations {
	private WebDriver driver;
	private WebDriverWait wait;
	JavascriptExecutor j;
	@FindBy(xpath = "//span[text()='Address Information']")
	private WebElement addressInfo;

	@FindBy(xpath = "//span[@title='Sales Orders (Account)']")
	private WebElement salesOrder;

	@FindBy(xpath = "(//a[contains(@class,'slds-card__header-link')]//span[@title='(1)'])[2]")
	private WebElement salesOrderNumber;

	@FindBy (xpath="(//span[text()='Sales Orders (Account)'])[1]")
	private WebElement salesLink;
	
	
	public WebElement headerOfSalesOrder(String ariaLabel) {
		String locator = String.format("//a[@data-label='%s']", ariaLabel);
		return driver.findElement(By.xpath(locator));
	}
	
	@FindBy (xpath="(//table[@aria-label='Installment Lines']//a[text()='Enter Receipt'])[1]")
	private WebElement enterReceipt;
	
	@FindBy (xpath="//h2[text()='Receipt Acknowledgement Creation']")
	private WebElement headerPopUp;
	
	@FindBy (xpath="//button[@title='Close']")
	private WebElement closePopUp;
	
	@FindBy (xpath="(//span[contains(@class,'slds-grid slds-grid_align-spread')])[3]//span")
	private WebElement orderNumberLink;
	
	@FindBy (xpath="(//span[contains(@class,'slds-grid slds-grid_align-spread')])[2]//span")
	private WebElement adminSalesOrderLink;
	@FindBy (xpath="//span[text()='Contact Details']")
	private WebElement contactDetalis;
	
	@FindBy (xpath="//h1[@title='Installment Lines']")
	private WebElement installmentLine;
	
	
	@FindBy (xpath="//legend[text()='Cheque/CC/Wire Transfer #']/..//input")
	private WebElement chequeValue;
	
	@FindBy (xpath="//legend[text()='Maturity/Cheque Date']/..//input")
	private WebElement dateMaturity;
	@FindBy (xpath="//textarea[@placeholder='Please add your comments']")
	private WebElement commentsValues;
	
	@FindBy (xpath="//button[@title='Save Receipt']")
	private WebElement saveRecipts;

	
	@FindBy (xpath="//table[@aria-label='Sales Orders Other Charges']//a[text()='Enter Receipt']")
	private WebElement salesOrderRecipt;
	
	@FindBy (xpath="(//div[contains(@class,'slds-align-middle')]//a)[2]")
	private WebElement salesOrderLink;
	
	@FindBy (xpath="//span[text()='Receipts Entered']")
	private WebElement recepitsEnterText;
	
	@FindBy (xpath="//div[@class='listWrapper']//span[text()='Relationships']")
	private WebElement relationshipTab;
	
	@FindBy (xpath="(//span[@class='view-all-label'])[2]")
	private WebElement viewTab;

	@FindBy (xpath="//button[@name='New']")
	private WebElement newButton;
	
	@FindBy (xpath="//h2[text()='New Account Relationship']")
	private WebElement newAccRelationship;
	
	@FindBy (xpath="//span[@title='Relationships With']")
	private WebElement relationsWith;
	
	@FindBy (xpath="//input[@placeholder='Search Accounts...']")
	private WebElement realtedAccounts;
	
	@FindBy (xpath="(//div[contains(@class,'slds-listbox')])[4]/ul/li[2]")
	private WebElement selectionOfTheAccount;
	
	
	@FindBy (xpath="//p[@title='Status']/..//slot/lightning-formatted-text")
	private WebElement statusOFTheSaleOrder;
	
	@FindBy (xpath="(//span[text()='Receipt Acknowledgements'])[1]")
	private WebElement recepitAcknolegemts;
	
	@FindBy (xpath="(//span[text()='Sales Orders Other Charges'])[1]")
	private WebElement salesOrderChrages;
	
	@FindBy (xpath="//span[text()='Opportunity Information']")
	private WebElement oppornityInfo;
	
	@FindBy (xpath="//div[contains(@class,'slds-size_1-of-1 label-inline')]//button[@title='Edit Opportunity']")
	private WebElement editStatusButton;
	
	@FindBy (xpath="//button[@aria-label='Status, Received']")
	private WebElement statusButton;
	
	@FindBy (xpath="//span[@title='Cleared']")
	private WebElement clearedValue;
	
	@FindBy (xpath="//span[text()='Amount Information']")
	private WebElement amountInfo;
	
	@FindBy (xpath="//input[@name='ReceiptNumber__c']")
	private WebElement recipt;
	
	@FindBy (xpath="//input[@name='ReceiptDate__c']")
	private WebElement recepitDate;
	
	@FindBy (xpath="//input[@name='ClearedDate__c']")
	private WebElement clearceData;
	public WebElement linkReciptAcknowment(String ariaLabel) {
		String locator = String.format("((//table[@aria-label='Receipt Acknowledgements'])[2]/tbody/tr//slot/span)[%s]", ariaLabel);
		return driver.findElement(By.xpath(locator));
	}
	public WebElement getButtonByAriaLabel(String ariaLabel) {
		String locator = String.format("//button[@aria-label='%s']", ariaLabel);
		return driver.findElement(By.xpath(locator));
	}

	@FindBy (xpath="//div[contains(@class,'slds-dropdown_length-with-icon-7')]//span[2]")
	private WebElement selectionOFThePaidOf;
	public RecepitAllocations(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		j = (JavascriptExecutor) driver;
		wait = new WebDriverWait(driver, 20);
	}

	public String salesOrderNumber() {
		j.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'center'});", addressInfo);
		j.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'center'});", contactDetalis);
		wait.until(ExpectedConditions.visibilityOf(salesOrder));
		return salesOrderNumber.getText();
	}
	public boolean salesOrderLinkSelectionAndValidateReceiptAcknowledgementCreation() {
		wait.until(ExpectedConditions.elementToBeClickable(salesLink)).click(); 
		wait.until(ExpectedConditions.elementToBeClickable(orderNumberLink)).click();
		headerOfSalesOrder("Installment and Receipts").click();
		enterReceipt.click();
		boolean textOfPopUp=headerPopUp.isDisplayed();
		closePopUp.click();
		return textOfPopUp;
	}
	public boolean withoutClosePopUp() throws InterruptedException {
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(salesLink)).click(); 
		wait.until(ExpectedConditions.elementToBeClickable(orderNumberLink)).click();
		headerOfSalesOrder("Installment and Receipts").click();
		enterReceipt.click();
		boolean textOfPopUp=headerPopUp.isDisplayed();
		return textOfPopUp;
	}
	public void adminSalesOrder(String linkIndex) throws InterruptedException {
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(salesLink)).click(); 
		wait.until(ExpectedConditions.elementToBeClickable(adminSalesOrderLink)).click();
		headerOfSalesOrder("Installment and Receipts").click();
		j.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'center'});", salesOrderChrages);
		j.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'center'});", recepitAcknolegemts);
		recepitAcknolegemts.click();
		linkReciptAcknowment(linkIndex).click();
		wait.until(ExpectedConditions.visibilityOf(oppornityInfo));
		editStatusButton.click();
	}
	public void clearValueSelections() {
		j.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'center'});", statusButton);
		statusButton.click();
		wait.until(ExpectedConditions.elementToBeClickable(clearedValue)).click(); 
		j.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'center'});", amountInfo);
		recipt.sendKeys("CP-1234");
		recepitDate.sendKeys("12/04/2021");
		clearceData.sendKeys("16/06/2023");
	}
	public void salesReciptsSelections() {
		wait.until(ExpectedConditions.elementToBeClickable(salesLink)).click(); 
		wait.until(ExpectedConditions.elementToBeClickable(orderNumberLink)).click();
		headerOfSalesOrder("Installment and Receipts").click();
	}
	public void installMentSelections() {
		wait.until(ExpectedConditions.elementToBeClickable(salesOrderLink)).click();
		headerOfSalesOrder("Installment and Receipts").click();
	}
	public String salesOrderLinkClick() {
		wait.until(ExpectedConditions.elementToBeClickable(salesOrderLink)).click();
		return statusOFTheSaleOrder.getText();
	}
	public void selectSecoundRecipts() {
		enterReceipt.click();
		
	}
	public void installmentLines() {
		wait.until(ExpectedConditions.visibilityOf(installmentLine));
	}
	public void enterTheValuesInThePopUp() {
		chequeValue.sendKeys("12345");
		dateMaturity.clear();
		dateMaturity.sendKeys("12/10/2024");
		commentsValues.sendKeys("test");
	}
	public boolean enterRemark() throws InterruptedException {
		saveRecipts.click();
		wait.until(ExpectedConditions.elementToBeClickable(salesOrderLink));
		return recepitsEnterText.isDisplayed();
	}
	public void receptsForSalesOrder() {
		salesOrderRecipt.click();
	}
	public void relationsMaking() throws InterruptedException {
		j.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'center'});", viewTab);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(relationsWith));
		wait.until(ExpectedConditions.elementToBeClickable(relationshipTab)).click();
		wait.until(ExpectedConditions.elementToBeClickable(newButton)).click();
		wait.until(ExpectedConditions.visibilityOf(newAccRelationship));
		
	}
	public void seletionOfRealtedAccount() {
		realtedAccounts.click();
		wait.until(ExpectedConditions.elementToBeClickable(selectionOfTheAccount)).click();
		
	}
	public void selectionOFPaidOF(String dropdownTypes) throws InterruptedException {
		j.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'center'});",
				getButtonByAriaLabel(dropdownTypes));
		wait.until(ExpectedConditions.elementToBeClickable(getButtonByAriaLabel(dropdownTypes))).click();
		selectionOFThePaidOf.click();
	}
}
