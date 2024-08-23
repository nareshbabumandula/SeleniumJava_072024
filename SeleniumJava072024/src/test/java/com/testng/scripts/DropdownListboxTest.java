package com.testng.scripts;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class DropdownListboxTest {
	
	WebDriver driver;
	static ExtentTest test;
	static ExtentReports report;

	@Test
	public void listboxMethods() throws InterruptedException {
		
		driver.findElement(By.linkText("Sample Forms")).click();
		WebElement predefinedCounrties = driver.findElement(By.id("q9"));
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].setAttribute('style', 'background:yellow; border:2 px solid red;');", predefinedCounrties);
		
		Select select = new Select(predefinedCounrties);
		select.selectByIndex(1); // Selects the second item from the dropdown
		Thread.sleep(2000);
		select.selectByIndex(0); // Selects the first item from the dropdown
		Thread.sleep(2000);
		select.selectByVisibleText("Australia"); // Selects the dropdown list item based on text
		Thread.sleep(2000);
			
		List<WebElement> countries = select.getOptions();
		System.out.println("No of countries displayed are : " + countries.size());
		
		select.selectByIndex(countries.size()-2);
		Thread.sleep(2000);
		
		for (int i = 0; i < countries.size(); i++) {
			System.out.println(countries.get(i).getText());
		}
		
		System.out.println("For each loop starts..!");
		
		for (WebElement country : countries) {
			System.out.println(country.getText());
		}
		
		System.out.println("Lambda expression starts..!");
		countries.forEach(country->System.out.println(country.getText()));
	}

	@BeforeClass
	public void accessSite() {
		driver = new ChromeDriver();
		driver.get("https://www.mycontactform.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		report = new ExtentReports("./ExtentReportResults.html");
		test =report.startTest("Working with a dropdown list box");
		test.log(LogStatus.PASS, "Link", "Successfully performed actions on a dropdown list box");
	}

	@AfterClass
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
		report.endTest(test);
		report.flush();
	}

}
