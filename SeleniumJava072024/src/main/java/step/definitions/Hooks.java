package step.definitions;

import com.main.Base;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;

public class Hooks{

	@Before
	public void setup() {
		System.out.println("Before hook is running..!");
	}
	
	@BeforeStep
	public void beforeStep() {
		System.out.println("Before step is running before each step in the scenario..!");
	}
	
	@AfterStep
	public void afterStep() {
		System.out.println("After step is running after each step in the scenario..!");
	}

	@After
	public void teardown(){
		Base.getDriver().quit();
		System.out.println("After hook is running..!");
	}
	
}