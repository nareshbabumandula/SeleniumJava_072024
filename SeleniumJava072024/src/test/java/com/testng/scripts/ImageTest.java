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

public class ImageTest {
	
	WebDriver driver;
	static ExtentTest test;
	static ExtentReports report;

	@Test
	public void imageMethods() {
		WebElement imageLogo = driver.findElement(By.className("test_img"));
		System.out.println(imageLogo.getAttribute("src"));
		System.out.println(imageLogo.getAttribute("alt"));
		System.out.println(imageLogo.getAttribute("class"));
		System.out.println(imageLogo.isDisplayed());
		System.out.println(imageLogo.isEnabled());
		imageLogo.click();
	}

	@BeforeClass
	public void accessSite() {
		driver = new ChromeDriver();
		driver.get("https://www.mycontactform.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		report = new ExtentReports("./ExtentReportResults.html");
		test =report.startTest("Working with an Image");
		test.log(LogStatus.PASS, "Image", "Successfully performed actions on an image");
	}

	@AfterClass
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
		report.endTest(test);
		report.flush();
	}

}
