package com.dennismamyala.automation.My_First_Project.Retry;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * Implements TestNG's IRetryAnalyzer to allow test methods to be retried on failure.
 * The test will be retried up to a maximum number of times (default: 2).
 */
public class RetryTest implements IRetryAnalyzer{
	
	/** Maximum number of retries allowed. */
	int max = 2;
	/** Current retry count. */
	int count = 0;

	/**
	 * Determines whether a test should be retried after failure.
	 * @param result The result of the test execution
	 * @return true if the test should be retried, false otherwise
	 */
	@Override
	public boolean retry(ITestResult result) {
		if(count<max) {
			count++;
			return true;
		}
		return false;
	}

}