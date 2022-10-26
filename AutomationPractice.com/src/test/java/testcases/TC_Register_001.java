package testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.BaseClass;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.UserHomePage;
import Utilities.ConfigUtil;
import Utilities.RandomStringUtil;

public class TC_Register_001 extends BaseClass
{
	HomePage homePage;
	LoginPage loginPage;
	UserHomePage userHomePage;
	@BeforeMethod
	public void enterUrl()
	{
		driver.get(ConfigUtil.getBaseURL());
	}
	@Test
	public void testWithValidEmailAndPswd()
	{
		homePage=new HomePage(driver);
		loginPage=homePage.clickOnMyAccount();
		
		String randomString=RandomStringUtil.getRandomString(5);
		String emailString=randomString+"@test.com";
		System.out.println("Random generated email is :"+emailString);
		String passwordString="@Test@147258";
		
		loginPage.enterEmailforRegistration(emailString);
		loginPage.enterPasswornForRegistraion(passwordString);
		userHomePage=loginPage.ClickOnRegisterButton();
		String expString=userHomePage.getUsername();
		Assert.assertEquals(randomString, expString);
		
		userHomePage.clickOnLogout();
	}

}
