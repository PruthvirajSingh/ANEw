package Pom.Person;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Factory;

import Utility.ExcleReader;
import io.qameta.allure.Step;

public class LeadChagesAdmin {
	private WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor j;
	Actions actions;

	@FindBy(xpath = "//div[contains(@class,'noResultsTitle')]")
	private WebElement pageNotDisplay;

	@FindBy(xpath = "//h2[text()='Related List Quick Links']")
	private WebElement relatedList;

	@FindBy(css = "div[class='actions ']")
	private WebElement buttonsFollow;

	@FindBy(css = "button[aria-label='Search']")
	private WebElement serchBar;

	@FindBy(xpath = "//div[@data-aura-class='forceSearchNoResults']")
	private WebElement noResultsWindow;

	@FindBy(xpath = "//div[@class='forceSearchAssistantDialog']//input[@type='search']")
	private WebElement enterValuesSerchBar;

	@FindBy(css = "div.forceSearchRecordPreviewHeader a[data-refid='recordId']")
	private WebElement recordClick;

	@FindBy(xpath = "//button[@title='Edit Country of Residence']")
	private WebElement emailIdUpdate;

	@FindBy(xpath = "//label[text()='Email Address']")
	private WebElement emailIdText;

	@FindBy(xpath = "//input[@name='EmailAddress__c']")
	private WebElement enterEamilId;

	@FindBy(xpath = "//input[@name='MobileNumber__c']")
	private WebElement mobileNumber;

	@FindBy(xpath = "//span[text()='Home']")
	private WebElement homeButton;

	@FindBy(xpath = "//span[text()='Opportunities']")
	private WebElement oppertiesButton;

	public LeadChagesAdmin(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		j = (JavascriptExecutor) driver;
		wait = new WebDriverWait(driver, 20);
		actions = new Actions(driver);

	}

	@Step("globally search for the lead and click on the lead")
	public String searchLeadAndUpdateIt(String value) throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOf(oppertiesButton));
		wait.until(ExpectedConditions.visibilityOf(homeButton));
		// Wait for the search bar to be clickable
		boolean clicked = false;
		int attempts = 0;

		while (!clicked && attempts < 3) { // Retry clicking the search bar up to 3 times
			try {
				for (int i = 0; i <= 1; i++) {
					wait.until(ExpectedConditions.elementToBeClickable(serchBar)).click();
					;
				}
				clicked = true;
			} catch (WebDriverException e) {
				attempts++;
				Thread.sleep(1000); // Wait for 1 second before retrying
			}
		}

		wait.until(ExpectedConditions.elementToBeClickable(enterValuesSerchBar)).sendKeys(value);
		actions.sendKeys(Keys.ENTER).perform();

		try {
			if (pageNotDisplay.getText().equals("Don't give up yet!")) {
				System.out.println("if block");
				for (int i = 0; i <= 20; i++) {
					driver.navigate().refresh();
				}
			}
		} catch (NoSuchElementException e) {
			System.out.println("Element not found: pageNotDisplay");
		}

		wait.until(ExpectedConditions.visibilityOf(buttonsFollow));
		wait.until(ExpectedConditions.visibilityOf(relatedList));
		wait.until(ExpectedConditions.visibilityOf(recordClick));
		j.executeScript("arguments[0].click();", recordClick);
		String leadValue = recordClick.getText();
		String substring = leadValue.split(" - ")[0];
		System.out.println(substring + "{{{{{{{{{{{{{{{{{{");
		return substring;
	}

	public String adminTestCase(String value) throws InterruptedException {
		try {
			for (int i = 0; i <= 1; i++) {
				wait.until(ExpectedConditions.elementToBeClickable(serchBar)).click();
			}

		} catch (WebDriverException e) {

		}

		enterValuesSerchBar.sendKeys(value);
		actions.sendKeys(Keys.ENTER).perform();
		return pageNotDisplay.getText();
	}

	@Step("Applied asserations After login Serach button is displayed")
	public String asserationForSerach() {
		return serchBar.getText();
	}

	@Step("global search for the lead after the sales login")
	public void serchAndUpdateItData(String value) {
		wait.until(ExpectedConditions.visibilityOf(oppertiesButton));
		wait.until(ExpectedConditions.visibilityOf(homeButton));
		try {
			for (int i = 0; i <= 10; i++) {
				wait.until(ExpectedConditions.elementToBeClickable(serchBar)).click();
			}
		} catch (Exception e) {
			// Handle any exceptions or logging if necessary

		}

		wait.until(ExpectedConditions.visibilityOf(enterValuesSerchBar)).sendKeys(value);
		actions.sendKeys(Keys.ENTER).perform();
		wait.until(ExpectedConditions.visibilityOf(recordClick));
		recordClick.click();
	}

	@Step("global search for the lead name")
	public void globalSearchLeadName(String value) {

		wait.until(ExpectedConditions.visibilityOf(oppertiesButton));
		wait.until(ExpectedConditions.visibilityOf(homeButton));

		boolean clicked = false;
		int retryCount = 0;
		while (!clicked && retryCount < 3) {
			try {
				wait.until(ExpectedConditions.elementToBeClickable(serchBar));
				for (int i = 0; i <=5; i++) {
					j.executeScript("arguments[0].click();", serchBar);
				}
				clicked = true;
			} catch (Exception e) {
				// Handle any exceptions or logging if necessary
				retryCount++;
			}
		}

		if (!clicked) {
			// Log or throw an exception indicating that clicking on the search bar failed
			return;
		}

		enterValuesSerchBar.sendKeys(value);
		actions.sendKeys(Keys.ENTER).perform();
	}

	@Step("Set the random eamil id")
	public void enterEamilId(String emailID) {
		j.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'center'});", emailIdUpdate);
		j.executeScript("arguments[0].click();", emailIdUpdate);
		j.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'center'});", emailIdText);
		enterEamilId.sendKeys(emailID);
	}

	@Step("Set the random mobile number")
	public void setMobileNumber(String mobileNumberValue) {
		mobileNumber.sendKeys(mobileNumberValue);
	}

}
