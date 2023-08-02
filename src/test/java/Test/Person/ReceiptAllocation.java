package Test.Person;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseClass;
import Utility.ExcleReader;
import Utility.UtilClass;

public class ReceiptAllocation extends BaseClass{
	String substring;
	@Test(description = "Verify that user able to book unit and also make the relations with the account so 'paid of' in recipts is enable")
	public void TC001() throws EncryptedDocumentException, InterruptedException, IOException {
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
		unitSel.accountLinkClcikFromTheOpporites();
		receipt.relationsMaking();
		leads.withoutSangType(BaseClass.jsonArrayValue("DropDown","Relationship Type"),BaseClass.jsonArrayValue("DropDown Values","Relationship Type value"));
		receipt.seletionOfRealtedAccount();
		leads.saveLeadInformation();
		adminLead.globalSearchLeadName(substring);
		unitSel.clickOnOpp();
		boolean exlmetoryMark = leads.unitSearch();
		adminLead.globalSearchLeadName(substring);
		unitSel.clickOnOpp();
		leads.unitSearch();
		unitSel.selectionOftheUnit(BaseClass.jsonArrayValue("DropDown","Projects"),BaseClass.jsonArrayValue("DropDown Values","Projects value"));
		unitSel.dropDownSelectionUnit();
		logoutUserFromSandBox.logoutUser();
	}
	@Test(description = "Verify that, after the book unit is successfully completed, the user is able to see the sales order generated in the account tab.",dependsOnMethods="T001")
	public void TC002() throws InterruptedException {
		login.loginToSandBox(prop.getProperty("Username"),prop.getProperty("Password"));
		adminLead.globalSearchLeadName(substring);
		unitSel.accountLinkClcikFromTheOpporites();
		Assert.assertEquals(receipt.salesOrderNumber(),"(1)");
		logoutUserFromSandBox.logoutUser();
	}
	@Test (description="Verify user able to fill all types of the installment and sales order other charges 'Receipt Acknowledgement Creation' all the informations and check the status is pending",dependsOnMethods="T001")
	public void TC004() throws InterruptedException {
		login.loginToSandBox(prop.getProperty("Username"),prop.getProperty("Password"));
		adminLead.globalSearchLeadName(substring);
		unitSel.accountLinkClcikFromTheOpporites();
		Assert.assertEquals(receipt.salesOrderNumber(),"(1)");
		boolean value=receipt.withoutClosePopUp();
		Assert.assertEquals(value,true);
		unitSel.selectionOftheUnit("Select an Option", "Cheque");	
		receipt.enterTheValuesInThePopUp();
		unitSel.selectionOftheUnit("Select an Option", "Abu Dhabi Commercial Bank");
		receipt.selectionOFPaidOF("Select an Option");
		Assert.assertEquals(receipt.enterRemark(),true);
		receipt.installmentLines();
		receipt.selectSecoundRecipts();
		unitSel.selectionOftheUnit("Select an Option", "Cheque");	
		receipt.enterTheValuesInThePopUp();
		unitSel.selectionOftheUnit("Select an Option", "Abu Dhabi Commercial Bank");
		receipt.selectionOFPaidOF("Select an Option");
		Assert.assertEquals(receipt.enterRemark(),true);
		receipt.installMentSelections();
		receipt.receptsForSalesOrder();
		unitSel.selectionOftheUnit("Select an Option", "Cheque");	
		receipt.enterTheValuesInThePopUp();
		unitSel.selectionOftheUnit("Select an Option", "Abu Dhabi Commercial Bank");
		receipt.selectionOFPaidOF("Select an Option");
		Assert.assertEquals(receipt.enterRemark(),true);
		receipt.receptsForSalesOrder();
		unitSel.selectionOftheUnit("Select an Option", "Cheque");	
		receipt.enterTheValuesInThePopUp();
		unitSel.selectionOftheUnit("Select an Option", "Abu Dhabi Commercial Bank");
		receipt.selectionOFPaidOF("Select an Option");
		Assert.assertEquals(receipt.enterRemark(),true);
		Assert.assertEquals(receipt.salesOrderLinkClick(),"Pending");;
		logoutUserFromSandBox.logoutUser();
	}
	@Test(description="Verify that user able to change the status pending to close after the admin login",dependsOnMethods="T004")
	public void TC005() throws InterruptedException {
		login.loginToSandBox(prop.getProperty("AdminUsername"),prop.getProperty("AdminPassword"));
		adminLead.globalSearchLeadName("Autmation804 Automation Autmation19008");
		unitSel.accountLinkClcikFromTheOpporites();
		Assert.assertEquals(receipt.salesOrderNumber(),"(1)");
		receipt.adminSalesOrder("1");
		receipt.clearValueSelections();
		leads.saveLeadInformation();
		Thread.sleep(2000);
		driver.navigate().back();
		receipt.adminSalesOrder("2");
		receipt.clearValueSelections();
		leads.saveLeadInformation();
		Thread.sleep(2000);
		driver.navigate().back();
		receipt.adminSalesOrder("3");
		receipt.clearValueSelections();
		leads.saveLeadInformation();
		Thread.sleep(2000);
		driver.navigate().back();
		receipt.adminSalesOrder("4");
		receipt.clearValueSelections();
		leads.saveLeadInformation();
		Thread.sleep(2000);
		driver.navigate().back();
	}
}
