package testcases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseClass;
import PageObjects.HomePage;
import PageObjects.ShopPage;
import Utilities.ConfigUtil;
import io.github.bonigarcia.wdm.WebDriverManager;

/*
 * 1) Open the browser
2) Enter the URL “http://practice.automationtesting.in/”
3) Click on Shop Menu
4) Now click on Home menu button
5) Test whether the Home page has Three Arrivals only
6) The Home page must contains only three Arrivals
 */

public class TC_HomePage_002 extends BaseClass
{
	HomePage homePage;
	ShopPage shopPage;
	
	
	@Test
	public void testArrivals()
	{
		
		driver.get(ConfigUtil.getBaseURL());
		homePage=new HomePage(driver);
		shopPage=homePage.clickONShopLink();
		homePage=shopPage.clickOnHomePageLink();
		int listSize=homePage.getArrivalsCount();
		System.out.println("the size of list is : "+listSize);
		Assert.assertEquals(listSize, 3);
		
		
	}
	

}
