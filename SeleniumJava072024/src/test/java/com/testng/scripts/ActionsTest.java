package com.testng.scripts;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ActionsTest {
	
	WebDriver driver;
	static ExtentTest test;
	static ExtentReports report;

	@Test
	public void actionMethods() throws InterruptedException {
		WebElement addons = driver.findElement(By.xpath("//div[contains(text(),'Add-ons')]"));
		Actions action = new Actions(driver);
		WebElement flightSearch = driver.findElement(By.xpath("//div[contains(text(),'Search Flight')]"));
		action.contextClick(flightSearch).perform();
		action.moveToElement(addons).perform();
		driver.findElement(By.xpath("(//a[@data-testid='test-id-Taxi']/div/div[contains(text(),'Taxi')])[1]")).click();
	}

	@BeforeClass
	public void accessSite() {
		driver = new ChromeDriver();
		driver.get("https://www.spicejet.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		report = new ExtentReports("./ExtentReportResults.html");
		test =report.startTest("Working with a actions class");
		test.log(LogStatus.PASS, "Link", "Successfully performed actions using Actions class methods");
	}

	@AfterClass
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
		report.endTest(test);
		report.flush();
	}

}
