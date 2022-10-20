package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseClass;
import PageObjects.HomePage;
import PageObjects.PaymentGatewayPage;
import PageObjects.ProceedToCheckOutPage;
import PageObjects.ProductAddToCartPage;
import PageObjects.ShopPage;
import Utilities.ConfigUtil;

public class TC_HomePage_016 extends BaseClass
{
	HomePage homePage;
	ShopPage shopPage;
	ProductAddToCartPage productAddToCartPage;
	ProceedToCheckOutPage proceedToCheckOutPage;
	PaymentGatewayPage paymentGatewayPage;
	
	@Test
	public void checkForProceedToCheckOutButton() throws InterruptedException
	{
		driver.get(ConfigUtil.getBaseURL());
		homePage=new HomePage(driver);
		shopPage= homePage.clickONShopLink();
		homePage=shopPage.clickOnHomePageLink();
		productAddToCartPage=homePage.clickOnJavaScriptBook();;
		Thread.sleep(2000);
		//String bookStock=productAddToCartPage.getBooksStock();
		productAddToCartPage.enterQuantity("10");
		
		productAddToCartPage.clickOnAddToCart();
		String menuListPrice =productAddToCartPage.getMenuListPrice();
		String MenuListQuantity=productAddToCartPage.getMenuListQuantity();
		System.out.println("Menu list items are:"+menuListPrice+" "+MenuListQuantity);
		proceedToCheckOutPage=productAddToCartPage.clickOnMenuList();
		float subtotalPrice=Float.parseFloat(proceedToCheckOutPage.getSubTotal());
		float totalCartPrice=Float.parseFloat(proceedToCheckOutPage.getTotalCartPrice());
		Assert.assertTrue(totalCartPrice>=subtotalPrice);
		paymentGatewayPage=proceedToCheckOutPage.clickOnProceedToCheckOutButton();
		String actTitle=driver.getTitle();
		System.out.println("Title of page is :"+actTitle);
		String expTitle="Checkout &#8211; Automation Practice Site";
		//Assert.assertEquals(actTitle, expTitle);
		Assert.assertTrue(driver.getPageSource().contains("Billing Details"));
		
	}

}
