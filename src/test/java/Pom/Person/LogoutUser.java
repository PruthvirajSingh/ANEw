package Pom.Person;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
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
	public void logoutUser() throws InterruptedException {
		int maxRetries = 3;
		int retryCount = 0;
		while (retryCount < maxRetries) {
			try {
				wait.until(ExpectedConditions.elementToBeClickable(userLogoHeader));
				j.executeScript("arguments[0].click();", userLogoHeader);
				wait.until(ExpectedConditions.elementToBeClickable(logoutButton));
				logoutButton.click();
				wait.until(ExpectedConditions.visibilityOf(username));
				break; // Exit the loop if execution reaches this point without throwing an exception
			} catch (Exception e) {
				// Exception occurred, retry logic
				retryCount++;
				System.out.println("Attempt " + retryCount + " to locate userLogoHeader failed.");
				Thread.sleep(1000); // Wait for a short duration before retrying
			}
		}

		if (retryCount >= maxRetries) {
			// Maximum number of retries reached, handle the failure scenario
			System.out.println("Unable to locate userLogoHeader after " + maxRetries + " attempts.");
		}
	}

	public String logoValidation() {
		return imageOFTheLogout.getAttribute("title");
	}
}
