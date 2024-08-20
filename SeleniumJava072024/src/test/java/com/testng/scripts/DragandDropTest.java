package com.testng.scripts;

import static org.testng.Assert.assertEquals;

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

public class DragandDropTest {
	
	WebDriver driver;
	static ExtentTest test;
	static ExtentReports report;

	@Test
	public void actionMethods() throws InterruptedException {
		boolean bFlag=false;
		String errMsg="";
		try {
			WebElement lnkdraggable = driver.findElement(By.linkText("Draggable"));
			lnkdraggable.click();
			
			driver.switchTo().frame(0);
			
			WebElement dragmearound = driver.findElement(By.id("draggable"));
			Actions action = new Actions(driver);
			action.dragAndDropBy(dragmearound, 280, 110).perform();
			Thread.sleep(4000);
			driver.switchTo().defaultContent(); // Exit from the frame
			driver.findElement(By.linkText("Droppable")).click();
			driver.switchTo().frame(0);

			WebElement draggable = driver.findElement(By.id("draggable"));
			WebElement droppable = driver.findElement(By.id("droppable"));
			action.dragAndDrop(draggable, droppable).perform();
			
			bFlag = driver.findElement(By.xpath("//p[contains(text(),'Dropped123!')]")).isDisplayed();
		} catch (Exception e) {
			e.printStackTrace();
			errMsg = e.getMessage();
		}
		
		finally {
			if (bFlag) {
				test.log(LogStatus.PASS, "Drag and Drop", "Successfully performed drag and drop using Actions class method");
			} else {
				test.log(LogStatus.FAIL, "Drag and Drop", "Failed to perform drag and drop operation since - " + errMsg);
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
