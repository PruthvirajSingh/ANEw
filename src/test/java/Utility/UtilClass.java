package Utility;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.text.SimpleDateFormat;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestResult;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.qameta.allure.Attachment;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.apache.commons.io.FileUtils;

public class UtilClass {
	
	public void UtilClassMethod(WebDriver driver, List<WebElement> webElementsValue, String value) {
		for (WebElement element : webElementsValue) {
			if (element.getText().equals(value)) {
				JavascriptExecutor j = (JavascriptExecutor) driver;
				j.executeScript("arguments[0].click();", element);
				break;
			}
		}

	}
	public static JsonNode readJson(String JsonFilepath) throws IOException {
        
		 
	       ObjectMapper mapper=new ObjectMapper();
	       JsonNode node =mapper.readTree(new File(JsonFilepath));
	       return node;
	    
	    }

	public void utilMethodActionClass(WebDriver driver, List<WebElement> webElementsValue, String value) {
		for (WebElement element : webElementsValue) {
			if (element.getText().equals(value)) {
				Actions actions = new Actions(driver);
				actions.moveToElement(element).build().perform();
				actions.click(element).build().perform();
				break;
			}
		}
	}

	@Attachment(value = "ScrenShot", type = "image/png")
	public static String Take_screenshot(WebDriver driver, ITestResult result) throws IOException {

		TakesScreenshot screenshot = (TakesScreenshot) driver;

		File src = screenshot.getScreenshotAs(OutputType.FILE);

		String path = System.getProperty("user.dir") + "\\Screenshot\\" + result.getMethod().getMethodName() + ".png";
		File dest = new File(path);
		FileUtils.copyFile(src, dest);
		return path;
	}

	public static void asyncClickLinkInUl(WebDriver driver, String ulxpath, String linkText) {

		WebElement ulElement = driver.findElement(By.xpath(ulxpath));
		List<WebElement> liElements = ulElement.findElements(By.tagName("li"));
		for (WebElement li : liElements) {
			WebElement a = li.findElement(By.tagName("a"));
			String text = a.getText();
			if (text.equals(linkText)) {
				a.click();
				break;
			}
		}
	}

	public static String randomNameGenerator(int num) {
		StringBuilder res = new StringBuilder();
		for (int i = 0; i < num; i++) {
			int random = (int) (Math.random() * 26);
			res.append((char) (97 + random));
		}
		return res.toString();
	}

	public static int[] generateRandomNumbers(int num, int min, int max) {
		int[] randomNumbers = new int[num];
		Random random = new Random();

		for (int i = 0; i < num; i++) {
			randomNumbers[i] = random.nextInt(max - min + 1) + min;
		}

		return randomNumbers;
	}

	public static String generateRandomMobileNumber() {
		Random random = new Random();
		int operatorCode = random.nextInt(1000); // Random 3-digit operator code
		int remainingDigits = random.nextInt(900000) + 1000000; // Random 9-digit remaining digits
		return String.format("%03d%d", operatorCode, remainingDigits);
	}

	public static String generateSequentialNumbers(int count) {
		StringBuilder sb = new StringBuilder();

		for (int i = 1; i <= count; i++) {
			sb.append(i);
		}

		return sb.toString();
	}

	public static String generateRandomNumbers(int count) {
		StringBuilder sb = new StringBuilder();
		Random random = new Random();

		for (int i = 0; i < count; i++) {
			sb.append(random.nextInt(10)); // Generates a random number between 0 and 9
		}

		return sb.toString();
	}

	public static void clickOnDynamicElement(WebDriver driver) {
	    WebElement table = driver.findElement(By.xpath("//table[contains(@class,'slds-table')]"));
	    WebElement firstRow = table.findElement(By.xpath("//tr")); // Select the first row
	    WebElement column = firstRow.findElement(By.xpath("//td"));

	    List<WebElement> listOfTheATag = column.findElements(By.xpath("//a[contains(@class,'flex-wrap-ie11 slds-truncate')]"));
	    for (WebElement aTag : listOfTheATag) {
	        List<WebElement> spanValuesToSelect = aTag.findElements(By.xpath("//span"));
	        for (WebElement spanValue : spanValuesToSelect) {
	            String text = spanValue.getText();
	            if (text.contains("D-")) {
	                System.out.println(text + "_____________________________________");
	                spanValue.click();
	            }
	        }
	        break;
	    }
	}
//	This modified code will click on the first element with the "D-" identifier found in the table's first row. Feel free to adjust the code further based on your specific requirements.








	public static void main(String[] args) {
		System.out.println(UtilClass.generateRandomNumbers(3));
	}
}
