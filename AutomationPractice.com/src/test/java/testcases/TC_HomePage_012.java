package testcases;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
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

public class TC_HomePage_012 extends BaseClass
{
	HomePage homePage;
	ShopPage shopPage;
	ProductAddToCartPage productAddToCartPage;
	ProceedToCheckOutPage proceedToCheckOutPage;
	
	@Test
	public void checkForUpdateCart() throws InterruptedException
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
		
		
		List<WebElement> firstRowList= proceedToCheckOutPage.getFirstRowList();
		//get product name in list
		String productName=firstRowList.get(2).getText();
		System.out.println("The product name is : "+productName);
		//retrieving menulist price before remove
		String beforeMenuListPrice=proceedToCheckOutPage.getmenuListPrice();
		//retrieving total price of product
		String productTotalPriceString=firstRowList.get(5).getText().replace("₹", "");

		int beforefirstRowQuantity= Integer.parseInt( proceedToCheckOutPage.getfirstRowQuantity());
		System.out.println("33333333333333:"+firstRowList.get(5).getText().replace("₹", "").replaceAll(",",""));
		float beforeproductTotalPrice=Float.parseFloat( firstRowList.get(5).getText().replace("₹", "").replaceAll(",",""));
		System.out.println("before total price list is :"+beforeproductTotalPrice);
		
		int quantitytoChange=2;
		proceedToCheckOutPage.setFirstRowQuantity(String.valueOf(beforefirstRowQuantity+quantitytoChange));
		
		Assert.assertTrue(proceedToCheckOutPage.isUpdateCartButtonEnaled());
		proceedToCheckOutPage.clickOnUpdateButton();
		Thread.sleep(2000);
		float afterproductTotalPrice=Float.parseFloat( firstRowList.get(5).getText().replace("₹", "").replaceAll(",",""));
		System.out.println("After product update total is :"+afterproductTotalPrice);
		
		//Assert.assertEquals(false, null);
		System.out.println("----->"+beforeproductTotalPrice/beforefirstRowQuantity);
		System.out.println("----->"+beforeproductTotalPrice/beforefirstRowQuantity*quantitytoChange);
		float priceOfEachProduct=beforeproductTotalPrice/beforefirstRowQuantity;
		assertEquals(priceOfEachProduct*quantitytoChange, afterproductTotalPrice-beforeproductTotalPrice);
		
		//float exp=Float.parseFloat(beforeMenuListPrice)-Float.parseFloat(productTotalPriceString);
		//System.out.print("exp price is :"+exp);
	}
}
