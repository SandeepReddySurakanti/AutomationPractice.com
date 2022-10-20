package testcases;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseClass;
import PageObjects.HomePage;
import PageObjects.ProceedToCheckOutPage;
import PageObjects.ProductAddToCartPage;
import PageObjects.ShopPage;
import Utilities.ConfigUtil;

public class TC_HomePage_011 extends BaseClass
{
	HomePage homePage;
	ShopPage shopPage;
	ProductAddToCartPage productAddToCartPage;
	ProceedToCheckOutPage proceedToCheckOutPage;
	
	@Test
	public void checkForRemoveItem() throws InterruptedException
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
		List<WebElement> firstRowList= proceedToCheckOutPage.getFirstRowList();
		//get product name in list
		String productName=firstRowList.get(2).getText();
		System.out.println("The product name is : "+productName);
		//retrieving menulist price before remove
		String beforeMenuListPrice=proceedToCheckOutPage.getmenuListPrice();
		//retrieving total price of product
		String productTotalPriceString=firstRowList.get(5).getText().replace("₹", "");
		System.out.println("the product total price is :"+productTotalPriceString);

		//click on remove product
		firstRowList.get(0).click();
		
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10000));
		boolean b= wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//div[@class='woocommerce-message']"), productName+" removed"));
		Assert.assertTrue(b);	
		Thread.sleep(2000);
		String afterMenuListPrice= proceedToCheckOutPage.getmenuListPrice();
		System.out.println("before menulist price is :"+beforeMenuListPrice);		
		System.out.println("ater menulist price is :"+afterMenuListPrice);		
		float exp=Float.parseFloat(beforeMenuListPrice)-Float.parseFloat(afterMenuListPrice);
		System.out.print("exp price is :"+exp);
		System.out.println("---->"+productTotalPriceString.replaceAll("₹", ""));
		Assert.assertEquals(exp,Float.parseFloat(productTotalPriceString));
		
		
	
		
	}
	
			

}
