package testcases;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.dockerjava.api.command.PullImageCmd;

import Base.BaseClass;
import PageObjects.HomePage;
import PageObjects.ProductAddToCartPage;
import PageObjects.ShopPage;
import Utilities.ConfigUtil;

public class TC_HomePage_003 extends BaseClass
{
	HomePage homePage;
	ShopPage shopPage;
	ProductAddToCartPage productAddToCartPage;
	@Test
	public void verifyIsArrivalsClickable() throws InterruptedException
	{
		driver.get(ConfigUtil.getBaseURL());
		homePage=new HomePage(driver);
		shopPage=homePage.clickONShopLink();
		homePage=shopPage.clickOnHomePageLink();
		int listSize=homePage.getArrivalsCount();
		System.out.println("the size of list is : "+listSize);
		Assert.assertEquals(listSize, 3);
		List<WebElement> arrivalsList=  homePage.getArrivalsList();
	
		int i=0;
		for(WebElement element:arrivalsList)
		{
			Thread.sleep(3000);
		
			arrivalsList.get(i).click();
			i++;
			productAddToCartPage=new ProductAddToCartPage(driver);
			System.out.println("title of page is:  "+driver.getTitle());
			
			Assert.assertTrue(productAddToCartPage.isAddToCartButtonPresent());		
			Thread.sleep(5000);
			driver.navigate().back();
		}
		
		
	}

}
