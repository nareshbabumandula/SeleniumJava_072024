package com.testng.scripts;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class Generic {
	
	@BeforeSuite
	public void UserRegistration() {
		System.out.println("Registration");
	}
			
	@AfterSuite
	void logout() {
		System.out.println("Logged out successfully..!");
	}

}
