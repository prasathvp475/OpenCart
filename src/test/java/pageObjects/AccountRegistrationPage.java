package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {

	public AccountRegistrationPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(css="#input-firstname")
	WebElement textFirstName;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement textLastName;
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement textEmail;
	
	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement intTelephone;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement textPassword;
	
	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement textConfirmPassword;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement checkPolicy;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement buttonContinue;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement confirmationMessage;
	
	public void setFirstName(String fname)
	{
		textFirstName.sendKeys(fname);
	}
	
	public void setLastName(String lname)
	{
		textLastName.sendKeys(lname);
	}
	
	public void setEmail(String email)
	{
		textEmail.sendKeys(email);
	}
	
	public void setTelephone(String phnumber)
	{
		intTelephone.sendKeys(phnumber);
	}
	
	public void setPassword(String pass)
	{
		textPassword.sendKeys(pass);
	}
	
	public void setConfirmPassword(String pass)
	{
		textConfirmPassword.sendKeys(pass);
	}
	public void clickCheckPolicy()
	{
		checkPolicy.click();
	}
	
	public void clickCnButton()
	{
		buttonContinue.click();
	}
	
	public String getConfirmationMsg()
	{
		try 
		{
			return confirmationMessage.getText();
		}
		catch(Exception e)
		{
			return (e.getMessage());
		}
	}
	
	
}
