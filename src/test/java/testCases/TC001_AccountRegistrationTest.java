package testCases;

import org.testng.*;
import org.testng.annotations.*;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;

public class TC001_AccountRegistrationTest extends BaseClass{

	
	
	
	@Test
	void verify_account_registration()
	{
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickRegister();
		
		AccountRegistrationPage arp=new AccountRegistrationPage(driver);
		arp.setFirstName("John");
		arp.setLastName("Joe");
		arp.setEmail(randomString()+"@gmail.com");
		arp.setTelephone("1233456789");
		
		String password=randomPassword();
		arp.setPassword(password);
		arp.setConfirmPassword(password);
		arp.clickCheckPolicy();
		arp.clickCnButton();
		String actCreatedText=arp.getConfirmationMsg();
//		System.out.print(actCreatedText);
		
		Assert.assertEquals(actCreatedText, "Your Account Has Been Created!");
		
	}
	
	
	
	
	
}
