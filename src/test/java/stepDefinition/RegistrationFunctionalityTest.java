package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import base.Main;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegistrationFunctionalityTest extends Main{
	
	@When("user provides all the required details {string}, {string}, {string}, {string}, {string} & {string}")
	public void user_provides_all_the_required_details(String firstName, String lastName, String country, String username, String password, String confirmPassword) {
	 driver.findElement(By.name("firstName")).sendKeys(firstName);
	 driver.findElement(By.name("lastName")).sendKeys(lastName);
	 //drop down
	 Select select = new Select(driver.findElement(By.name("country")));
	 select.selectByVisibleText(country);
	 
	 driver.findElement(By.name("email")).sendKeys(username);
	 driver.findElement(By.name("password")).sendKeys(password);
	 driver.findElement(By.name("confirmPassword")).sendKeys(confirmPassword); 
	}

	@Then("user should be able to register")
	public void user_should_be_able_to_register() {
	 String expectedFlightFinderPageUrl = "http://demo.guru99.com/test/newtours/register_sucess.php";
	 String actualFlightFinderPageUrl = driver.getCurrentUrl();
	 Assert.assertEquals(actualFlightFinderPageUrl, expectedFlightFinderPageUrl);
	}

	@And("user should be able to see successful registration message with provide {string}")
	public void user_should_be_able_to_see_successful_registration_message_with_provide(String username) {
	   String expectedSuccessMsg = "Note: Your user name is "+username+".";
	   String actualSuccessMsg = driver.findElement(By.xpath("//table[@width='492']/tbody/tr[3]/td/p[3]/font")).getText();
	   Assert.assertEquals(actualSuccessMsg, expectedSuccessMsg);
	}

	@And("user doesn't provide any required data")
	public void user_doesn_t_provide_any_required_data() {
		driver.findElement(By.name("firstName")).clear();
		 driver.findElement(By.name("lastName")).clear();
		 Select select = new Select(driver.findElement(By.name("country")));
		 select.selectByIndex(0);;
		 
		 driver.findElement(By.name("email")).clear();
		 driver.findElement(By.name("password")).clear();
		 driver.findElement(By.name("confirmPassword")).clear(); 
	}
	@Then("user should not be able to register")
	public void user_should_not_be_able_to_register() {
	    Assert.assertEquals(driver.getTitle(), "Register : Mercury Tours");
	}
	@And("user should be able to see error message")
	public void user_should_be_able_to_see_error_message() {
	    Assert.assertTrue(driver.findElement(By.xpath(
	    		"//font[text()='Enter values in required fields.']")).isDisplayed());
	}




}
