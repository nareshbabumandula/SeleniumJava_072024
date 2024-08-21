package com.selenium.scripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultipleWaysToLaunchBrowser {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver;

		// Approach 1:
		System.setProperty("webdriver.chrome.driver", "./browsers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.mycontactform.com");
		Thread.sleep(4000);
		driver.quit();

		// Approach 2:
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.google.co.in");
		Thread.sleep(4000);
		driver.quit();

		// Approach 3:
		driver = new ChromeDriver();
		driver.get("https://www.spicejet.com");
		Thread.sleep(4000);
		driver.quit();


	}

}
