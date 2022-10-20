package testcases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseClass;
import PageObjects.HomePage;
import PageObjects.PaymentGatewayPage;
import PageObjects.ProceedToCheckOutPage;
import PageObjects.ProductAddToCartPage;
import PageObjects.ShopPage;
import Utilities.ConfigUtil;

public class TC_HomePage_017 extends BaseClass
{
	HomePage homePage;
	ShopPage shopPage;
	ProductAddToCartPage productAddToCartPage;
	ProceedToCheckOutPage proceedToCheckOutPage;
	PaymentGatewayPage paymentGatewayPage;
	
	@Test
	public void checkPaymentGateWayPage() throws InterruptedException, AWTException
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
		
		paymentGatewayPage=proceedToCheckOutPage.clickOnProceedToCheckOutButton();
		paymentGatewayPage.enterFirstName("sandeep");
		paymentGatewayPage.enterLastName("reddy");
		paymentGatewayPage.enterEmail("abc@abc.com");
		paymentGatewayPage.enterPhone("8956231478");
		
		paymentGatewayPage.selectCountry("India");
		paymentGatewayPage.enterBillingCity("HYD");
		paymentGatewayPage.enterBillingAddress("Jubilee hills");
	    Thread.sleep(5000);
		
		paymentGatewayPage.selectState("Sikkim");
	    Thread.sleep(5000);

		paymentGatewayPage.enterBillingPincode("500001");


		
		Assert.assertTrue(paymentGatewayPage.isClickToEnterCouponisPresent());
		String beforetotalPrice=paymentGatewayPage.getBillingTotalPrice();
		System.out.println("before total price is :"+beforetotalPrice);

		paymentGatewayPage.clickToEnterCoupon();
		paymentGatewayPage.enterCouponCode("krishnasakinala");
		paymentGatewayPage.clickOnApplyCouponButton();
		Thread.sleep(3000);		
		String afterTotalPrice=paymentGatewayPage.getBillingTotalPrice();
		
		System.out.println("before total price is :"+beforetotalPrice);
		System.out.println("After total price is :"+afterTotalPrice);
		
		
	}
}
