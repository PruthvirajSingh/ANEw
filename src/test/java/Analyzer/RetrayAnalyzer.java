package Analyzer;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetrayAnalyzer implements IRetryAnalyzer{
	int counter =0;
	int retrayCount=3;
	
	public boolean retry(ITestResult result) {
		if(counter < retrayCount) {
			counter++;
			return true;
		}
		return false;
	}
}
