package step.definitions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.AssertJUnit;

import com.main.Base;
import com.object.repository.Homepage;
import com.object.repository.StoreSearchResultspage;
import com.qa.util.ExplicitWaitUtils;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EGW_StoreSearch_Steps {
	
	Homepage hp;
	StoreSearchResultspage sp = new StoreSearchResultspage(Base.getDriver());
	ExplicitWaitUtils wait;

	@Given("I access EGW website")
	public void accessSite() {
		Base.getDriver().get("https://www.eyeglassworld.com");
		Base.getDriver().manage().window().maximize();
		Base.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		System.out.println("Accessed EGW site");
	}

	@When("I want to search for an eyeglass store based on City, State or zipcode")
	public void searchStore() {
		Base.getDriver().findElement(hp.txtstoreSearch).sendKeys("Tampa");
		Base.getDriver().findElement(hp.btnfindStore).click();
		System.out.println("Searched the store based on city name");
	}

	@Then("So that I can see the store details")
	public void verifyStoreSearchResults() {
		String actCity = sp.getStoreName();
		AssertJUnit.assertEquals("Expected city is not found in the store search results..!", "Tampa", actCity);
		System.out.println("Successfully verified the store search results..!");
		Base.getDriver().quit();
	}

	@When("I want to search for an eyeglass store based on {string}")
	public void i_want_to_search_for_an_eyeglass_store_based_on(String citystatezipcode) {
		Base.getDriver().findElement(hp.txtstoreSearch).sendKeys(citystatezipcode);
		Base.getDriver().findElement(hp.btnfindStore).click();
		System.out.println("Searched the store based on : " + citystatezipcode);
	}
	
	@Then("So that I can see the store details {string}")
	public void so_that_i_can_see_the_store_details(String expCityStateZip) {
		String actCityStateZip = sp.getStoreName();
		AssertJUnit.assertEquals("Expected city/state/zip is not found in the store search results..!", expCityStateZip, actCityStateZip);
		System.out.println("Successfully verified the store search results..!");
		Base.getDriver().quit();
	}

	
	@When("I want to search for an eyeglass store based on following search criteria")
	public void i_want_to_search_for_an_eyeglass_store_based_on_following_search_criteria(io.cucumber.datatable.DataTable dataTable) {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
		List<String> data = dataTable.asList();
		for (int i = 0; i < data.size(); i++) {
			System.out.println(data.get(i));
			Base.getDriver().findElement(hp.txtstoreSearch).clear();
			Base.getDriver().findElement(hp.txtstoreSearch).sendKeys(data.get(i));
			Base.getDriver().findElement(hp.btnfindStore).click();
			wait.waitForElementToBeVisible(sp.storeName);
			Base.getDriver().navigate().back();
		}
	}
	
	@Then("So that I can see the appropriate store details")
	public void so_that_i_can_see_the_appropriate_store_details() {
		String actCityStateZip = sp.getStoreName();
		System.out.println("Store displayed is : " + actCityStateZip);
		Base.getDriver().quit();
	}



}
