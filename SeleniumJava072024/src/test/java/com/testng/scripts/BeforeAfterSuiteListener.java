package com.testng.scripts;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BeforeAfterSuiteListener {

	@BeforeSuite
	public void accessSite() {
		System.out.println("Launched browser");
	}
	
	@AfterSuite
	public void closeBrowser() {
		System.out.println("Closed the browser");
	}

}
