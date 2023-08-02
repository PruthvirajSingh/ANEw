package Pom.Person;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Utility.UtilClass;
import io.qameta.allure.Step;

public class UnitSelectionForAccount {
	private WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor j;
	Actions actions;

	@FindBy(xpath = "//h2//a[text()='Opportunities']")
	private WebElement opporitesText;

	@FindBy(xpath = "(//div[contains(@class,'entityNameTitle slds-line-height--reset')])[2]")
	private WebElement opportiesModalText;

	@FindBy(xpath = "(//div[contains(@class,'windowViewMode-normal')]//table//a[@data-refid='recordId'])[1]")
	private WebElement linkOfTheAccountFromTable;

	@FindBy(xpath = "(//div[contains(@class,'windowViewMode-normal')]//a[@data-refid='recordId'])[1]")
	private WebElement linkInOppForClcik;
	@FindBy(xpath = "(//span[text()='Opportunity Information'])[3]")
	private WebElement oppInfo;

	@FindBy(xpath = "//li[@title='Unit Search']//a")
	private WebElement unitSearch;

	@FindBy(xpath = "(//a[@data-refid='recordId'])[3]")
	private WebElement accountLink;

	@FindBy(xpath = "(//span[@class='test-id__section-header-title'])[1]")
	private WebElement contryOfResidence;

	@FindBy(xpath = "((//div[@class='slds-card__body slds-wrap slds-grid'])[2]//span)[1]")
	private WebElement opporitesLink;

	@FindBy(xpath = "((//div[contains(@class,'slds-button-group')])[2]//button)[5]")
	private WebElement excimatoryMark;

	@FindBy(xpath = "((//div[contains(@class,'slds-button-group')])[2]//button)[7]")
	private WebElement excimatoryMark1;

	@FindBy(xpath = "(//div[contains(@class,'recordHomeFlexipage2')]//a[contains(@class,'slds-truncate')]//span)[1]")
	private WebElement accountSelection;

	@FindBy(xpath = "//div[text()='Person Account']")
	private WebElement personAccountText;

	@FindBy(xpath = "//button[@title='Edit Gender']")
	private WebElement editGender;

	@FindBy(xpath = "//span[@title='United Arab Emirates']")
	private WebElement countrySelectionFromDropDown;

	public WebElement getAndAddValuesAfterSang(String ariaLabel) {
		String locator = String.format("//input[@name='%s']", ariaLabel);
		return driver.findElement(By.xpath(locator));
	}

	@FindBy(xpath = "//input[@name='PersonBirthdate']")
	private WebElement enterDOB;

	@FindBy(xpath = "//button[@name='SaveEdit']")
	private WebElement saveNewLeadPerson;

	@FindBy(xpath = "//input[@aria-label='Permanent Country']")
	private WebElement countrySelection;

	@FindBy(xpath = "(//input[@placeholder='Search Address'])[1]")
	private WebElement permanentAddress;

	@FindBy(xpath = "(//textarea[@autocomplete='street-address'])[1]")
	private WebElement textAreaAddress;

	public WebElement getButtonByAriaLabel(String ariaLabel) {
		String locator = String.format("//button[@aria-label='%s']", ariaLabel);
		return driver.findElement(By.xpath(locator));
	}

	@FindBy(xpath = "//span[text()='Address Information']")
	private WebElement addressInformation;

	@FindBy(xpath = "(//span[text()='View All'])[1]")
	private WebElement viewAll;

	@FindBy(css = "h1[title='Documents']")
	private WebElement documents;

	@FindBy(xpath = "//a[@data-label='Details']")
	private WebElement detailsHeader;

	@FindBy(xpath = "//span[contains(@class,' label bBody')]")
	private WebElement doneButton;

	public WebElement doucmentList1(String ariaLabel) {
		String locator = String.format(
				"(//table[contains(@class,'slds-table')]//th[@data-label='Document Number']//a[@class='flex-wrap-ie11 slds-truncate']//span)[%s]",
				ariaLabel);
		return driver.findElement(By.xpath(locator));
	}

	public WebElement linkForTheUpload(String ariaLabel) {
		String locator = String.format("(//lst-formatted-text[text()='%s']/../../../../../..//th//span)[2]", ariaLabel);
		return driver.findElement(By.xpath(locator));
	}

	@FindBy(xpath = "//div[contains(@class,'center')]/div[contains(@class,'windowViewMode-normal')]//div[contains(@class,'forceRelatedListSingleContainer')]//div/h2//span[2]")
	private WebElement numberOfDocuments;
	@FindBy(xpath = "(//th[@data-label='Document Number'])[1]")
	private WebElement doucmentList;

	@FindBy(xpath = "//div[contains(@class,'center')]/div[contains(@class,'windowViewMode-normal')]//slot/input")
	private WebElement inputSlot;

	public WebElement inputUploadButtons(String ariaLabel) {
		String locator = String.format("(//div[@class='drag-over-body']//slot/input[@name='fileInput'])[%s]",
				ariaLabel);
		return driver.findElement(By.xpath(locator));
	}

	@FindBy(xpath = "(//input[@name='fileInput'])[1]")
	private WebElement uploadFile;

	@FindBy(xpath = "(//input[@name='fileInput'])[2]")
	private WebElement uploadFile1;

	@FindBy(xpath = "//span[text()='Employment Details']")
	private WebElement emplymentText;

	@FindBy(xpath = "//span[text()='1 file was added to the Document.']")
	private WebElement documentUploadedMessage;

	@FindBy(xpath = "//span[@title='Relationships']")
	private WebElement relationships;

	@FindBy(xpath = "//h1[@title='Documents']")
	private WebElement documentsText;

	@FindBy(xpath = "//button[@aria-label='Gender, --None--']//span")
	private WebElement genderSelectionFirstValue;

	@FindBy(xpath = "//span[contains(@class,'slds-p-top--x-small header')]")
	private WebElement statusOfTheUploadFile;

	@FindBy(xpath = "(//button[@title='Edit Document Type'])[2]")
	private WebElement editButtonForTheValueSelect;

	@FindBy(xpath = "//button[@name='CancelEdit']")
	private WebElement cancleButton;
	@FindBy(xpath = "//button[@title='Edit Sale Type']")
	private WebElement clickOnEditSalesType;
//	//button[@aria-label='Document Type, National ID Back Copy']
	@FindBy(xpath = "//div[contains(@class,'slds-form-element_horizontal')]//lightning-formatted-text[text()='KYC Form']")
	private WebElement documentType;
	@FindBy(xpath = "//button[@title='Close this window']")
	private WebElement closeWindowPopUp;
	@FindBy(xpath = "//div[contains(@class,'slds-show_inline-block slds-float_left slds-align-middle thumbnailImg medium')]")
	private WebElement documentSelectionByIndex;

	@FindBy(xpath = "//span[text()='Booking Details']")
	private WebElement bookingDetails;

	@FindBy(xpath = "//label[text()='Sale Type']")
	private WebElement salesTypes;

	@FindBy(xpath = "//button[@name='SaveEdit']")
	private WebElement saveButtonForTheDetials;

	@FindBy(xpath = "(//lightning-input[@data-unit-unittype='Apartment']//span[@class='slds-checkbox'])[1]")
	private WebElement unitCheckBox;

	@FindBy(xpath = "//button[@name='BOOKING']")
	private WebElement bookingUnit;

	@FindBy(xpath = "//button[@name='FORWARD']")
	private WebElement proceedButton;

	@FindBy(xpath = "(//div[@class='slds-card__body']//input[@type='checkbox'])[1]")
	private WebElement customerVerifiedCheckBox;

	@FindBy(xpath = "//label[text()='Mortgage Applicable']")
	private WebElement mortageApplied;

	@FindBy(xpath = "(//button[@name='Book Unit(s)'])[2]")
	private WebElement booksUnits;

	@FindBy (xpath="//span[contains(@class,'slds-notification-badge')]")
	private WebElement cartNumber;
	
	@FindBy (xpath="//a[@title='Unit Search']")
	private WebElement unitSerachText;
	
	@FindBy (xpath="//h1[text()='Payment And Offer']")
	private WebElement paymentText;
	
	@FindBy (xpath="//span[text()='Select Offer']")
	private WebElement selectOfferText;
	
	@FindBy (xpath="//label[text()='Win Reason']")
	private WebElement winReason;
	
	@FindBy (xpath="//div[@role='alertdialog']//div[text()='Offer selection is mandatory. ']")
	private WebElement offerSelectionAlert;
	
	@FindBy (xpath="//div[@role='alertdialog']//div[text()='Please select Mortgage applicable']")
	private WebElement mortageApplyAlert;
	
	@FindBy (xpath="//div//h2[text()='Save changes in Account?']")
	private WebElement saveAccountPopUp;
	
	@FindBy (xpath="//div[@role='alertdialog']//div[text()='Mandatory Document Missing']")
	private WebElement meditoryDocumentError;
	
	@FindBy (xpath="//button[@title='Close']")
	private WebElement closeWindows;
	
	public WebElement dropDownValuesFromDetails(String ariaLabel) {
		String locator = String.format(
				"//div[contains(@class,'slds-dropdown_fluid slds-dropdown_left ')]//span[@title='%s']", ariaLabel);
		return driver.findElement(By.xpath(locator));
	}

	public WebElement documentSelectionByIndex(String ariaLabel) {
		String locator = String.format("(//div//table/tbody/tr/th//slot/span)[%s]", ariaLabel);
		return driver.findElement(By.xpath(locator));
	}

	public WebElement documentType(String ariaLabel) {
		String locator = String.format("//button[@aria-label='Document Type, %s']", ariaLabel);
		return driver.findElement(By.xpath(locator));
	}

	public UnitSelectionForAccount(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		j = (JavascriptExecutor) driver;
		wait = new WebDriverWait(driver,60);
		actions = new Actions(driver);

	}

	@Step("After click on the accounts get the number of opportunity link with account")
	public boolean opporitesCreations() throws InterruptedException {
		opporitesText.click();
		j.executeScript("arguments[0].click();", linkOfTheAccountFromTable);
		wait.until(ExpectedConditions.visibilityOf(unitSearch));
		j.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'center'});", unitSearch);
		unitSearch.click();
		wait.until(ExpectedConditions.visibilityOf(excimatoryMark));
		boolean values = excimatoryMark.isDisplayed();
		return values;
	}

	@Step("Check that opporties created")
	public boolean opporitesCreations1() {
		wait.until(ExpectedConditions.visibilityOf(excimatoryMark1));
		boolean values = excimatoryMark1.isDisplayed();
		return values;
	}

	@Step("Clcik on the account button after click on the Opportunities")
	public void accountClcikInOpp() {
		opporitesText.click();
		j.executeScript("arguments[0].click();", linkOfTheAccountFromTable);
		accountSelection.click();
		wait.until(ExpectedConditions.visibilityOf(personAccountText));
		j.executeScript("arguments[0].click();", editGender);
	}
	@Step("Clcik on the account button after click on the Opportunities")
	public void accountLinkClcikFromTheOpporites() {
		wait.until(ExpectedConditions.visibilityOf(opporitesText)).click();
		wait.until(ExpectedConditions.elementToBeClickable(linkOfTheAccountFromTable)).click(); 
		wait.until(ExpectedConditions.elementToBeClickable(accountSelection)).click();
		wait.until(ExpectedConditions.visibilityOf(personAccountText));
	}
	@Step("Validate the gender is displayed")
	public String genderSelection() {
		return genderSelectionFirstValue.getText();
	}

	@Step("Select the dropdown from the account page")
	public void addDetailsInAccounts(String values, String sangTypes, String sangValueInput)
			throws InterruptedException {
		j.executeScript("arguments[0].click();", saveNewLeadPerson);
		UtilClass.asyncClickLinkInUl(driver, "//ul[contains(@class,'slds-list_dotted')]", sangTypes);
		j.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'center'});",
				getAndAddValuesAfterSang(sangValueInput));
		wait.until(ExpectedConditions.visibilityOf(getAndAddValuesAfterSang(sangValueInput)));
		getAndAddValuesAfterSang(sangValueInput).sendKeys(values);

	}

	@Step("Add the values in the account")
	public void setValuesInInputAddress(String values, String sangValueInput) {
		getAndAddValuesAfterSang(sangValueInput).sendKeys(values);
	}

	@Step("Add the address in the accounts")
	public void textAreaAddressInput(String permanentStreet) {
		textAreaAddress.sendKeys(permanentStreet);
	}

	@Step("Update the address")
	public void addressUpdate(String values) throws InterruptedException {
		j.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'center'});", addressInformation);
		permanentAddress.sendKeys(values);
		countrySelection.click();
		wait.until(ExpectedConditions.visibilityOf(countrySelectionFromDropDown));
		j.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'center'});",
				countrySelectionFromDropDown);
		j.executeScript("arguments[0].click();", countrySelectionFromDropDown);
	
	}

	public void emplymentDetails() {
		j.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'center'});", emplymentText);
	}

	@Step("Validate the relationship text is displyed")
	public String saveInfo() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(saveNewLeadPerson)).click();
		Thread.sleep(5000);
		return relationships.getText();
	}
	@Step("Validate the relationship text is displyed")
	public boolean saveInfoWithoutPause() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(saveNewLeadPerson)).click();
		return saveAccountPopUp.isDisplayed();
	}
	@Step("Click on the view All button for the documents upload")
	public void relationship() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOf(viewAll));
		j.executeScript("arguments[0].click();", viewAll);
	}

	public String validateTableSelectionValues(String value) throws InterruptedException {

		wait.until(ExpectedConditions.elementToBeClickable(editButtonForTheValueSelect));
		j.executeScript("arguments[0].click();", editButtonForTheValueSelect);
		String valuesofData = documentType(value).getAttribute("data-value");
		cancleButton.click();
		return valuesofData;
	}

//	public void uploadDocuments(String document, WebDriver driver, String inputIndex, String inputIndex2) throws InterruptedException {
//	    documentSelectionByIndex(inputIndex2).click();
//	    WebElement parentElement = driver.findElement(By.cssSelector("div.forceRelatedListSingleContainer div.drag-over-body"));
//	    ((JavascriptExecutor) driver).executeScript("arguments[0].querySelector('input').removeAttribute('disabled')", parentElement);
//	    WebElement inputElement = parentElement.findElement(By.cssSelector("input[type='file']"));
//	    inputElement.sendKeys("C:\\Aldar\\Aldar\\sample (1).pdf");
//	    System.out.println(doneButton.isEnabled() + "{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{");
//	    Thread.sleep(10000);
//	    wait.until(ExpectedConditions.elementToBeClickable(doneButton)).click();
//	    driver.navigate().back();
//	    wait.until(ExpectedConditions.visibilityOf(documentsText));
//	}
	@Step("Upload documents and validate the status of the document is 'one'")
	public void uploadDocuments(String document, String inputIndex2) throws InterruptedException {
		documentSelectionByIndex(inputIndex2).click();
		wait.until(ExpectedConditions.visibilityOf(numberOfDocuments));
		driver.navigate().refresh();
		wait.until(ExpectedConditions.elementToBeClickable(inputSlot)).sendKeys("C:\\Aldar\\Aldar\\sample (1).pdf");
		Thread.sleep(9000);
		wait.until(ExpectedConditions.elementToBeClickable(doneButton)).click();

		System.out.println("Document updated");

		driver.navigate().back();
		wait.until(ExpectedConditions.visibilityOf(documentsText));
	}
	public String numberOfTheDocuments(String document, String inputIndex2) throws InterruptedException {
		documentSelectionByIndex(inputIndex2).click();
		wait.until(ExpectedConditions.visibilityOf(numberOfDocuments));
		driver.navigate().refresh();
		wait.until(ExpectedConditions.elementToBeClickable(inputSlot)).sendKeys("C:\\Aldar\\Aldar\\sample (1).pdf");
		Thread.sleep(7000);
		wait.until(ExpectedConditions.elementToBeClickable(doneButton)).click();
		return numberOfDocuments.getText();
		
	}

	@Step("click on the save button")
	public void saveButton() throws InterruptedException {
		
//		wait.until(ExpectedConditions.elementToBeClickable(saveButtonForTheDetials)).click();
		j.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'center'});", saveButtonForTheDetials);
		wait.until(ExpectedConditions.elementToBeClickable(saveButtonForTheDetials)).click();
		
	}

	@Step("Click on the opporitesText and click on the link")
	public void clickOnOpp() {
		opporitesText.click();
		j.executeScript("arguments[0].click();", linkInOppForClcik);
	}

	public void refreshPage() {
		for (int i = 0; i <= 25; i++) {
			driver.navigate().refresh();
		}
	}

	@Step("Opporites text validate")
	public boolean opportiesText() {
		for (int i = 0; i <= 15; i++) {
			driver.navigate().refresh();
		}
		opporitesText.click();
		return linkInOppForClcik.isDisplayed();
	}

	public void detailsInOpporties() {
		opporitesText.click();
		j.executeScript("arguments[0].click();", linkInOppForClcik);
		j.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'center'});", bookingDetails);
		j.executeScript("arguments[0].click();", clickOnEditSalesType);
	}

	@Step("Validate sales Types is displyed")
	public boolean salesTypesText() {
		return salesTypes.isDisplayed();
	}

	@Step("Selection of the drop down from the Opportunities details")
	public void dropdownFromDetailsHandle(String dropdownTypes, String dropDownValues) throws InterruptedException {
		j.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'center'});",
				getButtonByAriaLabel(dropdownTypes));
		wait.until(ExpectedConditions.elementToBeClickable(getButtonByAriaLabel(dropdownTypes))).click();
		wait.until(ExpectedConditions.elementToBeClickable(dropDownValuesFromDetails(dropDownValues))).click();
	}
	public void selectionOftheUnit(String dropdownTypes, String dropDownValues) throws InterruptedException {
		j.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'center'});",
				getButtonByAriaLabel(dropdownTypes));
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(getButtonByAriaLabel(dropdownTypes))).click();
		wait.until(ExpectedConditions.elementToBeClickable(dropDownValuesFromDetails(dropDownValues))).click();
	}
	@Step("Select the offer and Mortgage Applicable and click on the book unit")
	public void dropDownSelectionUnit() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(unitCheckBox)).click();
		wait.until(ExpectedConditions.elementToBeClickable(bookingUnit)).click();
		wait.until(ExpectedConditions.visibilityOf(paymentText));
		wait.until(ExpectedConditions.visibilityOf(selectOfferText));
		this.dropdownFromDetailsHandle("Select Offer", "1002");
		Thread.sleep(1000);
		j.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'center'});", proceedButton);
		proceedButton.click();
		wait.until(ExpectedConditions.visibilityOf(winReason));
		customerVerifiedCheckBox.click();
		this.dropdownFromDetailsHandle("Win Reason, Win Reason", "Won - Aldar Brand Value");
		j.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'center'});", mortageApplied);
		this.dropdownFromDetailsHandle("Mortgage Applicable", "No");
		booksUnits.click();
	}
	
	public boolean missingDocumentWindows() {
		wait.until(ExpectedConditions.elementToBeClickable(unitCheckBox)).click();
		wait.until(ExpectedConditions.elementToBeClickable(bookingUnit)).click();
		wait.until(ExpectedConditions.elementToBeClickable(closeWindows)).click();
		return meditoryDocumentError.isDisplayed();
	}
	public boolean missingDocumentsAndGenderDetails() {
		wait.until(ExpectedConditions.elementToBeClickable(unitCheckBox)).click();
		return bookingUnit.isEnabled();
	}
	public boolean errorWithoutOffer() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(unitCheckBox)).click();
		wait.until(ExpectedConditions.elementToBeClickable(bookingUnit)).click();
		wait.until(ExpectedConditions.visibilityOf(paymentText));
		wait.until(ExpectedConditions.visibilityOf(selectOfferText));
		Thread.sleep(1000);
		j.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'center'});", proceedButton);
		proceedButton.click();
		return offerSelectionAlert.isDisplayed();
	}
	public boolean checkBoxNotSelections() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(unitCheckBox)).click();
		wait.until(ExpectedConditions.elementToBeClickable(bookingUnit)).click();
		wait.until(ExpectedConditions.visibilityOf(paymentText));
		wait.until(ExpectedConditions.visibilityOf(selectOfferText));
		this.dropdownFromDetailsHandle("Select Offer", "1002");
		Thread.sleep(1000);
		j.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'center'});", proceedButton);
		proceedButton.click();
		wait.until(ExpectedConditions.visibilityOf(winReason));
		this.dropdownFromDetailsHandle("Win Reason, Win Reason", "Won - Aldar Brand Value");
		j.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'center'});", mortageApplied);
		return booksUnits.isEnabled();
	}
	public boolean withoutWinReson() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(unitCheckBox)).click();
		wait.until(ExpectedConditions.elementToBeClickable(bookingUnit)).click();
		wait.until(ExpectedConditions.visibilityOf(paymentText));
		wait.until(ExpectedConditions.visibilityOf(selectOfferText));
		this.dropdownFromDetailsHandle("Select Offer", "1002");
		Thread.sleep(1000);
		j.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'center'});", proceedButton);
		proceedButton.click();
		wait.until(ExpectedConditions.visibilityOf(winReason));
		customerVerifiedCheckBox.click();
		j.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'center'});", mortageApplied);
		return booksUnits.isEnabled();
	}

	public void mortageDisplayed() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(unitCheckBox)).click();
		wait.until(ExpectedConditions.elementToBeClickable(bookingUnit)).click();
		wait.until(ExpectedConditions.visibilityOf(paymentText));
		wait.until(ExpectedConditions.visibilityOf(selectOfferText));
		this.dropdownFromDetailsHandle("Select Offer", "1002");
		Thread.sleep(1000);
		j.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'center'});", proceedButton);
		proceedButton.click();
		wait.until(ExpectedConditions.visibilityOf(winReason));
		customerVerifiedCheckBox.click();
		this.dropdownFromDetailsHandle("Win Reason, Win Reason", "Won - Aldar Brand Value");
		j.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'center'});", mortageApplied);
	}

	public void winReason() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(unitCheckBox)).click();
		wait.until(ExpectedConditions.elementToBeClickable(bookingUnit)).click();
		wait.until(ExpectedConditions.visibilityOf(paymentText));
		wait.until(ExpectedConditions.visibilityOf(selectOfferText));
		this.dropdownFromDetailsHandle("Select Offer", "1002");
		Thread.sleep(1000);
		j.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'center'});", proceedButton);
		proceedButton.click();
		wait.until(ExpectedConditions.visibilityOf(winReason));
		customerVerifiedCheckBox.click();
		this.dropdownFromDetailsHandle("Win Reason, Win Reason", "Won - Aldar Brand Value");
	}
	public boolean enableBookUnitWithoutMortage() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(unitCheckBox)).click();
		wait.until(ExpectedConditions.elementToBeClickable(bookingUnit)).click();
		wait.until(ExpectedConditions.visibilityOf(paymentText));
		wait.until(ExpectedConditions.visibilityOf(selectOfferText));
		this.dropdownFromDetailsHandle("Select Offer", "1002");
		Thread.sleep(1000);
		j.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'center'});", proceedButton);
		proceedButton.click();
		wait.until(ExpectedConditions.visibilityOf(winReason));
		customerVerifiedCheckBox.click();
		this.dropdownFromDetailsHandle("Win Reason, Win Reason", "Won - Aldar Brand Value");
		booksUnits.click();
		return mortageApplyAlert.isDisplayed();
		
		
		
	}
	public void unitFilterData() {
		wait.until(ExpectedConditions.elementToBeClickable(unitCheckBox)).click();
		
	}

	public String addToCart() {
		wait.until(ExpectedConditions.elementToBeClickable(unitCheckBox)).click();
		wait.until(ExpectedConditions.elementToBeClickable(bookingUnit)).click();
		return cartNumber.getText();
	}

	public void payMeantAndOffers() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(unitCheckBox)).click();
		wait.until(ExpectedConditions.elementToBeClickable(bookingUnit)).click();
		wait.until(ExpectedConditions.visibilityOf(paymentText));
		wait.until(ExpectedConditions.visibilityOf(selectOfferText));
		this.dropdownFromDetailsHandle("Select Offer", "1002");
	}
}