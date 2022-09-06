package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseClass;
import PageObjects.HomePage;
import PageObjects.ProductAddToCartPage;
import PageObjects.ShopPage;
import Utilities.ConfigUtil;

public class TC_HomePage_007 extends BaseClass
{
	HomePage homePage;
	ShopPage shopPage;
	ProductAddToCartPage productAddToCartPage;
	
	@Test
	public void checkForQuantityInput() throws InterruptedException
	{
		driver.get(ConfigUtil.getBaseURL());
		homePage=new HomePage(driver);
		shopPage= homePage.clickONShopLink();
		homePage=shopPage.clickOnHomePageLink();
		productAddToCartPage=homePage.clickONRubybook();
		Thread.sleep(2000);
		String bookStock=productAddToCartPage.getBooksStock();
		productAddToCartPage.enterQuantity(bookStock+1);
		
		productAddToCartPage.clickOnAddToCart();
		Assert.assertFalse(productAddToCartPage.isLink_ViewasketEnabled());
		
			
	
	}

}
