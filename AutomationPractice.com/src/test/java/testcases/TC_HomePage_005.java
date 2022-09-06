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

public class TC_HomePage_005 extends BaseClass
{
	HomePage homePage;
	ShopPage shopPage;
	ProductAddToCartPage productAddToCartPage;
	
	@Test
	public void checkForReviews() throws InterruptedException
	{
		driver.get(ConfigUtil.getBaseURL());
		homePage=new HomePage(driver);
		shopPage= homePage.clickONShopLink();
		homePage=shopPage.clickOnHomePageLink();
		List<WebElement> arrivalsList= driver.findElements(By.xpath("//div[@class='themify_builder_sub_row clearfix gutter-default   sub_row_1-0-2']/div/div/div/ul/li/a[1]"));
		int i=0;
		for(WebElement arrival:arrivalsList)
		{
			//WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
			//wait.until(ExpectedConditions.elementToBeClickable(arrival)).click();
			arrivalsList.get(i).click();
			i++;
	
			productAddToCartPage=new ProductAddToCartPage(driver);
			productAddToCartPage.clickOnReviewsLink();
			Assert.assertTrue(productAddToCartPage.IsReviewSectionPresent());
			
			Thread.sleep(5000);
			driver.navigate().back();
			//driver.navigate().refresh();
			Thread.sleep(2000);
			
		}
		
	}
}
