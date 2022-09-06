package testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseClass;
import PageObjects.HomePage;
import PageObjects.ProductAddToCartPage;
import PageObjects.ShopPage;
import Utilities.ConfigUtil;

public class TC_HomePage_006 extends BaseClass
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
		//List<WebElement> arrivalsList= driver.findElements(By.xpath("//div[@class='themify_builder_sub_row clearfix gutter-default   sub_row_1-0-2']/div/div/div/ul/li/a[1]"));
		//driver.findElement(By.xpath("//a[@href='https://practice.automationtesting.in/product/selenium-ruby/']")).click();
		productAddToCartPage=homePage.clickONRubybook();
		Thread.sleep(2000);
		String priceOfBook= productAddToCartPage.getBookPrice();
		System.out.println("The price of book is :"+priceOfBook);
		Assert.assertNotEquals(priceOfBook, "");
			//productAddToCartPage=new ProductAddToCartPage(driver);
			
	
	}

}
