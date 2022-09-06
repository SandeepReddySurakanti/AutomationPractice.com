package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseClass;
import PageObjects.HomePage;
import PageObjects.ProductAddToCartPage;
import PageObjects.ShopPage;
import Utilities.ConfigUtil;

public class TC_HomePage_006_2 extends BaseClass
{
	HomePage homePage;
	ShopPage shopPage;
	ProductAddToCartPage productAddToCartPage;
	
	@Test
	public void checkForPrice() throws InterruptedException
	{
		driver.get(ConfigUtil.getBaseURL());
		homePage=new HomePage(driver);
		shopPage= homePage.clickONShopLink();
		homePage=shopPage.clickOnHomePageLink();
		productAddToCartPage=homePage.clickONRubybook();
		Thread.sleep(2000);
		//String priceOfBook= productAddToCartPage.getBookPrice();
		//System.out.println("The price of book is :"+priceOfBook);
		productAddToCartPage.clickOnAddToCart();
		Assert.assertTrue(productAddToCartPage.isLink_ViewasketEnabled());
		
		//Assert.assertNotEquals(priceOfBook, "");
			
	
	}

}
