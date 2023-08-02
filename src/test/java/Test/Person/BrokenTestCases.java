//package Test.Person;
//
//import java.io.IOException;
//
//import org.apache.poi.EncryptedDocumentException;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//
//import Base.BaseClass;
//import Utility.ExcleReader;
//import Utility.UtilClass;
//
//public class BrokenTestCases extends BaseClass{
//	String substring;
//	@Test(description = "Verify that when the admin login and search for the lead with unique lead number then it displayed")
//	public void T001() throws EncryptedDocumentException, InterruptedException, IOException {
//		login.loginToSandBox(prop.getProperty("Username"),prop.getProperty("Password"));
//		leads.leadCreations("Autmation" + UtilClass.generateRandomNumbers(3),
//				ExcleReader.excleReader("Lead Creation", 2, 1), "Autmation" + UtilClass.generateRandomNumbers(5));
//		String lead = leads.leadName();
//		leads.taskStatus();
//		super.driver.navigate().back();
//		logoutUserFromSandBox.logoutUser();
//		login.loginToSandBox("arbaaz.khan@infobeans.com.regsb", "Amk@0101.IT");
//		String searchButton1 = adminLead.asserationForSerach();
//		Assert.assertEquals(searchButton1, "Search...");
//		Assert.assertEquals(adminLead.adminTestCase(lead),"Don't give up yet!");	
//		logoutUserFromSandBox.logoutUser();
//	}
//	@Test(description = "Verify if the user convert lead into 'qulified lead' and search globally then the 'opporties'and 'account'is displayed")
//	public void T002() throws EncryptedDocumentException, InterruptedException, IOException {
//		login.loginToSandBox(prop.getProperty("Username"),prop.getProperty("Password"));
//		leads.leadCreations("Autmation" + UtilClass.generateRandomNumbers(3),
//				ExcleReader.excleReader("Lead Creation", 2, 1), "Autmation" + UtilClass.generateRandomNumbers(5));
//		String lead = leads.leadName();
//		leads.taskStatus();
//		super.driver.navigate().back();
//		logoutUserFromSandBox.logoutUser();
//		login.loginToSandBox("arbaaz.khan@infobeans.com.regsb", "Amk@0101.IT");
//		String searchButton1 = adminLead.asserationForSerach();
//		Assert.assertEquals(searchButton1, "Search...");
//		substring = adminLead.searchLeadAndUpdateIt(lead);
//		System.out.println(substring + "{{{{{{{");
//		adminLead.enterEamilId("abd" + UtilClass.randomNameGenerator(3) + "@gmail.com");
//		leads.waitUntilEmailIdDisplay();
//		String codeNone = leads.mobileNumberCode();
//		Assert.assertEquals(codeNone, "--None--");
//		leads.withoutSangType("Mobile Country Code, --None--", "United Arab Emirates(+971)");
//		adminLead.setMobileNumber(UtilClass.generateRandomMobileNumber());
//		leads.saveLeadInformation();
//		String imagePresent = logoutUserFromSandBox.logoValidation();
//		Assert.assertEquals(imagePresent, "User");
//		logoutUserFromSandBox.logoutUser();
//		login.loginToSandBox(ExcleReader.excleReader("Login", 2, 1), ExcleReader.excleReader("Login", 3, 1));
//		String searchButton2 = adminLead.asserationForSerach();
//		Assert.assertEquals(searchButton1, "Search...");
//		adminLead.serchAndUpdateItData(lead);
//		leads.leadStatusUpdate();
//		String valueBeforSelectionLeadStatus = leads.inprocessLeadUpdate();
//		Assert.assertEquals(valueBeforSelectionLeadStatus, "In Progress Lead");
//		leads.qulifiedLeadUpdate2();
//		String status = leads.leadStatusCheckItsConverted();
//		Assert.assertEquals(status, "Converted Lead");
//		adminLead.globalSearchLeadName(substring);
//		System.out.println(substring + "{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}");
//		Assert.assertEquals(leads.withoutRefershOpporties(),false);
//		logoutUserFromSandBox.logoutUser();
//	}
//	@Test(description = "Verify Book unit button able to click after entering all the mandatory details.")
//	public void T003() throws EncryptedDocumentException, InterruptedException, IOException {
//		login.loginToSandBox(prop.getProperty("Username"),prop.getProperty("Password"));
//		leads.leadCreations("Autmation" + UtilClass.generateRandomNumbers(3),
//				ExcleReader.excleReader("Lead Creation", 2, 1), "Autmation" + UtilClass.generateRandomNumbers(5));
//		String lead = leads.leadName();
//		leads.taskStatus();
//		super.driver.navigate().back();
//		logoutUserFromSandBox.logoutUser();
//		login.loginToSandBox("arbaaz.khan@infobeans.com.regsb", "Amk@0101.IT");
//		String searchButton1 = adminLead.asserationForSerach();
//		Assert.assertEquals(searchButton1, "Search...");
//		substring = adminLead.searchLeadAndUpdateIt(lead);
//		System.out.println(substring + "{{{{{{{");
//		adminLead.enterEamilId("abd" + UtilClass.randomNameGenerator(3) + "@gmail.com");
//		leads.waitUntilEmailIdDisplay();
//		String codeNone = leads.mobileNumberCode();
//		Assert.assertEquals(codeNone, "--None--");
//		leads.withoutSangType("Mobile Country Code, --None--", "United Arab Emirates(+971)");
//		adminLead.setMobileNumber(UtilClass.generateRandomMobileNumber());
//		leads.saveLeadInformation();
//		String imagePresent = logoutUserFromSandBox.logoValidation();
//		Assert.assertEquals(imagePresent, "User");
//		logoutUserFromSandBox.logoutUser();
//		login.loginToSandBox(ExcleReader.excleReader("Login", 2, 1), ExcleReader.excleReader("Login", 3, 1));
//		String searchButton2 = adminLead.asserationForSerach();
//		Assert.assertEquals(searchButton1, "Search...");
//		adminLead.serchAndUpdateItData(lead);
//		leads.leadStatusUpdate();
//		String valueBeforSelectionLeadStatus = leads.inprocessLeadUpdate();
//		Assert.assertEquals(valueBeforSelectionLeadStatus, "In Progress Lead");
//		leads.qulifiedLeadUpdate2();
//		String status = leads.leadStatusCheckItsConverted();
//		Assert.assertEquals(status, "Converted Lead");
//		adminLead.globalSearchLeadName(substring);
//		System.out.println(substring + "{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}");
//		leads.clickOnTheAccountLinkAfterGobalSearch();
//		unitSel.accountClcikInOpp();
//		String gender = unitSel.genderSelection();
//		Assert.assertEquals(gender, "--None--");
//		leads.withoutSangType("Gender, --None--", "Male");
//		unitSel.addDetailsInAccounts("01/05/1789", "Date of Birth", "PersonBirthdate");
//		leads.corrporateWelthName("Marital Status, --None--", "Single", "Marital Status");
//		leads.corrporateWelthName("Residential Address same as Permanent?, --None--", "Yes",
//				"Residential Address same as Permanent?");
//		unitSel.addDetailsInAccounts("N/A", "Passport Type", "PassportType__pc");
//		unitSel.addDetailsInAccounts("N/A", "Place of Issue", "PlaceofIssue__pc");
//		unitSel.addDetailsInAccounts("01/05/1989", "Passport Issue Date", "PassportIssueDate__pc");
//		unitSel.addDetailsInAccounts("01/05/1990", "Passport Expiry Date", "PassportExpiryDate__pc");
//		unitSel.addDetailsInAccounts("N/A", "Passport Number", "PassportNumber__pc");
//		leads.corrporateWelthName("Employment Status, --None--", "Unemployed", "Employment Status");
//		unitSel.addressUpdate("N/A");
//		unitSel.textAreaAddressInput("N/A");
//		unitSel.setValuesInInputAddress("N/A", "postalCode");
//		unitSel.setValuesInInputAddress("N/A", "city");
//		boolean saveChagesPopup = unitSel.saveInfoWithoutPause();
//		Assert.assertEquals(saveChagesPopup,true);
//		unitSel.relationship();
//		logoutUserFromSandBox.logoutUser();
//		
//	}
//	@Test(description = "Verify that when the user upload documents then the status is still '[0]'")
//	public void T004() throws EncryptedDocumentException, InterruptedException, IOException {
//		login.loginToSandBox(prop.getProperty("Username"),prop.getProperty("Password"));
//		leads.leadCreations("Autmation" + UtilClass.generateRandomNumbers(3),
//				ExcleReader.excleReader("Lead Creation", 2, 1), "Autmation" + UtilClass.generateRandomNumbers(5));
//		String lead = leads.leadName();
//		leads.taskStatus();
//		super.driver.navigate().back();
//		logoutUserFromSandBox.logoutUser();
//		login.loginToSandBox("arbaaz.khan@infobeans.com.regsb", "Amk@0101.IT");
//		String searchButton1 = adminLead.asserationForSerach();
//		Assert.assertEquals(searchButton1, "Search...");
//		substring = adminLead.searchLeadAndUpdateIt(lead);
//		System.out.println(substring + "{{{{{{{");
//		adminLead.enterEamilId("abd" + UtilClass.randomNameGenerator(3) + "@gmail.com");
//		leads.waitUntilEmailIdDisplay();
//		String codeNone = leads.mobileNumberCode();
//		Assert.assertEquals(codeNone, "--None--");
//		leads.withoutSangType("Mobile Country Code, --None--", "United Arab Emirates(+971)");
//		adminLead.setMobileNumber(UtilClass.generateRandomMobileNumber());
//		leads.saveLeadInformation();
//		String imagePresent = logoutUserFromSandBox.logoValidation();
//		Assert.assertEquals(imagePresent, "User");
//		logoutUserFromSandBox.logoutUser();
//		login.loginToSandBox(ExcleReader.excleReader("Login", 2, 1), ExcleReader.excleReader("Login", 3, 1));
//		String searchButton2 = adminLead.asserationForSerach();
//		Assert.assertEquals(searchButton1, "Search...");
//		adminLead.serchAndUpdateItData(lead);
//		leads.leadStatusUpdate();
//		String valueBeforSelectionLeadStatus = leads.inprocessLeadUpdate();
//		Assert.assertEquals(valueBeforSelectionLeadStatus, "In Progress Lead");
//		leads.qulifiedLeadUpdate2();
//		String status = leads.leadStatusCheckItsConverted();
//		Assert.assertEquals(status, "Converted Lead");
//		adminLead.globalSearchLeadName(substring);
//		System.out.println(substring + "{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}{}");
//		leads.clickOnTheAccountLinkAfterGobalSearch();
//		unitSel.accountClcikInOpp();
//		String gender = unitSel.genderSelection();
//		Assert.assertEquals(gender, "--None--");
//		String relationshipText = unitSel.saveInfo();
//		Assert.assertEquals(relationshipText, "Relationships");
//		unitSel.relationship();
//		String numberValue=unitSel.numberOfTheDocuments("National ID Back Copy", "3");
//		Assert.assertEquals(numberValue, "1");
//		logoutUserFromSandBox.logoutUser();
//	}
//}
