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

public class TextboxTest {
	
	WebDriver driver;
	static ExtentTest test;
	static ExtentReports report;

	@Test
	public void textboxMethods() {
		WebElement username = driver.findElement(By.id("user"));
		//<input name="user" type="text" class="txt_log" id="user" value="" tabindex="1">
		System.out.println(username.getAttribute("name"));
		System.out.println(username.getAttribute("type"));
		System.out.println(username.getAttribute("class"));
		System.out.println(username.getAttribute("id"));
		System.out.println(username.getAttribute("tabindex"));
		System.out.println(username.isDisplayed());
		System.out.println(username.isEnabled());
				
		username.sendKeys("sapthagiri");
		System.out.println(username.getAttribute("value"));
		Assert.assertEquals(username.getAttribute("value"), "sapthagiri", "Expected value is not matching with the actual value");
		username.clear();
		username.sendKeys("Saiteja");
		System.out.println(username.getAttribute("value"));
	}

	@BeforeClass
	public void accessSite() {
		driver = new ChromeDriver();
		driver.get("https://www.mycontactform.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		report = new ExtentReports("./ExtentReportResults.html");
		test =report.startTest("Working with Textbox");
		test.log(LogStatus.PASS, "Textbox", "Successfully performed actions on a textbox");
	}

	@AfterClass
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
		report.endTest(test);
		report.flush();
	}

}
