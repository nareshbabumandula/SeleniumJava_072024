package com.selenium.scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
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
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input.txt_log")).clear();

		// 7. Using CSS Selector Locator to locate the username field with starts with function
		driver.findElement(By.cssSelector("input[id^='use']")).sendKeys("Naveen");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input[id^='use']")).clear();

		// 8. Using CSS Selector Locator to locate the username field with ends with function
		driver.findElement(By.cssSelector("input[id$='ser']")).sendKeys("Pradeep");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input[id$='ser']")).clear();

		// 9. Using CSS Selector Locator to locate the username field with contains function
		driver.findElement(By.cssSelector("input[id*='use']")).sendKeys("Shravan");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input[id*='use']")).clear();

		// Absolute CSS Path
		driver.findElement(By.cssSelector("html>body>div:nth-of-type(3)>div:nth-of-type(2)>div>form>fieldset>div>input")).sendKeys("Sheshu");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("html>body>div:nth-of-type(3)>div:nth-of-type(2)>div>form>fieldset>div>input")).clear();

		// CSS Path from the node of our choice
		driver.findElement(By.cssSelector("div:nth-of-type(2)>div>form>fieldset>div>input")).sendKeys("Prashanth");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("div:nth-of-type(2)>div>form>fieldset>div>input")).clear();

		// Using linkText locator to locate link in a webpage
		driver.findElement(By.linkText("Sample Forms")).click();
		Thread.sleep(1000);
		driver.navigate().back();
		Thread.sleep(1000);

		// Using partialLinkText locator to locate link in a webpage
		driver.findElement(By.partialLinkText("Sample")).click();
		Thread.sleep(1000);
		driver.navigate().back();
		Thread.sleep(1000);

		// Using tagName locator to locate a field
		driver.findElement(By.tagName("input")).sendKeys("Bhanu");
		Thread.sleep(1000);
		driver.findElement(By.tagName("input")).clear();

		// Using relative xpath with attributes locator to locate a field
		driver.findElement(By.xpath("//input[@id='user']")).sendKeys("Swetha");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='user']")).clear();

		// Using absolute xpath
		driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/form/fieldset/div/input")).sendKeys("Sumithra");
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/form/fieldset/div/input")).clear();

		// Using relative xpath by choosing the node of choice
		driver.findElement(By.xpath("//form/fieldset/div/input")).sendKeys("Rajini");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//form/fieldset/div/input")).clear();
		
		// Using relative xpath with starts-with
		driver.findElement(By.xpath("//input[starts-with(@id,'use')]")).sendKeys("Vinay");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[starts-with(@id,'use')]")).clear();
		
		// Using relative xpath with contains
		driver.findElement(By.xpath("//input[contains(@id,'se')]")).sendKeys("Sapthagiri");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[contains(@id,'se')]")).clear();
		
		// Using xpath with and keyword
		driver.findElement(By.xpath("//input[@id='user' and @name='user']")).sendKeys("John");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='user' and @name='user']")).clear();
		
		// Using xpath with or keyword
		driver.findElement(By.xpath("//input[@id='user' or @name='user']")).sendKeys("Alex");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='user' or @name='user']")).clear();
		
		// Using xpath with or operator 
		driver.findElement(By.xpath("//input[@id='user'] | //input[@name='user23523536']")).sendKeys("Ramana");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='user'] | //input[@name='user23523536']")).clear();
		
		//added the following code snippets - Saptagiri
		driver.switchTo().newWindow(WindowType.TAB);
		driver.navigate().to("https://www.mycontactform.com/how.php");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@id='user' and @name='user' and @class='txt_log']")).sendKeys("Aariv");
		driver.findElement(By.xpath("//input[@id='user' and @name='user' and @class='txt_log']")).clear();

		driver.findElement(By.xpath("//input[@id='user' or @name='user' or @class='txt_log']")).sendKeys("Shresta");
		driver.findElement(By.xpath("//input[@id='user' or @name='user' or @class='txt_log']")).clear();
		driver.findElement(By.xpath("//img[contains(@class,'test_')]"));
		
		Thread.sleep(3000);
		driver.quit();
	}

}
