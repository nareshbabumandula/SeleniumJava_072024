package com.testng.scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.listeners.CustomTestListener;
import com.listeners.MyRetry;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

@Listeners(CustomTestListener.class)
public class TestNGParametersExample extends BeforeAfterSuiteListener{

	WebDriver driver;
	static ExtentTest test;
	static ExtentReports report;

	@Parameters({"username", "password"})
	@Test(retryAnalyzer = MyRetry.class)
	public void verifyLogin(String username, String password) {
		String errMsg="";
		boolean bFlag=false;
		try {
			driver.findElement(By.id("user")).sendKeys(username);
			driver.findElement(By.id("pass")).sendKeys(password);
			driver.findElement(By.name("btnSubmit")).click();
			Assert.assertEquals(false, true, "Test case failed..!");
			bFlag=true;
			Assert.assertEquals(bFlag, true, "Expected value is not matching with actual value");
			test.log(LogStatus.PASS, "Enter username", "Entered username as : " +username);
			test.log(LogStatus.PASS, "Enter password", "Entered password as : " +password);
		} catch (Exception e) {
			errMsg = e.getMessage();
			test.log(LogStatus.FAIL, "Enter username", "Failed to enter username : " +username+ " since " + errMsg);
			// Hard Assertion
			//Assert.assertEquals(bFlag, true, "Failed to login into the application since :" +errMsg);
			// Soft Assertion
			SoftAssert softassert = new SoftAssert();
			softassert.assertEquals(bFlag, true, "Failed to login into the application since :" +errMsg);
			System.out.println("Test case failed..!");
			e.printStackTrace();
			softassert.assertAll();
		}
	}

	@Parameters({"url"})
	@BeforeClass
	public void accessSite(String url) {
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		report = new ExtentReports("./ExtentReportResults.html");
		test =report.startTest("TestNG Parameters");
		test.log(LogStatus.PASS, "Access Site", "Access MCF site");
	}

	@AfterClass
	public void signOut() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
		report.endTest(test);
		report.flush();
	}


}
