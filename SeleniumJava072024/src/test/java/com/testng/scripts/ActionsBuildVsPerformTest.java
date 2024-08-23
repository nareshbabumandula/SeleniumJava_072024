package com.testng.scripts;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ActionsBuildVsPerformTest {
	
	WebDriver driver;
	static ExtentTest test;
	static ExtentReports report;

	@Test
	public void actionMethods() throws InterruptedException {
		boolean bFlag=false;
		String errMsg="";
		try {
			// build() method is used to compile the series/sequence of actions into a single 'Action' object
			// Note: build method doesn't execute the actions, it only prepare them
			WebElement addons = driver.findElement(By.xpath("//div[contains(text(),'Add-ons')]"));
			Actions actions = new Actions(driver);
			Action action = actions.moveToElement(addons).click().build();
			action.perform();
			
		} catch (Exception e) {
			e.printStackTrace();
			errMsg = e.getMessage();
		}
		
		finally {
			if (bFlag) {
				test.log(LogStatus.PASS, "Build and Perform", "Successfully performed build and perform method");
			} else {
				test.log(LogStatus.FAIL, "Build and Perform", "Failed to perform build and perform operation since - " + errMsg);
			}
		}
		
		
	}

	@BeforeClass
	public void accessSite() {
		driver = new ChromeDriver();
		driver.get("https://jqueryui.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		report = new ExtentReports("./ExtentReportResults.html");
		test =report.startTest("Working with a actions class");
		test.log(LogStatus.PASS, "Drag and Drop", "Successfully performed actions using Actions class methods");
	}

	@AfterClass
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
		report.endTest(test);
		report.flush();
	}

}
