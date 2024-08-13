package com.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class MyRetry implements IRetryAnalyzer {

	private int retryCount = 0;
	private static final int maxRetryCount = 1;

	public boolean retry(ITestResult result) {
		System.out.println("Result status is : " + result.isSuccess());
		if (retryCount < maxRetryCount) {
			retryCount++;
			return true;
		}
		return false;
	}
}