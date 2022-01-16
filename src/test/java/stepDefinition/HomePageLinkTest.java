package stepDefinition;

import org.openqa.selenium.By;
import org.testng.Assert;

import base.Main;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePageLinkTest extends Main{
	
	@Given ("user is in homepage")
	public void user_is_in_homepage() {
//		initialization(); // handled in Hooks class
		Assert.assertEquals(driver.getTitle(), "Welcome: Mercury Tours");
	}
	
	@When("user clicks Flights link")
	public void user_clicks_flights_link() {
	   driver.findElement(By.linkText("Flights")).click();
	}

	@Then("user will land into Flight Finder page")
	public void user_will_land_into_flight_finder_page() {
		String expectedFightFinderPageTitle = "Find a Flight: Mercury Tours";
		Assert.assertEquals(driver.getTitle(), expectedFightFinderPageTitle);    
//		tearDown(); // handled in Hooks class
	}

	@When("^user clicks Register link$")
	public void user_clicks_register_link() {
		driver.findElement(By.linkText("REGISTER")).click();
	}

	@Then("^user will land into Register page$")
	public void user_will_land_into_register_page() {
		String expectedRegisterPageTitle = "Register: Mercury Tours";
		Assert.assertEquals(driver.getTitle(), expectedRegisterPageTitle); 
//		tearDown(); // handled in Hooks class
	}
}
