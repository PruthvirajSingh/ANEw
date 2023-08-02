package Pom.Person;

import java.awt.Toolkit;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
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

import io.qameta.allure.Step;

public class DataBasePom {
	private WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor j;
	Actions actions;
	@FindBy(css = "div[title='Show Salesforce details (Alt+I / Shift+Alt+I)']")
	private WebElement buttonForPopUpSalesforceInspector;

	@FindBy(xpath = "//div[@class='header-icon']")
	private WebElement textHeader;

	@FindBy(xpath = "//a[text()='xport']")
	private WebElement exportData;

	@FindBy(xpath = "//textarea[@id='query']")
	private WebElement queryValues;

	@FindBy(xpath = "//button[text()='Export']")
	private WebElement exportButton;

	@FindBy(css = "#result-table tr td a")
	private List<WebElement> allDataValues;
	
	@FindBy (xpath="//button[text()='Copy (JSON)']")
	private WebElement copyAsJson;
	public DataBasePom(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 10);
	}
	@Step("Connect with the database and extact all the data")
	public void salesForceInspector() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(buttonForPopUpSalesforceInspector)).click();
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='insext-popup']")));
		wait.until(ExpectedConditions.elementToBeClickable(textHeader));
		exportData.click();
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		queryValues.clear();
		queryValues.sendKeys("select Id, IsDeleted, MasterRecordId, Name, LastName, FirstName, Salutation, MiddleName from Account");
//		queryValues.sendKeys("c, AppointmentSystemID__c, ApprovalStatus__c, BankCountry__c, BankEmail__c, BankName__c, Blacklisted__c, BranchAddress__c, BrokerAgent__c, BrokerClassification__c, BrokerUserSubmitter__c, ClassificationSalesAmount__c, CurrentValueRating__c, CustomerClass__c, CustomerType__c, DarnaId__c, DateOfRegistration__c, ERPID__c, EmailAddress__c, Email__c, ErrorReason__c, EssadId__c, EstablishmentDate__c, ExistingAccount__c, FacebookId__c, FazaaId__c, IBANNumber__c, InstagramId__c, LinkedinId__c, Loyalty__c, MobileCountryCode__c, MobileNumber1__c, MobileNumberEnc__c, MobileNumber__c, NameInArabic__c, NameOfPOA__c, OriginalCreationDate__c, OtherERPID__c, OwnedBy__c, Owner__c, PhoneNumberEnc__c, Phone__c, PlaceOfRegistration__c, PotentialValueRating__c, PreviousAgencyStatus__c, ProposedExpiryDate__c, PurposeofBuying__c, RegistrationExpiryDate__c, RegistrationIssueDate__c, RegistrationNumber__c, ResidentialAddressSameAsPermanent__c, RetryCount__c, RingfencedUntil__c, SendEmail__c, ServiceRequest__c, SwiftCode__c, SyncStatus__c, SyncTime__c, TradeName__c, TwitterId__c, TypeOfCompany__c, UAEVATRegisterNumber__c, UnifiedNumber__c, UniqueKey1__c, UniqueKey2__c, UniqueKey__c, VIPClass__c, WhatsappNumber__c, YearofEstablished__c, CorporateWealthName__c, CustomerSubType__c, BankAccountNumber__c, OwnerManagerEmail__c, Interested_in_Golden_Visa__c, Agencytoprocessthevisa__c, BlacklistReason__c, GVprocessStatus__c, InterestRecordedon__c, IsAgentChange__c, IsBrokerChange__c, LastSalesOrderClosureDate__c, BrokerAgencyStatus__c, BrokerCompliantStatus__c, Broker_Classification_Formula__c, Logger_Id__c, CurrentAgencyStatus__c, Generate_Appointment_System_Id__c, TransferThresholdLimitExcluded__c, IsNagwaCustomer__c, IsVIP__c, NAGWA_Pin__c, BrokerPremiumClassification__c, AgentID__pc, AgentStatus__pc, AnnualIncome__pc, BrokerType__pc, CompanyAddress__pc, Company__pc, CountryOfResidence__pc, CustomerLocation__pc, ERPID__pc, EmailAddress__pc, EmploymentStatus__pc, DMT_Registration_Number__pc, Gender__pc, Homatcardnumber__pc, LanguagePreference__pc, DarnaMembershipNumber__pc, MaritalStatus__pc, NationalityinArabic__pc, MinorIndicator__pc, MobileCountryCode__pc, MobileNumberEnc__pc, MobilePhone__pc, MotherNameArabic__pc, NationalIdExpiryDate__pc, NationalIdNumber__pc, Nationality__pc, NextBirthday1__pc, NextBirthday__pc, NoofYearswithCompany__pc, OriginalCreationDate__pc, OtherSourceofFunds__pc, PassportExpiryDate__pc, PassportIssueDate__pc, PassportNumber__pc, PassportType__pc, PhoneNumberEnc__pc, PlaceofIssue__pc, Position__pc, PrimaryContact__pc, ResidentStatus__pc, SmartPass__pc, SourceofFunds__pc, UAEPassExists__pc, UaeFamilyBookDateofIssue__pc, UaeFamilyBookNumber__pc, UaeFamilyBookPlaceofIssue__pc, UaeFamilyNumber__pc, VisaExpiryDate__pc, VisaUIDNo__pc, AccountName__pc, OwnerManagerEmail__pc from Account");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(exportButton)).click();
		Thread.sleep(20000);
		wait.until(ExpectedConditions.elementToBeClickable(copyAsJson)).click();
		
	     try {
	            String jsonData = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
//	            System.out.println(jsonData); // Print the copied JSON data

	            // Save the JSON data to a file named "output.json"
	            try (FileWriter fileWriter = new FileWriter("output.json")) {
	                fileWriter.write(jsonData);
	            } catch (IOException e) {
	                e.printStackTrace();
	            }

	        } catch (UnsupportedFlavorException | IOException e) {
	            e.printStackTrace();
	            
	    }
	     
//		List<String> allDataValues1 = new ArrayList<>();
//		for (WebElement element : allDataValues) {
//			allDataValues1.add(element.getText());
//
//		}
//		System.out.println(allDataValues1);
//		JSONObject jsonObject = new JSONObject();
//		jsonObject.put("message", allDataValues1);

		// Write the JSON object to a file
//		try (FileWriter fileWriter = new FileWriter("output1.json")) {
//			fileWriter.write(jsonObject.toString());
//			System.out.println("Data has been written to the file 'output.json'");
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}


}
