package Pom.Person;

import java.util.NoSuchElementException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.qameta.allure.Step;

public class LogoutUser {
	private WebDriver driver;
	private WebDriverWait wait;
	JavascriptExecutor j;
	@FindBy(css = ".slds-button.branding-userProfile-button")
	private WebElement userLogoHeader;

	@FindBy(css = ".logout")
	private WebElement logoutButton;

	@FindBy(xpath = "//input[@id='username']")
	private WebElement username;

	@FindBy(xpath = "//img[contains(@class,'icon noicon')]")
	private WebElement imageOFTheLogout;

	public LogoutUser(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		j = (JavascriptExecutor) driver;
		wait = new WebDriverWait(driver, 20);
	}

	@Step("logout from the account")
	public void logoutUser() {
	    int maxRetries = 3;
	    int retryCount = 0;
	    WebDriverWait wait = new WebDriverWait(driver, 10); // Adjust the timeout as needed (seconds)

	    while (retryCount < maxRetries) {
	        try {
	            wait.until(ExpectedConditions.elementToBeClickable(userLogoHeader)).click();
	            wait.until(ExpectedConditions.elementToBeClickable(logoutButton)).click();
	            return; // Exit the method if logout is successful
	        } catch (NoSuchElementException | WebDriverException e) {
	            // Exception occurred, retry logic
	            retryCount++;
	            System.out.println("Attempt " + retryCount + " to logout failed: " + e.getMessage());
	        }
	    }

	    // Maximum number of retries reached, handle the failure scenario
	    System.out.println("Unable to logout after " + maxRetries + " attempts.");
	}


	public String logoValidation() {
		return imageOFTheLogout.getAttribute("title");
	}
}
