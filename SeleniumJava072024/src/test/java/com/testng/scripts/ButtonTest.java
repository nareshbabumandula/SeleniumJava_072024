package com.testng.scripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ButtonTest {
	
	WebDriver driver;
	static ExtentTest test;
	static ExtentReports report;

	@Test
	public void buttonMethods() {
		//<input type="submit" name="btnSubmit" value="Login" class="btn_log" tabindex="3">
		WebElement login = driver.findElement(By.name("btnSubmit"));
		System.out.println(login.isDisplayed());
		System.out.println(login.isEnabled());
		
		login.click();
	}

	@BeforeClass
	public void accessSite() {
		driver = new ChromeDriver();
		driver.get("https://www.mycontactform.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		report = new ExtentReports("./ExtentReportResults.html");
		test =report.startTest("Working with Button");
		test.log(LogStatus.PASS, "Button", "Successfully performed actions on a button");
	}

	@AfterClass
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
		report.endTest(test);
		report.flush();
	}

}
