package Test.Person;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseClass;
import Utility.ExcleReader;
import Utility.UtilClass;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class LeadsCreationTest extends BaseClass {
	private WebDriver driver;

	@Test(description = "Verify associated task automatically completed when lead is created with same user (Sales Manager).", priority = 3)
	public void associatedTaskAutomaticallyCompletedTC001() throws InterruptedException, EncryptedDocumentException, IOException {
		login.loginToSandBox(prop.getProperty("Username"), prop.getProperty("Password"));
		leads.leadCreations("Autmation" + UtilClass.generateRandomNumbers(3),
				"Automation", "Autmation" + UtilClass.generateRandomNumbers(5));
		String statusOfleads = leads.taskStatus();
		Assert.assertEquals(statusOfleads,BaseClass.jsonArrayValue("Asserations", "lead status"));
		String custmerReach = leads.custmerReachValidation();
		Assert.assertEquals(custmerReach, BaseClass.jsonArrayValue("Asserations", "custmer reached status"));
		logoutUserFromSandBox.logoutUser();
	}

	@Test(description = "Verify user able to create lead with 'Person' record type.")
	public void personRecordTypeTC006() throws InterruptedException, EncryptedDocumentException, IOException {
		login.loginToSandBox(prop.getProperty("Username"), prop.getProperty("Password"));
		leads.leadCreations("Automation" + UtilClass.generateSequentialNumbers(3),
				"Automation", "Automation" + UtilClass.generateSequentialNumbers(4));
		String statusOfleads = leads.taskStatus();
		Assert.assertEquals(statusOfleads, BaseClass.jsonArrayValue("Asserations", "lead status"));
		leads.custmerReachValidation();
		logoutUserFromSandBox.logoutUser();
	}

	@Test(description = "Verify user is able to login with correct credentials", priority = 2)
	public void loginCorrectCreadentialsTC002() throws EncryptedDocumentException, InterruptedException, IOException {
		login.loginToSandBox(prop.getProperty("Username"), prop.getProperty("Password"));
		String headerAldarSales = leads.aldarSales();
		Assert.assertEquals(headerAldarSales, BaseClass.jsonArrayValue("Asserations", "Header validate"));
		logoutUserFromSandBox.logoutUser();
	}

	@Test(description = "Verify user can't login with invalid credentials", priority = 4)
	public void loginInvalidCreadentialsErrorTC003() throws EncryptedDocumentException, InterruptedException, IOException {
		login.loginToSandBox(ExcleReader.excleReader("Login", 3, 1), ExcleReader.excleReader("Login", 3, 1));
		String errorValue = login.errorInvalideLogin();
		Assert.assertEquals(errorValue, BaseClass.jsonArrayValue("Asserations", "Error message"));

	}

	@Test(description = "Verify user can't login invalide unsername", priority = 4)
	public void loginInvalidUserNameTC007() throws EncryptedDocumentException, InterruptedException, IOException {
		login.loginToSandBox(ExcleReader.excleReader("Login", 3, 1), ExcleReader.excleReader("Login", 3, 1));
		String errorValue = login.errorInvalideLogin();
		Assert.assertEquals(errorValue, BaseClass.jsonArrayValue("Asserations", "Error message"));

	}

	@Test(description = "Verify user can't login invalide password", priority = 4)
	public void loginInvalidPasswordTC008() throws EncryptedDocumentException, InterruptedException, IOException {
		login.loginToSandBox(ExcleReader.excleReader("Login", 3, 1), ExcleReader.excleReader("Login", 3, 1));
		String errorValue = login.errorInvalideLogin();
		Assert.assertEquals(errorValue, BaseClass.jsonArrayValue("Asserations", "Error message"));

	}

	@Test(description = "Verify 'Person' and 'Organisation' record types are visible while creating new lead.", priority = 1)
	public void recordTypePersonAndOrgTC004() throws EncryptedDocumentException, InterruptedException, IOException {
		login.loginToSandBox(prop.getProperty("Username"), prop.getProperty("Password"));
		boolean personButton = leads.leadTypesValidation();
		Assert.assertEquals(personButton, true);
		boolean organizationButton = leads.organizationValidation();
		Assert.assertEquals(organizationButton, true);
		logoutUserFromSandBox.logoutUser();
	}

	@Test(description = "Verify user able to create lead with 'Organisation' record type.")
	public void organisationTC005() throws EncryptedDocumentException, InterruptedException, IOException {
		login.loginToSandBox(prop.getProperty("Username"), prop.getProperty("Password"));
		leads.leadCreationOrizationType("Automation" + UtilClass.generateSequentialNumbers(5),
				"Automation", "Automation" + UtilClass.generateSequentialNumbers(6));
		String statusOfleads = leads.taskStatus();
		Assert.assertEquals(statusOfleads,BaseClass.jsonArrayValue("Asserations", "lead status"));
		String custmerReach = leads.custmerReachValidation();
		Assert.assertEquals(custmerReach, BaseClass.jsonArrayValue("Asserations", "custmer reached status"));
		logoutUserFromSandBox.logoutUser();
	}

	@Test(description = "Verify user able to see 'New Lead: Person' after click on the person lead")
	public void newPersonLeadTC009() throws InterruptedException, EncryptedDocumentException, IOException {
		login.loginToSandBox(prop.getProperty("Username"), prop.getProperty("Password"));
		Assert.assertEquals(leads.personLeadHeadder(), BaseClass.jsonArrayValue("Asserations", "Header Person"));
		logoutUserFromSandBox.logoutUser();
	}

	@Test(description = "Verify user not able to see 'New Lead: Organization' after click on the person lead")
	public void newOrganizationsTC0010() throws InterruptedException, EncryptedDocumentException, IOException {
		login.loginToSandBox(prop.getProperty("Username"), prop.getProperty("Password"));
		Assert.assertNotEquals(leads.personLeadHeadder(), BaseClass.jsonArrayValue("Asserations", "Header organization") );
		logoutUserFromSandBox.logoutUser();
	}
}
