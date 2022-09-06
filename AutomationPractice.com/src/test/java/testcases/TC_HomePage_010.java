package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseClass;
import PageObjects.HomePage;
import PageObjects.ProceedToCheckOutPage;
import PageObjects.ProductAddToCartPage;
import PageObjects.ShopPage;
import Utilities.ConfigUtil;

public class TC_HomePage_010 extends BaseClass
{
	HomePage homePage;
	ShopPage shopPage;
	ProductAddToCartPage productAddToCartPage;
	ProceedToCheckOutPage proceedToCheckOutPage;
	
	@Test
	public void checkForCouponNotAppliedOnLessThan450() throws InterruptedException
	{
		driver.get(ConfigUtil.getBaseURL());
		homePage=new HomePage(driver);
		shopPage= homePage.clickONShopLink();
		homePage=shopPage.clickOnHomePageLink();
		productAddToCartPage=homePage.clickOnJavaScriptBook();;
		Thread.sleep(2000);
		//String bookStock=productAddToCartPage.getBooksStock();
		//productAddToCartPage.enterQuantity("10");
		
		productAddToCartPage.clickOnAddToCart();
		String menuListPrice =productAddToCartPage.getMenuListPrice();
		String MenuListQuantity=productAddToCartPage.getMenuListQuantity();
		System.out.println("Menu list items are:"+menuListPrice+" "+MenuListQuantity);
		
		proceedToCheckOutPage=productAddToCartPage.clickOnMenuList();
		String couponString="krishnasakinala";
		
		proceedToCheckOutPage.enterCouponCode(couponString);
		proceedToCheckOutPage.clickOnApplyCoupon();
		String errMessage="The minimum spend for this coupon is ₹450.00";
		Assert.assertTrue(driver.getPageSource().contains(couponString));
		
	
		//Assert.assertFalse(productAddToCartPage.isLink_ViewasketEnabled());		
			
	
	}


}
