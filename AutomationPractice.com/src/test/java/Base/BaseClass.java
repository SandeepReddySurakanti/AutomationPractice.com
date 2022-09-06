package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import Utilities.ConfigUtil;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass 
{
	public static WebDriver driver;
	
	public BaseClass()
	{
		
	}
	@BeforeTest
	public void testSetUp()
	{
	
		
	}
	@BeforeClass
	public void setUpDriver()
	{
		if(ConfigUtil.getBowser().equalsIgnoreCase("Chrome"))
		{
			System.out.println("entered in chromedriver method");
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if (ConfigUtil.getBowser().equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
					
	}
	@AfterClass
	public void closeBrowser()
	{
		driver.close();
	}
	
}
