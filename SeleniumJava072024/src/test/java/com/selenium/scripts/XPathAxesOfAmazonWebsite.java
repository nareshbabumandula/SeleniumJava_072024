package com.selenium.scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class XPathAxesOfAmazonWebsite {
	WebDriver driver;
	static ExtentTest test;
	static ExtentReports report;
	@Test
	public void xpathaxesExamples() throws InterruptedException {
		driver.get("https://www.amazon.in");
		driver.manage().window().maximize();
		try {
			driver.findElement(By.linkText("Today's Deals")).click();
			driver.findElement(By.linkText("All Deals")).click();
			//descendant Axes
			driver.findElement(By.xpath("//ol[@class='a-carousel']/descendant::li/button")).click();
			//following axes
			driver.findElement(By.xpath("//input[@name='departments' and @value='1571275031']/following::i")).click();
			driver.findElement(By.linkText("Clear Filters")).click();
			driver.findElement(By.xpath("//div[@class='nav-line-1-container']")).click(); // Signing in
			//child
			driver.findElement(By.xpath("//div[@class='a-box-inner a-padding-extra-large']/child::div/input[@id='ap_email']")).sendKeys("9505180071");
			//ancestor-or-self
			driver.findElement(By.xpath("//div[@id='legalTextRow']/ancestor-or-self::div[2]/span/span/input")).click();
			Thread.sleep(2000); 
			//ancestor
			driver.findElement(By.xpath("//div[@class='a-row a-spacing-top-medium']/ancestor::div[2]/div/input[@id='ap_password']")).sendKeys("abc1@1248te");
			//preceding-sibling
			driver.findElement(By.xpath("//div[@class='a-row a-spacing-top-medium']/preceding-sibling::span/span")).click();
			driver.navigate().back();
			driver.navigate().back();
			driver.navigate().back();
			Thread.sleep(1000);
			driver.findElement(By.linkText("Start here.")).click();
			//descendant-or-self
			driver.findElement(By.xpath("//div[@class='a-row a-spacing-base']/descendant-or-self::input")).sendKeys("Naresh");
			//self
			driver.findElement(By.xpath("//div[@class='a-fixed-left-grid-inner']/self::div/div[2]/input")).sendKeys("9505180071");
			//following-sibling
			driver.findElement(By.xpath("//div[@class='a-row a-spacing-base']/following-sibling::div[2]/div/input")).sendKeys("sabkjba22JJS");
			driver.findElement(By.xpath("//input[@id='continue']")).click();
			Thread.sleep(1000);
			driver.navigate().back();
			driver.navigate().back();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//i[contains(@class,'-icon nav-')]")).click();
			driver.findElement(By.linkText("Best Sellers")).click();
			Thread.sleep(10000);
			test.log(LogStatus.PASS, "Successfully performed actions on the webelements using advanced xpath axes methods");
		}
		catch(Exception e){
			test.log(LogStatus.FAIL, "Test Failed" + e.getMessage());
		}
	}
	
	@BeforeClass
	public void beforeClass() {
		driver = new EdgeDriver();
		driver.get("https://www.amazon.in");
		driver.manage().window().maximize();
		report = new ExtentReports("./ExtentReportResultsOfAmazonSite.html");
		test =report.startTest("TC001");
	}
	
	@AfterClass
	public void afterClass() {
		report.endTest(test);
		report.flush();
		driver.quit();
	}
}
