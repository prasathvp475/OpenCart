package testCases;

import org.junit.Assert;
import org.testng.annotations.*;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;

public class TC002_LoginTest extends BaseClass{

	@Test
	public void verify_Login()
	{
		//logger.info("****Starting TC002_LoginTest****");
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		LoginPage lp=new LoginPage(driver);
		lp.enterEmail(p.getProperty("email"));
		lp.enterPassword(p.getProperty("password"));
		lp.clickLogin();
		
		MyAccountPage myAcc=new MyAccountPage(driver);
		boolean statusMyAccount=myAcc.isMyAccountPageExists();
		
		Assert.assertTrue(statusMyAccount);
	}
}
