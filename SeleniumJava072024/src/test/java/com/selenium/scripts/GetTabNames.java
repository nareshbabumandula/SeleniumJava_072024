package com.selenium.scripts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class GetTabNames {
	WebDriver driver;
	static ExtentTest test;
	static ExtentReports report;
	@Test
	public void xpathaxesExamples() throws InterruptedException {
		try {
			List<WebElement> tabs = driver.findElements(By.xpath("//div[@id='header']/ul/li/*"));
			System.out.println("No of tabs displayed are : " + tabs.size());
			test.log(LogStatus.PASS, "No of tabs displayed in MCF page are : " + tabs.size());
			
			tabs.forEach(tab->System.out.println(tab.getText()));
			
			for (WebElement tab : tabs) {
				System.out.println("Tab name is : " + tab.getText());
				test.log(LogStatus.PASS, "'" + tab.getText() +  "' tab is displayed");
			}
			
			Thread.sleep(1000);
			test.log(LogStatus.PASS, "Successfully retrived all the tab names");
		}
		catch(Exception e){
			test.log(LogStatus.FAIL, "Test Failed" + e.getMessage());
		}
	}
	
	@BeforeClass
	public void beforeClass() {
		driver = new ChromeDriver();
		driver.get("https://www.mycontactform.com/");
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

