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

public class LinkTest {
	
	WebDriver driver;
	static ExtentTest test;
	static ExtentReports report;

	@Test
	public void linkMethods() {
		WebElement lnkSampleForms = driver.findElement(By.linkText("Sample Forms"));
		lnkSampleForms.click();
		
		driver.navigate().back();
		WebElement lnkSample = driver.findElement(By.partialLinkText("Sample"));
		lnkSample.click();
		
	}

	@BeforeClass
	public void accessSite() {
		driver = new ChromeDriver();
		driver.get("https://www.mycontactform.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		report = new ExtentReports("./ExtentReportResults.html");
		test =report.startTest("Working with a Link");
		test.log(LogStatus.PASS, "Link", "Successfully performed actions on link");
	}

	@AfterClass
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
		report.endTest(test);
		report.flush();
	}

}
