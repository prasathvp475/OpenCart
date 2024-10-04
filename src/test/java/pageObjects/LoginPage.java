package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) 
	{
		super(driver);
	}
	
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement emailBox;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement passwordBox;
		
	@FindBy(xpath="//input[@value='Login']")
	WebElement loginButton;
		
	public void enterEmail(String email)
	{
		emailBox.sendKeys(email);
	}
	
	public void enterPassword(String password)
	{
		passwordBox.sendKeys(password);
	}
	
	public void clickLogin()
	{
		loginButton.click();
	}
	
	
	
}
