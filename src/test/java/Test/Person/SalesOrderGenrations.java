package Test.Person;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseClass;
import Utility.ExcleReader;
import Utility.UtilClass;

public class SalesOrderGenrations extends BaseClass  {
	String substring;
	@Test(description = "Verify Book unit button able to click after entering all the mandatory details.")
	public void bookUnitAfterClickAllMandatoryDetailsTC001() throws EncryptedDocumentException, InterruptedException, IOException {
		login.loginToSandBox(prop.getProperty("Username"),prop.getProperty("Password"));
		leads.leadCreations("Autmation" + UtilClass.generateRandomNumbers(3),
				"Automation", "Autmation" + UtilClass.generateRandomNumbers(5));
		String lead = leads.leadName();
		leads.taskStatus();
		super.driver.navigate().back();
		logoutUserFromSandBox.logoutUser();
		login.loginToSandBox(prop.getProperty("AdminUsername"),prop.getProperty("AdminPassword"));
		String searchButton1 = adminLead.asserationForSerach();
		Assert.assertEquals(searchButton1, BaseClass.jsonArrayValue("Asserations","Search Asserations"));
		substring = adminLead.searchLeadAndUpdateIt(lead);
		System.out.println(substring);
		adminLead.enterEamilId("abd" + UtilClass.randomNameGenerator(3) + "@gmail.com");
		leads.waitUntilEmailIdDisplay();
		String codeNone = leads.mobileNumberCode();
		Assert.assertEquals(codeNone, "--None--");
		leads.withoutSangType(BaseClass.jsonArrayValue("DropDown","mobile number code"),BaseClass.jsonArrayValue("DropDown Values","mobile number code value"));
		adminLead.setMobileNumber(UtilClass.generateRandomMobileNumber());
		leads.saveLeadInformation();
		String imagePresent = logoutUserFromSandBox.logoValidation();
		Assert.assertEquals(imagePresent, BaseClass.jsonArrayValue("Asserations","user logoutButton"));
		logoutUserFromSandBox.logoutUser();
		login.loginToSandBox(prop.getProperty("Username"),prop.getProperty("Password"));
		String searchButton2 = adminLead.asserationForSerach();
		Assert.assertEquals(searchButton1,BaseClass.jsonArrayValue("Asserations","Search Asserations"));
		adminLead.serchAndUpdateItData(lead);
		leads.leadStatusUpdate();
		String valueBeforSelectionLeadStatus = leads.inprocessLeadUpdate();
		Assert.assertEquals(valueBeforSelectionLeadStatus,BaseClass.jsonArrayValue("Asserations","Lead Status in process"));
		leads.qulifiedLeadUpdate2();
		String status = leads.leadStatusCheckItsConverted();
		Assert.assertEquals(status,BaseClass.jsonArrayValue("Asserations","Converted lead Status"));
		adminLead.globalSearchLeadName(substring);
		System.out.println(substring);
		leads.clickOnTheAccountLinkAfterGobalSearch();
		unitSel.accountClcikInOpp();
		String gender = unitSel.genderSelection();
		Assert.assertEquals(gender, "--None--");
		leads.withoutSangType(BaseClass.jsonArrayValue("DropDown","gender selection"),BaseClass.jsonArrayValue("DropDown Values","gender selection value"));
		unitSel.addDetailsInAccounts("01/05/1789", "Date of Birth", "PersonBirthdate");
		leads.corrporateWelthName(BaseClass.jsonArrayValue("DropDown","marital Status"),BaseClass.jsonArrayValue("DropDown Values","marital status value"),BaseClass.jsonArrayValue("Sang values","marital status sang value"));
		leads.corrporateWelthName(BaseClass.jsonArrayValue("DropDown","residential status"),BaseClass.jsonArrayValue("DropDown Values","residentail status value"),BaseClass.jsonArrayValue("Sang values","residental status sang value"));
		unitSel.addDetailsInAccounts(BaseClass.jsonArrayValue("Update input feild","N/A value"),BaseClass.jsonArrayValue("Sang values","passport type value"),BaseClass.jsonArrayValue("Sang value input","Passport value"));
		unitSel.addDetailsInAccounts(BaseClass.jsonArrayValue("Update input feild","N/A value"), BaseClass.jsonArrayValue("Sang values","place of issue"),BaseClass.jsonArrayValue("Sang value input","PlaceofIssue value"));
		unitSel.addDetailsInAccounts(BaseClass.jsonArrayValue("Update input feild","Date passport issue"),BaseClass.jsonArrayValue("Sang values","Passport Issue"),BaseClass.jsonArrayValue("Sang value input","Passport issue value"));
		unitSel.addDetailsInAccounts(BaseClass.jsonArrayValue("Update input feild","Date passport expiry"),BaseClass.jsonArrayValue("Sang values","Passport Expiry"),BaseClass.jsonArrayValue("Sang value input","Passport Expiry Date value"));
		unitSel.addDetailsInAccounts(BaseClass.jsonArrayValue("Update input feild","N/A value"), BaseClass.jsonArrayValue("Sang values","Passport num"), BaseClass.jsonArrayValue("Sang value input","Passport Number value"));
		leads.corrporateWelthName(BaseClass.jsonArrayValue("DropDown","employmet status"),BaseClass.jsonArrayValue("DropDown Values","employmet status value"),BaseClass.jsonArrayValue("Sang values","employmet sang value"));
		unitSel.addressUpdate(BaseClass.jsonArrayValue("Update input feild","N/A value"));
		unitSel.textAreaAddressInput(BaseClass.jsonArrayValue("Update input feild","N/A value"));
		unitSel.setValuesInInputAddress(BaseClass.jsonArrayValue("Update input feild","N/A value"),BaseClass.jsonArrayValue("Sang values","postal"));
		unitSel.setValuesInInputAddress(BaseClass.jsonArrayValue("Update input feild","N/A value"),BaseClass.jsonArrayValue("Sang values","Type of city"));
		String relationshipText = unitSel.saveInfo();
		Assert.assertEquals(relationshipText, "Relationships");
		unitSel.relationship();
		unitSel.uploadDocuments("National ID Back Copy", "3");
		unitSel.uploadDocuments("National ID Front Copy", "4");
		unitSel.uploadDocuments("Passport Copy", "6");
		unitSel.uploadDocuments("Signed KYC Form", "7");
		adminLead.globalSearchLeadName(substring);
		unitSel.detailsInOpporties();
		Assert.assertEquals(unitSel.salesTypesText(), true);
		unitSel.dropdownFromDetailsHandle(BaseClass.jsonArrayValue("DropDown","Sale Type"),BaseClass.jsonArrayValue("DropDown Values","sales types value"));
		unitSel.dropdownFromDetailsHandle(BaseClass.jsonArrayValue("DropDown","Deal Type"),BaseClass.jsonArrayValue("DropDown Values","Deal Type value"));
		unitSel.dropdownFromDetailsHandle(BaseClass.jsonArrayValue("DropDown","Booking Type"),BaseClass.jsonArrayValue("DropDown Values","Booking Type value"));
		unitSel.dropdownFromDetailsHandle(BaseClass.jsonArrayValue("DropDown","Agent Type"),BaseClass.jsonArrayValue("DropDown Values","Agent Type value"));
		unitSel.dropdownFromDetailsHandle(BaseClass.jsonArrayValue("DropDown","Delivery Method"),BaseClass.jsonArrayValue("DropDown Values","Delivery Method value"));
		unitSel.saveButton();
		adminLead.globalSearchLeadName(substring);
		unitSel.clickOnOpp();
		boolean exlmetoryMark = leads.unitSearch();
		logoutUserFromSandBox.logoutUser();
	}

	@Test(description = "Verify if \"payment and offer selection\" is visible after user click on book Unit(s).",dependsOnMethods="bookUnitAfterClickAllMandatoryDetailsTC001")
	public void paymentAndOfferBookUnitTC002() throws EncryptedDocumentException, InterruptedException, IOException {
		login.loginToSandBox(prop.getProperty("Username"),prop.getProperty("Password"));
		adminLead.globalSearchLeadName(substring);
		unitSel.clickOnOpp();
		leads.unitSearch();
		unitSel.selectionOftheUnit("Projects, Select an Option", "MoonTown");
		unitSel.payMeantAndOffers();
		logoutUserFromSandBox.logoutUser();
		
	}
	@Test(description = "Verify if new field\"Mortgage bank\" appears after selecting Yes in mortgage applicable fields.",dependsOnMethods="bookUnitAfterClickAllMandatoryDetailsTC001")
	public void mortgageBankUncheckBookUnitTC004() throws EncryptedDocumentException, InterruptedException, IOException {
		login.loginToSandBox(prop.getProperty("Username"),prop.getProperty("Password"));
		adminLead.globalSearchLeadName(substring);
		unitSel.clickOnOpp();
		leads.unitSearch();
		unitSel.selectionOftheUnit("Projects, Select an Option", "MoonTown");
		unitSel.mortageDisplayed();
		logoutUserFromSandBox.logoutUser();
	}
	@Test(description = "Verify if \"Customer contact details are verfied\" checkbox and \"Win Reason\" dropdown is mandatory for Booking unit.",dependsOnMethods="bookUnitAfterClickAllMandatoryDetailsTC001")
	public void winResonAfterBookUnitTC005() throws EncryptedDocumentException, InterruptedException, IOException {
		login.loginToSandBox(prop.getProperty("Username"),prop.getProperty("Password"));
		adminLead.globalSearchLeadName(substring);
		unitSel.clickOnOpp();
		leads.unitSearch();
		unitSel.selectionOftheUnit("Projects, Select an Option", "MoonTown");
		unitSel.winReason();
		logoutUserFromSandBox.logoutUser();
	}
	
	@Test(description="Verify user able to book unit after the all meditory feild are updated",dependsOnMethods="bookUnitAfterClickAllMandatoryDetailsTC001")
	public void TC003() throws EncryptedDocumentException, InterruptedException, IOException {
		login.loginToSandBox(prop.getProperty("Username"),prop.getProperty("Password"));
		adminLead.globalSearchLeadName(substring);
		unitSel.clickOnOpp();
		leads.unitSearch();
		logoutUserFromSandBox.logoutUser();
	}
	@Test(description="Verify if Sales Order is created when user completes the Unit Booking process.",dependsOnMethods="bookUnitAfterClickAllMandatoryDetailsTC001")
	public void salesOrderUnitBookingTC006() throws EncryptedDocumentException, InterruptedException, IOException {
		login.loginToSandBox(prop.getProperty("Username"),prop.getProperty("Password"));
		adminLead.globalSearchLeadName(substring);
		unitSel.clickOnOpp();
		leads.unitSearch();
		unitSel.selectionOftheUnit("Projects, Select an Option", "MoonTown");
		unitSel.dropDownSelectionUnit();
		logoutUserFromSandBox.logoutUser();
	}
	@Test(description="Verify that when the user click on the 'Proceed' button without select offer then error is displayed",dependsOnMethods="bookUnitAfterClickAllMandatoryDetailsTC001")
	public void proceedButttonWithoutSelectOfferTC007() throws EncryptedDocumentException, InterruptedException, IOException {
		login.loginToSandBox(prop.getProperty("Username"),prop.getProperty("Password"));
		adminLead.globalSearchLeadName(substring);
		unitSel.clickOnOpp();
		leads.unitSearch();
		unitSel.selectionOftheUnit("Projects, Select an Option", "MoonTown");
		Assert.assertEquals(unitSel.errorWithoutOffer(), true);
		logoutUserFromSandBox.logoutUser();
	}
	@Test(description="Verify that when the user select only  'Win Reason' without 'Customer Contact Details are Verified' then book unit button is not enable",dependsOnMethods="bookUnitAfterClickAllMandatoryDetailsTC001")
	public void bookUnitNotEnableWithoutCustomerContactDetaileVerifiedTC008() throws EncryptedDocumentException, InterruptedException, IOException {
		login.loginToSandBox(prop.getProperty("Username"),prop.getProperty("Password"));
		adminLead.globalSearchLeadName(substring);
		unitSel.clickOnOpp();
		leads.unitSearch();
		unitSel.selectionOftheUnit("Projects, Select an Option", "MoonTown");
		Assert.assertEquals(unitSel.checkBoxNotSelections(), false);
		logoutUserFromSandBox.logoutUser();
	}
	@Test(description="Verify that when the user select only 'Customer Contact Details are Verified' without  'Win Reason'  then book unit button is not enable",dependsOnMethods="bookUnitAfterClickAllMandatoryDetailsTC001")
	public void withoutWinResonUnitButtonNotEnableTC009() throws EncryptedDocumentException, InterruptedException, IOException {
		login.loginToSandBox(prop.getProperty("Username"),prop.getProperty("Password"));
		adminLead.globalSearchLeadName(substring);
		unitSel.clickOnOpp();
		leads.unitSearch();
		unitSel.selectionOftheUnit("Projects, Select an Option", "MoonTown");
		Assert.assertEquals(unitSel.withoutWinReson(), false);
		logoutUserFromSandBox.logoutUser();
	}
	@Test(description="Verify that when the user select only 'Customer Contact Details are Verified' without  'Win Reason'  then book unit button is enable",dependsOnMethods="bookUnitAfterClickAllMandatoryDetailsTC001")
	public void withoutWinResonUnitButtonEnableTC0010() throws EncryptedDocumentException, InterruptedException, IOException {
		login.loginToSandBox(prop.getProperty("Username"),prop.getProperty("Password"));
		adminLead.globalSearchLeadName(substring);
		unitSel.clickOnOpp();
		leads.unitSearch();
		unitSel.selectionOftheUnit("Projects, Select an Option", "MoonTown");
		Assert.assertEquals(unitSel.enableBookUnitWithoutMortage(), true);
		logoutUserFromSandBox.logoutUser();
	}
}
