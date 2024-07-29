package com.selenium.naveen;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
public class AllBrowser {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver= new EdgeDriver();
		driver.get("https://wwww.eyeglassworld.com");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.navigate().to("https://makemytrip.com");
		Thread.sleep(2000);
		driver.navigate().to("https://www.youtube.com");
		driver.navigate().to("https://www.facebook.com");
		Thread.sleep(2000);
		driver.navigate().back();
		driver.navigate().forward();
		Thread.sleep(7000);
		driver.quit();
	}
}
