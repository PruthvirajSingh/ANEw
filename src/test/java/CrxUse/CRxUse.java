package CrxUse;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CRxUse {
	public static void main(String[] args) {
	  	WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
       
        options.addExtensions(new File("C:\\Inspector salesforce\\aodjmnfhjibkcdimpodiifdjnnncaafh (1).crx"));

        // Instantiate ChromeDriver with the specified ChromeOptions
        WebDriver driver = new ChromeDriver(options);

        // Navigate to a URL and perform some actions (e.g., getting Google homepage)
        driver.get("https://www.google.com/");

        // Use JavaScript Executor to perform some action
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        

        // Perform other actions or tests using the WebDriver instance as needed

        // Close the WebDriver session
        
	}
    
}