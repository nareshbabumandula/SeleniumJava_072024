package com.selenium.naveen;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class NewWindowAndNewTab {
	public static void main(String[] args) throws InterruptedException {
		WebDriver dr = new ChromeDriver();
		dr.get("https://www.saragreg.com");
		Thread.sleep(5000);
		dr.navigate().to("https://www.amazon.com");
		Thread.sleep(5000);
		dr.quit();

		try {
			dr.get("https://www.eyeglassworld.com/location/search/");	
			Thread.sleep(5000);
			dr.switchTo().newWindow(WindowType.TAB);  //This tab opens in first window
			Thread.sleep(5000);
			dr.switchTo().newWindow(WindowType.WINDOW);
			Thread.sleep(5000);
			dr.get("https://www.flipkart.com");
			Thread.sleep(5000);
			dr.switchTo().newWindow(WindowType.TAB);  //This tab opens in first window only but not in recently opened window
			Thread.sleep(3000);
			WebDriver dr1 = new ChromeDriver();
			dr1.get("https://www.amazon.com");
			dr1.switchTo().newWindow(WindowType.TAB);
			Thread.sleep(3000);
			dr1.quit();
		}
		finally {
			Set<String> gt=dr.getWindowHandles();
			System.out.println(gt);
			dr.quit();
		}
		WebDriver edg = new EdgeDriver();
		edg.get("https://www.eyeglassworld.com/location/search/");
		edg.switchTo().newWindow(WindowType.WINDOW);
		Thread.sleep(5000);
		String str = edg.getWindowHandle();
		System.out.println(str);
		edg.switchTo().newWindow(WindowType.TAB);
		Thread.sleep(5000);
		Set<String> st=edg.getWindowHandles();
		System.out.println(st);
		edg.quit();
	}

}
