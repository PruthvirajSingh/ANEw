package Pom.Person;

import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Factory;

import Base.BaseClass;
import Utility.ExcleReader;
import Utility.UtilClass;
import io.qameta.allure.Step;

public class Leads {
	private WebDriver driver;
	Actions act;
	WebDriverWait wait;
	UtilClass util;
	JavascriptExecutor j;
	Actions actions;
	@FindBy(xpath = "//span[@title='Aldar Sales']")
	private WebElement aldarSales;

	@FindBy(xpath = "//a[@class='slds-context-bar__label-action dndItem']//span[@class='slds-truncate']")
	private List<WebElement> headers;

	@FindBy(css = ".triggerLinkText")
	private WebElement recentlyViewed;

	@FindBy(xpath = "(//div[@title='New'])[1]")
	private WebElement newButton;

	@FindBy(css = ".inlineTitle.slds-p-top--large")
	private WebElement newLead;

	@FindBy(xpath = "(//span[@class='slds-radio--faux'])[1]")
	private WebElement personCheckBox;

	@FindBy(xpath = "//span[text()='Organization']")
	private WebElement organizationCheckBox;

	@FindBy(css = ".slds-button_brand.uiButton span")
	private WebElement nextButton;

	@FindBy(xpath = "//h2[text()='New Lead: Person']")
	private WebElement newLeadPerson;

	@FindBy(xpath = "//button[@name='salutation']")
	private WebElement nameSalutation;

	@FindBy(xpath = "//span[@class='slds-media__body']//span[@class='slds-truncate']")
	private List<WebElement> salutation;

	@FindBy(xpath = "//button[@name='SaveEdit']")
	private WebElement saveNewLeadPerson;

	@FindBy(css = ".errorsList")
	private WebElement ulLeadPerson;

	@FindBy(css = ".slds-icon.slds-icon-text-error")
	private WebElement weHitASnagIcon;

	public WebElement getPersonNameDetails(String personDetails) {
		String locator = String.format("//input[@placeholder='%s']", personDetails);
		return driver.findElement(By.xpath(locator));
	}

	@FindBy(xpath = "//input[@name='Company']")
	private WebElement companyName;
	@FindBy(xpath = "(//ul[contains(@class,'errorsList')]//li)[1]//a")
	private WebElement snagFirstValue;

	@FindBy(xpath = "(//ul[contains(@class,'errorsList slds-list_dotted slds-m-left_medium')]//li)[3]//a")
	private WebElement sangFirstValueAtLeadPage;

	@FindBy(xpath = "//span[@class='slds-media__body']//span[@class='slds-truncate']")
	private List<WebElement> customerType;

	@FindBy(xpath = "//span[@class='slds-media__body']//span[@class='slds-truncate']")
	private List<WebElement> salesType;

	@FindBy(css = ".slds-text-selected")
	private WebElement compltedButton;

	@FindBy(xpath = "((//div[contains(@class,'itemBody')])[14]//span)[2]")
	private WebElement compltedStatus;

	@FindBy(css = ".groupRelativeLabel")
	private WebElement contactCreated;

	@FindBy(xpath = "//span[@title='(0)']")
	private WebElement duplicateLeadsZero;

	@FindBy(xpath = "(//span[@class='test-id__field-value slds-form-element__static slds-grow '])[5]//span")
	private WebElement customerReached;

	@FindBy(xpath = "//button[@title='Edit Lead Status']")
	private WebElement leadStatus;

	@FindBy(css = "span[title='Qualified Lead']")
	private WebElement qulifiedLead;

	@FindBy(xpath = "//button[@aria-label='Lead Status, In Progress Lead']")
	private WebElement dropdownLeadStatus;

	public WebElement getButtonByAriaLabel(String ariaLabel) {
		String locator = String.format("//button[@aria-label='%s']", ariaLabel);
		return driver.findElement(By.xpath(locator));
	}

	@FindBy(xpath = "(//span[text()='Lead Details'])[2]")
	private WebElement leadRecord;

	@FindBy(css = ".subjectLink.slds-truncate")
	private WebElement youHaveTask;

	@FindBy(xpath = "(//slot[@name='primaryField'])[2]//lightning-formatted-text")
	private WebElement leadsName;

	public WebElement personAndOrinization(String ariaLabel) {
		String locator = String.format("(//span[contains(@class,'slds-form-element__label')])[%s]", ariaLabel);
		return driver.findElement(By.xpath(locator));
	}

	@FindBy(xpath = "//label[text()='Mobile Country Code']")
	private WebElement countryCode;

	@FindBy(xpath = "(//span[contains(@class,'slds-form-element__label')])[1]")
	private WebElement personLead;

	@FindBy(xpath = "(//span[contains(@class,'slds-form-element__label')])[2]")
	private WebElement personLead2;

	@FindBy(css = "button[title='Close this window']")
	private WebElement closeWindowOfNewLead;

	@FindBy(xpath = "//span[text()='Lead Details']")
	private WebElement leadsDetails;

	@FindBy(xpath = "//button[@title='Edit Lead Status']")
	private WebElement editLeadStatus;

	@FindBy(xpath = "//button[@aria-label='Lead Status, Converted Lead']")
	private WebElement convertedLeadUpdate;

	@FindBy(xpath = "//h2[@title='We hit a snag.']")
	private WebElement titleSang;

	@FindBy(xpath = "//label[text()='Email Address']")
	private WebElement emailIdTextValues;

	@FindBy(css = "records-record-layout-item[field-label='Lead Status']")
	private WebElement leadStatusUpdate;

	@FindBy(xpath = "//button[@name='CancelEdit']")
	private WebElement cancleButtonConvertedLead;

	@FindBy(xpath = "//span[text()='Person']")
	private WebElement personText;

	@FindBy(xpath = "//span[text()='Organization']")
	private WebElement organizationText;

	@FindBy(css = "button[data-aura-class='uiButton']:nth-child(1)")
	private WebElement cancleButton;
	
	@FindBy(xpath="//button[@name='CancelEdit']")
	private WebElement cancleButtonAtLead;
	
	@FindBy(xpath = "//span[@title='--None--']")
	private WebElement contryCode;

	@FindBy(css = "button[title='Select a List View: Accounts']")
	private WebElement dropdownButton;

	@FindBy(xpath = "//span[text()='All Accounts']")
	private WebElement allAccounts;

	@FindBy(xpath = "//input[@aria-label='Search All Accounts list view.']")
	private WebElement searchButtonInAccount;

	@FindBy(xpath = "(//a[@data-refid='recordId'])[1]")
	private WebElement recordSearchValue;

	@FindBy(xpath = "(//div[@class='slds-grid slds-grid_vertical'])[2]//a[text()='Opportunities']")
	private WebElement opportunities;

	@FindBy(xpath = "//a[text()='Leads']")
	private WebElement leadsValuesAfterGobalSearch;

	@FindBy(xpath = "(//a[@data-refid='recordId'])[3]")
	private WebElement opporitesLink;

	@FindBy(xpath = "(//span[contains(@class,'lds-shrink-none')])[4]")
	private WebElement opportiesRecord;

	@FindBy(xpath = "(//span[text()='Opportunities'])[4]")
	private WebElement opprtiesOptions;

	@FindBy(xpath = "(//span[@class='test-id__section-header-title'])[1]")
	private WebElement contryOfResidence;

	@FindBy(xpath = "//strong[@aria-label='We hit a snag. Review the following fields']")
	private WebElement reviewFeilds;

	@FindBy(xpath = "//button[@aria-label='Mobile Country Code, --None--']//span")
	private WebElement textNone;

	@FindBy(xpath = "//button[@aria-label='Lead Status, In Progress Lead']//span")
	private WebElement inProcessLead;

	@FindBy(xpath ="//a[@data-label='Unit Search']")
	private WebElement unitSearchButton;

	@FindBy (xpath="//flexipage-tab2[@id='tab-15']//button/span[text()='Opportunity Information']")
	private WebElement oppInfo;
	
	@FindBy (xpath="//strong[@aria-label='We hit a snag. Review the errors on this page.']")
	private WebElement sangPoPUp;
	
	@FindBy (xpath="//button[@title='Close error dialog']")
	private WebElement closeSangPopup;
//	@FindBy (xpath="//div[contains(@class,'slds-dropdown_fluid slds-dropdown_left ')]//span[@title='Downgrade Sale']")
//	private WebElement dropDownValuesFromDetails;
	@FindBy (xpath="(//div[@class='slds-no-flex']//button[@part='button button-icon'])[1]")
	private WebElement exclamtoryMark;
	public Leads(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		j = (JavascriptExecutor) driver;
		wait = new WebDriverWait(driver, 20);
		util = new UtilClass();
		actions = new Actions(driver);
	}

	@Step("Fill the data in the lead page")
	public void leadCreations(String firstName, String middleName, String LastName)
			throws EncryptedDocumentException, InterruptedException, IOException {
		this.nameOfThePersonLeads(firstName, middleName, LastName);
		this.fillDataInDropDown(BaseClass.jsonArrayValue("DropDown","Customer Type"),BaseClass.jsonArrayValue("DropDown Values","Customer Type selection"));
		this.domasticSelection(BaseClass.jsonArrayValue("DropDown","Customer sub-type"),BaseClass.jsonArrayValue("DropDown Values","Customer sub-type value"));
		this.fillDataInDropDown(BaseClass.jsonArrayValue("DropDown","sales"),BaseClass.jsonArrayValue("DropDown Values","sales value"));
		this.fillDataInDropDown(BaseClass.jsonArrayValue("DropDown","proprties Usage"),BaseClass.jsonArrayValue("DropDown Values","proprties usage value"));
		this.fillDataInDropDown(BaseClass.jsonArrayValue("DropDown","project"),BaseClass.jsonArrayValue("DropDown Values","project value"));
		this.fillDataInDropDown(BaseClass.jsonArrayValue("DropDown","sales origin"),BaseClass.jsonArrayValue("DropDown Values","sales origin value"));
		this.fillDataInDropDown(BaseClass.jsonArrayValue("DropDown","method of contact"),BaseClass.jsonArrayValue("DropDown Values","method of contact value"));
		this.fillDataInDropDown(BaseClass.jsonArrayValue("DropDown","enquiry category"),BaseClass.jsonArrayValue("DropDown Values","enquiry category value"));
		this.fillDataInDropDown(BaseClass.jsonArrayValue("DropDown","enquiry trigger"),BaseClass.jsonArrayValue("DropDown Values","enquiry trigger Value"));
		this.saveLeadInformation();
	}

	@Step("Click on the Orization and select the all dropdown 'New Lead: Organization' modal")
	public void leadCreationOrizationType(String firstName, String middleName, String LastName)
			throws EncryptedDocumentException, IOException, InterruptedException {
		this.organizationCompanyName(firstName, middleName, LastName);
		this.fillDataInDropDown(ExcleReader.excleReader("Lead Creation", 7, 0),
				ExcleReader.excleReader("Lead Creation", 7, 1));
		this.fillDataInDropDown(ExcleReader.excleReader("Lead Creation", 8, 0),
				ExcleReader.excleReader("Lead Creation", 8, 1));
		this.fillDataInDropDown(ExcleReader.excleReader("Lead Creation", 9, 0),
				ExcleReader.excleReader("Lead Creation", 9, 1));
		this.fillDataInDropDown(ExcleReader.excleReader("Lead Creation", 10, 0),
				ExcleReader.excleReader("Lead Creation", 10, 1));
		this.fillDataInDropDown(ExcleReader.excleReader("Lead Creation", 11, 0),
				ExcleReader.excleReader("Lead Creation", 11, 1));
		this.fillDataInDropDown(ExcleReader.excleReader("Lead Creation", 12, 0),
				ExcleReader.excleReader("Lead Creation", 12, 1));
		this.fillDataInDropDown(ExcleReader.excleReader("Lead Creation", 13, 0),
				ExcleReader.excleReader("Lead Creation", 13, 1));
		this.saveLeadInformation();

	}

	/*
	 * click on save and from snag First Value
	 * 
	 * 
	 * 
	 * add the name of the person details
	 */
	@Step("Add the random name middle name and the last name")
	public void nameOfThePersonLeads(String firstNameValue, String MiddleNameValue, String lastNameValue)
			throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOf(aldarSales));
		util.UtilClassMethod(driver, headers, "Leads");
		wait.until(ExpectedConditions.visibilityOf(recentlyViewed));
		newButton.click();
		wait.until(ExpectedConditions.visibilityOf(newLead));
		personCheckBox.click();
		nextButton.click();
		wait.until(ExpectedConditions.visibilityOf(newLeadPerson));
		saveNewLeadPerson.click();
		snagFirstValue.click();
		nameSalutation.click();
		util.UtilClassMethod(driver, salutation, "Mr.");
		getPersonNameDetails("First Name").sendKeys(firstNameValue);
		getPersonNameDetails("Middle Name").sendKeys(MiddleNameValue);
		getPersonNameDetails("Last Name").sendKeys(lastNameValue);
	}
	public String personLeadHeadder() {
		wait.until(ExpectedConditions.visibilityOf(aldarSales));
		util.UtilClassMethod(driver, headers, "Leads");
		wait.until(ExpectedConditions.visibilityOf(recentlyViewed));
		newButton.click();
		wait.until(ExpectedConditions.visibilityOf(newLead));
		personCheckBox.click();
		nextButton.click();
		cancleButtonAtLead.click();
		return newLeadPerson.getText();
		
	}
	@Step("Enter the name and the company name")
	public void organizationCompanyName(String firstNameValue, String MiddleNameValue, String lastNameValue)
			throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOf(aldarSales));
		util.UtilClassMethod(driver, headers, "Leads");
		wait.until(ExpectedConditions.visibilityOf(recentlyViewed));
		newButton.click();
		wait.until(ExpectedConditions.visibilityOf(newLead));
		j.executeScript("arguments[0].click();", organizationCheckBox);
		nextButton.click();
		saveNewLeadPerson.click();
		snagFirstValue.click();
		nameSalutation.click();
		util.UtilClassMethod(driver, salutation, "Mr.");
		getPersonNameDetails("First Name").sendKeys(firstNameValue);
		getPersonNameDetails("Middle Name").sendKeys(MiddleNameValue);
		getPersonNameDetails("Last Name").sendKeys(lastNameValue);
		j.executeScript("arguments[0].click();", saveNewLeadPerson);
		snagFirstValue.click();
		companyName.sendKeys("Alldar");

	}

	/*
	 * click on save and from snag First Value
	 * 
	 * 
	 * 
	 * add the fillDataInDropDown details
	 */
	public void sangAtTheLeadPage(String dropdownTypes, String dropdownValues, String sangTypes) {

		saveNewLeadPerson.click();
		UtilClass.asyncClickLinkInUl(driver,
				"(//ul[contains(@class,'errorsList slds-list_dotted slds-m-left_medium')])[2]", sangTypes);
		j.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'center'});",
				getButtonByAriaLabel(dropdownTypes));
		wait.until(ExpectedConditions.visibilityOf(getButtonByAriaLabel(dropdownTypes)));
		j.executeScript("arguments[0].click();", getButtonByAriaLabel(dropdownTypes));
		util.UtilClassMethod(driver, customerType, dropdownValues);
	}

	@Step("fill the values of the dropdown after the qulified lead")
	public void qulifiedLeadUpdate() throws InterruptedException {
		try {
			this.withoutSangType("Lead Status, In Progress Lead", "Qualified Lead");
		} catch (Exception e) {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException ex) {
				// Handle interrupted exception
			}
			this.withoutSangType("Lead Status, In Progress Lead", "Qualified Lead");
		}
		this.corrporateWelthName("Unit Type, --None--", "Apartment", "Unit Type");
		this.corrporateWelthName("Buy/Rent, --None--", "Buy", "Buy/Rent");
		this.corrporateWelthName("Lead Origin, --None--", "United Arab Emirates", "Lead Origin");
		this.corrporateWelthName("Customer Budget, --None--", "0M-AED 25M", "Customer Budget");
		this.corrporateWelthName("Customer Sub Type, --None--", "DOMESTIC", "Customer Sub Type");
		this.corrporateWelthName("Number of Bedrooms, --None--", "2BHK", "Number of Bedrooms");
		this.corrporateWelthName("Resident Status, --None--", "Resident", "Resident Status");
		this.corrporateWelthName("Financing, --None--", "Yes", "Financing");
		this.corrporateWelthName("Purpose of Use, --None--", "End User", "Purpose of Use");
		this.corrporateWelthName("Property Readiness, --None--", "0-12 months", "Property Readiness");
		this.saveLeadInformation();
	}
	@Step("fill the values of the dropdown after the qulified lead")
	public void qulifiedLeadUpdate2() throws InterruptedException {
		try {
			this.withoutSangType(BaseClass.jsonArrayValue("DropDown","Lead Status"),"Qualified Lead");
		} catch (Exception e) {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException ex) {
				// Handle interrupted exception
			}
			this.withoutSangType("Lead Status, In Progress Lead", "Qualified Lead");
		}
		this.corrporateWelthName(BaseClass.jsonArrayValue("DropDown","Unit type"),BaseClass.jsonArrayValue("DropDown Values","Unit Type value"),BaseClass.jsonArrayValue("Sang values","ErroR Unit Type"));
		this.corrporateWelthName(BaseClass.jsonArrayValue("DropDown","Buy or Rent"), BaseClass.jsonArrayValue("DropDown Values","Buy/Rent value"), BaseClass.jsonArrayValue("Sang values","ErroR Buy/Rent"));
		this.corrporateWelthName(BaseClass.jsonArrayValue("DropDown","Lead origin"), BaseClass.jsonArrayValue("DropDown Values","Lead Origin value"),BaseClass.jsonArrayValue("Sang values","ErroR Lead Origin"));
		this.corrporateWelthName(BaseClass.jsonArrayValue("DropDown","Customer Budget"),BaseClass.jsonArrayValue("DropDown Values","Customer Budget value"),BaseClass.jsonArrayValue("Sang values","ErroR Customer Budget"));
		this.corrporateWelthName(BaseClass.jsonArrayValue("DropDown","Number of Bedrooms"),BaseClass.jsonArrayValue("DropDown Values","Number of Bedrooms value"),BaseClass.jsonArrayValue("Sang values","ErroR Number of Bedrooms"));
		this.corrporateWelthName(BaseClass.jsonArrayValue("DropDown","Resident Status"),BaseClass.jsonArrayValue("DropDown Values","Resident Status value"),BaseClass.jsonArrayValue("Sang values","ErroR Resident Status"));
		this.corrporateWelthName(BaseClass.jsonArrayValue("DropDown","Financing"),BaseClass.jsonArrayValue("DropDown Values","Financing value"),BaseClass.jsonArrayValue("Sang values","ErroR Financing"));
		this.corrporateWelthName(BaseClass.jsonArrayValue("DropDown","Purpose of Use"),BaseClass.jsonArrayValue("DropDown Values","Purpose of Use value"),BaseClass.jsonArrayValue("Sang values","ErroR Purpose of Use"));
		this.corrporateWelthName(BaseClass.jsonArrayValue("DropDown","Property Readiness"),BaseClass.jsonArrayValue("DropDown Values","Property Readiness value"),BaseClass.jsonArrayValue("Sang values","ErroR Property Readiness"));
		this.saveLeadInformation();
	}
	public String hitSang() throws InterruptedException {
		this.withoutSangType(BaseClass.jsonArrayValue("DropDown","Lead Status"), "Qualified Lead");
		this.saveLeadInformation();
		String values=sangPoPUp.getText();
		closeSangPopup.click();
		cancleButtonConvertedLead.click();
		return values;
		
	}
	public String inprocessLeadUpdate() {
		return inProcessLead.getText();
	}

	@Step("Add data in the dropdown after clcik on save and sang suggestions")
	public void corrporateWelthName(String dropdownTypes, String dropdownValues, String sangTypes)
			throws InterruptedException {
		try {

			j.executeScript("arguments[0].click();", saveNewLeadPerson);
			UtilClass.asyncClickLinkInUl(driver, "//ul[contains(@class,'slds-list_dotted')]", sangTypes);
			wait.until(ExpectedConditions.elementToBeClickable(getButtonByAriaLabel(dropdownTypes)));
			j.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'center'});",
					getButtonByAriaLabel(dropdownTypes));
			j.executeScript("arguments[0].click();", getButtonByAriaLabel(dropdownTypes));
			util.UtilClassMethod(driver, customerType, dropdownValues);
		} catch (StaleElementReferenceException e) {
			// Handle the StaleElementReferenceException
			System.out.println("StaleElementReferenceException occurred: " + e.getMessage());
			// Additional error handling code or logging can be added here
		} catch (Exception e) {
			// Handle any other exceptions
			System.out.println("An exception occurred: " + e.getMessage());
			// Additional error handling code or logging can be added here
		}
	}

	public String mobileNumberCode() {
		return textNone.getText();
	}
	@Step("Wait unit the emailID Text is to be displyed")
	public void waitUntilEmailIdDisplay() {
		wait.until(ExpectedConditions.visibilityOf(emailIdTextValues));
		wait.until(ExpectedConditions.visibilityOf(saveNewLeadPerson));
	}

	@Step("Set values in the dropdown without click on the save")
	public void withoutSangType(String dropdownTypes, String dropdownValues) throws InterruptedException {
		int maxRetries = 3;
		int retryCount = 0;

		while (retryCount < maxRetries) {
			try {
				for (int i = 0; i <=2; i++) {
					
					wait.until(ExpectedConditions.elementToBeClickable(getButtonByAriaLabel(dropdownTypes))).click();
				}
				wait.until(ExpectedConditions.visibilityOf(contryCode));
				util.UtilClassMethod(driver, customerType, dropdownValues);
				
				break; // Exit the loop if the click is successful
			} catch (TimeoutException e) {
				// Element is not clickable, retry after a delay
				System.out.println("Element is not clickable: " + dropdownTypes);
				retryCount++;
				Thread.sleep(1000); // Wait for 1 second before retrying
			}
		}

		if (retryCount == maxRetries) {
			// Max retries exceeded, handle the failure here
			System.out.println("Failed to click the element after multiple retries: " + dropdownTypes);
			// Add appropriate actions or throw an exception if needed
		}
	}
	@Step("Set values in the dropdown without click on the save")
	public void withoutSangTypeForTheScroll(String dropdownTypes, String dropdownValues) throws InterruptedException {
		int maxRetries = 3;
		int retryCount = 0;

		while (retryCount < maxRetries) {
			try {
				for (int i = 0; i <=2; i++) {
					j.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'center'});", getButtonByAriaLabel(dropdownTypes));
					wait.until(ExpectedConditions.elementToBeClickable(getButtonByAriaLabel(dropdownTypes))).click();
				}

				
				util.UtilClassMethod(driver, customerType, dropdownValues);
				
				break; // Exit the loop if the click is successful
			} catch (TimeoutException e) {
				// Element is not clickable, retry after a delay
				System.out.println("Element is not clickable: " + dropdownTypes);
				retryCount++;
				Thread.sleep(1000); // Wait for 1 second before retrying
			}
		}

		if (retryCount == maxRetries) {
			// Max retries exceeded, handle the failure here
			System.out.println("Failed to click the element after multiple retries: " + dropdownTypes);
			// Add appropriate actions or throw an exception if needed
		}
	}
	public void domasticSelection(String dropdownTypes,String dropdownValues) {
		j.executeScript("arguments[0].click();", getButtonByAriaLabel(dropdownTypes));
		util.UtilClassMethod(driver, customerType, dropdownValues);
	}
	public void repeteClcikOnTheLeadPageSang() {
		saveNewLeadPerson.click();
		sangFirstValueAtLeadPage.click();
	}

	@Step("Fill the data form dropdown to create lead")
	public void fillDataInDropDown(String dropdownTypes, String dropdownValues) {
		saveNewLeadPerson.click();
		snagFirstValue.click();
		getButtonByAriaLabel(dropdownTypes).click();
		util.UtilClassMethod(driver, customerType, dropdownValues);
	}

	@Step("Click on save button")
	public void saveLeadInformation() throws InterruptedException {
		saveNewLeadPerson.click();
		Thread.sleep(5000);
	}

	@Step("Validate the status of the lead after click on the lead that is inprocess or completed")
	public String taskStatus() throws InterruptedException {
		j.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'center'});", contactCreated);
		j.executeScript("arguments[0].click();", youHaveTask);
		wait.until(ExpectedConditions.visibilityOf(compltedButton));
		String status = compltedStatus.getText();
		System.out.println(status);
		return status;
	}

	@Step("Get the unique id of the lead from the lead page")
	public String leadName() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOf(duplicateLeadsZero));
		wait.until(ExpectedConditions.visibilityOf(contactCreated));

		boolean scrolledToElement = false;
		int maxScrollAttempts = 3;
		int scrollAttempt = 0;

		while (!scrolledToElement && scrollAttempt < maxScrollAttempts) {
			try {
				j.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'center'});", contactCreated);
				scrolledToElement = true;
			} catch (Exception e) {
				scrollAttempt++;
				Thread.sleep(1000); // Wait for 1 second before attempting to scroll again
			}
		}

		if (!scrolledToElement) {
			throw new RuntimeException("Failed to scroll to contactCreated element after multiple attempts");
		}

		wait.until(ExpectedConditions.visibilityOf(youHaveTask));
		String leadName = youHaveTask.getText();
		String subString = leadName.substring(0, leadName.indexOf(" -"));
		return subString;
	}

	@Step("Validate the custumer reach should be displayed")
	public String custmerReachValidation() {
		String cusReach = customerReached.getText();
		return cusReach;
	}

	@Step("Updated the qulified lead")
	public void leadStatusUpdate() {
		wait.until(ExpectedConditions.visibilityOf(leadStatus)).click();
//		j.executeScript("arguments[0].click();", leadStatus);
		j.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'center'});", dropdownLeadStatus);
	}

	public void textValidateFeild() {
		wait.until(ExpectedConditions.visibilityOf(leadRecord));
	}

	public String validationSelectARecordType() {

		wait.until(ExpectedConditions.visibilityOf(aldarSales));
		util.UtilClassMethod(driver, headers, "Leads");
		wait.until(ExpectedConditions.visibilityOf(recentlyViewed));
		newButton.click();
		wait.until(ExpectedConditions.visibilityOf(newLead));
		String personLeadText = personLead.getText();
		j.executeScript("arguments[0].click();", closeWindowOfNewLead);
		return personLeadText;
	}

	public void leadStatusValidation() {
		try {
			wait.until(ExpectedConditions.visibilityOf(leadsDetails));
			wait.until(ExpectedConditions.visibilityOf(leadStatusUpdate));
		} catch (Exception e) {
			driver.navigate().refresh();
		}

	}

	public String validateOrganization() {
		String personLeadText = personLead2.getText();
		return personLeadText;
	}

	public void selectionDropdownWithoutSave(String dropdownTypes, String dropdownValues) {
		j.executeScript("arguments[0].click();", closeWindowOfNewLead);
		getButtonByAriaLabel(dropdownTypes).click();
		util.UtilClassMethod(driver, customerType, dropdownValues);
	}

	@Step("Validate the lead status is able to show as 'converted lead'")
	public String leadStatusCheckItsConverted() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOf(editLeadStatus));
		j.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'center'});", editLeadStatus);
		j.executeScript("arguments[0].click();", editLeadStatus);
		String statusOFLead = convertedLeadUpdate.getAttribute("data-value");
		System.out.println(statusOFLead + "{{{{{{{{{{{{{{{{{{{{{{{{{{{{");
		cancleButtonConvertedLead.click();
		return statusOFLead;
	}

	@Step("Validate that user able to see the aldar sales text after the login")
	public String aldarSales() {
		wait.until(ExpectedConditions.visibilityOf(aldarSales));
		String salesHeadder = aldarSales.getText();
		return salesHeadder;
	}

	@Step("Validate that user able to see the person after click on the new Button")
	public boolean leadTypesValidation() {
		wait.until(ExpectedConditions.visibilityOf(aldarSales));
		util.UtilClassMethod(driver, headers, "Leads");
		wait.until(ExpectedConditions.visibilityOf(recentlyViewed));
		newButton.click();
		wait.until(ExpectedConditions.visibilityOf(newLead));
		boolean person = personText.isDisplayed();
		return person;
	}

	@Step("Validate that user able to see the organization after click on the new Button")
	public boolean organizationValidation() {
		wait.until(ExpectedConditions.visibilityOf(organizationText));
		boolean organi = organizationText.isDisplayed();
		cancleButton.click();
		return organi;

	}

	@Step("Click on the account after gobal search")
	public boolean clickOnTheAccountLinkAfterGobalSearch() {
		wait.until(ExpectedConditions.visibilityOf(leadsValuesAfterGobalSearch));
		for (int i = 0; i <= 25; i++) {
			driver.navigate().refresh();
		}
		boolean values = opportunities.isDisplayed();
		return values;
	}
	public boolean withoutRefershOpporties() {
		wait.until(ExpectedConditions.visibilityOf(leadsValuesAfterGobalSearch));
		boolean values = opportunities.isDisplayed();
		return values;
	}
	@Step("After click on the accounts get the number of opportunity link with account")
	public String getTheOpporitesCreatedNumber() throws InterruptedException {
		opporitesLink.click();
		System.out.println(contryOfResidence.getText() + "}}}}}}}}}}}}}}}}}}}}}}}}}}}}}");
		j.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'center'});", contryOfResidence);
		wait.until(ExpectedConditions.visibilityOf(opportiesRecord));
		String recordTypes = opportiesRecord.getText();
		return recordTypes;
	}
	@Step("Check the bookUnit button is clickble")
	public boolean unitSearch() {
		j.executeScript("arguments[0].click();", unitSearchButton);
		return exclamtoryMark.isDisplayed();
	}

}
