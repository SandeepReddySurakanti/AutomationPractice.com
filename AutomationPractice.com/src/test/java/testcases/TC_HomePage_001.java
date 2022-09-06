package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseClass;
import PageObjects.HomePage;
import Utilities.ConfigUtil;

/*
 * 1) Open the browser
2) Enter the URL “http://practice.automationtesting.in/”
3) Click on Shop Menu
4) Now click on Home menu button
5) Test whether the Home page has Three Sliders only
6) The Home page must contains only three sliders
 */

public class TC_HomePage_001 extends BaseClass
{
	HomePage homePage;
	@Test
	public void verifySliders()
	{
		driver.get(ConfigUtil.getBaseURL());
		homePage=new HomePage(driver);
		int sliderCount=homePage.getSliderCount();
		System.out.println("No of slides are: "+sliderCount);
		Assert.assertEquals(3, sliderCount);
		
	
	}

}
