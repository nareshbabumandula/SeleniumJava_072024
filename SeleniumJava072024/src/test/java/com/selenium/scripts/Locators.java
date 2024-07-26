package com.selenium.scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {
	
	static WebDriver driver;

	/**
	 * In Selenium we have 8 different locators
		 * 1. ID
		 * 2. Name
		 * 3. Classname
		 * 4. CSS
		 * 5. Linktext
		 * 6. PartialLinktext
		 * 7. TagName
		 * 8. XPath
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
	   driver = new ChromeDriver();
	   driver.get("https://www.mycontactform.com");
	   driver.manage().window().maximize();
	   
	// 1. Using id Locator to locate the username field
	   driver.findElement(By.id("user")).sendKeys("Sapthagiri");
	   
	// 2. Using name Locator to locate the password field
	   driver.findElement(By.name("pass")).sendKeys("Secure*1234");
	   
	// 3. Using className Locator to locate the Login button
	   driver.findElement(By.className("btn_log")).click();
	   
	// 4. Using CSS Selector Locator to locate the username field
	   // CSS Syntax : html tag[attribute='value']
	   driver.findElement(By.cssSelector("input[id='user']")).sendKeys("Vinay");
	   Thread.sleep(2000);
	   driver.findElement(By.cssSelector("input[id='user']")).clear();
	   
	// 5. Using CSS Selector Locator to locate the username field with # as a replacement for ID
	   driver.findElement(By.cssSelector("input#user")).sendKeys("Saiteja");
	   Thread.sleep(2000);
	   driver.findElement(By.cssSelector("input#user")).clear();
	   
	// 6. Using CSS Selector Locator to locate the username field with . as a replacement for Class
	   driver.findElement(By.cssSelector("input.txt_log")).sendKeys("Ravi");
	 
	   Thread.sleep(3000);
	   driver.quit();
	}

}
