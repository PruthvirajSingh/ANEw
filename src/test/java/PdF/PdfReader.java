package PdF;

import java.awt.image.RenderedImage;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.json.JSONArray;
import java.util.Scanner;

import javax.imageio.ImageIO;

import org.json.JSONObject;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageTree;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.graphics.PDXObject;
import org.apache.pdfbox.pdmodel.graphics.form.PDFormXObject;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.val;

public class PdfReader {
	WebDriver driver;
	String urlV = "file:///C:/Users/Pruthvirajsing/Downloads/statement_sample1%20(1).pdf";

	@BeforeTest
	public void beforeTest() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(urlV);

	}
	public static List<RenderedImage> getImagesFromPDF(PDDocument document) throws IOException {
		List<RenderedImage> images = new ArrayList<>();
		for (PDPage page : document.getPages()) {
			images.addAll(getImagesFromResources(page.getResources()));
		}

		return images;
	}
	private static List<RenderedImage> getImagesFromResources(PDResources resources) throws IOException {
		List<RenderedImage> images = new ArrayList<>();

		for (COSName xObjectName : resources.getXObjectNames()) {
			PDXObject xObject = resources.getXObject(xObjectName);

			if (xObject instanceof PDFormXObject) {
				images.addAll(getImagesFromResources(((PDFormXObject) xObject).getResources()));
			} else if (xObject instanceof PDImageXObject) {
				images.add(((PDImageXObject) xObject).getImage());
			}
		}
		
		return images;
	}
	public void PDFBoxExtractImages(PDDocument document) throws Exception {
	    PDPageTree list = document.getPages();
	    for (PDPage page : list) {
	        PDResources pdResources = page.getResources();
	        for (COSName c : pdResources.getXObjectNames()) {
	            PDXObject o = pdResources.getXObject(c);
	            if (o instanceof org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject) {
	                File file = new File("./pdfimages/" + System.nanoTime() + ".png");
	                ImageIO.write(((org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject)o).getImage(), "png", file);
	            }
	        }
	    }
	}
	@Test
	public void test1() throws Exception {
		URL pdfUrl = new URL(urlV);
		InputStream ip = pdfUrl.openStream();
		BufferedInputStream bf = new BufferedInputStream(ip);
		PDDocument pdfDoc = PDDocument.load(bf);
		System.out.println(pdfDoc.getNumberOfPages() + "{}{{{{}}{}{}{}{}{}{{");
		PDFTextStripper pdfText = new PDFTextStripper();
		System.out.println(pdfText.getText(pdfDoc));
		try {
			PrintStream ps = new PrintStream(new File("D:/newFile.txt"));
			String value = pdfText.getText(pdfDoc); 
			ps.print(value);
			PdfReader pr=new PdfReader();
			System.out.println(pr.getImagesFromPDF(pdfDoc).size()+"::::::::::::::::::::::::::::");
			pr.PDFBoxExtractImages(pdfDoc);
			
			
			System.out.println(value.length()+"||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
			System.out.println("-------------------------------------------------------------");

			int startIndex = value.indexOf("Account Summary Account # 000009752")
					+ "Account Summary Account # 000009752".length();

			int endIndex = value.indexOf("Description");

			// Extract the desired substring
			String substring = value.substring(startIndex, endIndex);
			System.out.println(substring);
			String realValue=substring.replaceAll("[A-Za-z,&]","");
			System.out.println(realValue+")))))))))))))))))))))))))))))))))))");
			String[] values = realValue.split("\\$|\\s|\\+|-");

			// Remove empty elements from the array
			values = Arrays.stream(values).filter(s -> !s.isEmpty()).toArray(String[]::new);

			// Display the extracted values
			for (String value1 : values) {
				System.out.println(value1+"||||||||||||||||||||||||||||||||||||||||||||||||");
			}
//	        String sub1=substring.replaceAll("[^a-zA-Z0-9.,\\s]", "");
//	        String sub2=sub1.trim();
//	        System.out.println(sub2.replace(",", "")+"|||||||||||||||||||||||||");
//	        // Print the extracted substring
//	        System.out.println(sub1.trim());
//	        double number = Double.parseDouble(sub2.replace(",", ""));
//	        System.out.println(number);
//	        int startIndex1 = substringV.indexOf("May 3, 2003");
//	        int lastIndex2 = substringV.indexOf("Deposits");
//
//	        String balance = substringV.substring(startIndex1 + "Beginning".length(), lastIndex2).trim();
//
//	        System.out.println(balance+"|||||||||||||||||||||||||||||||||||||||||||||||");
			System.out.println("-------------------------------------------------------------");
//			Gson gson = new GsonBuilder().setLenient().create();
//			Object json = gson.fromJson(value, Object.class);
//			String convertedJsonString = gson.toJson(json);
//			System.out.println(substring+"||||||||||||||||||||||||||||||||||||||||||");
//			String[] splitArray = value.split(" ");
//			for (String element : splitArray) {
//				System.out.println(element);
//
//			}
		} catch (FileNotFoundException e) {
			System.out.println("empty");
		}

		driver.close();

	}

}
