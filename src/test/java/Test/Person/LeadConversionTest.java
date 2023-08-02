package Test.Person;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseClass;
import Utility.ExcleReader;
import Utility.UtilClass;
import io.qameta.allure.Step;

public class LeadConversionTest extends BaseClass {
	@Test(description = "Verify user able to change the status of lead to 'Qualified Lead' and after that its show as 'converted lead'")
	public void qualifiedToConvertedLeadTC001() throws EncryptedDocumentException, InterruptedException, IOException {
		//login to sandbox using the Sales manager credentials and Create the lead As the person.
		login.loginToSandBox(prop.getProperty("Username"),prop.getProperty("Password"));
		leads.leadCreations("Autmation" + UtilClass.generateRandomNumbers(3),"Automation", "Autmation" + UtilClass.generateRandomNumbers(5));
		System.out.println(ExcleReader.excleReader("Lead Creation", 2, 1)+"++++++++++++++++++++");
		String lead = leads.leadName();
		leads.taskStatus();
		super.driver.navigate().back();
		//logout from the account
		logoutUserFromSandBox.logoutUser();
		//login with the Admin username and password and update the Mobile number and Email 
		login.loginToSandBox(prop.getProperty("AdminUsername"),prop.getProperty("AdminPassword"));
		adminLead.searchLeadAndUpdateIt(lead);
		adminLead.enterEamilId("abd" + UtilClass.randomNameGenerator(4) + "@gmail.com");
		leads.waitUntilEmailIdDisplay();
		leads.withoutSangType(BaseClass.jsonArrayValue("DropDown","mobile number code"),BaseClass.jsonArrayValue("DropDown Values","mobile number code value"));
		adminLead.setMobileNumber(UtilClass.generateRandomMobileNumber());
		leads.saveLeadInformation();
		//logout from the account
		logoutUserFromSandBox.logoutUser();
		//login to sandbox using the Sales manager credentials and after the update informations check the status Converted lead Status.
		login.loginToSandBox(prop.getProperty("Username"),prop.getProperty("Password"));
		adminLead.serchAndUpdateItData(lead);
		leads.leadStatusUpdate();
		leads.qulifiedLeadUpdate2();
		String status = leads.leadStatusCheckItsConverted();
		Assert.assertEquals(status,BaseClass.jsonArrayValue("Asserations","Converted lead Status"));
		logoutUserFromSandBox.logoutUser();
	}
	
	@Test(description = "Verify lead has been converted to Opportunity and new account is created if 'Name','Email','Phone Number' does not matches with existing Account. ")
	public void opportunityLeadTC002() throws EncryptedDocumentException, InterruptedException, IOException {
		//login to sandbox using the Sales manager credentials and Create the lead As the person.
		login.loginToSandBox(prop.getProperty("Username"),prop.getProperty("Password"));
		leads.leadCreations("Autmation" + UtilClass.generateRandomNumbers(3),
				"Automation", "Autmation" + UtilClass.generateRandomNumbers(5));
		System.out.println(ExcleReader.excleReader("Lead Creation", 2, 1)+"{{{{{{{{{{{{{{{{{{");
		String lead = leads.leadName();
		leads.taskStatus();
		super.driver.navigate().back();
		logoutUserFromSandBox.logoutUser();
		//login with the Admin username and password and update the Mobile number and Email 
		login.loginToSandBox(prop.getProperty("AdminUsername"),prop.getProperty("AdminPassword"));
		String substring = adminLead.searchLeadAndUpdateIt(lead);
		adminLead.enterEamilId("abd" + UtilClass.randomNameGenerator(4) + "@gmail.com");
		leads.waitUntilEmailIdDisplay();
		leads.withoutSangType(BaseClass.jsonArrayValue("DropDown","mobile number code"),BaseClass.jsonArrayValue("DropDown Values","mobile number code value"));
		adminLead.setMobileNumber(UtilClass.generateRandomMobileNumber());
		leads.saveLeadInformation();
		//logout from the account
		logoutUserFromSandBox.logoutUser();
		//login to sandbox using the Sales manager credentials and after the update informations check the status Converted lead Status and check this new account added.
		login.loginToSandBox(prop.getProperty("Username"),prop.getProperty("Password"));
		adminLead.serchAndUpdateItData(lead);
		leads.leadStatusUpdate();
		leads.qulifiedLeadUpdate2();
		String status = leads.leadStatusCheckItsConverted();
		Assert.assertEquals(status,BaseClass.jsonArrayValue("Asserations","Converted lead Status"));
		adminLead.globalSearchLeadName(substring);
		Assert.assertEquals(unitSel.opportiesText(),true);
		logoutUserFromSandBox.logoutUser();
	}
	@Test (description="Verify the user able to update the mobile number and email id after login with the admin")
	public void adminLoginEmailMobUpdateTC003() throws InterruptedException, EncryptedDocumentException, IOException {
		login.loginToSandBox(prop.getProperty("Username"),prop.getProperty("Password"));
		leads.leadCreations("Autmation" + UtilClass.generateRandomNumbers(3),
				"Automation", "Autmation" + UtilClass.generateRandomNumbers(5));
		String lead = leads.leadName();
		leads.taskStatus();
		super.driver.navigate().back();
		logoutUserFromSandBox.logoutUser();
		login.loginToSandBox(prop.getProperty("AdminUsername"),prop.getProperty("AdminPassword"));
		String substring = adminLead.searchLeadAndUpdateIt(lead);
		adminLead.enterEamilId("abd" + UtilClass.randomNameGenerator(4) + "@gmail.com");
		leads.waitUntilEmailIdDisplay();
		leads.withoutSangType(BaseClass.jsonArrayValue("DropDown","mobile number code"),BaseClass.jsonArrayValue("DropDown Values","mobile number code value"));
		adminLead.setMobileNumber(UtilClass.generateRandomMobileNumber());
		leads.saveLeadInformation();
		logoutUserFromSandBox.logoutUser();
	}
	@Test (description="Verfiy the user able to enter the all the dropdown after click on 'Qualified Lead'")
	public void qualifiedLeadDropdownTC004() throws InterruptedException, EncryptedDocumentException, IOException {
		login.loginToSandBox(prop.getProperty("Username"),prop.getProperty("Password"));
		leads.leadCreations("Autmation" + UtilClass.generateRandomNumbers(3),
				"Automation", "Autmation" + UtilClass.generateRandomNumbers(5));
		String lead = leads.leadName();
		leads.taskStatus();
		super.driver.navigate().back();
		logoutUserFromSandBox.logoutUser();
		login.loginToSandBox(prop.getProperty("AdminUsername"),prop.getProperty("AdminPassword"));
		adminLead.searchLeadAndUpdateIt(lead);
		adminLead.enterEamilId("abd" + UtilClass.randomNameGenerator(4) + "@gmail.com");
		leads.waitUntilEmailIdDisplay();
		leads.withoutSangType(BaseClass.jsonArrayValue("DropDown","mobile number code"),BaseClass.jsonArrayValue("DropDown Values","mobile number code value"));
		adminLead.setMobileNumber(UtilClass.generateRandomMobileNumber());
		leads.saveLeadInformation();
		logoutUserFromSandBox.logoutUser();
		login.loginToSandBox(prop.getProperty("Username"),prop.getProperty("Password"));
		adminLead.serchAndUpdateItData(lead);
		leads.leadStatusUpdate();
		leads.qulifiedLeadUpdate2();
		logoutUserFromSandBox.logoutUser();
	}
	@Test(description = "Verify user canot able to change the status of lead to 'Qualified Lead' if the mobile number and email Id not updated in the admin")
	public void qualifiedLeadWithouMobAndEmailIDTC005() throws EncryptedDocumentException, InterruptedException, IOException {
		login.loginToSandBox(prop.getProperty("Username"),prop.getProperty("Password"));
		leads.leadCreations("Autmation" + UtilClass.generateRandomNumbers(3),
				"Automation","Autmation" + UtilClass.generateRandomNumbers(5));
		String lead = leads.leadName();
		leads.taskStatus();
		super.driver.navigate().back();
		leads.leadStatusUpdate();
		Assert.assertEquals(leads.hitSang(),BaseClass.jsonArrayValue("Asserations","Review error on page"));			
		logoutUserFromSandBox.logoutUser();
	}
	

}
