package com.testng.scripts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.listeners.MyRetry;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import jxl.Sheet;
import jxl.Workbook;

public class ReadExcelDataProvider {


	@DataProvider(name="userLogin")
	public Object[][] loginData() throws FileNotFoundException{
		Object[][] arrayObject = getExcelData("./files/Test Data.xls", "Data") ;
		return arrayObject;
	}

	public String[][] getExcelData(String fileName, String sheetName) throws FileNotFoundException{
		String[][] arrayExcelData = null;

		try {
			FileInputStream fs = new FileInputStream(fileName);
			Workbook wb = Workbook.getWorkbook(fs);

			Sheet sh = wb.getSheet("Data");
			int nRows = sh.getRows();
			int nColumns = sh.getColumns();

			arrayExcelData = new String[nRows-1][nColumns];

			for(int i=1; i<nRows;i++) {
				for(int j=0;j<nColumns;j++) {
					arrayExcelData[i-1][j] = sh.getCell(j,i).getContents();
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return arrayExcelData;
	}

	WebDriver driver;
	static ExtentTest test;
	static ExtentReports report;

	@Test(retryAnalyzer = MyRetry.class, dataProvider = "userLogin")
	public void verifyLogin(String username, String password) {
		String errMsg="";
		boolean bFlag=false;
		try {
			driver.findElement(By.id("user")).sendKeys(username);
			driver.findElement(By.id("pass")).sendKeys(password);
			driver.findElement(By.className("btn_log")).click();
			bFlag=true;
			Assert.assertEquals(bFlag, true);
			test.log(LogStatus.PASS, "Enter username", "Entered username as : " +username);
			test.log(LogStatus.PASS, "Enter password", "Entered password as : " +password);
		} catch (Exception e) {
			errMsg = e.getMessage();
			test.log(LogStatus.FAIL, "Enter username", "Failed to enter username : " +username+ " since " + errMsg);
			// Hard Assertion
			//Assert.assertEquals(bFlag, true, "Failed to login into the application since :" +errMsg);
			// Soft Assertion
			SoftAssert softassert = new SoftAssert();
			softassert.assertEquals(bFlag, true, "Failed to login into the application since :" +errMsg);
			System.out.println("Test case failed..!");
			e.printStackTrace();
			softassert.assertAll();
		}
	}

	@BeforeClass
	public void accessSite() {
		driver = new ChromeDriver();
		driver.get("https://www.mycontactform.com");
		driver.manage().window().maximize();
		report = new ExtentReports("./ExtentReportResults.html");
		test =report.startTest("TestNG Parameters");
		test.log(LogStatus.PASS, "Access Site", "Access MCF site");
	}

	@AfterClass
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
		report.endTest(test);
		report.flush();
	}

}
