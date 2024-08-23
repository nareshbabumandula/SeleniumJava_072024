package step.definitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.AssertJUnit;

import com.main.Base;
import com.object.repository.Homepage;
import com.object.repository.StoreSearchResultspage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EGW_StoreSearch_Steps {
	
	Homepage hp;
	StoreSearchResultspage sp = new StoreSearchResultspage(Base.getDriver());

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



}
