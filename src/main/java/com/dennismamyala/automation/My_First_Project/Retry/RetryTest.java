package com.dennismamyala.automation.My_First_Project.Retry;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryTest implements IRetryAnalyzer{
	
	int max = 2;
	int count = 0;

	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		
		if(count<max) {
			
			count++;
			return true;
		}
		
		
		return false;
	}

}
