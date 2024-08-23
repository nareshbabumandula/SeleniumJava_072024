package com.object.repository;

import org.openqa.selenium.By;

public class Homepage {
	
	// Page Object Model
	public static By txtstoreSearch = By.id("inputStoreValue");
	public static By btnfindStore = By.xpath("//button[contains(@class, 'a-btn--is-slim m-store-finder__submit')]");
	
}
