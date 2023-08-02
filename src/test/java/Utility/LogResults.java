package Utility;

import java.awt.Desktop;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Listeners;

import Base.BaseClass;
import io.qameta.allure.Allure;
@Listeners
public class LogResults extends BaseClass implements ITestListener{
public void onTestStart(ITestResult result) {
	    try {
          report.create_test(result.getMethod().getMethodName(),"No", "Window" );
	    } catch (Exception e) {
            e.printStackTrace();
        }
}
public void onTestSuccess(ITestResult result) {
        try {
          report.create_info(result.getMethod().getDescription());
          report.test_pass(result.getMethod().getMethodName());
          System.out.println(result.getMethod().getMethodName() + " : PASSED");
        } catch (IOException e) {
        	e.printStackTrace();
        }
    }
public void onTestFailure(ITestResult result) {
		try {
        	report.create_info(result.getMethod().getDescription());
        	report.test_fail(result.getMethod().getMethodName() + " is failed due to"+"/n" +result.getThrowable(), result);
            System.out.println(result.getMethod().getMethodName() + " : FAILED");
            System.out.println("     ");
            result.getThrowable().printStackTrace();
            System.out.println("     ");
            Allure.addAttachment(result.getMethod().getMethodName(),new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
		} catch (Exception e) {
            e.printStackTrace();
        }
}
public void onTestSkipped(ITestResult result) {
    	report.create_info(result.getMethod().getDescription());
    	report.test_skip(result.getMethod().getMethodName());
        System.out.println(result.getMethod().getMethodName() + " : SKIPED");
    }

   
}
