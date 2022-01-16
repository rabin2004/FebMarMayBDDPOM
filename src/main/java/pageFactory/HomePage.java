package pageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Main;


public class HomePage extends Main{
	// 1. Create webElement -> @FindBy
	@FindBy(name="userName") // driver.findElement(By.name("userName"));
	WebElement usernameTxtBox;
	@FindBy(name="password")
	WebElement passwordTxtBox;
	@FindBy(name="submit")
	WebElement submitBtn;
	@FindBy(xpath="//td[@width='112']/span")
	WebElement loginErrorMsg;
	
	// 2. initialize webElement with driver -> in constructor
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	// 3. Actions to the webElement
	public void enterUserName(String username) {
		usernameTxtBox.sendKeys(username);
	}
	
	public void enterPassword(String password) {
		passwordTxtBox.sendKeys(password);
	}
	
	public void clickSubmitBtn() {
		submitBtn.click();
	}
	
	public boolean validateLoginErrorMsg() {
		boolean errorMsgValidation = loginErrorMsg.isDisplayed();
		return errorMsgValidation;
	}

}
