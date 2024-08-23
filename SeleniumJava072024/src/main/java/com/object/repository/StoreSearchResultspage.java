package com.object.repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import com.main.Base;

public class StoreSearchResultspage {

	WebDriver driver;
	
	@FindBy(id="inputStoreValue")
	private WebElement txtstoreSearch;
	
	@FindBy(how = How.XPATH, using = "//button[contains(@class, 'a-btn--is-slim m-store-finder__submit')]")
	private WebElement btnFindStore;
	
	@FindBy(xpath = "(//div[@class='Locator-resultsSummary']/h2/span[2])[1]")
	private WebElement storeName;

	public void enterCityStateZip(String citystatezip) {
		txtstoreSearch.sendKeys(citystatezip);
	}
	
	public String getStoreName() {
		return storeName.getText();
	}
	
	public StoreSearchResultspage(WebDriver driver) {
		this.driver = Base.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	
}
