package com.selenium.scripts;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BrowserTest {
	WebDriver driver;
	
	public void accessSite(String browser) throws InterruptedException {
		switch (browser.toLowerCase().trim()) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		case "safari":
			driver = new SafariDriver();
			break;
		default:
			System.out.println("Invalid browser..!");
			break;
		}
		driver.get("https://www.mycontactform.com");
		driver.manage().window().maximize();
		System.out.println(driver.getCurrentUrl()); // Browser current URL
		System.out.println(driver.getTitle()); // Browser tab title
		String mainWindow = driver.getWindowHandle();
		System.out.println(driver.getWindowHandle()); // Session ID
		driver.navigate().to("https://www.mycontactform.com/samples.php");
		driver.navigate().back();
		driver.navigate().refresh();
		Thread.sleep(2000);
		
		WebElement aboutUs = driver.findElement(By.linkText("About Us"));
		aboutUs.sendKeys(Keys.CONTROL, Keys.RETURN);
		System.out.println(driver.getWindowHandles()); // Session ID's of multiple windows
		
		Set<String> windows = driver.getWindowHandles();
		System.out.println("No of tabs opened are : " + windows.size());
		
		Iterator<String> iter = windows.iterator();
		
		while (iter.hasNext()) {
			String childWindow = iter.next();
			System.out.println("Window session id is : " + childWindow);
			if (!mainWindow.equals(childWindow)) {
				driver.switchTo().window(childWindow);
				driver.findElement(By.id("email")).sendKeys("qatestuser@gmail.com");
				Thread.sleep(3000);
				driver.close();
			}
		}
		driver.switchTo().window(mainWindow);
		driver.findElement(By.id("user")).sendKeys("testuser");
		Thread.sleep(2000);
		driver.quit();
	}

	public static void main(String[] args) throws InterruptedException {
		BrowserTest bt = new BrowserTest();
		bt.accessSite("chrome");
	}

}
