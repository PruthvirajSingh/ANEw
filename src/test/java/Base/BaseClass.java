package Base;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;

import org.apache.maven.shared.utils.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.reporter.configuration.Theme;
import com.fasterxml.jackson.databind.JsonNode;

import Pom.Person.DataBasePom;
import Pom.Person.LeadChagesAdmin;
import Pom.Person.Leads;
import Pom.Person.LoginClass;
import Pom.Person.LogoutUser;
import Pom.Person.RecepitAllocations;
import Pom.Person.UnitSelectionForAccount;

import Test.Person.UnitSelection;
import Utility.ExcleReader;
import Utility.PojoClass;
import Utility.Sparkreport;
import Utility.UtilClass;

import org.testng.ITestResult;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.ExtentTest;

public class BaseClass extends PojoClass {
	public LoginClass login;
	public Leads leads;
	public static WebDriver driver;
	public ExcleReader util;
	public static Sparkreport report;
	public static LogoutUser logoutUserFromSandBox;
	public ExtentReports extent;
	public static ExtentTest extentTest;
	public LeadChagesAdmin adminLead;
	public UnitSelectionForAccount unitSel;
	public static Properties prop;
	public static JsonNode node;
	public static RecepitAllocations receipt;
	public static DataBasePom database;
	public BaseClass() {
        try {
            prop = new Properties();
            FileInputStream fis = new FileInputStream(
                    System.getProperty("user.dir") + "\\src\\test\\java\\Config\\Config.Properties");
            prop.load(fis);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	public static String jsonValue(String key) {
        return node.get(key).asText();
    }
	public static String jsonArrayValue(String parentkey, String key) {
		System.out.println(node.get(parentkey).get(key).asText()+"{}{}{}{}{}{}{}{}{}{}{}{}{{}{}{}{}{}{}{{");
        return node.get(parentkey).get(key).asText();
    }
	public static WebDriver chromeBrowser() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		Map < String, Object > prefs = new HashMap < String, Object > ();
	    Map < String, Object > profile = new HashMap < String, Object > ();
	    Map < String, Object > contentSettings = new HashMap < String, Object > ();
	    contentSettings.put("geolocation", 1);
	    profile.put("managed_default_content_settings", contentSettings);
	    prefs.put("profile", profile);
	    options.setExperimentalOption("prefs", prefs);
	    options.addArguments("--disable-geolocation","--disable-javascript","--disable-popup-blocking", "--disable-notifications", "--disable-cookies");
	    options.addExtensions(new File(System.getProperty("user.dir") +"\\Inspector salesforce\\aodjmnfhjibkcdimpodiifdjnnncaafh (1).crx"));
	    WebDriver driver = new ChromeDriver(options);
		return driver;
	}

	@BeforeTest(alwaysRun = true)
	public void launchBrowser() throws EncryptedDocumentException, IOException, InterruptedException {
		driver = chromeBrowser();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		report = new Sparkreport("Test", "extent report", "Aldar", "AldarProject");
	}

	@BeforeClass(alwaysRun = true)
	public void extractDataExcleAndObjectOfClassCreations() throws IOException, EncryptedDocumentException, InterruptedException {
		driver.navigate().to(prop.getProperty("URL"));
		node=UtilClass.readJson(System.getProperty("user.dir")+"\\JSONTestData\\Aldar.json");
		login = new LoginClass(driver);
		logoutUserFromSandBox = new LogoutUser(driver);
		leads = new Leads(driver);
		adminLead = new LeadChagesAdmin(driver);
		unitSel=new UnitSelectionForAccount(driver);
		receipt=new RecepitAllocations(driver);
		database=new DataBasePom(driver);
	}

	@BeforeMethod(alwaysRun = true)
	public void beforeMethod() throws EncryptedDocumentException, IOException, InterruptedException {

	}

	@AfterMethod(alwaysRun = true)
	public void closeWindow(ITestResult result) throws IOException, InterruptedException {
		report.flush();

	}

	@AfterClass(alwaysRun = true)
	public void logout() throws InterruptedException {
		
		login = null;
	}

	@AfterTest
	public void tearDown() throws InterruptedException {
		
		driver.close();
		System.gc();
	}
}