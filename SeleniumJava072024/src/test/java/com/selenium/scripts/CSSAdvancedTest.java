package com.selenium.scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class CSSAdvancedTest {
	WebDriver driver;
	static ExtentTest test;
	static ExtentReports report;
	@Test
	public void xpathaxesExamples() throws InterruptedException {
		try {
			boolean bfirstoftypeFlag = driver.findElement(By.cssSelector("select[name='fromPort']:first-of-type")).isDisplayed();
			test.log(LogStatus.PASS, "Checked the display status of an object using first-of-type method in CSS : " +bfirstoftypeFlag);
			boolean blastoftypeFlag = driver.findElement(By.cssSelector("select[name='fromPort']:last-of-type")).isDisplayed();
			test.log(LogStatus.PASS, "Checked the display status of an object using last-of-type method in CSS : " +blastoftypeFlag);
			boolean bnthoftypeFlag = driver.findElement(By.cssSelector("form[action='reserve.php']>select:nth-of-type(1)")).isDisplayed();
			test.log(LogStatus.PASS, "Checked the display status of an object using nth-of-type method in CSS : " +bnthoftypeFlag);
			boolean bnthchildFlag = driver.findElement(By.cssSelector("select[name='fromPort']>:nth-child(2)")).isDisplayed();
			test.log(LogStatus.PASS, "Checked the display status of an object using nth-child method in CSS : " +bnthchildFlag);
			//boolean bfollowingSiblingFlag = driver.findElement(By.cssSelector("select[name='fromPort']+select")).isDisplayed();
			
			Thread.sleep(1000);
			test.log(LogStatus.PASS, "Successfully performed actions on the webelements using advanced css methods");
		}
		catch(Exception e){
			test.log(LogStatus.FAIL, "Test Failed" + e.getMessage());
		}
	}
	
	@BeforeClass
	public void beforeClass() {
		driver = new ChromeDriver();
		driver.get("https://blazedemo.com/");
		driver.manage().window().maximize();
		report = new ExtentReports("./ExtentReportResults.html");
		test =report.startTest("TC001");
	}
	
	@AfterClass
	public void afterClass() {
		report.endTest(test);
		report.flush();
		driver.quit();
	}
}

