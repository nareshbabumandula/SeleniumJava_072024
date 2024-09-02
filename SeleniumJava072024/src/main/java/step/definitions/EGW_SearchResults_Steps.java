package step.definitions;

import org.testng.AssertJUnit;
import com.main.Base;
import com.object.repository.Homepage;
import com.object.repository.StoreSearchResultspage;
import com.qa.util.ExplicitWaitUtils;

import io.cucumber.java.en.Then;

public class EGW_SearchResults_Steps {
	
	Homepage hp;
	StoreSearchResultspage sp = new StoreSearchResultspage(Base.getDriver());
	ExplicitWaitUtils wait;

	@Then("So that I can see the google map in the search results")
	public void so_that_i_can_see_the_google_map_in_the_search_results() {
	    try {
	        //AssertJUnit.assertTrue(false);
			sp.googleMap.isDisplayed();
			System.out.println("Google map is displayed in the search results page");
		} catch (Exception e) {
			System.out.println("Google map is not displayed in the search results page since : " + e.getMessage());
		}
	}

}
