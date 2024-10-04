package testCases;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.*;
import org.testng.annotations.Parameters;

public class BaseClass 
{

public WebDriver driver;
public Properties p;
	
	@BeforeClass
	@Parameters({"os","browser"})
	public void setup(String os, String browser) throws IOException
	{
		
		FileReader file=new FileReader("./src//test//resources//config.properties");
		p=new Properties();
		p.load(file);
		
		if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
		{
			DesiredCapabilities capabilities=new DesiredCapabilities();
			
			//os
			if(os.equalsIgnoreCase("windows"))
			{
				capabilities.setPlatform(Platform.WIN10);
			}
			else if(os.equalsIgnoreCase("mac"))
			{
				capabilities.setPlatform(Platform.MAC);
			}
			else
			{
				System.out.println("No matching OS");
				return;
			}
			
			//browser
			switch(browser.toLowerCase())
			{
			case "chrome":capabilities.setBrowserName("chrome");
			break;
			case "edge":capabilities.setBrowserName("MicrosoftEdge");
			break;
			case "fire fox":capabilities.setBrowserName("firefox");

			default : System.out.println("No matching Browser");
			}
			
			driver=new RemoteWebDriver(new URL("http://192.168.14.2:4444/wd/hub"),capabilities);
		}
		
		if(p.getProperty("execution_env").equalsIgnoreCase("local"))
		{
			switch(browser.toLowerCase())
				{
					case "chrome":driver=new ChromeDriver();
					break;
					case "edge":driver=new EdgeDriver();
					break;
					default : System.out.println("Invalid Browser Details");
				}
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//driver.get("http://localhost/opencart/upload/");
		driver.get(p.getProperty("appURL"));
	}
	
	@AfterClass
	public void teardown()
	{
//		driver.quit();
	}
	
	public String randomString()
	{
		String randomName=RandomStringUtils.randomAlphabetic(5);
		return randomName;
	}
	
	public String randomNumber()
	{
		String randomNo=RandomStringUtils.randomNumeric(10);
		return randomNo;
	}
	
	public String randomPassword()
	{
		String randomPassString=RandomStringUtils.randomAlphabetic(5);
		String randomPassNumber=RandomStringUtils.randomNumeric(10);
		String randomPass=randomPassString+"@"+randomPassNumber;
		return randomPass;
	}
}
