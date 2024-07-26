package com.selenium.saptagiri;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.edge.EdgeDriver;

public class Sample {
//	static WebDriver driver = new EdgeDriver();
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new EdgeDriver();
		driver.get("https://www.mycontactform.com");
		driver.manage().window().maximize();
		System.out.println(driver.getCurrentUrl()); //https://www.mycontactform.com/
		System.out.println(driver.getTitle());		//Free Contact and Email Forms - myContactForm.com
		String mainWindow = driver.getWindowHandle(); // in mainWndow, ID of the browser tab is stored
		Thread.sleep(3000);
		driver.quit();

		driver = new EdgeDriver(); // this must for another window
//		driver.navigate().to("https://www.eyeglassworld.com"); can also use this one
		driver.get("https://www.eyeglassworld.com");
		driver.manage().window().maximize();
		String currentUrl = driver.getCurrentUrl();
		String title = driver.getTitle();
		System.out.println(currentUrl);
		System.out.println(title);
		
		Set<String> new_Windows = driver.getWindowHandles();
		System.out.println("No of tabs opened are : " + new_Windows.size());
		try {
			driver.switchTo().newWindow(WindowType.TAB);
			driver.navigate().to("https://www.eyeglassworld.com/location/search/");
			driver.quit();
		} finally {
			WebDriver anotherWindow = new EdgeDriver();
			anotherWindow.switchTo().newWindow(WindowType.WINDOW);
			anotherWindow.switchTo().newWindow(WindowType.TAB);
			if (anotherWindow != null) {
				Thread.sleep(3000);
                anotherWindow.quit();
            }
		}
	}
}
