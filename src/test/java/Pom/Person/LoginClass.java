package Pom.Person;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.qameta.allure.Step;

public class LoginClass {
	private WebDriver driver;
	WebDriverWait wait;
	@FindBy (xpath="//input[@id='username']")
	private WebElement username;
	
	@FindBy (xpath="//input[@id='password']")
	private WebElement password;
	
	@FindBy (css="#Login")
	private WebElement loginToSandBoxButton;
	
	@FindBy (css="img[title='User']")
	private WebElement userLogoHeader;
	
	@FindBy (css="form[name='login'] div[class='loginError']")
	private WebElement errorLogin;
	
	public LoginClass(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		wait = new WebDriverWait(driver, 10);
		
	}
	@Step("User login sandbox with the correct credentials")
	public void loginToSandBox(String usernameValue,String passwordValue) throws InterruptedException {
		username.sendKeys(usernameValue);
		password.sendKeys(passwordValue);
		loginToSandBoxButton.click();
	}
	@Step("Validate that the user able to see the error message after the wrong creditals")
	public String errorInvalideLogin() {
		wait.until(ExpectedConditions.visibilityOf(errorLogin));
		String error=errorLogin.getText();
		return error;
		
	}
	
	
}
