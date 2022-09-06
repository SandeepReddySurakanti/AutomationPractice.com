package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseClass;
import PageObjects.HomePage;
import PageObjects.ProceedToCheckOutPage;
import PageObjects.ProductAddToCartPage;
import PageObjects.ShopPage;
import Utilities.ConfigUtil;

public class TC_HomePage_008 extends BaseClass
{
	HomePage homePage;
	ShopPage shopPage;
	ProductAddToCartPage productAddToCartPage;
	ProceedToCheckOutPage proceedToCheckOutPage;
	
	@Test
	public void checkForNavigatingtoProceedToCheckOutPage() throws InterruptedException
	{
		driver.get(ConfigUtil.getBaseURL());
		homePage=new HomePage(driver);
		shopPage= homePage.clickONShopLink();
		homePage=shopPage.clickOnHomePageLink();
		productAddToCartPage=homePage.clickONRubybook();
		Thread.sleep(2000);
		//String bookStock=productAddToCartPage.getBooksStock();
		productAddToCartPage.enterQuantity("10");
		
		productAddToCartPage.clickOnAddToCart();
		String menuListPrice =productAddToCartPage.getMenuListPrice();
		String MenuListQuantity=productAddToCartPage.getMenuListQuantity();
		System.out.println("Menu list items are:"+menuListPrice+" "+MenuListQuantity);
		
		proceedToCheckOutPage=productAddToCartPage.clickOnMenuList();
		String expTitleString="Basket "+"&#8211;"+" Automation Practice Site";
		String actTitleString=proceedToCheckOutPage.getTitle();
		System.out.println("Actual title is :"+actTitleString);
		
		
		Assert.assertEquals(actTitleString,expTitleString);
		
		//Assert.assertFalse(productAddToCartPage.isLink_ViewasketEnabled());		
			
	
	}

}
