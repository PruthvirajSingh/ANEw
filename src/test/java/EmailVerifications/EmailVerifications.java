package EmailVerifications;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.search.FlagTerm;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EmailVerifications {
	public static WebDriver driver;
	static Actions actions;
	static JavascriptExecutor j;

	public static void main(String[] args) throws MessagingException, IOException, InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://mail.google.com/");
		driver.findElement(By.cssSelector("input[type='email']")).sendKeys("testpruthvitest@gmail.com");
		driver.findElement(By.xpath("//span[text()='Next']")).click();
		Thread.sleep(5000);
		actions = new Actions(driver);
		driver.findElement(By.xpath("//input[@aria-label='Enter your password']")).sendKeys("1Pruthvir@j");
		driver.findElement(By.xpath("//span[text()='Next']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[text()='Inbox']")).click();
		Thread.sleep(5000);
		List<WebElement> gmailValues = driver
				.findElements(By.xpath("(//table)[6]//tr//td[contains(@class,'xY ')]//span"));
		for (WebElement element : gmailValues) {
			if (element.getText().equals("ACTION NEEDED: Untitled Document")) {
				Thread.sleep(5000);
				System.out.println("Value: " + element.getText());
				j = (JavascriptExecutor) driver;
				j.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'center'});", element);
				element.click();
				break;
			}
		}
		String parentWindow = driver.getWindowHandle();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//td[@valign='middle']")).click();
		Thread.sleep(5000);
		Set<String> windowHandles = driver.getWindowHandles();

		// Iterate over the window handles
		for (String windowHandle : windowHandles) {
			// Switch to the new window by comparing window handles
			if (!windowHandle.equals(driver.getWindowHandle())) {
				driver.switchTo().window(windowHandle);
				break; // Exit the loop after switching to the new window
			}
		}

		Thread.sleep(5000);
		if (driver.findElement(By.xpath("(//div[contains(@class,'tracking-wider')])[1]")).isDisplayed() == true) {
			driver.findElement(By.xpath("//input[contains(@class,'ember-checkbox')]")).click();
			driver.findElement(By.xpath("//button[text()=\"Let's do this!\"]")).click();
		} else {
			System.out.println("Window not found");
		}
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@class='dh-toolbar-dropdown']//button")).click();
		driver.findElement(By.xpath("//div[@class='tippy-content']//button[1]")).click();
		Thread.sleep(5000);
		driver.findElement(By.cssSelector("#typeTab")).click();
		Thread.sleep(5000);
		driver.findElement(By.cssSelector("#signature-name-input")).clear();
		driver.findElement(By.cssSelector("#signature-name-input")).sendKeys("Aldr5h943s");
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//div[contains(@class,'grid')])[2]//button[1]")).click();
		driver.findElement(By.xpath("//div[contains(@class,'flex justify-end')]//button")).click();
		Thread.sleep(7000);
		driver.findElement(By.xpath("//div[@class='dh-toolbar-dropdown']//button")).click();
		Thread.sleep(5000);
		WebElement sourceElement = driver
				.findElement(By.xpath("(//div[contains(@class,'dh-user-signature')])[1]//img"));
		WebElement targetElement = driver
				.findElement(By.xpath("//div[@class='dh-pdf-js-image overflow-hidden bg-white']"));
		actions.click(sourceElement).build().perform();
		actions.click(targetElement).build().perform();
		
		
		
		// closing child window

//        driver.findElement(By.xpath("//button[text()='Finalize']")).click();
//        Thread.sleep(5000);
//        driver.findElement(By.xpath("//input[@type='checkbox']")).click();
//        driver.findElement(By.xpath("(//div[contains(@class,'text-center')])[2]//button")).click();
        Set<String> windowHandles1 = driver.getWindowHandles();
        String currentWindowHandle = driver.getWindowHandle();

		// Iterate over the window handles in reverse order
        List<String> windowHandlesList = new ArrayList<>(windowHandles);
        Collections.reverse(windowHandlesList);

        for (String windowHandle : windowHandlesList) {
            if (!windowHandle.equals(currentWindowHandle)) {
                driver.switchTo().window(windowHandle);
                break; // Exit the loop after switching to the previous window
            }
        }
        Thread.sleep(5000);
        boolean values=driver.findElement(By.xpath("//div[text()='Inbox']")).isDisplayed();
        System.out.println(values+"}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}");
        driver.findElement(By.xpath("//a[text()='Inbox']")).click();
    	List<WebElement> gmailValues2 = driver.findElements(By.xpath("(//table)[6]//tr//td[contains(@class,'xY ')]//span"));
		for (WebElement element : gmailValues2) {
			if (element.getText().equals("ACTION NEEDED: Untitled Document")) {
				Thread.sleep(5000);
				System.out.println("Value: "+element.getText());
				actions.moveToElement(element).build().perform();
				Thread.sleep(5000);
				driver.findElement(By.xpath("//li[@data-tooltip='Delete']")).click();
				break;
			}
		}
		Thread.sleep(5000);
		
		
		
		
		
		
		
		
		
		
		
		
		

//		String OTP1;
//		String mailFolderName = "Inbox"; // (Eg- "INBOX"),
//		String emailSubjectContent = "Your login confirmation code for B2C Content Hub";
//		int lengthOfOTP = 8;
//		String hostName = "smtp.gmail.com";// change it according to your mail
//		String username = "testpruthvitest@gmail.com";// username
//		String password = "pgqzokayjyxoghnq";
//		int messageCount;
//		int unreadMsgCount;
//		String emailSubject;
//		Message emailMessage;
//		String searchText = "null";
//		Properties sysProps = System.getProperties();
//		sysProps.setProperty("mail.smtp.starttls.enable", "true");
//		sysProps.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
//		sysProps.setProperty("mail.store.protocol", "imaps");
//		System.setProperty("mail.imaps.ssl.protocols", "TLSv1.2");
//		Session session = Session.getInstance(sysProps, null);
//		Store store = session.getStore();
//		store.connect(hostName, username, password);
//		Folder emailBox = store.getFolder(mailFolderName);
//		emailBox.open(Folder.READ_WRITE);
//		Flags seen = new Flags(Flags.Flag.SEEN);
//		FlagTerm unseenFlagTerm = new FlagTerm(seen, false);
//		Message messages[] = emailBox.search(unseenFlagTerm);
//		if (messages.length == 0)
//			System.out.println("No messages found.");
//
//		for (int i = 0; i < messages.length; i++) {
//			// stop after listing ten messages
//			if (i > messages.length) {
//				System.exit(0);
//				emailBox.close(true);
//				store.close();
//			}
//
//			String line, OTP;
//			StringBuffer buffer = new StringBuffer();
//			BufferedReader reader = new BufferedReader(new InputStreamReader(messages[0].getInputStream()));
//			while ((line = reader.readLine()) != null) {
//				OTP = line.replaceAll("[^\\d]", " ");
//				OTP1 = OTP.replaceAll("\\s", "");
//				driver.findElement(By.id("authcode")).sendKeys(OTP1);
//				break;
//			}
//		}
//
	}
}
