package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import base.Main;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginFunctionalityTest extends Main{
	
	@Given("user is in home page of the application")
	public void user_is_in_home_page_of_the_application() {
//		initialization(); // handled in Hooks class
		Assert.assertEquals(driver.getTitle(), "Welcome: Mercury Tours");
	}

	@When("enters valid username")
	public void enters_valid_username() {
		driver.findElement(By.name("userName")).sendKeys("test12");
	}

	@And("enters valid password")
	public void enters_valid_password() {
		driver.findElement(By.name("password")).sendKeys("123");
	}

	@And("clicks submit button")
	public void clicks_submit_button() {
		driver.findElement(By.name("submit")).click();
	}

	@Then("user will be logged in")
	public void user_will_be_logged_in() {
		Assert.assertEquals(driver.getCurrentUrl(), "http://demo.guru99.com/test/newtours/login_sucess.php");
//		tearDown(); // handled in Hooks class
	}

	@And("will be able to see login success message")
	public void will_be_able_to_see_login_success_message() {
		WebElement loginSuccessMsg = driver.findElement(By.xpath("//table[@width='492']/tbody/tr[1]"));
		String actualLoginSuccessMsg = loginSuccessMsg.getText();
		String expectedLoginSuccessMsg = "Login Successfully";
		Assert.assertEquals(actualLoginSuccessMsg, expectedLoginSuccessMsg);
	}
	
	@When("enters invalid username")
	public void enters_invalid_username() {
		driver.findElement(By.name("userName")).sendKeys("tommy12334");
	}

	@When("enters invalid password")
	public void enters_invalid_password() {
		driver.findElement(By.name("password")).sendKeys("123456");
	}

	@Then("user will not be logged in")
	public void user_will_not_be_logged_in() {
		Assert.assertEquals(driver.getTitle(), "Welcome: Mercury Tours");
//		tearDown(); // handled in Hooks class
	}

	@And("will be seeing login error message")
	public void will_be_seeing_login_error_message() {
		WebElement loginErrorMsg = driver.findElement(By.xpath("//table[@width='192']/tbody/tr[4]"
				+ "/td/table/tbody/tr[3]/td[2]/span"));
		String actualErrorMsg = loginErrorMsg.getText();
		String expectedErrorMsg = "Enter your userName and password correct";
		Assert.assertEquals(actualErrorMsg, expectedErrorMsg);
	}
	
	// older format from Tidy Gherkin
	@When("^enters valid username \"([^\"]*)\"$") // \"([^\"]*)\" => parameter expression
	public void enters_valid_dataDriven_username(String username) {
		driver.findElement(By.name("userName")).sendKeys(username);
	}
	@And("^enters valid password \"([^\"]*)\"$")
	public void enters_valid_dataDriven_password(String password) {
		driver.findElement(By.name("password")).sendKeys(password);
	}
	
	// newer format from Console
	@When("enters invalid username {string}") // {string} => parameter expression
	public void enters_invalid_username(String username) {
		driver.findElement(By.name("userName")).sendKeys(username);
	}

	@And("enters invalid password {string}")
	public void enters_invalid_password(String password) {
		driver.findElement(By.name("password")).sendKeys(password);
	}

}
